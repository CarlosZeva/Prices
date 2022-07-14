package com.crud.prices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.*;


@Entity 
@Data
@Getter 
@Setter
public class Prices {

	@Column(name = "BRAND_ID")
	private long brandId;
	@Column(name = "START_DATE")
	private String startDate;
	@Column(name = "END_DATE")
	private String endDate;
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRICE_LIST")
	private long priceList;
	@Column(name = "PRODUCT_ID")
	private long productId;
	@Column(name = "PRIORITY")
	private int priority;
	@Column(name = "PRICE")
	private float price;
	@Column(name = "CURR")
	private String curr;

}
