package com.spring.threatment.repository;

import com.spring.threatment.model.Patients;
import com.spring.threatment.model.Treatments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatments, Long> {

}
