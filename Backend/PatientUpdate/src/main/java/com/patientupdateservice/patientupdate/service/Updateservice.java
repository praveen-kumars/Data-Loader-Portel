package com.patientupdateservice.patientupdate.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patientupdateservice.patientupdate.DTO.Patientdto;
import com.patientupdateservice.patientupdate.model.patient;
import com.patientupdateservice.patientupdate.repository.PatientRepo;

@Service
public class Updateservice {
	
	@Autowired
	PatientRepo patientRepo;
	
	public  ResponseEntity<patient> getPatientDetails(String patientName){
		
		patient patientdetail=patientRepo.findById(patientName).get();
		//Optional<patient> patientdataOptional=patientRepo.findBypatientName(patientName);
		if(patientdetail!=null) {
			return new ResponseEntity<>(patientdetail,HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}

	public ResponseEntity<Patientdto> updatePatientDetails(Patientdto patientdto,String patientName) {
		patient patientupdate=patientRepo.findById(patientName).get();
		if(patientupdate!=null) {
			patientupdate.setPatientAddress(patientdto.getPatientAddress());
			patientupdate.setPatientEmail(patientdto.getPatientEmail());
			patientupdate.setContactNumber(patientdto.getContactNumber());
			patientupdate.setDateofbirth(patientdto.getDateofbirth());
			patientupdate.setStatus("inducted");
			patientRepo.save(patientupdate);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
}
