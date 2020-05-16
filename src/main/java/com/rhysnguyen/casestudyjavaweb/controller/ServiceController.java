package com.rhysnguyen.casestudyjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rhysnguyen.casestudyjavaweb.entity.RentType;
import com.rhysnguyen.casestudyjavaweb.entity.Service;
import com.rhysnguyen.casestudyjavaweb.entity.ServiceType;
import com.rhysnguyen.casestudyjavaweb.service.RentTypeService;
import com.rhysnguyen.casestudyjavaweb.service.ServiceService;
import com.rhysnguyen.casestudyjavaweb.service.ServiceTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/admin")
public class ServiceController {
    ServiceService serviceService;
    ServiceTypeService serviceTypeService;
    RentTypeService rentTypeService;
    /**
     * @param serviceService the serviceService to set
     */
    @Autowired
    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    /**
     * @param serviceTypeService the serviceTypeService to set
     */
    @Autowired
    public void setServiceTypeService(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    /**
     * @param rentTypeService the rentTypeService to set
     */
    @Autowired
    public void setRentTypeService(RentTypeService rentTypeService) {
        this.rentTypeService = rentTypeService;
    }

    @ModelAttribute("serviceTypes")
    public List<ServiceType> getServiceTypes() {
        return serviceTypeService.findAll();
    }
    @ModelAttribute("rentTypes")
    public List<RentType> getRentTypes() {
        return rentTypeService.findAll();
    }

    @GetMapping(value="/services")
    public String getListServices(Model model, HttpServletRequest request) {
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
        model.addAttribute("services", serviceService.findAll(PageRequest.of(page, size)));
        return "admin/service/list";
    }

    @GetMapping(value="/service/create")
    public String createService(Model model) {
        model.addAttribute("service", new Service());
        return "admin/service/create";
    }    
    
    
}