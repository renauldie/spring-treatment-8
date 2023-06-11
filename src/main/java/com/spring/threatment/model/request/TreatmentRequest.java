package com.spring.threatment.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreatmentRequest {

    private Long id;

    private Long patient_id;

    private Long doctor_id;

    private String complaint;

    private String treatment;

    private Double charge;

    private String status;

    private String treatment_id;
}
