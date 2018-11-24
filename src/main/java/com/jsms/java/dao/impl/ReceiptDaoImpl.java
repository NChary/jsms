package com.jsms.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.ReceiptDao;
import com.jsms.java.model.AgentCommission;
import com.jsms.java.model.CashBook;
import com.jsms.java.model.PaymentType;
import com.jsms.java.model.ProductSubCat;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.ReceiptType;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.util.SMSHelper;

@Repository(value="receiptDao")
public class ReceiptDaoImpl implements ReceiptDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SMSHelper smsHelper;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public List<PaymentType> getAllPaymentTypes() {
		String sql = "select * from "+JsfsTables.PAYMENTTYPES;
		List<PaymentType> paymentTypes = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(PaymentType.class));
		return paymentTypes;
	}

	@Override
	public List<ReceiptType> getAllReceiptTypes() {
		String sql = "select * from "+JsfsTables.PRODUCT_CATEGORIES;
		List<ReceiptType> receiptTypes = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(ReceiptType.class));
		return receiptTypes;
	}

	@Override
	public RestfulResponse createReceipt(Receipt receipt) {

		final Receipt receiptDetails = receipt; 
		RestfulResponse restfulResponse = new RestfulResponse();
		// If receipt type is FRN
		if(receipt.getReceiptType()==1){

			final String insertSql = "insert into "+JsfsTables.RECEIPT+"(receiptType,amount,submittedBy,paymentTypeId,branchId,date,createdBy,userType) "
					+ "values(?,?,?,?,?,?,?,?)";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							PreparedStatement pst =
									con.prepareStatement(insertSql, new String[] {"id"});
							pst.setLong(1,receiptDetails.getReceiptType());
							pst.setDouble(2,receiptDetails.getAmount());
							pst.setString(3,receiptDetails.getSubmittedBy() );
							pst.setInt(4, receiptDetails.getPaymentTypeId());
							pst.setString(5, receiptDetails.getBranchId());
							pst.setString(6, receiptDetails.getDate());
							pst.setInt(7, receiptDetails.getCreatedBy());
							pst.setInt(8, receiptDetails.getUserType());
							return pst;
						}
					},
					keyHolder);
			long pkId = (Long)keyHolder.getKey();

			System.out.println("********************** Auto inc. value = "+pkId);

			if(pkId>0){
				smsHelper.sendReceiptSMSToAgent(pkId, getAgentMobileNo(receiptDetails.getSubmittedBy()));
				// Bring last record from Cash Book
				long pk = insertCashBook(receiptDetails,pkId);
					if(pk>0){
						restfulResponse.setCode(String.valueOf("CR"+pkId));
						restfulResponse.setMessage(JsfsLiterals.CREATE_RECEIPT_SUCCESS);
						restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
					}
				

			}else{
				restfulResponse.setCode(null);
				restfulResponse.setMessage(JsfsLiterals.CREATE_RECEIPT_FAIL);
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			}
		}	// Insert into JSBS table
		else if(receipt.getReceiptType() == 2){

			final String insertSql = "insert into "+JsfsTables.JSBS_RECEIPT+"(receiptType,amount,submittedBy,paymentTypeId,branchId,date,createdBy,userType,jsbsCustomerCode) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							PreparedStatement pst =
									con.prepareStatement(insertSql, new String[] {"id"});
							pst.setLong(1,receiptDetails.getReceiptType());
							pst.setDouble(2,receiptDetails.getAmount());
							pst.setString(3,receiptDetails.getSubmittedBy() );
							pst.setInt(4, receiptDetails.getPaymentTypeId());
							pst.setString(5, receiptDetails.getBranchId());
							pst.setString(6, receiptDetails.getDate());
							pst.setInt(7, receiptDetails.getCreatedBy());
							pst.setInt(8, receiptDetails.getUserType());
							pst.setString(9, receiptDetails.getJsbsCustomerCode());
							return pst;
						}
					},
					keyHolder);
			long pkId = (Long)keyHolder.getKey();

			//System.out.println("********************** Auto inc. value = "+pkId);

			if(pkId>0){

				//saveJsbs(receipt,pkId);
				// Calculate commission for Bonanza
				insertAgentCommission(receiptDetails,pkId);	
				long pk = insertCashBook(receiptDetails,pkId);

				smsHelper.sendReceiptSMSToAgent(pkId, getAgentMobileNo(receiptDetails.getSubmittedBy()));

				restfulResponse.setCode(String.valueOf("JSBS"+pkId));
				restfulResponse.setMessage(JsfsLiterals.CREATE_RECEIPT_SUCCESS);
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
			}else{
				restfulResponse.setCode(null);
				restfulResponse.setMessage(JsfsLiterals.CREATE_RECEIPT_FAIL);
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			}

		}
		return restfulResponse;
	}

	// Insert into JSBS 
	private void saveJsbs(Receipt receipt,long pkid){

		String jsbsCode = "JSBS"+String.valueOf(pkid);

		String query = "insert into "+JsfsTables.JSBS_CUSTOMER_DETAILS+"(jsbsCode,customerId,agentCode,jsbsReceiptId,branchCode,jsbsGroup,"
				+ "installmentNo,openingBalance,paidAmount,balanceAmount) values(?,?,?,?,?,?,?,?,?,?)";

		int res = jdbcTemplate.update(query,new Object[]{jsbsCode,});

	}


	private String getAgentMobileNo(String agentId){
		String sql = "select mobileNo from "+JsfsTables.AGENT_PERSONAL_DETAILS+" where agentCode = ?";
		String mobileNo = getJdbcTemplate().queryForObject(sql,new Object[]{agentId},String.class);
		return mobileNo;
	}


	@Override
	public List<Receipt> getAllReceiptDetails() {
		//String sql = "select * from "+JsfsTables.RECEIPT;
		
		String sql = "select r.id,r.submittedBy,r.amount,p.paymentType,r.branchId,r.date from receipt r left join paymenttypes p on r.paymentTypeId = p.id order by 6 desc";
		List<Receipt> lstreceipt = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Receipt.class));
		return lstreceipt;	
	}


	@Override
	public List<Receipt> getReceiptIds() {
		String sql = "select id from "+JsfsTables.RECEIPT+" where receiptType=1 and status=0";
		List<Receipt> lstreceipt = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Receipt.class));
		return lstreceipt;	
	}

	@Override
	public List<ProductSubCat> getAllProductSub() {
		String sql = "select id from "+JsfsTables.PRODUCT_SUB_CATEGORIES;
		List<ProductSubCat> lstsubcat = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(ProductSubCat.class));
		return lstsubcat;	
	}

	@Override
	public List<Receipt> getAllJsbsReceipt(String agentCode) {
		String sql = "select * from "+JsfsTables.JSBS_RECEIPT+" where submittedBy="+agentCode+" and status=0";
		List<Receipt> lstJsbsReceipt = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Receipt.class));
		return lstJsbsReceipt;	
	}

	
	// Insert into Cash Book
	
	public long insertCashBook(Receipt receiptDetails,long pkId){
		long res = 0;
		String sql = "select * from "+JsfsTables.FIN_ACC_CASHBOOK+" order by 9 desc limit 1";
		CashBook cashBook = (CashBook)getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper(CashBook.class));

		// Insert into Cash book
		if(cashBook!=null){	
			String sql1 = "insert into "+JsfsTables.FIN_ACC_CASHBOOK+"(receiptType,transactionType,voucherId,openingBalance,transactionAmount,closingBalance,transactionDate)"
					+ "values(?,?,?,?,?,?,?)";

			double openingBal = cashBook.getClosingBalance();
			double closingBal = openingBal + receiptDetails.getAmount();

			 res = getJdbcTemplate().update(sql1,new Object[]{1,receiptDetails.getPaymentTypeId(),pkId,openingBal,receiptDetails.getAmount(),closingBal,receiptDetails.getDate()});

		}
		return res;
	}
	
	
	
	/******************************  AGENT COMMISSION CALCULATION DETAILS ****************************************/

	public void insertAgentCommission(Receipt receipt,long receiptId){
		Connection con=null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsms","root","root");  Local
			con = DriverManager.getConnection("jdbc:mysql://localhost:3309/jsms","root","Fs123&*("); // Live
			String sql = "select distinct a.caderId,a.agentCode,b.caderId,b.agentCode,c.caderId,c.agentCode,d.caderId,d.agentCode,e.caderId,e.agentCode,f.caderId,f.agentCode"+ 
					" from agent_personal_details as a"+
					" LEFT JOIN agent_personal_details as  b on b.agentCode = a.sagentCode"+
					" LEFT JOIN agent_personal_details as c on c.agentCode = b.sagentCode "+
					" LEFT JOIN agent_personal_details as d on d.agentCode = c.sagentCode "+
					" LEFT JOIN agent_personal_details as e on e.agentCode = d.sagentCode "+
					" LEFT JOIN agent_personal_details as f on f.agentCode = e.sagentCode where a.agentCode="+receipt.getSubmittedBy();


			stmt = con.createStatement();
			Map<Integer,String> agentStructure = null;

			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				agentStructure = new HashMap<>();
				//System.out.println(" SO = "+rs.getString(1)+" SM = "+rs.getString(2)+" AM = "+rs.getString(3)+" RM = "+rs.getString(4)+" ZM = "+rs.getString(5));
				agentStructure.put(rs.getInt(1), rs.getString(2));
				agentStructure.put(rs.getInt(3), rs.getString(4));
				agentStructure.put(rs.getInt(5), rs.getString(6));
				agentStructure.put(rs.getInt(7), rs.getString(8));
				agentStructure.put(rs.getInt(9), rs.getString(10));
				agentStructure.put(rs.getInt(11), rs.getString(12));
			}

			List<AgentCommission> agentCommissionList = new ArrayList<>();
			AgentCommission agentCommission = null;

			/*int caderId = 6;
			for (Map.Entry<Integer, String> entry : agentStructure.entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

				if(caderId == entry.getKey())
				{

				}


			 	//double commission = calculateNewBusinessCommission(entry.getKey(),entry.getValue(),amount);
			}*/

			for(int i=6;i>0;i--){
				if(agentStructure.get(i)!=null){
					System.out.println("Agent = "+agentStructure.get(i));	
					double percentage = getCommissionPercentage(i,receipt.getReceiptType());
					double commission = getCommission(receipt.getAmount(),percentage);

					agentCommission = new AgentCommission();
					agentCommission.setAgentcode(agentStructure.get(i));
					agentCommission.setAmount(receipt.getAmount());
					agentCommission.setCommission(commission);
					agentCommission.setReceiptId(receiptId);
					agentCommission.setDate(receipt.getDate());
					agentCommission.setGapCommission(false);
					agentCommission.setUserType(receipt.getUserType());

					agentCommissionList.add(agentCommission);

				}else{
					//Gap comission	
					double percentage = getCommissionPercentage(i,receipt.getReceiptType());
					double commission = getCommission(receipt.getAmount(),percentage);

					agentCommission = new AgentCommission();
					agentCommission.setAgentcode(JsfsLiterals.DEFAULT_AGENT_CODE);
					agentCommission.setAmount(receipt.getAmount());
					agentCommission.setCommission(commission);
					agentCommission.setReceiptId(receiptId);
					agentCommission.setDate(receipt.getDate());
					agentCommission.setGapCommission(true);
					agentCommission.setUserType(receipt.getUserType());
					System.out.println("Agent Gap commission = "+agentStructure.get(i));
					agentCommissionList.add(agentCommission);
				}
			}

			// Inserting batch details at a time

			int[] insertRes = insertAgentTreeCommission(agentCommissionList);

			if(insertRes.length>0){
				System.out.println("Success");
			}else{
				System.out.println("Fail");
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// Updating whole Agent tree structure into table at a time using Batch Update
	public int[] insertAgentTreeCommission(final List<AgentCommission> agentCommissions){

		String sql = "INSERT INTO "+JsfsTables.AGENT_COMMISSION+"(agentCode,amount,commission,receiptId,date,status,isGapCommission,userType) VALUES (?,?,?,?,?,?,?,?)";

		int[] res =  getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				AgentCommission agentCommission = agentCommissions.get(i);
				ps.setString(1, agentCommission.getAgentcode());
				ps.setDouble(2, agentCommission.getAmount());
				ps.setDouble(3, agentCommission.getCommission());
				ps.setLong(4, agentCommission.getReceiptId() );
				ps.setString(5, agentCommission.getDate());
				ps.setInt(6, agentCommission.getStatus() );
				ps.setBoolean(7, agentCommission.isGapCommission());
				ps.setInt(8, agentCommission.getUserType());
			}

			@Override
			public int getBatchSize() {
				return agentCommissions.size();
			}
		});
		return res;
	}

	// Get commission percentage from the commission_structure table based on receipt type
	public double getCommissionPercentage(int caderId,int commissionColumn){
		String columnName = "";
		double percentage=0.0;
		if(commissionColumn == 2){
			columnName = JsfsLiterals.PRODUCT_BONANZA_NEW_BUSINESS;
		}else if(commissionColumn == 4){
			columnName = JsfsLiterals.PRODUCT_LOANS;
		}else if(commissionColumn == 6){
			columnName = JsfsLiterals.PRODUCT_REALESTATE_NEW_BUSINESS;
		}
		if(!columnName.isEmpty()){
			String sql = "select "+columnName+" from commission_structure where caderId = ?";
			percentage = getJdbcTemplate().queryForObject(sql,new Object[]{caderId},Double.class);
			//System.out.println("Percentage = "+percentage);
		}
		return percentage;
	}

	public double getCommission(double amount,double percentage){
		return (amount*percentage)/100;
	}



}
