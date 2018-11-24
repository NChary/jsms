package com.jsms.java.util;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import java.awt.image.ReplicateScaleFilter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public final class GenerateId {

	static byte[] result;

	public String hexEncode(byte[] aInput){
		StringBuilder result = new StringBuilder();
		char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','9','6','3','3','6','9'};
		for (int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append(digits[ (b&0xf0) >> 4 ]);
			result.append(digits[ b&0x0f]);
		}
		return result.toString();
	}


	public String get16DigitNumber(String messageDigest){
		return  messageDigest.substring(9,25);
	}

	public String get4DigitNumber(String messageDigest){
		return  messageDigest.substring(3,7);
	}

	public String generate16DigitNumber(String type){
		String cardNumber="";
		String digit16="";
		try {
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			String randomNum = new Integer(prng.nextInt()).toString();
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			result = sha.digest(randomNum.getBytes());
			String messDigest = hexEncode(result);
			if(!messDigest.isEmpty()){
				// Getting 16 digit number
				if(type.equalsIgnoreCase("CARD")){
					digit16 = get16DigitNumber(messDigest);
				}else if(type.equalsIgnoreCase("CVV")){
					digit16 = get4DigitNumber(messDigest);
				}
				// If first digit is zero then regenerate number
				//String replaceZero = generateId.replaceZero(digit16);
				int zeroIndex = digit16.indexOf("0");
				if (zeroIndex == 0) {

				} else {
					cardNumber = digit16;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cardNumber;
	}




	public static void main (String... arguments) {

		Connection con=null;
		java.sql.PreparedStatement pst = null;

		try {
			GenerateId generateId = new GenerateId();

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jsms","root","root");
			String sql = "insert into card_details(Card_No,CVV_Number)values(?,?)";
			pst = con.prepareStatement(sql);
			String cardNo="";
			String cvvNo="";
			Statement stmt = con.createStatement();
			for(int i=1;i<=5;i++){
				System.out.println(i+ "Card Number = "+generateId.generate16DigitNumber("Card")+"   CVV Number = "+generateId.generate16DigitNumber("CVV"));
				boolean isCardExisted=false;
				boolean isCvvExisted=false;
				
				if(!generateId.generate16DigitNumber("Card").isEmpty()){
					cardNo = generateId.generate16DigitNumber("Card");
				}
				if(!generateId.generate16DigitNumber("CVV").isEmpty()){
					cvvNo = generateId.generate16DigitNumber("CVV");
				}

				if(!cardNo.isEmpty() && !cvvNo.isEmpty()){

					ResultSet rs = stmt.executeQuery("select * from card_details where card_no="+cardNo);
					if(rs.next()){
						isCardExisted=true;
					}

					if(!isCardExisted){
						pst.setString(1, cardNo);
						pst.setString(2, cvvNo);
						pst.executeUpdate();
					}
				}
			}

		}
		catch (Exception ex) {
			System.err.println(ex);
		}
	}


} 
