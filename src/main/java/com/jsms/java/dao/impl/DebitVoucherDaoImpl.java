package com.jsms.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.DebitVoucherDao;
import com.jsms.java.model.CashBook;
import com.jsms.java.model.DebitVoucher;
import com.jsms.java.model.DebitVoucherTypes;
import com.jsms.java.model.RestfulResponse;

@Repository(value="dvDao")
public class DebitVoucherDaoImpl implements DebitVoucherDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public RestfulResponse createDebitVoucher(DebitVoucher dv) {

		RestfulResponse restfulResponse = new RestfulResponse();
		final DebitVoucher debitVoucher = dv;

		final String query = "insert into "+JsfsTables.DEBIT_VOUCHER+"(date,expenditureType,name,amount,description,paymentType,createdBy,agentCode,employeeCode)values(?,?,?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pst =
								con.prepareStatement(query, new String[] {"id"});
						pst.setString(1, debitVoucher.getDate());
						pst.setInt(2,debitVoucher.getExpenditureType());
						pst.setString(3,debitVoucher.getName() );
						pst.setDouble(4,debitVoucher.getAmount());
						pst.setString(5, debitVoucher.getDescription());
						pst.setInt(6, debitVoucher.getPaymentType());
						pst.setLong(7, debitVoucher.getCreatedBy());
						pst.setString(8, debitVoucher.getAgentCode());
						pst.setString(9, debitVoucher.getEmployeeCode());

						return pst;
					}
				},
				keyHolder);
		long pkId = (Long)keyHolder.getKey();

		if(pkId>0){

			// Bring last record from Cash Book
			String sql = "select * from "+JsfsTables.FIN_ACC_CASHBOOK+" order by 9 desc limit 1";
			CashBook cashBook = (CashBook)getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper(CashBook.class));

			// Insert into Cash book
			if(cashBook!=null){	
				String sql1 = "insert into "+JsfsTables.FIN_ACC_CASHBOOK+"(receiptType,transactionType,voucherId,openingBalance,transactionAmount,closingBalance,transactionDate)"
						+ "values(?,?,?,?,?,?,?)";

				double openingBal = cashBook.getClosingBalance();
				double closingBal = openingBal - debitVoucher.getAmount();

				long pk = getJdbcTemplate().update(sql1,new Object[]{2,debitVoucher.getPaymentType(),pkId,openingBal,debitVoucher.getAmount(),closingBal,debitVoucher.getDate()});

				if(pk>0){
					restfulResponse.setCode(String.valueOf("DV"+pkId));
					restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
					restfulResponse.setMessage(JsfsLiterals.CREATE_AGENT_SUCCESS);
				}
			}

		}else{
			restfulResponse.setCode(null);
			restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			restfulResponse.setMessage(JsfsLiterals.CREATE_AGENT_FAIL);
		}
		return restfulResponse;		
	}

	@Override
	public List<DebitVoucherTypes> getAllExpenditureTypes() {
		String sql = "select * from "+JsfsTables.EXPENDIGURE_TYPES+" order by 2";
		List<DebitVoucherTypes> lstDebitVouchers = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(DebitVoucherTypes.class));
		return lstDebitVouchers;
	}

	@Override
	public List<DebitVoucher> getAllDebitVouchers() {
		//String sql = "select * from "+JsfsTables.DEBIT_VOUCHER;
		String sql = "select d.id,d.date,e.expenditureType as expType,d.name,d.amount,d.description,p.paymentType as payType,d.agentcode,d.employeeCode,d.createdBy,d.createdDate "
				+ " from debit_voucher d,expenditure_types e,paymenttypes p where d.expenditureType = e.id and p.id = d.paymentType order by 1 desc";
		
		List<DebitVoucher> lstDebitVouchers = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(DebitVoucher.class));
		return lstDebitVouchers;
	}

}
