package com.jsms.java.util;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jsms.java.constants.JsfsLiterals;
@Component
public class IdGeneratorUtil {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	// Generate number based on range
	private int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	// Generating customer 12 digit number
	public String getCustomerCode(){
		return RandomStringUtils.random(10, false, true);
		/*boolean isValid = true;
		String customerId="";
		while(isValid){
			customerId = RandomStringUtils.random(10, false, true);
			//long custCode = getRandomNumberInRange(JsfsLiterals.cust, JsfsLiterals.AGENT_CODE_MAX);
			String sql = "select * from customer_personal_details where customerCode = "+customerId;
			Customer customer = getJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper(Customer.class));

			if(customer!=null){
				isValid=false;
			}else{

			}
		}

		return customerId; */
	}

	// Generate 5 digit employee code 
	public long getEmpNumber(){
		return getRandomNumberInRange(JsfsLiterals.EMP_CODE_MIN, JsfsLiterals.EMP_CODE_MAX);
	}

	// Generate 8 digit Agent code
	public long getAgentCode(){
		return getRandomNumberInRange(JsfsLiterals.AGENT_CODE_MIN, JsfsLiterals.AGENT_CODE_MAX);
		/*boolean isValid = true;
		long agentCode=0;
		while(isValid){
			agentCode = getRandomNumberInRange(JsfsLiterals.AGENT_CODE_MIN, JsfsLiterals.AGENT_CODE_MAX);
			String sql = "select * from agent_personal_details where agentCode = "+agentCode;
			Agent agents = getJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper(Agent.class));

			if(agents!=null){
				isValid = false;
			}else{

			}
		}

		return agentCode;
*/	}

	// Generate 8 digit password
	public String getRandomStringPasswordUtil(){
		String random = RandomStringUtils.random(8, "abcdefghijklmnopqrstuvwxyz0123456789");
		return random.toUpperCase();
	}

	// Generate 10 digit password
	public String getRandomStringPasswordUtil1(){
		String random = "I"+ RandomStringUtils.random(7, "abcdefghijklmnopqrstuvwxyz0123456789");
		return random.toUpperCase();
	}

	/* public boolean getValidate(String type,String code){
		if(type.toUpperCase().equals(JsfsLiterals.AGENT_GENERATION_TYPE)){
			String sql = "select * from agent_personal_details where agentCode="+code;
			List<Agent> agent = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Agent.class));
			if(agent.size()>=0){

			}
			return customer;
		}else if(type.toUpperCase().equals(JsfsLiterals.CUSTOMER_GENERATION_TYPE)){
			String sql = "select * from customer_personal_details where agentId="+agentId;
			List<Customer> customer = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Customer.class));
			return customer;
		} 

	} */


	public static void main(String[] args) {
		//System.out.println(" emp "+ new IdGeneratorUtil().getAgentNumber());
		//System.out.println(" emp "+ new IdGeneratorUtil().getCustomerId());

		for(int i=0;i<21;i++)
			System.out.println( new IdGeneratorUtil().getRandomStringPasswordUtil1());

		//System.out.println(" emp =  "+ new IdGeneratorUtil().getAgentCode());

	}

}
