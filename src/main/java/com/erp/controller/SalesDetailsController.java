package com.erp.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.erp.entity.SalesDetails;
import com.erp.model.PaginationDto;
import com.erp.model.SalesDetailsDto;
import com.erp.model.ShopName;
import com.erp.service.SalesDetailsService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/api/erp")
public class SalesDetailsController {

	Logger log = LoggerFactory.getLogger(SalesDetailsController.class);
	
	@Autowired
	SalesDetailsService salesDetailsService;


	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String checkStatus() {
		return "I am ok!";
	}

	@RequestMapping(value = "/submitSalesDetails", method = RequestMethod.POST)
	public String submitSalesDetails(SalesDetailsDto salesDetailsDto, @RequestParam("uploadfile") List<MultipartFile> uploadfileList) {
		log.info("Start:: submitSalesDetails in SalesDetailsController for input data: {}", salesDetailsDto);
		boolean salesDetails  = salesDetailsService.submitSalesDetails(salesDetailsDto, uploadfileList);
		if(salesDetails) 
			return "successMessage:  Sales details submit successfully";  
		else
			return "failureMessage:  ";

	}

	@RequestMapping(value = "/getSalesDetails/{shopName}", method = RequestMethod.GET)
	public ResponseEntity<?> getSalesDetails(@PathVariable ShopName shopName, @RequestBody PaginationDto paginationDto ) {
		List<SalesDetails> list = salesDetailsService.getSalesDetails(shopName,paginationDto);

		if(list != null) {
			return new ResponseEntity<>(list ,HttpStatus.OK);
		}
		else {	 
			return new ResponseEntity<>("failureMessage" , HttpStatus.BAD_REQUEST);		 
		}
	}

	@RequestMapping(value= "/deleteSalesDetails/{id}" , method = RequestMethod.DELETE)
	public String deleteSalesDetails(@PathVariable long id) {
		boolean deleteDetails = salesDetailsService.deleteSalesDetails(id);
		if(deleteDetails) 
			return "SucessMessage: sales details delete sucessfully";
		else
			return "failureMessage:something went wrong";
	}

	@RequestMapping(value = "/updateSalesDetails/{id}", method = RequestMethod.PUT)
	public String updateSalesDetails(SalesDetailsDto salesDetailsDto, @PathVariable Long id, @RequestParam("uploadfile") List<MultipartFile> uploadfileList) {

		boolean updateDetails = salesDetailsService.updateSalesDetails(salesDetailsDto, id,uploadfileList);
		if(updateDetails)
			return "sucessMessage: sales updated sucessfully";
		else
			return "failureMessage: something went wrong";

	}

}
