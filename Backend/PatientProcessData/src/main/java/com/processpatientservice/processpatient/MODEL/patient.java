package com.processpatientservice.processpatient.MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class patient {
	
	
	@Id
	@Column(name="patient_Name")
	private String patientName;
	
	@Column(name="patient_Address")
	private String patientAddress;
	
	@Column(name = "Date_of_Birth")
	private String dateofbirth;
	
	@Column(name = "patient_Email")
	private String patientEmail;
	
	@Column(name="contact_Number")
	private String contactNumber;
	
	@Column(name = "drug_Id")
	private String drugId;
	
	@Column(name = "drug_Name")
	private String drugName;
	
	@Column(name = "status")
	private String status;


}