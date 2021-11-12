package com.app.it.util;

import org.springframework.stereotype.Component;

import com.app.it.model.Bill;

@Component
public class BillUtil {

	
	public void calculateDetails(Bill b) {
		var amt = b.getBillAmount();
		var tax=b.getBillTax();
		b.setBillTotal(amt+ tax);
		
	}
}
