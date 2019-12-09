package com.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.erp.entity.FileUpload;
import com.erp.entity.SalesDetails;
import com.erp.model.PaginationDto;
import com.erp.model.SalesDetailsDto;
import com.erp.model.ShopName;
import com.erp.repository.FileRepository;
import com.erp.repository.SalesDetailsRepository;

@Service
public class SalesDetailsImpl implements SalesDetailsService {

	@Autowired SalesDetailsRepository salesDetailsRepository;
	@Autowired FileRepository  fileRepository;
	@Autowired private Environment env;
	Logger log = LoggerFactory.getLogger(SalesDetailsRepository.class);

	@Override
	public boolean submitSalesDetails(SalesDetailsDto salesDetailsDto, List<MultipartFile> uploadfileList) {

		SalesDetails salesDetails = new SalesDetails();
		salesDetails.setName(salesDetailsDto.getName());
		salesDetails.setShopName(salesDetailsDto.getShopName());
		salesDetails.setAmount(salesDetailsDto.getAmount());
		salesDetails.setDate(salesDetailsDto.getDate());
		salesDetails.setItem(salesDetailsDto.getItem());
		salesDetails.setMobileNo(salesDetailsDto.getMobileNo());
		salesDetails.setQuantity(salesDetailsDto.getQuantity());
		salesDetails = salesDetailsRepository.save(salesDetails);
		try {
			for(MultipartFile uploadfile : uploadfileList) {
				String filename = uploadfile.getOriginalFilename();	
				filename = filename.replaceAll(" ", "");
				String directory = env.getProperty("netgloo.paths.uploadedFiles")+salesDetails.getId();
				File dir = new File(directory);
				dir.mkdir();
				String filepath = Paths.get(directory, filename).toString();	
				String path = "/image/"+salesDetails.getId();
				// =============Save the file locally====================
				BufferedOutputStream stream =
						new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				stream.write(uploadfile.getBytes());
				stream.close();

				FileUpload fileUpload = new FileUpload();
				fileUpload.setFileName(filename);
				fileUpload.setFilePath(path+filename);
				fileUpload.setFileType(uploadfile.getContentType());
				fileUpload.setSalesDetails(salesDetails);
				salesDetails = salesDetailsRepository.findById(salesDetails.getId()).orElse(null);
				fileUpload.setSalesDetails(salesDetails);
				fileRepository.save(fileUpload); 
			}}
		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return true;
	}




	@Override
	public List<SalesDetails> getSalesDetails(ShopName shopName,PaginationDto paginationDto) {

		int pageNo = paginationDto.getPageNo();
		int pageSize =paginationDto.getPageSize();
		String sortBy = paginationDto.getSortBy();
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<SalesDetails> salesDetails = salesDetailsRepository.findByshopName(shopName);
		if(salesDetails != null) {
			Page<SalesDetails> pagedResult = salesDetailsRepository.findAll(pageable);
			
			return pagedResult.getContent();
		}
		return null;
	}

	@Override
	public boolean deleteSalesDetails(Long id) {
		log.info("Start :: deleteSalesDetails in SalesDetailsImpl for input data {} ",id );
		SalesDetails salesDetails = salesDetailsRepository.findById(id).orElse(null);
		if(salesDetails != null) {
			salesDetails.setIsDeleted(true);
			salesDetailsRepository.save(salesDetails);
			log.info("End :: deleteSalesDetails in SalesDetailsImpl");
			return true;
		}
		return false;

	}

	@Override
	public boolean updateSalesDetails(SalesDetailsDto salesDetailsDto,Long id, List<MultipartFile> uploadfileList) {
		log.info("Start :: updateSalesDetails in SalesDetailsImpl for input data {}",salesDetailsDto);
		SalesDetails salesDetails = salesDetailsRepository.findById(id).orElse(null);
		if(salesDetails != null) {
		
			salesDetails.setName(salesDetailsDto.getName());
			salesDetails.setAmount(salesDetailsDto.getAmount());
			salesDetails.setDate(salesDetailsDto.getDate());
			salesDetails.setQuantity(salesDetailsDto.getQuantity());
			salesDetails.setMobileNo(salesDetailsDto.getMobileNo());
			salesDetails.setShopName(salesDetailsDto.getShopName());
			salesDetails.setItem(salesDetailsDto.getItem());
			salesDetails = salesDetailsRepository.save(salesDetails);
			
			try {
				for(MultipartFile uploadfile : uploadfileList) {
					String filename = uploadfile.getOriginalFilename();	
					filename = filename.replaceAll(" ", "");
					String directory = env.getProperty("netgloo.paths.uploadedFiles")+salesDetails.getId();
					File dir = new File(directory);
					dir.mkdir();
					String filepath = Paths.get(directory, filename).toString();	
					String path = "/image/"+salesDetails.getId();
					// =============Save the file locally====================
					BufferedOutputStream stream =
							new BufferedOutputStream(new FileOutputStream(new File(filepath)));
					stream.write(uploadfile.getBytes());
					stream.close();

					FileUpload fileUpload = new FileUpload();
					fileUpload.setFileName(filename);
					fileUpload.setFilePath(path+filename);
					fileUpload.setFileType(uploadfile.getContentType());
					fileUpload.setSalesDetails(salesDetails);
					salesDetails = salesDetailsRepository.findById(id).orElse(null);
					fileUpload.setSalesDetails(salesDetails);
					fileRepository.save(fileUpload); 
				}}
			catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		return true;
	
	}


}



