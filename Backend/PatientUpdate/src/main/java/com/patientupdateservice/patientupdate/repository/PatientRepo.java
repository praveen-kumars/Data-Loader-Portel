package com.patientupdateservice.patientupdate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patientupdateservice.patientupdate.DTO.Patientdto;
import com.patientupdateservice.patientupdate.model.patient;

@Repository
public interface PatientRepo extends JpaRepository<patient,String>{

	
	Optional<patient> findBypatientName(String patientName);

	

}
