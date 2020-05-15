package com.rhysnguyen.casestudyjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ContractController {
    @GetMapping(value="/contracts")
    public String getListServices() {
        return "admin/contract/list";
    }
    
}