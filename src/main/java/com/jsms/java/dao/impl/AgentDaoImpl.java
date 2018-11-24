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
import com.jsms.java.dao.AgentDao;
import com.jsms.java.model.Agent;
import com.jsms.java.model.BankerDetails;
import com.jsms.java.model.Customer;
import com.jsms.java.model.Designation;
import com.jsms.java.model.ReferenceDetails;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.util.IdGeneratorUtil;
import com.jsms.java.util.ImageUploadUtil;
import com.jsms.java.util.SMSHelper;

@Repository(value="agentDao")
public class AgentDaoImpl implements AgentDao{

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
	public RestfulResponse saveAgent(Agent agent) {

		RestfulResponse restfulResponse = new RestfulResponse();

		final Agent agentDetails = agent;
		final String password = idGeneratorUtil.getRandomStringPasswordUtil();
		final long agentCode = idGeneratorUtil.getAgentCode();

		String idProofImageURL = "";
		String profileImageURL = "";
		String addressProofImageURL="";
		
		if(agentDetails.getApplicantImage()!=null && !agentDetails.getApplicantImage().isEmpty()){
			profileImageURL = imageUploadUtil.uploadProfileImag(agentDetails.getApplicantImage(),String.valueOf(agentCode),JsfsLiterals.AGENT_CODE);
			agentDetails.setApplicantImage(profileImageURL);
		}
		if(agentDetails.getIdProofImage()!=null && !agentDetails.getIdProofImage().isEmpty()){
			idProofImageURL = imageUploadUtil.uploadIdProofImag(agentDetails.getIdProofImage(),String.valueOf(agentCode),JsfsLiterals.AGENT_CODE);
			agentDetails.setIdProofImage(idProofImageURL);
		}
		
		if(agentDetails.getAddressProofImage()!=null && !agentDetails.getAddressProofImage().isEmpty()){
			addressProofImageURL = imageUploadUtil.uploadAddressProofImag(agentDetails.getAddressProofImage(), String.valueOf(agentCode),JsfsLiterals.AGENT_CODE);
			agentDetails.setAddressProofImage(addressProofImageURL);
		}

		if(agent.getId()>0){
			
			final String updateSql = "update set "+ JsfsTables.AGENT_PERSONAL_DETAILS +" fatherName=?,dob=?,age=?,presentAddress=?,permanentAddress=?,"
					+ "mobileNo=?,landNo=?,email=?,house=?,office=?,qualificationId=?,casteId=?,maritalStatus=?,bloodGroupId=?,spouseName=?,spouseAge=?,spouseMobileNo=?,"
					+ "childrenMale=?,childrenFemale=?,vehicleType=?,vehicleNo=?,idProofId=?,idProofNo=?,idProofImage=?,addressProofId=?,addressProofNo=?,addressProofImage=?,agentParticulars=?,"
					+ "applicantImage=?,udpatedBy=? where agentCode = "+agent.getAgentCode();

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							PreparedStatement pst =
									con.prepareStatement(updateSql, new String[] {"id"});
							pst.setString(1,JsfsLiterals.getUpperCase( agentDetails.getFatherName()));
							pst.setString(2, agentDetails.getDob());
							pst.setInt(3, agentDetails.getAge());
							pst.setString(4,JsfsLiterals.getUpperCase( agentDetails.getPresentAddress()));
							pst.setString(5, JsfsLiterals.getUpperCase(agentDetails.getPermanentAddress()));
							pst.setString(6, agentDetails.getMobileNo());
							pst.setString(7, agentDetails.getLandNo());
							pst.setString(8, agentDetails.getEmail());
							pst.setString(9, agentDetails.getHouse());
							pst.setString(10, agentDetails.getOffice());
							pst.setInt(11, agentDetails.getQualificationId());
							pst.setInt(12, agentDetails.getCasteId());
							pst.setString(13, agentDetails.getMaritalStatus());
							pst.setInt(14, agentDetails.getBloodGroupId());
							pst.setString(15, agentDetails.getSpouseName());
							pst.setInt(16, agentDetails.getSpouseAge());
							pst.setString(17, agentDetails.getSpouseMobileNo());
							pst.setInt(18, agentDetails.getChildrenMale());
							pst.setInt(19, agentDetails.getChildrenFemale());
							pst.setString(20, agentDetails.getVehicleType());
							pst.setString(21, agentDetails.getVehicleNo());
							pst.setInt(21, agentDetails.getIdProofId());
							pst.setString(23, agentDetails.getIdProofNo());
							pst.setString(24, agentDetails.getIdProofImage());
							pst.setInt(25, agentDetails.getAddressProofId());
							pst.setString(26, agentDetails.getAddressProofNo());
							pst.setString(27, agentDetails.getAddressProofImage());
							pst.setString(28, agentDetails.getAgentParticulars());
							pst.setString(29, agentDetails.getApplicantImage());
							pst.setInt(30, agentDetails.getUpdatedBy());

							return pst;
						}
					},
					keyHolder);
			
			
			String updateRefDetails = "update "+JsfsTables.AGENT_REFERENCES+" set r1Name=?,r1Occupation=?,r1Address=?,r1MobileNo=?,r1Email=?,r2Name=?,r2Occupation=?,r2Address=?,"
					+ "r2MobileNo=?,r2Email=? where agentId = ?";

			int res2 = jdbcTemplate.update(updateRefDetails,new Object[]{agent.getRefDetails().getRef1Name(),agent.getRefDetails().getRef1Occupation(),
					agent.getRefDetails().getRef1Address(),agent.getRefDetails().getRef1MobileNo(),agent.getRefDetails().getRef1Email(),
					agent.getRefDetails().getRef2Name(),agent.getRefDetails().getRef2Occupation(),agent.getRefDetails().getRef2Address(),
					agent.getRefDetails().getRef2MobileNo(),agent.getRefDetails().getRef2Email(),agent.getId()});
			
			
			String updateBankerDetails = "update "+JsfsTables.BANKER_DETAILS+" set bankId=?,accountType=?,accountNo=?,since=?,ifscCode=?,branch=? where refId=? and userType="+JsfsLiterals.AGENT_CODE;

			int res1 = jdbcTemplate.update(updateBankerDetails,new Object[]{agent.getBankerDetails().getBankId(),agent.getBankerDetails().getAccountType(),
					agent.getBankerDetails().getAccountNo(),agent.getBankerDetails().getSince(),agent.getId(),agent.getBankerDetails().getIfscCode(),
					agent.getBankerDetails().getBranch(),agent.getId()});

			if(res2>0 && res1>0){
				restfulResponse.setCode(String.valueOf(agentCode));
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
				restfulResponse.setMessage(JsfsLiterals.UPDATE_AGENT_SUCCESS);
				String caderName = findCaderById(agent.getCaderId());
			}else{
				restfulResponse.setCode(null);
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
				restfulResponse.setMessage(JsfsLiterals.UPDATE_EMPLOYEE_FAIL);
			}

		}else{

			
			/* final String insertSql = "insert into "+ JsfsTables.AGENT_PERSONAL_DETAILS +" (agentCode,password,name,surName,fatherName,dob,age,presentAddress,permanentAddress,"
					+ "mobileNo,landNo,email,house,office,qualificationId,casteId,maritalStatus,bloodGroupId,spouseName,spouseAge,spouseMobileNo,"
					+ "childrenMale,childrenFemale,vehicleType,vehicleNo,idProofId,idProofNo,idProofImage,addressProofId,addressProofNo,addressProofImage,agentParticulars,"
					+ "applicantImage,sagentCode,caderId,createdBy,udpatedBy,sagentCaderId)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							PreparedStatement pst =
									con.prepareStatement(insertSql, new String[] {"id"});
							pst.setLong(1,agentCode);
							pst.setString(2,"" );
							pst.setString(3,JsfsLiterals.getUpperCase(agentDetails.getName()));
							pst.setString(4,JsfsLiterals.getUpperCase(agentDetails.getSurName()));
							pst.setString(5,JsfsLiterals.getUpperCase( agentDetails.getFatherName()));
							pst.setString(6, agentDetails.getDob());
							pst.setInt(7, agentDetails.getAge());
							pst.setString(8,JsfsLiterals.getUpperCase( agentDetails.getPresentAddress()));
							pst.setString(9, JsfsLiterals.getUpperCase(agentDetails.getPermanentAddress()));
							pst.setString(10, agentDetails.getMobileNo());
							pst.setString(11, agentDetails.getLandNo());
							pst.setString(12, agentDetails.getEmail());
							pst.setString(13, agentDetails.getHouse());
							pst.setString(14, agentDetails.getOffice());
							pst.setInt(15, agentDetails.getQualificationId());
							pst.setInt(16, agentDetails.getCasteId());
							pst.setString(17, agentDetails.getMaritalStatus());
							pst.setInt(18, agentDetails.getBloodGroupId());
							pst.setString(19, agentDetails.getSpouseName());
							pst.setInt(20, agentDetails.getSpouseAge());
							pst.setString(21, agentDetails.getSpouseMobileNo());
							pst.setInt(22, agentDetails.getChildrenMale());
							pst.setInt(23, agentDetails.getChildrenFemale());
							pst.setString(24, agentDetails.getVehicleType());
							pst.setString(25, agentDetails.getVehicleNo());
							pst.setInt(26, agentDetails.getIdProofId());
							pst.setString(27, agentDetails.getIdProofNo());
							pst.setString(28, agentDetails.getIdProofImage());
							pst.setInt(29, agentDetails.getAddressProofId());
							pst.setString(30, agentDetails.getAddressProofNo());
							pst.setString(31, agentDetails.getAddressProofImage());
							pst.setString(32, agentDetails.getAgentParticulars());
							pst.setString(33, agentDetails.getApplicantImage());
							pst.setString(34,agentDetails.getSagentCode());
							pst.setInt(35, agentDetails.getCaderId());
							pst.setInt(36, agentDetails.getCreatedBy());
							pst.setInt(37, agentDetails.getCreatedBy());
							pst.setInt(38, agentDetails.getSagentCaderId());

							return pst;
						}
					},
					keyHolder);
			long pkId = (Long)keyHolder.getKey(); */

			
			final String insertSql = "insert into "+ JsfsTables.AGENT_PERSONAL_DETAILS +" (agentCode,name,surName,fatherName,"
					+ "mobileNo,email,idProofId,idProofNo,addressProofId,addressProofNo,presentAddress,applicantImage,sagentCode,caderId,"
					+ "createdBy,udpatedBy,sagentCaderId)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							PreparedStatement pst =
									con.prepareStatement(insertSql, new String[] {"id"});
							pst.setLong(1,agentCode);
							pst.setString(2,JsfsLiterals.getUpperCase(agentDetails.getName()));
							pst.setString(3,JsfsLiterals.getUpperCase(agentDetails.getSurName()));
							pst.setString(4,JsfsLiterals.getUpperCase( agentDetails.getFatherName()));
							pst.setString(5, agentDetails.getMobileNo());
							pst.setString(6, agentDetails.getEmail());	
							pst.setInt(7, agentDetails.getIdProofId());
							pst.setString(8, agentDetails.getIdProofNo());
							pst.setInt(9, agentDetails.getAddressProofId());
							pst.setString(10, agentDetails.getAddressProofNo());
							pst.setString(11,JsfsLiterals.getUpperCase( agentDetails.getPresentAddress()));
							pst.setString(12, agentDetails.getApplicantImage());
							pst.setString(13,agentDetails.getSagentCode());
							pst.setInt(14, agentDetails.getCaderId());
							pst.setInt(15, agentDetails.getCreatedBy());
							pst.setInt(16, agentDetails.getCreatedBy());
							pst.setInt(17, agentDetails.getSagentCaderId());

							return pst;
						}
					},
					keyHolder);
			long pkId = (Long)keyHolder.getKey(); 
			
			
			System.out.println("********************** Auto inc. value = "+pkId);

			if(pkId>0){

				//**** Inserting into User Table ****************//

				String sql2 = "insert into "+ JsfsTables.USER +" (userId,password,name,surName,profilePic,userType)values(?,?,?,?,?,?)";
				int userRes = jdbcTemplate.update(sql2,new Object[]{agentCode,password,agentDetails.getName(),agentDetails.getSurName(),
						agentDetails.getApplicantImage(),JsfsLiterals.AGENT_CODE});

				// ************************************************* //
				//String insertBankDetails = "insert into agent_bank_details(bankId,accountType,accountNo,since,agentId,ifscCode)values(?,?,?,?,?,?)";

				/*int res1 = jdbcTemplate.update(insertBankDetails,new Object[]{agent.getAgentBankDetails().getBankId(),agent.getAgentBankDetails().getAccountType(),
					agent.getAgentBankDetails().getAccountNo(),agent.getAgentBankDetails().getSince(),pkId,agent.getAgentBankDetails().getIfscCode()});*/

				/*String sql = "insert into "+JsfsTables.BANKER_DETAILS+"(bankId,accountType,accountNo,since,refId,ifscCode,userType,branch)"
						+ "values(?,?,?,?,?,?,?,?)";

				int res1 = jdbcTemplate.update(sql,new Object[]{agent.getBankerDetails().getBankId(),agent.getBankerDetails().getAccountType(),
						agent.getBankerDetails().getAccountNo(),agent.getBankerDetails().getSince(),pkId,agent.getBankerDetails().getIfscCode(),
						JsfsLiterals.AGENT_CODE,agent.getBankerDetails().getBranch()});*/


				//if(res1 == 1){
					
					/*String insertRefDetails = "insert into "+JsfsTables.AGENT_REFERENCES+"(r1Name,r1Occupation,r1Address,r1MobileNo,r1Email,r2Name,r2Occupation,r2Address,"
							+ "r2MobileNo,r2Email,agentId)values(?,?,?,?,?,?,?,?,?,?,?)";

					int res2 = jdbcTemplate.update(insertRefDetails,new Object[]{agent.getRefDetails().getRef1Name(),agent.getRefDetails().getRef1Occupation(),
							agent.getRefDetails().getRef1Address(),agent.getRefDetails().getRef1MobileNo(),agent.getRefDetails().getRef1Email(),
							agent.getRefDetails().getRef2Name(),agent.getRefDetails().getRef2Occupation(),agent.getRefDetails().getRef2Address(),
							agent.getRefDetails().getRef2MobileNo(),agent.getRefDetails().getRef2Email(),pkId});*/
					if(userRes == 1){
						restfulResponse.setCode(String.valueOf(agentCode));
						restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
						restfulResponse.setMessage(JsfsLiterals.CREATE_AGENT_SUCCESS);
						String caderName = findCaderById(agent.getCaderId());
						smsHelper.sendSMSToAgent(agentCode,caderName,agent.getMobileNo(),password);
					}else{
						restfulResponse.setCode(null);
						restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
						restfulResponse.setMessage(JsfsLiterals.CREATE_AGENT_FAIL);
					}
				//}
			}
		}
		return restfulResponse;
	}


	@Override
	public List<Agent> getAllAgents() {
		
		/*String sql = "select * from "+JsfsTables.AGENT_PERSONAL_DETAILS+" where status=1";
		List<Agent> agents = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Agent.class));
		return agents;*/
		
			 return getJdbcTemplate().query("select * from "+JsfsTables.AGENT_PERSONAL_DETAILS+" where status=1",new RowMapper<Agent>(){  
			    @Override  
			    public Agent mapRow(ResultSet rs, int rownumber) throws SQLException {  
			        Agent agent=new Agent();  
			        agent.setId(rs.getInt(1));
			        agent.setAgentCode(rs.getString(2));
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
			        agent.setCaderId(rs.getInt("sagentCaderId"));
			        return agent;  
			    }  
			    });  
	}

	@Override
	public List<Customer> getAllCustomersByAgentId(String agentId) {
		String sql = "select * from "+JsfsTables.CUSTOMER_PERSONAL_DETAILS+" where agentId="+agentId;
		List<Customer> customer = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Customer.class));
		return customer;
	}

	@Override
	public Agent getAgentById(String agentId) {
		String sql = "select * from "+JsfsTables.AGENT_PERSONAL_DETAILS+" where agentCode="+agentId;
		Agent agent = (Agent)getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper(Agent.class));
		
		agent.setAddressProofImage(JsfsLiterals.BASE_URL+"/agent/addressproof/"+agent.getAddressProofImage());
		agent.setIdProofImage(JsfsLiterals.BASE_URL+"/agent/idproof/"+agent.getIdProofImage());
		agent.setApplicantImage(JsfsLiterals.BASE_URL+"/agent/"+agent.getApplicantImage());

		
		String refSql = "select * from "+JsfsTables.AGENT_REFERENCES+" where agentId="+agent.getId();
		ReferenceDetails refDetails = (ReferenceDetails)getJdbcTemplate().queryForObject(refSql, new BeanPropertyRowMapper(ReferenceDetails.class));
		if(refDetails!=null)
			agent.setRefDetails(refDetails);
		
		String bankSql = "select * from "+JsfsTables.BANKER_DETAILS+" where refId="+agent.getId()+" and userType = "+JsfsLiterals.AGENT_CODE;
		BankerDetails agentBankDetails =(BankerDetails) getJdbcTemplate().queryForObject(bankSql, new BeanPropertyRowMapper(BankerDetails.class));
		if(agentBankDetails!=null)
			agent.setBankerDetails(agentBankDetails);

		return agent;
	}

	@Override
	public List<Agent> getAgentsByCaderId(int caderId) {
		String sql = "select * from "+JsfsTables.AGENT_PERSONAL_DETAILS+"  where caderId="+caderId;
		List<Agent> lstAgents = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Agent.class));
		return lstAgents;
	}

	@Override
	public List<Agent> getAgentTreeById(String agentCode) {
		String sql = "select * from agent_personal_details as t1 where sagentCode = "+agentCode+" or exists "
				+ "( select * from agent_personal_details as t2 where agentCode = t1.sagentCode and ( sagentCode = "+agentCode+" or exists "
				+ "( select * from agent_personal_details as t3 where agentCode = t2.sagentCode and sagentCode = "+agentCode+" ) ) )";
		/*List<Agent> lstAgents = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Agent.class));
		return lstAgents;*/
		
		return getJdbcTemplate().query(sql,new RowMapper<Agent>(){  
		    @Override  
		    public Agent mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Agent agent=new Agent();  
		        agent.setId(rs.getInt(1));
		        agent.setAgentCode(rs.getString(2));
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
		        agent.setCaderId(rs.getInt("sagentCaderId"));
		        return agent;  
		    }  
		    });
	}

	@Override
	public List<Designation> getAgentCadersById(int caderId) {
		String sql = "select * from "+JsfsTables.CADERS+"  where id>"+caderId+" and id!=9";
		List<Designation> lstCaders = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Designation.class));
		return lstCaders;
	}

	@Override
	public int getAgentCaderById(String agentCode) {
		String sql = "select * from "+JsfsTables.AGENT_PERSONAL_DETAILS+"  where agentCode="+agentCode;
		Agent lstAgents = (Agent)getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper(Agent.class));
		return lstAgents.getCaderId();
	}

	public String findCaderById(int caderId){
		String sql = "select * from "+JsfsTables.CADERS+"  where id="+caderId;
		Designation designation = (Designation)getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper(Designation.class));
		return designation.getDesignation();
	}

}
