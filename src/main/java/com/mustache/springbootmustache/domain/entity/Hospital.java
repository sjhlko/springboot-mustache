package com.mustache.springbootmustache.domain.entity;

import com.mustache.springbootmustache.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nation_wide_hospitals")
public class Hospital {
    @Id
    private Integer id;

    //규칙 카멜-스네이크_ 기본값인 경우 name = "" 필요없음
    @Column(name = "hospital_name")
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;
    private String roadNameAddress;


}
