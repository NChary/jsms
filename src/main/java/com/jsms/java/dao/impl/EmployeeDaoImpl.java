package com.jsms.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jsms.java.constants.JsfsLiterals;
import com.jsms.java.constants.JsfsTables;
import com.jsms.java.dao.EmployeeDao;
import com.jsms.java.model.BankerDetails;
import com.jsms.java.model.Employee;
import com.jsms.java.model.RestfulResponse;
import com.jsms.java.util.IdGeneratorUtil;
import com.jsms.java.util.ImageUploadUtil;
import com.jsms.java.util.SMSHelper;

@Repository(value="employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{

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
	public RestfulResponse saveEmployee(Employee employee) {
		final Employee employeeObj = employee;
		RestfulResponse restfulResponse = new RestfulResponse();
		//long empCode = idGeneratorUtil.getEmpNumber();

		if(employee.getId()>0){
			if(JsfsLiterals.isImgUrlValid(employee.getApplicantImage())){
				String profileImageURL = imageUploadUtil.uploadProfileImag(employeeObj.getApplicantImage(),String.valueOf(employee.getEmpCode()),JsfsLiterals.EMPLOYEE_CODE);
				employeeObj.setApplicantImage(profileImageURL);
			}

			if(JsfsLiterals.isImgUrlValid(employee.getIdProofImage())){
				String idProofImageURL = imageUploadUtil.uploadIdProofImag(employeeObj.getIdProofImage(),String.valueOf(employee.getEmpCode()),JsfsLiterals.EMPLOYEE_CODE);
				employeeObj.setIdProofImage(idProofImageURL);
			}

			if(JsfsLiterals.isImgUrlValid(employee.getAddressProofImage())){
				String addressProofImageURL = imageUploadUtil.uploadAddressProofImag(employeeObj.getAddressProofImage(), String.valueOf(employee.getEmpCode()),JsfsLiterals.EMPLOYEE_CODE);
				employeeObj.setAddressProofImage(addressProofImageURL);
			}

			final String updateSql = "update "+JsfsTables.EMPLOYEE_DETAILS+" set branchId=?,designationId=?,fatherName=?,dob=?,age=?,presentAddress=?,permanentAddress=?,mobileNo=?,landNo=?,email=?,house=?,office=?,qualificationId=?,casteId=?,"
					+ "maritalStatus=?,bloodGroup=?,spouseName=?,spouseAge=?,spouseMobileNo=?,childrenMale=?,childrenFemale=?,vehicleType=?,vehicleNo=?,"
					+ "idProofId=?,idProofNo=?,addressProofId=?,addressProofNo=?,employeeParticulars=?,salary=?,updatedBy=? where id="+employeeObj.getId();

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							PreparedStatement pst =
									con.prepareStatement(updateSql, new String[] {"id"});
							pst.setString(1,employeeObj.getBranchId());
							pst.setInt(2,employeeObj.getDesignationId());
							pst.setString(3,employeeObj.getFatherName());
							pst.setString(4, employeeObj.getDob());
							pst.setInt(5,employeeObj.getAge());
							pst.setString(6, employeeObj.getPresentAddress());
							pst.setString(7,employeeObj.getPermanentAddress());
							pst.setString(8, employeeObj.getMobileNo());
							pst.setString(9, employeeObj.getLandNo());
							pst.setString(10, employeeObj.getEmail());
							pst.setString(11, employeeObj.getHouse());
							pst.setString(12, employeeObj.getOffice());
							pst.setInt(13, employeeObj.getQualificationId());
							pst.setInt(14, employeeObj.getCasteId());
							pst.setString(15, employeeObj.getMaritalStatus());
							pst.setString(16, employeeObj.getBloodGroup());
							pst.setString(17, employeeObj.getSpouseName());
							pst.setInt(18, employeeObj.getSpouseAge());
							pst.setString(19, employeeObj.getSpouseMobileNo());
							pst.setInt(20, employeeObj.getNoOfMaleChildrens());
							pst.setInt(21, employeeObj.getNoOfFemailChildrens());
							pst.setString(22, employeeObj.getVehicleType());
							pst.setString(23, employeeObj.getVehicleNo());
							pst.setInt(24, employeeObj.getIdProofId());
							pst.setString(25, employeeObj.getIdProofNo());
							pst.setInt(26, employeeObj.getAddressProofId());
							pst.setString(27, employeeObj.getAddressProofNo());
							pst.setString(28, employeeObj.getEmployeeParticulars());
							pst.setDouble(29, employeeObj.getSalary());
							pst.setInt(30, employeeObj.getUpdatedBy());
							return pst;
						}
					},
					keyHolder);


			int res1=0;
			if(isBankerDetailsExist(employee.getId())){
				String updateBankerSql = "update "+JsfsTables.BANKER_DETAILS+" set bankId=?,accountType=?,accountNo=?,since=?,ifscCode=?,branch=? where refId=? and userType=?";
				 res1 = jdbcTemplate.update(updateBankerSql,new Object[]{employee.getBankerDetails().getBankId(),employee.getBankerDetails().getAccountType(),
						employee.getBankerDetails().getAccountNo(),employee.getBankerDetails().getSince(),employee.getBankerDetails().getIfscCode(),
						employee.getBankerDetails().getBranch(),employeeObj.getId(),JsfsLiterals.EMPLOYEE_CODE});

			}else{
				String sql = "insert into "+JsfsTables.BANKER_DETAILS+"(bankId,accountType,accountNo,since,ifscCode,userType,branch,refId)"
						+ "values(?,?,?,?,?,?,?,?)";

				res1 = jdbcTemplate.update(sql,new Object[]{employee.getBankerDetails().getBankId(),employee.getBankerDetails().getAccountType(),
						employee.getBankerDetails().getAccountNo(),employee.getBankerDetails().getSince(),employee.getBankerDetails().getIfscCode(),
						JsfsLiterals.EMPLOYEE_CODE,employee.getBankerDetails().getBranch(),employee.getId()});

			}
			
			
			if(res1==1){
				restfulResponse.setCode(String.valueOf(""));
				restfulResponse.setMessage(JsfsLiterals.UPDATE_EMPLOYEE_SUCCESS);
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
			}else{
				restfulResponse.setCode(String.valueOf(""));
				restfulResponse.setMessage(JsfsLiterals.UPDATE_EMPLOYEE_FAIL);
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			}


		}else{

			final int empCode = getLastRecPk();
			final String password = idGeneratorUtil.getRandomStringPasswordUtil();

			//JsfsLiterals.EMPLOYEE_ID = ++empCode;
			String profileImageURL = imageUploadUtil.uploadProfileImag(employeeObj.getApplicantImage(),String.valueOf(empCode),JsfsLiterals.EMPLOYEE_CODE);
			employeeObj.setApplicantImage(profileImageURL);
			String idProofImageURL = imageUploadUtil.uploadIdProofImag(employeeObj.getIdProofImage(),String.valueOf(empCode),JsfsLiterals.EMPLOYEE_CODE);
			employeeObj.setIdProofImage(idProofImageURL);
			String addressProofImageURL = imageUploadUtil.uploadAddressProofImag(employeeObj.getAddressProofImage(), String.valueOf(empCode),JsfsLiterals.EMPLOYEE_CODE);
			employeeObj.setAddressProofImage(addressProofImageURL);


			final String insertSql = "insert into "+JsfsTables.EMPLOYEE_DETAILS+"(empCode,password,branchId,designationId,name,surName,fatherName,dob,age,presentAddress,permanentAddress,mobileNo,landNo,email,house,office,qualificationId,casteId,"
					+ "maritalStatus,bloodGroup,spouseName,spouseAge,spouseMobileNo,childrenMale,childrenFemale,vehicleType,vehicleNo,"
					+ "idProofId,idProofNo,idProofImage,addressProofId,addressProofNo,addressProofImage,employeeParticulars,applicantImage,salary,createdBy) "
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
							PreparedStatement pst =
									con.prepareStatement(insertSql, new String[] {"id"});
							pst.setInt(1,empCode);
							pst.setString(2,"" );
							pst.setString(3,employeeObj.getBranchId());
							pst.setInt(4, employeeObj.getDesignationId());
							pst.setString(5,JsfsLiterals.getUpperCase(employeeObj.getName()));
							pst.setString(6,JsfsLiterals.getUpperCase( employeeObj.getSurName()));
							pst.setString(7,JsfsLiterals.getUpperCase( employeeObj.getFatherName()));
							pst.setString(8, employeeObj.getDob());
							pst.setInt(9, employeeObj.getAge());
							pst.setString(10,JsfsLiterals.getUpperCase( employeeObj.getPresentAddress()));
							pst.setString(11,JsfsLiterals.getUpperCase( employeeObj.getPermanentAddress()));
							pst.setString(12, employeeObj.getMobileNo());
							pst.setString(13, employeeObj.getLandNo());
							pst.setString(14, employeeObj.getEmail());
							pst.setString(15, employeeObj.getHouse());
							pst.setString(16, employeeObj.getOffice());
							pst.setInt(17, employeeObj.getQualification());
							pst.setInt(18, employeeObj.getCaste());
							pst.setString(19, employeeObj.getMaritalStatus());
							pst.setString(20, employeeObj.getBloodGroup());
							pst.setString(21, employeeObj.getSpouseName());
							pst.setInt(22, employeeObj.getSpouseAge());
							pst.setString(23, employeeObj.getSpouseMobileNo());
							pst.setInt(24, employeeObj.getNoOfMaleChildrens());
							pst.setInt(25, employeeObj.getNoOfFemailChildrens());
							pst.setString(26, employeeObj.getVehicleType());
							pst.setString(27, employeeObj.getVehicleNo());
							pst.setInt(28, employeeObj.getIdProofId());
							pst.setString(29, employeeObj.getIdProofNo());
							pst.setString(30, employeeObj.getIdProofImage());
							pst.setInt(31, employeeObj.getAddressProofId());
							pst.setString(32, employeeObj.getAddressProofNo());
							pst.setString(33, employeeObj.getAddressProofImage());
							pst.setString(34, employeeObj.getEmployeeParticulars());
							pst.setString(35, employeeObj.getApplicantImage());
							pst.setDouble(36, employeeObj.getSalary());
							pst.setInt(37, employeeObj.getCreatedBy());
							return pst;
						}
					},
					keyHolder);
			long pkId = (Long)keyHolder.getKey();

			if(pkId>0){

				String sql = "insert into "+JsfsTables.BANKER_DETAILS+"(bankId,accountType,accountNo,since,ifscCode,userType,branch,refId)"
						+ "values(?,?,?,?,?,?,?,?)";

				int res1 = jdbcTemplate.update(sql,new Object[]{employee.getBankerDetails().getBankId(),employee.getBankerDetails().getAccountType(),
						employee.getBankerDetails().getAccountNo(),employee.getBankerDetails().getSince(),employee.getBankerDetails().getIfscCode(),
						JsfsLiterals.EMPLOYEE_CODE,employee.getBankerDetails().getBranch(),pkId});

				if(res1==1){

					//**** Inserting into User Table ****************//

					String sql2 = "insert into "+JsfsTables.USER+"(userId,password,name,surName,profilePic,userType)values(?,?,?,?,?,?)";
					int res2 = jdbcTemplate.update(sql2,new Object[]{empCode,password,employeeObj.getName(),employeeObj.getSurName(),employeeObj.getApplicantImage(),
							JsfsLiterals.EMPLOYEE_CODE});

					// ************************************************* //

					smsHelper.sendSMSToEmployee(empCode,employee.getMobileNo(),password);

					restfulResponse.setCode(String.valueOf(empCode));
					restfulResponse.setMessage(JsfsLiterals.CREATE_EMPLOYEE_SUCCESS);
					restfulResponse.setStatus(JsfsLiterals.RESPONSE_SUCCESS);
				}
			}else{
				restfulResponse.setCode(null);
				restfulResponse.setMessage(JsfsLiterals.CREATE_EMPLOYEE_FAIL);
				restfulResponse.setStatus(JsfsLiterals.RESPONSE_FAIL);
			}
		}

		return restfulResponse;
	}

	public int getLastRecPk(){

		String sql1 = "select count(*) from "+JsfsTables.EMPLOYEE_DETAILS;
		int empCount = getJdbcTemplate().queryForInt(sql1);
		if(empCount>0){
			String sql = "select * from "+JsfsTables.EMPLOYEE_DETAILS+" order by 1 desc limit 1";
			Employee employee = (Employee)getJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper(Employee.class));
			int empCode = employee.getEmpCode();
			return ++empCode;
		}else{
			return 10001;
		}
	}



	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from "+JsfsTables.EMPLOYEE_DETAILS;
		List<Employee> employees = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Employee.class));
		return employees;
	}


	@Override
	public Employee getEmployeeById(int empCode) {
		String sql = "select * from "+JsfsTables.EMPLOYEE_DETAILS+" where empCode=?";
		Employee employee = (Employee)getJdbcTemplate().queryForObject(sql,new Object[]{empCode},new BeanPropertyRowMapper(Employee.class));
		employee.setAddressProofImage(JsfsLiterals.BASE_URL+"/employee/addressproof/"+employee.getAddressProofImage());
		employee.setIdProofImage(JsfsLiterals.BASE_URL+"/employee/idproof/"+employee.getIdProofImage());
		employee.setApplicantImage(JsfsLiterals.BASE_URL+"/employee/"+employee.getApplicantImage());

		if(isBankerDetailsExist(employee.getId())){
			String bankerSql = "select * from "+JsfsTables.BANKER_DETAILS+" where refId="+employee.getId()+" and userType="+JsfsLiterals.EMPLOYEE_CODE;
			BankerDetails bankerDetails = (BankerDetails) getJdbcTemplate().queryForObject(bankerSql, new BeanPropertyRowMapper(BankerDetails.class));
			employee.setBankerDetails(bankerDetails);
			return employee;
		}else{
			return employee;
		}

		
	}

	public boolean isBankerDetailsExist(int id){
		boolean isExist=false;
		try{
			String bankerSql = "select * from "+JsfsTables.BANKER_DETAILS+" where refId="+id+" and userType="+JsfsLiterals.EMPLOYEE_CODE;
			BankerDetails bankerDetails = (BankerDetails) getJdbcTemplate().queryForObject(bankerSql, new BeanPropertyRowMapper(BankerDetails.class));
			if(bankerDetails!=null){
				isExist= true;
			}

		}catch(EmptyResultDataAccessException e){
			isExist= false;
		}catch(Exception e1){
			isExist= false;
		}
		finally{
			//isExist = true;
			return isExist;
		}

	}



	@Override
	public RestfulResponse updateEmployee(Employee employee) {

		return null;
	}

	@Override
	public List<Employee> findEmployeesByBranch(String branchCode) {
		String sql = "select * from "+JsfsTables.EMPLOYEE_DETAILS+" where branchId = ?";
		List<Employee> employees = getJdbcTemplate().query(sql,new Object[]{branchCode},new BeanPropertyRowMapper(Employee.class));
		return employees;
	}

}
