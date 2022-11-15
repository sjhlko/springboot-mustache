package com.mustache.springbootmustache.repository;

import com.mustache.springbootmustache.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByRoadNameAddressContaining(String keyword); // 포함
    List<Hospital> findByHospitalNameStartsWith(String keyword); // 시작
    List<Hospital> findByHospitalNameEndingWith(String keyword); // 끝남
}
