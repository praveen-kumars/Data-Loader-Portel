package com.processpatientservice.processpatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PatientProcessDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientProcessDataApplication.class, args);
	}

}
