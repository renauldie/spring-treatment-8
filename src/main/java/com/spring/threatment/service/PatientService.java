package com.spring.threatment.service;

import com.spring.threatment.model.Patients;
import com.spring.threatment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public List<Patients> get() {
        return patientRepository.findAll();
    }

    public void create(Patients patients) {
        patientRepository.save(patients);
    }

    public void destroy(Patients patient) {
        patientRepository.deleteAllById(Collections.singleton(patient.getId()));
    }
}
