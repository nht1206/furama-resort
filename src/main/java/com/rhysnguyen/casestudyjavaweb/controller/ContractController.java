package com.rhysnguyen.casestudyjavaweb.controller;

import javax.servlet.http.HttpServletRequest;

import com.rhysnguyen.casestudyjavaweb.service.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class ContractController {
    ContractService contractService;
    /**
     * @param contractService the contractService to set
     */
    @Autowired
    public void setContractService(final ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping(value = "contracts")
    public String getAllContracts(final Model model, final HttpServletRequest request) {
        int page = 0;
        int size = 10;
        
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            if (Integer.parseInt(request.getParameter("page")) < 1) {
                page = 0;
            } else {
                page = Integer.parseInt(request.getParameter("page")) - 1;
            }
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            if (Integer.parseInt(request.getParameter("size")) < 1) {
                size = 1;
            } else {
                size = Integer.parseInt(request.getParameter("size"));
            }
        }
        model.addAttribute("contracts", contractService.findAll(PageRequest.of(page, size)));
        return "admin/contract/list";
    }
        
}