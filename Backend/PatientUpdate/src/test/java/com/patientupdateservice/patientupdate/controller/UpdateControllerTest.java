package com.patientupdateservice.patientupdate.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.patientupdateservice.patientupdate.PatientUpdateApplication;
import com.patientupdateservice.patientupdate.client.AuthClient;
import com.patientupdateservice.patientupdate.exception.InvalidTokenException;
import com.patientupdateservice.patientupdate.model.patient;
import com.patientupdateservice.patientupdate.service.Updateservice;
import com.patientupdateservice.patientupdate.service.servicetest;
import com.patientupdateservice.patientupdate.DTO.ValidatingDTO;
import com.patientupdateservice.patientupdate.DTO.Patientdto;

@SpringBootTest
@ContextConfiguration(classes = PatientUpdateApplication.class)
public class UpdateControllerTest {
	
	@Mock
	private Updateservice updateservice;
	@Mock
	private AuthClient authClient;
	
	@InjectMocks
	private UpdateController updateController;
	
	@Test
	void getpatientdata() {
		String tokenString="AAA";
		
		String id="Praveen";
		
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		patient patientot=new patient("Praveen","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel","inducted");
		
		when(authClient.getValidity(tokenString)).thenReturn(validatingDTO);
		when(updateservice.getPatientDetails(id)).thenReturn(new ResponseEntity<patient>(patientot,HttpStatus.OK));
		
		assertEquals(patientot.getPatientName(),updateController.retrievepatient("Praveen", tokenString).getBody().getPatientName());	
		
	}
	
	@Test
	void invalidtokengetpatient() {
        String tokenString="AAA";	
		String id="Praveen";
		
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authClient.getValidity(tokenString)).thenReturn(validatingDTO);
		assertThrows(InvalidTokenException.class, ()->
		updateController.retrievepatient("Praveen", tokenString));
		
		
	}
	
	@Test
	void updatetest(){
		
        String tokenString="AAA";
		String id="Praveen";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		Patientdto patientDTO=new Patientdto("Praveen","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		
		
		
		when(authClient.getValidity(tokenString)).thenReturn(validatingDTO);
		when(updateservice.updatePatientDetails(patientDTO,id)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		ResponseEntity <Patientdto> responseEntity=updateController.updatePatient(patientDTO,id,tokenString);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode() );
		
		
	}
	
	@Test
	void invalidtokenupdatepatient() {
        String tokenString="AAA";	
		String id="Praveen";
		//Patientdto patientDTO=new Patientdto("Praveen","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		Patientdto patientDTO=new Patientdto();
		
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		when(authClient.getValidity(tokenString)).thenReturn(validatingDTO);
		assertThrows(InvalidTokenException.class, ()->
		updateController.updatePatient(patientDTO,id, tokenString));
		
		
	}
	
	@Test
	void updatetestcheck1(){
		
        String tokenString="AAA";
		String id="Praveen";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		Patientdto patientDTO=new Patientdto("Praveen","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		
		
		
		when(authClient.getValidity(tokenString)).thenReturn(validatingDTO);
		when(updateservice.updatePatientDetails(patientDTO,id)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		ResponseEntity <Patientdto> responseEntity=updateController.updatePatient(patientDTO,id,tokenString);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode() );
		
		
	}
	

	

}
