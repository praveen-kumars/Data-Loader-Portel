package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PassThroughInterceptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.addpatient.induction.PatientinductionApplication;
import com.addpatient.induction.controller.PatientController;
import com.addpatient.induction.dto.PatientDTO;
import com.addpatient.induction.dto.ValidatingDTO;
import com.addpatient.induction.model.Patient;
import com.addpatient.induction.repository.PatientRepo;
import com.addpatient.induction.service.PatientService;

@SpringBootTest(classes = PatientService.class)
@ContextConfiguration(classes = PatientinductionApplication.class)
public class servicetest {
	
	
	@MockBean
	private PatientRepo patientRepo;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientController PatientController;
	
	@Test
	void submittest() {
		String tokenString="AAA";
		PatientDTO patientdto=new PatientDTO("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel");
		List patientList=new ArrayList<>();
		Patient patientsavePatient=new Patient("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel","inducted");
	    patientList.add(patientdto);
	    

	    assertEquals(new ResponseEntity<>(HttpStatus.OK), patientService.savePatient(patientList, tokenString));
	}
	
	@Test
	void submittest1() {
		String tokenString="AAA";
		PatientDTO patientdto=new PatientDTO("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel");
		List patientList=new ArrayList<>();
		Patient patientsavePatient=new Patient("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel","inducted");
	    patientList.add(patientdto);
	    when(patientRepo.existsById(patientdto.getPatientName())).thenReturn(true);
	    assertEquals(new ResponseEntity<>(HttpStatus.OK), patientService.savePatient(patientList, tokenString));
	}
	@Test
	void submittest2() {
		String tokenString="AAA";
		PatientDTO patientdto=new PatientDTO("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel");
		List patientList=new ArrayList<>();
		Patient patientsavePatient=new Patient("Praveen","a-6 coimbatore","Sep 14 05:30:00 IST 2001","praveen525@gmail.com","8220551298","12345-345-12","paraceptomel","inducted");
	    patientList.add(patientdto);
	 
	    
	    assertEquals(new ResponseEntity<>(HttpStatus.OK), patientService.savePatient(patientList, tokenString));
	}
	
	

}
