package com.mustache.springbootmustache.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MustacheController {

    @GetMapping("/hi")
    public String mustacheCon(Model model) {
        //view에 값을 넘기겠다
        model.addAttribute("username", "헝지");
        return "greetings"; //grettings라는 이름의 view를 리턴

    }

    @GetMapping("/hi/{id}")
    public String mustacheCon2(@PathVariable String id, Model model) {
        //view에 값을 넘기겠다
        model.addAttribute("username", "헝지");
        model.addAttribute("id", id);
        return "greetings"; //grettings라는 이름의 view를 리턴

    }


}
