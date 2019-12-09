package com.erp.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationDto implements Pageable {

	int pageNo;

	int pageSize;

	String sortBy;
	
	public PaginationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaginationDto(int pageNo, int pageSize, String sortBy) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.sortBy = sortBy;
	}

	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public int getPageNumber() {
		return pageNo;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public long getOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable previousOrFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
