package com.mustache.springbootmustache.controller;

import com.mustache.springbootmustache.domain.dto.HospitalResponse;
import com.mustache.springbootmustache.domain.entity.Hospital;
import com.mustache.springbootmustache.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {
    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){ //DTO
        HospitalResponse hospitalResponse = hospitalService.getHospital(id); //Entity
        return ResponseEntity.ok().body(hospitalResponse); // DTO
    }
}
