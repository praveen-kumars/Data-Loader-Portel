package com.addpatient.induction.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hibernate.engine.jdbc.spi.InvalidatableWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.addpatient.induction.PatientinductionApplication;

@SpringBootTest(classes = PatientinductionApplication.class)
@ContextConfiguration(classes = PatientinductionApplication.class)
public class Invalidpatienttest {
	
	InvalidData invalidData=new InvalidData();
	
	@Test
	void notnulltest() {
		assertThat(invalidData).isNotNull();
	}
	
	@Test
	void invaliddatatest() {
		InvalidData invalidData=new InvalidData("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel","inducted");

		invalidData.setPatientName("Arun");
		invalidData.setContactNumber("9524289320");
		invalidData.setPatientEmail("praveencbe525@gmail.com");
		invalidData.setDateofbirth("08-09-2000");
		invalidData.setDrugId("12345-123-88");
		invalidData.setDrugName("Paraceptomal");
		invalidData.setStatus("Failed");
		invalidData.setPatientAddress("a-6");
		assertEquals("Arun",invalidData.getPatientName());
		assertEquals("9524289320",invalidData.getContactNumber());
		assertEquals("08-09-2000",invalidData.getDateofbirth());
		assertEquals("12345-123-88",invalidData.getDrugId());
		assertEquals("Failed",invalidData.getStatus());
		assertEquals("Paraceptomal",invalidData.getDrugName());
		
		
		
	}

}
