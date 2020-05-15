package com.rhysnguyen.casestudyjavaweb.controller;

import java.util.List;

import javax.validation.Valid;

import com.rhysnguyen.casestudyjavaweb.entity.Customer;
import com.rhysnguyen.casestudyjavaweb.entity.CustomerType;
import com.rhysnguyen.casestudyjavaweb.service.CustomerService;
import com.rhysnguyen.casestudyjavaweb.service.CustomerTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/admin")
public class CustomerController {
    CustomerService customerService;
    CustomerTypeService customerTypeService;

    /**
     * @param customerService the customerService to set
     */
    @Autowired
    public void setCustomerService(final CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * @param customerTypeService the customerTypeService to set
     */
    @Autowired
    public void setCustomerTypeService(CustomerTypeService customerTypeService) {
        this.customerTypeService = customerTypeService;
    }

    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping(value = "/customers")
    public String getListCustomer(final Model model,@PageableDefault(size = 20) Pageable pageable) {
        model.addAttribute("customers", customerService.findAll(pageable));
        return "admin/customer/list";
    }

    @GetMapping(value = "/customer/create")
    public String createCustomer(final Model model) {
        model.addAttribute("customer", new Customer());
        return "admin/customer/create";
    }

    @PostMapping(value = "/customer/create")
    public String processCreateCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
        if (result.hasFieldErrors())
            return "admin/customer/create";
        customerService.save(customer);
        return "redirect:/admin/customers";
    }

    @GetMapping(value="/customer/edit/{id}")
    public String editCustomer(Model model, @PathVariable String id) {
        model.addAttribute("customer", customerService.findById("KH-5421"));
        return "admin/customer/edit";
    }

    @PostMapping(value="/customer/edit/{id}")
    public String processEditCustomer(@ModelAttribute("customer") Customer customer) {
        return "redirect:/admin/customers";
    }
    
    @GetMapping(value="/customer/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        customerService.delete(id);
        return "redirect:/admin/customers";
    }
    

}