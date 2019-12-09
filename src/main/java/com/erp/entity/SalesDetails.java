package com.erp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.erp.model.ShopName;

@Entity
@Table(name="sales_details")
public class SalesDetails {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "shop_name", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ShopName shopName;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date")
	private String date;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted = false;
	
	@OneToMany(mappedBy = "salesDetails")
	private List<FileUpload> fileUpload;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShopName getShopName() {
		return shopName;
	}

	public void setShopName(ShopName shopName) {
		this.shopName = shopName;
	}

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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<FileUpload> getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(List<FileUpload> fileUpload) {
		this.fileUpload = fileUpload;
	}

	
}