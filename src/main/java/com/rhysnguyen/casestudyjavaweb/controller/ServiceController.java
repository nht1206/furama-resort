package com.rhysnguyen.casestudyjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/admin")
public class ServiceController {
    @GetMapping(value="/services")
    public String getListServices() {
        return "admin/service/list";
    }
    
}