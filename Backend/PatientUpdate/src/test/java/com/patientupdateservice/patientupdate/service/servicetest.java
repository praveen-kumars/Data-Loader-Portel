package com.patientupdateservice.patientupdate.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.patientupdateservice.patientupdate.PatientUpdateApplication;
import com.patientupdateservice.patientupdate.DTO.Patientdto;
import com.patientupdateservice.patientupdate.DTO.ValidatingDTO;
import com.patientupdateservice.patientupdate.model.patient;
import com.patientupdateservice.patientupdate.repository.PatientRepo;

@SpringBootTest(classes = Updateservice.class)
@ContextConfiguration(classes = Updateservice.class)
public class servicetest extends Updateservice {
	
	@Autowired
	private Updateservice updateService;
	
	@MockBean
	PatientRepo patientRepo;
	
	@Test
	void getpatientdetailsservice() {
		assertThat(updateService).isNotNull();
	}
	
	@Test
	void getpatienttest(){
		
		String id="Arjun";
		//patient patient=new patient();
		//patient patientdetail=patientRepo.findById(id).get();
		
        patient patientot=new patient("Arjun","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel","inducted");
		when(patientRepo.findById(id)).thenReturn(Optional.of(patientot));
	    //when(updateService.getPatientDetails(id)).thenReturn(new ResponseEntity<>(patientot,HttpStatus.OK));
	    System.out.println(patientot);
		assertEquals(patientot.getPatientName(),updateService.getPatientDetails(id).getBody().getPatientName());
	}
	
	@Test
	void invalidpatienttest() {
		String id="Arju";
		patient patientot=new patient();
		//when(Patient=patientRepo.findById(id).get().thenReturn(patientot));
		when(patientRepo.findById(id)).thenReturn(Optional.of(patientot));
		assertEquals(null,updateService.getPatientDetails(id).getBody().getPatientName());
	}
	
	@Test
	void updatetest() {
		String id="Arjun";
		 patient patientot=new patient("Arjun","a-6 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel","inducted");
		 Patientdto patienrequest=new Patientdto("Arjun","a-7 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		 when(patientRepo.findById(id)).thenReturn(Optional.of(patientot));
		 patient patientotupdated=new patient("Arjun","a-7 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel","processes");
		 assertEquals(new ResponseEntity<>(HttpStatus.OK),updateService.updatePatientDetails(patienrequest, id));
		
	}
	
	@Test
	void invalidpatient() {
		String id="Arju";
		 patient patientot=new patient();
		 Patientdto patienrequest=new Patientdto("Arju","a-7 coimbatore","08/09/2000","praveen525@gmail.com","8220551298","1cxx-cfdvv-dcv","paraceptomel");
		 when(patientRepo.findById(id)).thenReturn(Optional.of(patientot));
		 assertEquals(new ResponseEntity<>(HttpStatus.OK),updateService.updatePatientDetails(patienrequest, id));
	}
	
	
	
}
