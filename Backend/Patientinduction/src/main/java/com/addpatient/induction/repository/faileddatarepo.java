package com.addpatient.induction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addpatient.induction.model.InvalidData;

@Repository
public interface faileddatarepo extends JpaRepository<InvalidData,String> {

}
