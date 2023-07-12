package com.addpatient.induction.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.addpatient.induction.PatientinductionApplication;

@SpringBootTest(classes = PatientinductionApplication.class)
@ContextConfiguration(classes = PatientinductionApplication.class)
public class validatingdtotest {
	
	ValidatingDTO validatingDTO=new ValidatingDTO();
	
	@Test
	void notnulltest() {
		assertThat(validatingDTO).isNotNull();
	}
	
	@Test
	void validatingdtotest() {
		ValidatingDTO validatingDTO=new ValidatingDTO(true);
		validatingDTO.setValidStatus(false);
		assertEquals(false,validatingDTO.isValidStatus());
		
	}

}
