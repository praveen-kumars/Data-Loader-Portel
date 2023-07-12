package com.processpatientservice.processpatient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.processpatientservice.processpatient.DTO.Patientdto;
import com.processpatientservice.processpatient.Exception.InvalidTokenException;
import com.processpatientservice.processpatient.MODEL.patient;
import com.processpatientservice.processpatient.client.AuthClient;
import com.processpatientservice.processpatient.service.ProcessService;

@RestController
@CrossOrigin(origins={"*"})
public class ProcessController {
	
	@Autowired
	private AuthClient authClient;
	
	@Autowired
	private ProcessService processService;
	
	
	@GetMapping(path = "/retrieve/{patientName}")
	public ResponseEntity<patient> retrievepatient(@PathVariable("patientName") String patientName,@RequestHeader(name="Authorization",required = true) String token){
		
	if(!authClient.getValidity(token).isValidStatus()) {
		throw new InvalidTokenException("Token is either expired or invalid");
		
		//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	return processService.getPatientDetails(patientName);

	}
	
	@PutMapping(path = "/updatepatient/{patientName}")
	public ResponseEntity<Patientdto> updatePatient(@RequestBody Patientdto patientdto,@PathVariable String patientName,@RequestHeader(name="Authorization",required = true) String token){
		if(!authClient.getValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return processService.processPatientDetails(patientdto,patientName);
	}

}
