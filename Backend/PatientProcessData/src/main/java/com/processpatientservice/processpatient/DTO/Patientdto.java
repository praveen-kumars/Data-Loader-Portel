package com.processpatientservice.processpatient.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patientdto {
	
    private String patientName;
	
	private String address;
	
	private String dateofBirth;
	
	private String emailId;
	
	private String phoneNumber;
	
	private String drugId;
	
	private String drugName;
	
	
	

}