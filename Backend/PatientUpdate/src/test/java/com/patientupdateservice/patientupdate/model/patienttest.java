package com.patientupdateservice.patientupdate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.patientupdateservice.patientupdate.PatientUpdateApplication;

@SpringBootTest(classes = PatientUpdateApplication.class)
@ContextConfiguration(classes = PatientUpdateApplication.class)
public class patienttest {
	
	patient patietnPatient=new patient();

    @Test
    void testnotnull() {
    	assertThat(patietnPatient).isNotNull();
    }
    
    @Test
    void patienttests() {
    	patient patient=new patient("Arjun","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel","inducted");
    	patient.setPatientName("Arun");
    	patient.setContactNumber("9524289320");
    	patient.setDateofbirth("08-09-2000");
    	patient.setDrugId("11111-345-23");
    	patient.setDrugName("Paraceptomel");
    	patient.setPatientAddress("A-6");
    	patient.setStatus("Processes");
    	patient.setPatientEmail("praveencbe525@gmail.com");
    	assertEquals("Arun",patient.getPatientName());
    	assertEquals("9524289320",patient.getContactNumber());
    	assertEquals("08-09-2000",patient.getDateofbirth());
    	assertEquals("A-6",patient.getPatientAddress());
    	assertEquals("Processes",patient.getStatus());
    	assertEquals("praveencbe525@gmail.com",patient.getPatientEmail());
    	assertEquals("11111-345-23",patient.getDrugId());
    	assertEquals("Paraceptomel",patient.getDrugName());
    }

}
