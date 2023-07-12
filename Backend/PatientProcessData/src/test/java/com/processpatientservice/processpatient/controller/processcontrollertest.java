package com.processpatientservice.processpatient.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.processpatientservice.processpatient.PatientProcessDataApplication;
import com.processpatientservice.processpatient.DTO.Patientdto;
import com.processpatientservice.processpatient.DTO.ValidatingDTO;
import com.processpatientservice.processpatient.Exception.InvalidTokenException;
import com.processpatientservice.processpatient.MODEL.patient;
import com.processpatientservice.processpatient.client.AuthClient;
import com.processpatientservice.processpatient.service.ProcessService;

@SpringBootTest
@ContextConfiguration(classes =PatientProcessDataApplication.class)
public class processcontrollertest {
	
	@Mock
	private ProcessService processService;
	
	@Mock
	private AuthClient authclient;
	
	@InjectMocks
	private ProcessController processcontroller;
	
	@Test
	void getpatientdata() {
		String tokenString="AAA";
		
		String id="Praveen";
		
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		patient patientot=new patient("Praveen","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel","inducted");
		
		when(authclient.getValidity(tokenString)).thenReturn(validatingDTO);
		when(processService.getPatientDetails(id)).thenReturn(new ResponseEntity<patient>(patientot,HttpStatus.OK));
		
		assertEquals(patientot.getPatientName(),processcontroller.retrievepatient("Praveen", tokenString).getBody().getPatientName());	
		
	}
	@Test
	void invalidtokengetpatient() {
        String tokenString="AAA";	
		String id="Praveen";
		
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authclient.getValidity(tokenString)).thenReturn(validatingDTO);
		assertThrows(InvalidTokenException.class, ()->
		processcontroller.retrievepatient("Praveen", tokenString));
		
		
	}
	
	@Test
	void processtest(){
		
        String tokenString="AAA";
		String id="Praveen";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		Patientdto patientDTO=new Patientdto("Praveen","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		
		
		
		when(authclient.getValidity(tokenString)).thenReturn(validatingDTO);
		when(processService.processPatientDetails(patientDTO,id)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		ResponseEntity <Patientdto> responseEntity=processcontroller.updatePatient(patientDTO,id,tokenString);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode() );
		
		
	}
	
	@Test
	void invalidtokenupdatepatient() {
        String tokenString="AAA";	
		String id="Praveen";
		//Patientdto patientDTO=new Patientdto("Praveen","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		Patientdto patientDTO=new Patientdto();
		
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authclient.getValidity(tokenString)).thenReturn(validatingDTO);
		assertThrows(InvalidTokenException.class, ()->
		processcontroller.updatePatient(patientDTO,id, tokenString));
		
		
	}
	
	@Test
	void processtestcheck1(){
		
        String tokenString="AAA";
		String id="Praveen";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		Patientdto patientDTO=new Patientdto("Praveen","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		
		
		
		when(authclient.getValidity(tokenString)).thenReturn(validatingDTO);
		when(processService.processPatientDetails(patientDTO,id)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		ResponseEntity <Patientdto> responseEntity=processcontroller.updatePatient(patientDTO,id,tokenString);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode() );
		
		
	}
	

}
