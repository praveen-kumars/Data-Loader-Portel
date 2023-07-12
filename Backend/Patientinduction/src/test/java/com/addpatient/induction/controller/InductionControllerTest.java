package com.addpatient.induction.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.addpatient.induction.PatientinductionApplication;
import com.addpatient.induction.Exception.InvalidTokenException;
import com.addpatient.induction.client.AuthClient;
import com.addpatient.induction.dto.PatientDTO;
import com.addpatient.induction.dto.ValidatingDTO;
import com.addpatient.induction.service.PatientService;

@SpringBootTest
@ContextConfiguration(classes = PatientinductionApplication.class)
public class InductionControllerTest {
	
	@InjectMocks
	private PatientController patientController;
	
	@Mock
	private AuthClient authclient;
	
	@Mock
	private PatientService patientService;
	
	
	
	@Test
    void submitdetailwithinvalidtoken() {
		String tokenString="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(false);
		
		PatientDTO patientDTO=new PatientDTO("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		List patientList=new ArrayList<>();
		patientList.add(patientDTO);
		
		when(authclient.getValidity(tokenString)).thenReturn(validatingDTO);
		assertThrows(InvalidTokenException.class,()
				->patientController.addpatient(patientList, tokenString));
		

	}
	
	
	
	@Test
	void submitdetails() {
		String tokenString="AAA";
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		PatientDTO patientDTO=new PatientDTO("Praveen","a-6 coimbatore","Fri Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		List patientList=new ArrayList<>();
		patientList.add(patientDTO);
		when(authclient.getValidity(tokenString)).thenReturn(validatingDTO);
		when(patientService.savePatient(patientList, tokenString)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		ResponseEntity <List<PatientDTO>> responseEntity=patientController.addpatient(patientList, tokenString);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode() );
		
	}
	
	
	
	

}
