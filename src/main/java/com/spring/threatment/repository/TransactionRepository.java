package com.spring.threatment.repository;

import com.spring.threatment.model.Transaction;
import com.spring.threatment.model.Treatments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    String reportQuery = "select p.name, d.name, t.complaint, t.treatment, t2.charge, t2.status " +
            "from treatments t " +
            "         join doctors d on t.doctor_id = d.id " +
            "         join patients p on p.id = t.patient_id " +
            "         join transactions t2 on t.id = t2.treatment_id " +
            "where p.id = :patient_id";
    @Query(nativeQuery = true, value = reportQuery)
    public Map<String, Object> getReport(Long patient_id);
}
