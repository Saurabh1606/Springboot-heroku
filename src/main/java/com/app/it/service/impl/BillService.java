package com.app.it.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.it.model.Bill;
import com.app.it.repo.BillRepository;
import com.app.it.service.IBillService;
import com.app.it.util.BillUtil;

@Service
public class BillService implements IBillService {

	@Autowired
	private BillRepository repo;
	
	@Autowired 
	private BillUtil util;
	
	@Override
	public Integer saveBill(Bill b) {
		util.calculateDetails(b);
		Integer bid=repo.save(b).getBillId();
		return bid;
	}

	@Override
	public void updateBill(Bill b) {
		util.calculateDetails(b);
		repo.save(b);
		
	}

	@Override
	public void deleteBill(Integer id) {
			repo.deleteById(id);
		
	}

	@Override
	public Bill getOneBill(Integer id) {
		Optional<Bill> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Bill> getAllBill(Date date) {
		return repo.findByDate(date);
	}

}
