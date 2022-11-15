package com.mustache.springbootmustache.repository;

import com.mustache.springbootmustache.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {
    @Autowired
    HospitalRepository hospitalRepository;

    void print(List<Hospital> hospitals){
        for (Hospital hospital : hospitals) {
            System.out.printf("%s %s\n",hospital.getHospitalName(),hospital.getRoadNameAddress());

        }
    }

    @Test
    void findById(){
        Optional<Hospital> hospital = hospitalRepository.findById(1);
        Hospital hp = hospital.get();
        System.out.println(hp.getId());
        assertEquals(1,hp.getId());
    }

    @Test
    void containing(){
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("송파구");
        this.print(hospitals);
    }

    @Test
    void startsWith(){
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartsWith("강남");
        this.print(hospitals);
    }
    @Test
    void endsWith(){
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndingWith("한방병원");
        this.print(hospitals);
    }

    @Test
    @DisplayName("보건소 보건지소 보건진료소만 출력")
    void findByBusinessTypeNameIn(){
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건 진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.getHospitalName());

        }
    }

    @Test
    void findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan(10,20);
        print(hospitals);
    }

    @Test
    void findByPatientRoomCountBetween() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetween(10,20);
        print(hospitals);
    }

    @Test
    void findByPatientRoomCountBetweenOrderByPatientRoomCountDesc() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(10,20);
        print(hospitals);
    }
}