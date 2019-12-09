package com.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.erp.entity.SalesDetails;
import com.erp.model.ShopName;

public interface SalesDetailsRepository extends JpaRepository<SalesDetails, Long>, PagingAndSortingRepository<SalesDetails, Long> {

	List<SalesDetails> findByshopName(ShopName shopName);
}
