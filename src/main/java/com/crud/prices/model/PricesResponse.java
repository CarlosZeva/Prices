package com.crud.prices.model;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class PricesResponse {

	private long brandId;
	private String startDate;
	private String endDate;
	private long priceList;
	private long productId;
	private float price;

}
