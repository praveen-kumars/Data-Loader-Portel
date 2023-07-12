package com.patientupdateservice.patientupdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.patientupdateservice.patientupdate.DTO.Patientdto;
import com.patientupdateservice.patientupdate.client.AuthClient;
import com.patientupdateservice.patientupdate.exception.InvalidTokenException;
import com.patientupdateservice.patientupdate.model.patient;
import com.patientupdateservice.patientupdate.service.Updateservice;

@RestController
@CrossOrigin(origins={"*"})
public class UpdateController {
	
	@Autowired
	private AuthClient authClient;
	
	@Autowired
	private Updateservice updateservice;
	
	


	@GetMapping(path = "/retrieve/{patientName}")
	public ResponseEntity<patient> retrievepatient(@PathVariable("patientName") String patientName,@RequestHeader(name="Authorization",required = true) String token)
	throws InvalidTokenException{
	
	if(!authClient.getValidity(token).isValidStatus()) {
		throw new InvalidTokenException("Token is either expired or invalid");
		//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	return updateservice.getPatientDetails(patientName);

	}
	
	@PutMapping(path = "/updatepatient/{patientName}")
	public ResponseEntity<Patientdto> updatePatient(@RequestBody Patientdto patientdto,@PathVariable String patientName,@RequestHeader(name="Authorization",required = true) String token){
		if(!authClient.getValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		System.out.println(patientdto);
		return updateservice.updatePatientDetails(patientdto,patientName);
	}
	
	
		
	
	



}
