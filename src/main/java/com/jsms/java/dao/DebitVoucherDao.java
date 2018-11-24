package com.jsms.java.dao;

import java.util.List;

import com.jsms.java.model.DebitVoucher;
import com.jsms.java.model.DebitVoucherTypes;
import com.jsms.java.model.RestfulResponse;

public interface DebitVoucherDao {
	RestfulResponse createDebitVoucher(DebitVoucher debitVoucher);
	List<DebitVoucherTypes> getAllExpenditureTypes();
	List<DebitVoucher> getAllDebitVouchers();
}
