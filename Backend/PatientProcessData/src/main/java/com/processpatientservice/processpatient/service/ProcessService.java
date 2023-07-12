package com.processpatientservice.processpatient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.processpatientservice.processpatient.DTO.Patientdto;
import com.processpatientservice.processpatient.MODEL.patient;
import com.processpatientservice.processpatient.repository.PatientRepo;

@Service
public class ProcessService {
	@Autowired
	PatientRepo patientRepo;
	
	public  ResponseEntity<patient> getPatientDetails(String patientName){
		
		patient patientdataOptional=patientRepo.findById(patientName).get();
		if(patientdataOptional!=null) {
			return new ResponseEntity<>(patientdataOptional,HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Patientdto> processPatientDetails(Patientdto patientdto,String patientName) {
		patient patientupdate=patientRepo.findById(patientName).get();
		if(patientupdate!=null) {
			patientupdate.setStatus("processes");
			patientRepo.save(patientupdate);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

}}
