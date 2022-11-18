package com.mustache.springbootmustache.controller;

import com.mustache.springbootmustache.domain.entity.Hospital;
import com.mustache.springbootmustache.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;
    public HospitalController(HospitalRepository hospitalRepository){
        this.hospitalRepository=hospitalRepository;
    }

//    @GetMapping("")
//    public String list(Pageable pageable, Model model){
//        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
//        model.addAttribute("hospitals", hospitals);
//        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
//        model.addAttribute("next", pageable.next().getPageNumber());
//        return "hospitals/list";
//    }

    @GetMapping("")
    public String list(@RequestParam String keyword, Pageable pageable, Model model){
        log.info("keyword:{}", keyword);
        Page<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining(keyword,pageable);
        model.addAttribute("hospitals",hospitals);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "hospitals/list";
    }
}
