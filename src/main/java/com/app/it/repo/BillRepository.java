package com.app.it.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.it.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	
	@Query("from Bill s where DATE(s.date) = :date")
	public List<Bill> findByDate(@Param("date") Date date);

}
