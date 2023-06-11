package com.spring.threatment.service;

import com.spring.threatment.model.Doctors;
import com.spring.threatment.model.Transaction;
import com.spring.threatment.model.Treatments;
import com.spring.threatment.model.request.TreatmentRequest;
import com.spring.threatment.repository.DoctorRepository;
import com.spring.threatment.repository.TransactionRepository;
import com.spring.threatment.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public List<Doctors> get() {
        return doctorRepository.findAll();
    }

    public void create(Doctors doctors) {
        doctorRepository.save(doctors);
    }

    public void destroy(Doctors doctor) {
        doctorRepository.deleteAllById(Collections.singleton(doctor.getId()));
    }

    public void doctorTreatments(TreatmentRequest treatments) throws Exception {

        Optional<Treatments> optionalTreatments = treatmentRepository.findById(treatments.getId());

        if (!optionalTreatments.isPresent()) {
            throw new Exception("Invalid treatment id");
        }

        Treatments validTreatment = optionalTreatments.get();

        Optional<Doctors> optionalDoctor = doctorRepository.findById(treatments.getDoctor_id());

        if (!optionalDoctor.isPresent()) {
            throw new Exception("Invalid Doctors");
        }

        validTreatment.setDoctor_id(treatments.getDoctor_id());
        validTreatment.setTreatment(treatments.getTreatment());
        treatmentRepository.save(validTreatment);

        Transaction transaction = new Transaction();

        transaction.setTreatment_id(treatments.getId());
        transaction.setCharge(treatments.getCharge().longValue());
        transaction.setStatus("TREATMENTED");
        transactionRepository.save(transaction);
    }
}
