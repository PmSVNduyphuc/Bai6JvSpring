package com.example.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index","/home"})
    public String showIndex() {
        return "index"; //tên view = tên file html
    }
}
