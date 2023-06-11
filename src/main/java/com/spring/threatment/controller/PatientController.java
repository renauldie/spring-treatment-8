package com.spring.threatment.controller;

import com.spring.threatment.model.Patients;
import com.spring.threatment.model.response.ResponseApi;
import com.spring.threatment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/api/patients")
    public ResponseEntity<?> index() {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("200");
            response.setMessage("Success");
            response.setData(patientService.get());
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/patients")
    public ResponseEntity<?> store(@RequestBody Patients patients) {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("201");
            response.setMessage("Success create data");
            patientService.create(patients);
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/api/patients")
    public ResponseEntity<?> destroy(@RequestBody Patients patients) {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("201");
            response.setMessage("Success delete data");
            patientService.destroy(patients);
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }
}
