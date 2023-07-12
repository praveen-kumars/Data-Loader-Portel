package com.processpatientservice.processpatient.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.processpatientservice.processpatient.PatientProcessDataApplication;
import com.processpatientservice.processpatient.DTO.Patientdto;

@SpringBootTest(classes = PatientProcessDataApplication.class)
@ContextConfiguration(classes = PatientProcessDataApplication.class)
public class Patientdtotest {
	
	Patientdto patientdto=new Patientdto();
	
	@Test
	void notnulltest() {
		assertThat(patientdto).isNotNull();
	}
	
	@Test
	void Patientdtotest() {
		Patientdto patientdto=new Patientdto("Arjun","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		patientdto.setPatientName("Arun");
		patientdto.setPhoneNumber("9524289320");
		patientdto.setEmailId("praveencbe525@gmail.com");
		patientdto.setAddress("A-6");
		patientdto.setDateofBirth("08-09-2000");
		patientdto.setDrugId("11111-344-23");
		patientdto.setDrugName("Paraceptomal");
		assertEquals("Arun",patientdto.getPatientName());
		assertEquals("9524289320",patientdto.getPhoneNumber());
		assertEquals("praveencbe525@gmail.com", patientdto.getEmailId());
		assertEquals("08-09-2000",patientdto.getDateofBirth());
		assertEquals("11111-344-23",patientdto.getDrugId());
		assertEquals("A-6",patientdto.getAddress());
		assertEquals("Paraceptomal",patientdto.getDrugName());
		
	}

}
