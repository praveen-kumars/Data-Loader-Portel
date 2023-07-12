package com.addpatient.induction.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.addpatient.induction.PatientinductionApplication;

@SpringBootTest(classes = PatientinductionApplication.class)
@ContextConfiguration(classes = PatientinductionApplication.class)
public class patientdtotest {
	
	PatientDTO patientDTO=new PatientDTO();
	
	@Test
	void notnulltest() {
		assertThat(patientDTO).isNotNull();
	}
	
	@Test
	void patientdtotest() {
		PatientDTO patientDTO=new PatientDTO("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel");
		patientDTO.setPatientName("Arun");
		patientDTO.setPhoneNumber("9524289320");
		patientDTO.setEmailId("praveencbe525@gmail.com");
		patientDTO.setAddress("A-6");
		patientDTO.setDateofBirth("08-09-2000");
		patientDTO.setDrugId("11111-234-23");
		patientDTO.setDrugName("Paraceptomal");
		
		assertEquals("Arun",patientDTO.getPatientName());
		assertEquals("9524289320",patientDTO.getPhoneNumber());
		assertEquals("praveencbe525@gmail.com",patientDTO.getEmailId());
		assertEquals("A-6",patientDTO.getAddress());
		assertEquals("praveencbe525@gmail.com",patientDTO.getEmailId());
		assertEquals("11111-234-23",patientDTO.getDrugId());
		assertEquals("Paraceptomal",patientDTO.getDrugName());

	
	}

}
