package com.spring.threatment.controller;

import com.spring.threatment.model.Doctors;
import com.spring.threatment.model.Treatments;
import com.spring.threatment.model.request.TreatmentRequest;
import com.spring.threatment.model.response.ResponseApi;
import com.spring.threatment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/api/doctors")
    public ResponseEntity<?> index() {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("200");
            response.setMessage("Success");
            response.setData(doctorService.get());
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/doctors")
    public ResponseEntity<?> store(@RequestBody Doctors doctors) {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("201");
            response.setMessage("Success create data");
            doctorService.create(doctors);
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/api/doctors")
    public ResponseEntity<?> destroy(@RequestBody Doctors doctor) {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("201");
            response.setMessage("Success delete data");
            doctorService.destroy(doctor);
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/doctors/treatments")
    public ResponseEntity<?> doctorTreatments(@RequestBody TreatmentRequest treatments) {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("201");
            response.setMessage("Success give treatment");
            doctorService.doctorTreatments(treatments);
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.ok(response);
    }
}
