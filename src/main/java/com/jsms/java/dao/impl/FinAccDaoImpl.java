package com.jsms.java.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jsms.java.dao.FinAccDao;
import com.jsms.java.model.CashBook;

@Repository(value="finDao")
public class FinAccDaoImpl implements FinAccDao{



	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public List<CashBook> getCashBook() {
		//String sql = "select * from "+JsfsTables.FIN_ACC_CASHBOOK+" order by 9 desc";
		String sql = "select f.receiptType as receiptType,p.paymentType,f.voucherId,f.openingBalance,f.transactionAmount,f.closingBalance,f.transactionDate,f.createdDate from fin_acc_cashbook f "
				+ "left join paymenttypes p on f.transactionType = p.id order by 8 desc";
		List<CashBook> lstCashBook = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(CashBook.class));
		return lstCashBook;
	}



}
