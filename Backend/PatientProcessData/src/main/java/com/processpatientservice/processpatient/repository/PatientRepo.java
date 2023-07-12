package com.processpatientservice.processpatient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.processpatientservice.processpatient.MODEL.patient;

@Repository
public interface PatientRepo extends JpaRepository<patient,String>{

	//Optional<patient> findBypatientName(String patientName);

}
