package com.patientupdateservice.patientupdate.patientdtotest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.patientupdateservice.patientupdate.DTO.Patientdto;

public class patientdtotest {
    Patientdto patientdto=new Patientdto();
	
	@Test
	void notnulltest() {
		assertThat(patientdto).isNotNull();
	}
	
	@Test
	void Patientdtotest() {
		Patientdto patientdto=new Patientdto("Arjun","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		patientdto.setPatientName("Arun");
		patientdto.setContactNumber("9524289320");
		patientdto.setPatientEmail("praveencbe525@gmail.com");
		patientdto.setPatientAddress("A-6");
		patientdto.setDateofbirth("08-09-2000");
		patientdto.setDrugId("11111-344-23");
		patientdto.setDrugName("Paraceptomal");
		assertEquals("Arun",patientdto.getPatientName());
		assertEquals("9524289320",patientdto.getContactNumber());
		assertEquals("praveencbe525@gmail.com", patientdto.getPatientEmail());
		assertEquals("08-09-2000",patientdto.getDateofbirth());
		assertEquals("11111-344-23",patientdto.getDrugId());
		assertEquals("A-6",patientdto.getPatientAddress());
		assertEquals("Paraceptomal",patientdto.getDrugName());
	}

}
