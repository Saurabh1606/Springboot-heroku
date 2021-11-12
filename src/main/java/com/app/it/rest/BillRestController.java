package com.app.it.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.it.model.Bill;
import com.app.it.service.IBillService;

@RestController
@RequestMapping("/bills")
public class BillRestController {

	
	@Autowired
	private IBillService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveBill(
			@RequestBody Bill bill
			) 
	{
		ResponseEntity<String> resp = null;
		try {
			Integer id = service.saveBill(bill);
			resp = new ResponseEntity<String>(
					"Bill saved "+id,
					HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(
					"Unable to process save",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

	//2. display all
	@GetMapping("/due/date")
	public ResponseEntity<?> getAllBills(
			@RequestParam("date") 
			  @DateTimeFormat(pattern = "dd.MM.yyyy") Date date
				
			) {
		ResponseEntity<?> resp = null;
		try {
			List<Bill> list = service.getAllBill(date);
			resp = new ResponseEntity<List<Bill>>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(
					"Unable to fetch data",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	//3. get one by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneBill(
			@PathVariable Integer id
			) 
	{
		ResponseEntity<?> resp = null;
		try {
			Bill bill = service.getOneBill(id);
			resp = new ResponseEntity<Bill>(
					bill,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(
					"Unable to fetch data",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

	//4. remove one
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeOneBill(
			@PathVariable Integer id
			) 
	{
		ResponseEntity<String> resp = null;
		try {
			service.deleteBill(id);
			resp = new ResponseEntity<String>(
					"Bill deleted!"+id,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(
					"Unable to fetch data for delete",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	//5. update one
	@PutMapping("/update")
	public ResponseEntity<String> updateBill(
			@RequestBody Bill bill) 
	{
		ResponseEntity<String> resp = null;
		try {
			service.updateBill(bill);
			resp = new ResponseEntity<String>(
					"Bill Updated!",
					HttpStatus.OK
					//HttpStatus.RESET_CONTENT
					);
		} catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(
					"Unable to update data",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resp;
	}

}
