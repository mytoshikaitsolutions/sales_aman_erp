package com.erp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.erp.entity.SalesDetails;
import com.erp.model.PaginationDto;
import com.erp.model.SalesDetailsDto;
import com.erp.model.ShopName;


public interface SalesDetailsService {

	boolean submitSalesDetails(SalesDetailsDto salesDetailsDto);

	 List<SalesDetails> getSalesDetails(ShopName shopName, PaginationDto paginationDto);

	boolean deleteSalesDetails(Long id);

	boolean updateSalesDetails(SalesDetailsDto salesDetailsDto, Long id, List<MultipartFile> uploadfileList);

}
