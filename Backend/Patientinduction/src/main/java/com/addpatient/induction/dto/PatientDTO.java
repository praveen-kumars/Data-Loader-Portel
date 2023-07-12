package com.addpatient.induction.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
	
   // public PatientDTO(String patientName2, String address2, String string, String emailId2, String phoneNumber2,
//			String drugId2, String drugName2) {
//	}

	private String patientName;
	
	private String address;
	
//    @JsonFormat(pattern = "MM-dd-yyyy")
	private String dateofBirth;
	
	private String emailId;
	
	@Size(min = 10,max = 10,message = "phone number criteria not met")
	private String phoneNumber;
	
	private String drugId;
	
	private String drugName;
	
	

}
