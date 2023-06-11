package com.spring.threatment.controller;

import com.spring.threatment.model.Treatments;
import com.spring.threatment.model.response.ResponseApi;
import com.spring.threatment.service.TreatmentService;
import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreatmentController {

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/api/treatment")
    public ResponseEntity<?> index() {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("200");
            response.setMessage("Success");
            response.setData(treatmentService.get());
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);

        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/treatment")
    public ResponseEntity<?> store(@RequestBody Treatments treatment) {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("201");
            response.setMessage("Success create data");
            treatmentService.create(treatment);
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("api/treatment/report")
    public ResponseEntity<?> getReport(@RequestBody Long id) {
        ResponseApi response = new ResponseApi();

        try {
            response.setCode("201");
            response.setMessage("Success create data");
            treatmentService.getReport(id);
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

//    @DeleteMapping("/api/treatment")
//    public ResponseEntity<?> destroy(@RequestBody Treatments treatment) {
//        ResponseApi response = new ResponseApi();
//
//        try {
//            response.setCode("201");
//            response.setMessage("Success delete data");
//            treatmentService.destroy(treatment);
//        } catch (Exception e) {
//            response.setCode("99");
//            response.setMessage(e.getMessage());
//        }
//
//        return ResponseEntity.ok(response);
//    }
}
