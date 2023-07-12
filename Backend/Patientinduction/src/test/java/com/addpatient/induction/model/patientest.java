package com.addpatient.induction.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.addpatient.induction.PatientinductionApplication;

@SpringBootTest(classes = PatientinductionApplication.class)
@ContextConfiguration(classes = PatientinductionApplication.class)
public class patientest {
	
	
	Patient patient=new Patient();
	
	@Test
	void patientnotnulltest() {
		assertThat(patient).isNotNull();}
	
	
	@Test
	void testingpatient() {
		Patient patient=new Patient("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel","inducted");
		patient.setPatientName("Arun");
		patient.setContactNumber("9524289320");
		patient.setPatientEmail("praveencbe525@gmail.com");
		patient.setDateofbirth("08-09-2000");
		patient.setDrugName("Paraceptomal");
		patient.setStatus("Inducted");
		patient.setDrugId("1111-345-98");
		patient.setPatientAddress("a-6");
		assertEquals("Arun",patient.getPatientName());
		assertEquals("9524289320", patient.getContactNumber());
		assertEquals("praveencbe525@gmail.com",patient.getPatientEmail());
		assertEquals("Inducted",patient.getStatus());
		assertEquals("1111-345-98",patient.getDrugId());
		assertEquals("a-6",patient.getPatientAddress());
		assertEquals("Paraceptomal",patient.getDrugName());
	}
	
	

}
