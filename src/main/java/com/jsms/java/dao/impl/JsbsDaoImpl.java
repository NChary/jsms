package com.jsms.java.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.JsbsDao;
import com.jsms.java.model.JsbsCustomer;
import com.jsms.java.model.Receipt;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.util.IdGeneratorUtil;
import com.jsms.java.util.ImageUploadUtil;
import com.jsms.java.util.SMSHelper;

@Repository(value="jsbsDaoImpl")
public class JsbsDaoImpl implements JsbsDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SMSHelper smsHelper;

	@Autowired
	private ImageUploadUtil imageUploadUtil;


	@Autowired
	private IdGeneratorUtil idGeneratorUtil;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public List<JsbsCustomer> getAllJsbsCustomers() {
		String sql = "select * from "+JsfsTables.JSBS_CUSTOMER_DETAILS;
		List<JsbsCustomer> jsbsCustomer = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(JsbsCustomer.class));
		return jsbsCustomer;
	}

	@Override
	public RestfulResponse saveUser(JsbsCustomer jsbsCustomer) {
		RestfulResponse restfulResponse = new RestfulResponse();
		String jsbsCode = getJsbsCustCode(jsbsCustomer.getJsbsReceiptId());
		double receiptAmount = gerReceiptAmtById(2);
		
		String query = "insert into "+JsfsTables.JSBS_CUSTOMER_DETAILS+"(jsbsCode,customerId,agentCode,jsbsReceiptId,branchCode,jsbsGroup,"
				+ "installmentNo,openingBalance,paidAmount,balanceAmount) values(?,?,?,?,?,?,?,?,?,?)";
		
		int res = jdbcTemplate.update(query,new Object[]{jsbsCode,jsbsCustomer.getCustomerId(),jsbsCustomer.getAgentCode(),
				jsbsCustomer.getJsbsReceiptId(),jsbsCustomer.getBranchCode(),"A",1,1500,receiptAmount,1500-receiptAmount});
		
		if(res == 1){
			
			long res1 = updateJsbsReceiptNoStatus(jsbsCustomer.getJsbsReceiptId()); 
			if(res1 == 1){
				restfulResponse.setCode(String.valueOf(jsbsCode));
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
				restfulResponse.setMessage(JsfsLiterals.CREATE_AGENT_SUCCESS);
			}else{
				restfulResponse.setCode(null);
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
				restfulResponse.setMessage(JsfsLiterals.CREATE_AGENT_FAIL);
			}
		}else{
			restfulResponse.setCode(null);
			restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			restfulResponse.setMessage(JsfsLiterals.CREATE_AGENT_FAIL);
		}
		
		return restfulResponse;
	}


	private String  getJsbsCustCode(long id){
		String jsbsCode="";
		if(id<10){
			jsbsCode = "JSBS0000"+id;
		}else if(id<100){
			jsbsCode = "JSBS000"+id;
		}else if(id<1000){
			jsbsCode = "JSBS00"+id;
		}else if(id<10000){
			jsbsCode = "JSBS0"+id;
		}else {
			jsbsCode = "JSBS"+id;
		}
		return jsbsCode;
	}
	
	
	private double gerReceiptAmtById(int id){
		String sql = "select * from "+JsfsTables.JSBS_RECEIPT+" where id = "+id;
		Receipt receipt = (Receipt)getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper(Receipt.class));
		if(receipt!=null)
			return receipt.getAmount();
		return 0;
	}
	
	public int updateJsbsReceiptNoStatus(long receiptId) {
		String sql = "update "+JsfsTables.JSBS_RECEIPT+" set status=? where id=?";
		return jdbcTemplate.update(sql,new Object[]{1,receiptId});
	}

	@Override
	public List<Receipt> getAllJsbsReceipts() {
		String sql = "select * from "+JsfsTables.JSBS_RECEIPT;
		List<Receipt> lstReceipts = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Receipt.class));
		return lstReceipts;
	}
	
	
}
