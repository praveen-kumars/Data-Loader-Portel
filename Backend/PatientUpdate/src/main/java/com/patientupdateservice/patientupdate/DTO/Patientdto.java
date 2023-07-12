package com.patientupdateservice.patientupdate.DTO;

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
	
	private String patientAddress;
	
	private String dateofbirth;
	
	private String patientEmail;
	
	private String contactNumber;
	
	private String drugId;
	
	private String drugName;
	
	
	

}
