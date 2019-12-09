package com.erp.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SalesDetailsDto {

	private String name;
	
	private String date;

	private Double amount;

	private String mobileNo;
	
	private String item;
	
	private Long quantity;
	
	@Enumerated(EnumType.STRING)
    private ShopName shopName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public ShopName getShopName() {
		return shopName;
	}

	public void setShopName(ShopName shopName) {
		this.shopName = shopName;
	}

	
	
	
}
