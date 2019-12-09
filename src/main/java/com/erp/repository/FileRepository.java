package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.FileUpload;



@Repository
public interface FileRepository extends JpaRepository<FileUpload, Long> {
	

}
