package com.app.it.service;

import java.util.Date;
import java.util.List;

import com.app.it.model.Bill;

public interface IBillService {
	
	public Integer saveBill(Bill e);
	public void updateBill(Bill e);
	public void deleteBill(Integer id);
	public Bill getOneBill(Integer id);
	public List<Bill> getAllBill(Date date);
	

}
