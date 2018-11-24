package com.jsms.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;


public class AgentCommissionGen {

	public static void main(String args[]){
		double amount= 1000.00;
		Connection con=null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsms","root","root");

			String sql = "select distinct a.caderId,a.agentCode,b.caderId,b.agentCode,c.caderId,c.agentCode,d.caderId,d.agentCode,e.caderId,e.agentCode,f.caderId,f.agentCode"+ 
					" from agent_personal_details as a"+
					" LEFT JOIN agent_personal_details as  b on b.agentCode = a.sagentCode"+
					" LEFT JOIN agent_personal_details as c on c.agentCode = b.sagentCode "+
					" LEFT JOIN agent_personal_details as d on d.agentCode = c.sagentCode "+
					" LEFT JOIN agent_personal_details as e on e.agentCode = d.sagentCode "+
					" LEFT JOIN agent_personal_details as f on f.agentCode = e.sagentCode where a.agentCode="+506967;


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

			
//			for (Map.Entry<Integer, String> entry : agentStructure.entrySet()) {
//				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//			 	//double commission = calculateNewBusinessCommission(entry.getKey(),entry.getValue(),amount);
//			}
			
			for(int i=6;i>0;i--){
				if(agentStructure.get(i)!=null){
					System.out.println(i+" = cader"+"Agent = "+agentStructure.get(i));
				}else{
					//Gap comission	
					System.out.println("Agent Gap commission = "+agentStructure.get(i));
				}
			}

			//for (Map.Entry<Integer, String> entry : agentStructure.entrySet()) {
			// System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());


			//double commission = calculateNewBusinessCommission(entry.getKey(),entry.getValue(),amount);
			//}
			new AgentCommissionGen().getCommissionPercentage(2);



		}catch(Exception e){
			e.printStackTrace();
		}

	}
 

	public void getCommissionPercentage(int caderId){
		try {
			String columnName = "";
			
			String sql = "select * from commission_structure where caderId = "+caderId;

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsms","root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				//System.out.println("Percen = "+rs.getString(JsfsLiterals.BONANZA_NEW_BUSINESS));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//List<Agent> agents = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Agent.class));
		//return agents;
	}

	public double calculateCommission(double amount,double percentage){
		return amount*percentage;
	}
}
