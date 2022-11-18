package com.mustache.springbootmustache.service;

import com.mustache.springbootmustache.domain.dto.HospitalResponse;
import com.mustache.springbootmustache.domain.entity.Hospital;
import com.mustache.springbootmustache.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


class HospitalServiceTest {
    private HospitalService hospitalService;

    @Autowired
    //HospitalRepository hospitalRepository;

    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);


    @BeforeEach
    void setUp() {
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("3일때 폐업")
    void businessStatusName1() {
        Hospital hospital1 = Hospital.builder()
                .id(718457)
                .businessStatusCode(3)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital1));

        HospitalResponse closedHospitalResponse = hospitalService.getHospital(71857);

        assertEquals("폐업", closedHospitalResponse.getBusinessStatusName());

    }

    @Test
    @DisplayName("13일때 영업중")
    void businessStatusName2() {
        Hospital hospital1 = Hospital.builder()
                .id(4)
                .businessStatusCode(13)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital1));

        HospitalResponse hospitalResponse = hospitalService.getHospital(71857);

        assertEquals("영업중", hospitalResponse.getBusinessStatusName());
    }

    @Test
    @DisplayName("13일때 영업중, 3일때 폐업")
    void businessStatusName3() {
        Hospital hospital1 = Hospital.builder()
                .id(718457)
                .businessStatusCode(3)
                .build();
        Hospital hospital2 = Hospital.builder()
                .id(4)
                .businessStatusCode(13)
                .build();
        // 폐업
        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital1));
        HospitalResponse closedHospitalResponse = hospitalService.getHospital(71857);
        assertEquals("폐업", closedHospitalResponse.getBusinessStatusName());
        // 영업중
        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital2));
        HospitalResponse hospitalResponse = hospitalService.getHospital(4);
        assertEquals("영업중", hospitalResponse.getBusinessStatusName());
    }




//    @Test
//    void getHospital() {
//        HospitalResponse hospitalResponse = hospitalService.getHospital(1);
//        assertEquals("영업중",hospitalResponse.getBusinessStatusName());
//        //assertEquals("폐업",hospitalService.getHospital(111826).getBusinessStatusName());
//
//    }
}