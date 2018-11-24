package com.jsms.java.service;

import java.util.List;

import com.jsms.java.model.DebitVoucher;
import com.jsms.java.model.DebitVoucherTypes;
import com.jsms.java.model.RestfulResponse;

public interface DebitVoucherService {
	RestfulResponse createDebitVoucher(DebitVoucher debitVoucher);
	List<DebitVoucherTypes> getAllExpenditureTypes();
	List<DebitVoucher> getAllDebitVouchers();
}
