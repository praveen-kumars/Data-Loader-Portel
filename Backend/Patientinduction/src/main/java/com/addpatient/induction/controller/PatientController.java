package com.addpatient.induction.controller;


import java.text.SimpleDateFormat;
import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.addpatient.induction.Exception.InvalidTokenException;
import com.addpatient.induction.client.AuthClient;
import com.addpatient.induction.dto.PatientDTO;
import com.addpatient.induction.model.Patient;
import com.addpatient.induction.service.PatientService;


@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AuthClient authClient;
	
	@CrossOrigin(origins= {"*"})
	@PostMapping(path = "/add-patient")
	public ResponseEntity<List<PatientDTO>> addpatient(@RequestBody List<PatientDTO> patientDTO,@RequestHeader(name = "Authorization",required=true) String token)
	throws InvalidTokenException,NullPointerException{
		if(!authClient.getValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either invalid");
		}
		System.out.println(patientDTO);
	
		return patientService.savePatient(patientDTO, token);
	}
	
	
	

}
