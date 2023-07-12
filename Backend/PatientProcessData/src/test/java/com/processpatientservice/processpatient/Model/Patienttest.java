package com.processpatientservice.processpatient.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.processpatientservice.processpatient.PatientProcessDataApplication;
import com.processpatientservice.processpatient.MODEL.patient;

@SpringBootTest(classes = PatientProcessDataApplication.class)
@ContextConfiguration(classes = PatientProcessDataApplication.class)
public class Patienttest {
	
	patient patient=new patient();
	
	@Test
	void notnulltest() {
		assertThat(patient).isNotNull();
	}
	
	@Test
	void testpatient() {
		patient patientot=new patient("Arjun","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel","inducted");
		patientot.setPatientName("Praveen");
		patientot.setContactNumber("9524289320");
		patientot.setDateofbirth("08-09-2000");
		patientot.setDrugId("12345-879-34");
		patientot.setDrugName("Paraceptomal");
		patientot.setPatientAddress("A-6");
		patientot.setStatus("Processes");
		patientot.setPatientEmail("praveencbe525@gmail.com");
		assertEquals("Praveen",patientot.getPatientName());
		assertEquals("9524289320",patientot.getContactNumber());
		assertEquals("08-09-2000",patientot.getDateofbirth());
		assertEquals("12345-879-34",patientot.getDrugId());
		assertEquals("Paraceptomal",patientot.getDrugName());
		assertEquals("A-6",patientot.getPatientAddress());
		assertEquals("Processes", patientot.getStatus());
		assertEquals("praveencbe525@gmail.com", patientot.getPatientEmail());
	}

}
