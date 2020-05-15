package com.rhysnguyen.casestudyjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class EmployeeController {
    @GetMapping(value="/employees")
    public String getListServices(Model model) {
        return "admin/employee/list";
    }   
}