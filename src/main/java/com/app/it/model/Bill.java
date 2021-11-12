package com.app.it.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "bill_tab")
public class Bill {

	@Id
	@GeneratedValue
	@Column(name = "billid")
	private Integer billId;

	@Column(name = "bname")
	private String billName;

	@Column(name="date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;

	@Column(name = "billAmount")
	private Double billAmount;

	@Column(name = "billTax")
	private Double billTax;

	@Column(name = "billtotal")
	private Double billTotal;
}
