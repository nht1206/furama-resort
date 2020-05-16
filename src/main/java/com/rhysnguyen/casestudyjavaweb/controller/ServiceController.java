package com.rhysnguyen.casestudyjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;





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
    public void setServiceService(final ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    /**
     * @param serviceTypeService the serviceTypeService to set
     */
    @Autowired
    public void setServiceTypeService(final ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    /**
     * @param rentTypeService the rentTypeService to set
     */
    @Autowired
    public void setRentTypeService(final RentTypeService rentTypeService) {
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

    @GetMapping(value = "/services")
    public String getListServices(final Model model, final HttpServletRequest request) {
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

    @GetMapping(value = "/service/create")
    public String createService(final Model model) {
        model.addAttribute("service", new Service());
        return "admin/service/create";
    }

    @PostMapping(value = "/service/create")
    public String processCreateService(@ModelAttribute @Valid final Service service, final BindingResult result) {
        if (result.hasFieldErrors()) {
            return "admin/service/create";
        }
        serviceService.save(service);
        return "redirect:/admin/services";
    }

    @GetMapping(value = "/service/edit/{id}")
    public String editService(@PathVariable("id") final String id, final Model model) {
        if (id == null || id.isEmpty()) {
            return "redirect:/admin/services";
        } else {
            if (serviceService.findById(id) == null) {
                return "redirect:/admin/services";
            }
        }
        final Service service = serviceService.findById(id);

        model.addAttribute("service", service);
        return "admin/service/edit";
    }

    @PostMapping(value = "/service/update")
    public String processEditService(@ModelAttribute @Valid final Service service, final BindingResult result) {
        if (result.hasFieldErrors()) {
            return "admin/service/create";
        }
        serviceService.save(service);
        return "redirect:/admin/services";
    }
    
    @GetMapping(value = "/service/delete/{id}")
    public String deleteService(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return "redirect:/admin/services";
        } else {
            if (serviceService.findById(id) == null) {
                return "redirect:/admin/services";
            }
        }
        serviceService.remove(id);
        return "redirect:/admin/services";
    }

}