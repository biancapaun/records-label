package com.recordslabel.labelapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/access-denied")
public class AccessDeniedExceptionController {

    @GetMapping("")
    public String accessDenied() {
        return "error/accessDenied";
    }
}
