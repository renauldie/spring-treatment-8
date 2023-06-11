package com.spring.threatment.service;

import com.spring.threatment.model.Patients;
import com.spring.threatment.model.Treatments;
import com.spring.threatment.repository.PatientRepository;
import com.spring.threatment.repository.TransactionRepository;
import com.spring.threatment.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public List<Treatments> get() {
        return treatmentRepository.findAll();
    }

    public void create(Treatments treatments) throws Exception {
        Patients patients = patientRepository.findById(treatments.getPatient_id()).get();

        if (patients == null) {
            throw new Exception("Patients not found");
        }

        treatments.setTreatment(null);
        treatments.setDoctor_id(null);

        treatmentRepository.save(treatments);
    }

    public void destroy(Treatments treatment) {
        treatmentRepository.deleteAllById(Collections.singleton(treatment.getId()));
    }

    public void getReport(Long id) {
        transactionRepository.getReport(id);
    }
}
