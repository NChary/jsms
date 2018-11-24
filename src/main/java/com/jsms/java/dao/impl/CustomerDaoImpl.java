package com.jsms.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.CustomerDao;
import com.jsms.java.model.BankerDetails;
import com.jsms.java.model.CardDetails;
import com.jsms.java.model.Customer;
import com.jsms.java.model.ReferenceDetails;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.util.IdGeneratorUtil;
import com.jsms.java.util.ImageUploadUtil;
import com.jsms.java.util.SMSHelper;

@Repository(value="customerDao")
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private IdGeneratorUtil idGeneratorUtil;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SMSHelper smsHelper;

	@Autowired
	private ImageUploadUtil imageUploadUtil;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public RestfulResponse saveCustomer(Customer customer) {
		RestfulResponse restfulResponse = new RestfulResponse();
		//boolean isCardValid = validateCardDetails(customer.getCardNumber(), customer.getCvvNumber());
		//if(isCardValid){

		final Customer customerDetails = customer;
		final String customerCode = idGeneratorUtil.getCustomerCode();
		final String password = idGeneratorUtil.getRandomStringPasswordUtil();
		customer.setAgentId(getAgentIdByReceiptId(customerDetails.getReceiptNo()));

		/*final String insertSql = "insert into "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+"(customerCode,password,name,surName,fatherName,dob,age,presentAddress,permanentAddress,"
				+ "mobileNo,landNo,email,house,office,qualificationId,casteId,maritalStatus,bloodGroupId,spouseName,spouseAge,spouseMobileNo,childrenMale,"
				+ "childrenFemale,vehicleType,vehicleNo,idProofId,idProofNo,idProofImage,addressProofId,addressProofNo,addressProofImage,employeeParticulars,applicantImage,agentId,branchId,"
				+ "receiptNo,createdBy) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; */
		
		final String insertSql = "insert into "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+"(customerCode,name,surName,fatherName,presentAddress,"
				+ "mobileNo,email,idProofId,idProofNo,addressProofId,addressProofNo,applicantImage,agentId,branchId,receiptNo,createdBy) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		
		String profileImageURL = "";
		String idProofImageURL = "";
		String addressProofImageURL = "";
		
		if(customerDetails.getApplicantImage()!=null && !customerDetails.getApplicantImage().isEmpty()){
			profileImageURL=imageUploadUtil.uploadProfileImag(customerDetails.getApplicantImage(),customerCode,JsfsLiterals.CUSTOMER_CODE);
			customerDetails.setApplicantImage(profileImageURL);
		}
		
		if(customerDetails.getIdProofImage()!=null && !customerDetails.getIdProofImage().isEmpty()){
			idProofImageURL = imageUploadUtil.uploadIdProofImag(customerDetails.getIdProofImage(),customerCode,JsfsLiterals.CUSTOMER_CODE);
			customerDetails.setIdProofImage(idProofImageURL);
		}
		
		if(customerDetails.getAddressProofImage()!=null && !customerDetails.getAddressProofImage().isEmpty()){
			addressProofImageURL = imageUploadUtil.uploadAddressProofImag(customerDetails.getAddressProofImage(),customerCode,JsfsLiterals.CUSTOMER_CODE);
			customerDetails.setAddressProofImage(addressProofImageURL);
		}

		/*
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pst =
								con.prepareStatement(insertSql, new String[] {"id"});
						pst.setString(1,customerCode);
						pst.setString(2,"" );
						pst.setString(3,JsfsLiterals.getUpperCase(customerDetails.getName()));
						pst.setString(4, JsfsLiterals.getUpperCase(customerDetails.getSurName()));
						pst.setString(5, JsfsLiterals.getUpperCase(customerDetails.getFatherName()));
						pst.setString(6, customerDetails.getDob());
						pst.setInt(7, customerDetails.getAge());
						pst.setString(8, JsfsLiterals.getUpperCase(customerDetails.getPresentAddress()));
						pst.setString(9,JsfsLiterals.getUpperCase( customerDetails.getPermanentAddress()));
						pst.setString(10, customerDetails.getMobileNo());
						pst.setString(11, customerDetails.getLandNo());
						pst.setString(12, customerDetails.getEmail());
						pst.setString(13, customerDetails.getHouse());
						pst.setString(14, customerDetails.getOffice());
						pst.setInt(15, customerDetails.getQualificationId());
						pst.setInt(16, customerDetails.getCasteId());
						pst.setString(17, customerDetails.getMaritalStatus());
						pst.setInt(18, customerDetails.getBloodGroupId());
						pst.setString(19, customerDetails.getSpouseName());
						pst.setInt(20, customerDetails.getSpouseAge());
						pst.setString(21, customerDetails.getSpouseMobileNo());
						pst.setInt(22, customerDetails.getChildrenMale());
						pst.setInt(23, customerDetails.getChildrenFemale());
						pst.setString(24, customerDetails.getVehicleType());
						pst.setString(25, customerDetails.getVehicleNo());
						pst.setInt(26, customerDetails.getIdProofId());
						pst.setString(27, customerDetails.getIdProofNo());
						pst.setString(28, customerDetails.getIdProofImage());
						pst.setInt(29, customerDetails.getAddressProofId());
						pst.setString(30, customerDetails.getAddressProofNo());
						pst.setString(31, customerDetails.getAddressProofImage());
						pst.setString(32, customerDetails.getCustomerParticulars());
						pst.setString(33, customerDetails.getApplicantImage());
						pst.setString(34, customerDetails.getAgentId());
						pst.setString(35, customerDetails.getBranchId());
						//pst.setString(36, customerDetails.getCardNumber());
						//pst.setInt(37, customerDetails.getCvvNumber());
						pst.setInt(36, customerDetails.getReceiptNo());
						//pst.setString(39, customerDetails.getValidUpTo());
						pst.setInt(37, customerDetails.getCreatedBy());
						return pst;
					}
				},
				keyHolder);
		long pkId = (Long)keyHolder.getKey();*/

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pst =
								con.prepareStatement(insertSql, new String[] {"id"});
						pst.setString(1,customerCode);
						pst.setString(2,JsfsLiterals.getUpperCase(customerDetails.getName()));
						pst.setString(3, JsfsLiterals.getUpperCase(customerDetails.getSurName()));
						pst.setString(4, JsfsLiterals.getUpperCase(customerDetails.getFatherName()));
						pst.setString(5, JsfsLiterals.getUpperCase(customerDetails.getPresentAddress()));
						pst.setString(6, customerDetails.getMobileNo());
						pst.setString(7, customerDetails.getEmail());
						pst.setInt(8, customerDetails.getIdProofId());
						pst.setString(9, customerDetails.getIdProofNo());
						pst.setInt(10, customerDetails.getAddressProofId());
						pst.setString(11, customerDetails.getAddressProofNo());
						pst.setString(12, customerDetails.getApplicantImage());
						pst.setString(13, customerDetails.getAgentId());
						pst.setString(14, customerDetails.getBranchId());
						pst.setInt(15, customerDetails.getReceiptNo());
						pst.setInt(16, customerDetails.getCreatedBy());
						return pst;
					}
				},
				keyHolder);
		long pkId = (Long)keyHolder.getKey();
		
		if(pkId>0){

			/*String sql = "insert into "+JsfsTables.BANKER_DETAILS+"(bankId,accountType,accountNo,since,ifscCode,userType,branch,refId)"
					+ "values(?,?,?,?,?,?,?,?)";

			int res1 = jdbcTemplate.update(sql,new Object[]{customer.getBankerDetails().getBankId(),customer.getBankerDetails().getAccountType(),
					customer.getBankerDetails().getAccountNo(),customer.getBankerDetails().getSince(),customer.getBankerDetails().getIfscCode(),
					JsfsLiterals.CUSTOMER_CODE,customer.getBankerDetails().getBranch(),pkId});*/


			//**** Inserting into User Table ****************//

			String sql2 = "insert into "+JsfsTables.USER+"(userId,password,name,surName,profilePic,userType)values(?,?,?,?,?,?)";
			int userRes = jdbcTemplate.update(sql2,new Object[]{customerCode,password,customerDetails.getName(),customerDetails.getSurName(),
					customerDetails.getApplicantImage(),	JsfsLiterals.CUSTOMER_CODE});

			// ************************************************* //


			/*String insertBankDetails = "insert into customer_bank_details(bankId,accountType,accountNo,since,customerId)values(?,?,?,?,?)";
				int res1 = jdbcTemplate.update(insertBankDetails,new Object[]{customer.getCustomerBankDetails().getBankId(),customer.getCustomerBankDetails().getAccountType(),
						customer.getCustomerBankDetails().getAccountNo(),customer.getCustomerBankDetails().getSince(),pkId});*/

			//if(res1==1){
				/*String insertRefDetails = "insert into "+JsfsTables.CUSTOMER_REFERENCES+"(r1Name,r1Occupation,r1Address,r1MobileNo,r1Email,r2Name,r2Occupation,r2Address,"
						+ "r2MobileNo,r2Email,customerId)values(?,?,?,?,?,?,?,?,?,?,?)";

				int res2 = jdbcTemplate.update(insertRefDetails,new Object[]{customer.getRefDetails().getRef1Name(),customer.getRefDetails().getRef1Occupation(),
						customer.getRefDetails().getRef1Address(),customer.getRefDetails().getRef1MobileNo(),customer.getRefDetails().getRef1Email(),
						customer.getRefDetails().getRef2Name(),customer.getRefDetails().getRef2Occupation(),customer.getRefDetails().getRef2Address(),
						customer.getRefDetails().getRef2MobileNo(),customer.getRefDetails().getRef2Email(),pkId});*/

				if(userRes == 1){
					//int udpateCardRes = updateCardDetails(customer.getCardNumber(), customer.getCvvNumber(), customer.getValidUpTo());
					//if(udpateCardRes==1){
					int receiptRes = updateReceiptNoStatus(customer.getReceiptNo());
					if(receiptRes == 1){
						smsHelper.sendSMSToCustomer(customerCode,customer.getMobileNo(),password);
						restfulResponse.setCode(customerCode);
						restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
						restfulResponse.setMessage(JsfsLiterals.CREATE_CUSTOMER_SUCCESS);							
					}else{
						restfulResponse.setCode(null);
						restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
						restfulResponse.setMessage(JsfsLiterals.INVALID_CARD);
					}

					//}
				}

			//}
		}
		//}else{
		/*restfulResponse.setCode(null);
			restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			restfulResponse.setMessage(JsfsLiterals.INVALID_CARD);*/
		//}

		return restfulResponse;
	}

	public String getAgentIdByReceiptId(int receiptId){
		String sql = "select submittedBy from "+JsfsTables.RECEIPT+" where id=? and userType=3";
		String agentId =  getJdbcTemplate().queryForObject(sql,new Object[]{receiptId},String.class);
		return agentId;
	}

	@Override
	public int updateReceiptNoStatus(int receiptId) {
		String sql = "update "+JsfsTables.RECEIPT+"  set status=? where id=?";
		return jdbcTemplate.update(sql,new Object[]{1,receiptId});
	}


	@Override
	public int updateCardDetails(String cardNo, int cvvNo,String valideUpTo) {
		String sql = "update "+JsfsTables.CARD_DETAILS+"  set toDate=?,status=? where cardNo=? and cvvNumber=?";
		return jdbcTemplate.update(sql,new Object[]{valideUpTo,1,cardNo,cvvNo});
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		/*String sql = "select * from "+JsfsTables.CUSTOMER_PERSONAL_DETAILS;
		List<Customer> customers = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Customer.class));
		return customers;*/
		
		return getJdbcTemplate().query("select * from "+JsfsTables.CUSTOMER_PERSONAL_DETAILS,new RowMapper<Customer>(){  
		    @Override  
		    public Customer mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	Customer agent=new Customer();  
		        agent.setId(rs.getInt(1));
		        agent.setCustomerCode(rs.getString(2));
		        agent.setPassword(rs.getString(3));
		        agent.setName(rs.getString(4));
		        agent.setSurName(rs.getString(5));
		        agent.setFatherName(rs.getString(6));
		        agent.setDob(rs.getString(7));
		        agent.setAge(rs.getInt(8));
		        agent.setPresentAddress(rs.getString(9));
		        agent.setPermanentAddress(rs.getString(10));
		        agent.setMobileNo(rs.getString(11));
		        agent.setLandNo(rs.getString(12));
		        agent.setEmail(rs.getString(13));
		        agent.setHouse(rs.getString(14));
		        //agent.setCaderId(rs.getInt("sagentCaderId"));
		        return agent;  
		    }  
		    });
		
		
		
	}


	public boolean validateCardDetails(String cardNo, int cvvNo) {
		boolean result=false;
		String sql = "select * from "+JsfsTables.CARD_DETAILS+"  where cardNo="+cardNo+" and cvvNumber="+cvvNo+" and status=0";
		CardDetails cardDetails = (CardDetails) jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper(CardDetails.class));

		if(cardDetails!=null && cardDetails.getCardNo().length()>0 && cardDetails.getCvvNumber()>0){
			result = true;
		}else{
			result = false;
		}
		return result;
	}

	@Override
	public Customer getCustomerById(String customerCode) {
		String sql = "select * from "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+"  where customerCode="+customerCode;
		Customer customer = getJdbcTemplate().queryForObject(sql, Customer.class);
		
		customer.setAddressProofImage(JsfsLiterals.BASE_URL+"/customer/addressproof/"+customer.getAddressProofImage());
		customer.setIdProofImage(JsfsLiterals.BASE_URL+"/customer/idproof/"+customer.getIdProofImage());
		customer.setApplicantImage(JsfsLiterals.BASE_URL+"/customer/"+customer.getApplicantImage());

		String refSql = "select * from "+JsfsTables.CUSTOMER_REFERENCES+"  where customerId="+customer.getId();
		ReferenceDetails refDetails = getJdbcTemplate().queryForObject(refSql, ReferenceDetails.class);
		if(refDetails!=null)
			customer.setRefDetails(refDetails);
		String bankSql = "select * from "+JsfsTables.BANKER_DETAILS+"  where refId="+customer.getId()+" and userType = "+JsfsLiterals.CUSTOMER_CODE;
		BankerDetails custBankDetails = getJdbcTemplate().queryForObject(bankSql, BankerDetails.class);
		if(custBankDetails!=null)
			customer.setBankerDetails(custBankDetails);

		return customer;
	}

	@Override
	public List<Customer> getCustomersByAgentId(String agentCode) {
		String sql = "select * from "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+" where agentId = "+agentCode;
		List<Customer> customers = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Customer.class));
		return customers;
	}

	@Override
	public List<Customer> getAssignCustomer() {
		String sql = "select * from "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+" where cardNumber IS NULL";
		List<Customer> customers = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Customer.class));
		return customers;
	}

	@Override
	public boolean assignCardToCustomer(Customer customer) {
		boolean result = false;
		String sql = "update "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+"  set cardNumber=?,cvvNumber=?,validUpTo=?,cardAssignedBy=? where customerCode=?";
		long id = jdbcTemplate.update(sql,new Object[]{customer.getCardNumber(),customer.getCvvNumber(),customer.getValidUpTo(),customer.getCardAssignedBy(),customer.getCustomerCode()});
		if(id>0){
			int update = updateCardDetails(customer.getCardNumber(),customer.getCvvNumber(),customer.getValidUpTo());
			if(update>0){
				String message = maskCardDetails(customer.getCardNumber());
				smsHelper.sendCardDetailsToCustomer(customer.getMobileNo(),message);
				result = true;
			}else{
				result=false;
			}
		}else{
			result=false;
		}

		return false;
	}


	private String maskCardDetails(String cardNo){
		int start = 0;
		int end = 4;
		String result = "";
		if(cardNo.length()==16){
			for(int i=0;i<4;i++){
				if(i==0 || i==3){
					String res = cardNo.substring(start,end);
					result = result+res;
				}else if(i==1 || i==2){
					result = result+ "XXXX";
				}
				start = end;
				end = end+4;
			}
		}
		return result;

	}

}
