package com.addpatient.induction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addpatient.induction.model.Patient;


@Repository
public interface PatientRepo extends JpaRepository<Patient,String>{

}
