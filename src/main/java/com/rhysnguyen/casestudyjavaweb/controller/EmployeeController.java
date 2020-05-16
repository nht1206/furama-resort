package com.rhysnguyen.casestudyjavaweb.controller;

import com.rhysnguyen.casestudyjavaweb.entity.*;
import com.rhysnguyen.casestudyjavaweb.service.DegreeService;
import com.rhysnguyen.casestudyjavaweb.service.DepartmentService;
import com.rhysnguyen.casestudyjavaweb.service.EmployeeService;
import com.rhysnguyen.casestudyjavaweb.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class EmployeeController {
    EmployeeService employeeService;
    DegreeService degreeService;
    PositionService positionService;
    DepartmentService departmentService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Autowired
    public void setDegreeService(DegreeService degreeService){
        this.degreeService = degreeService;
    }

    @Autowired
    public void setPositionService(PositionService positionService){
        this.positionService = positionService;
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @ModelAttribute("degreeList")
    public List<Degree> degreeList(){
        return degreeService.findAll();
    }

    @ModelAttribute("positionList")
    public List<Position> positionList(){
        return positionService.findAll();
    }

    @ModelAttribute("departmentList")
    public List<Department> departmentList(){
        return departmentService.findAll();
    }

    @GetMapping(value="/employees")
    public String getListServices(final Model model, HttpServletRequest request) {
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
        model.addAttribute("employees", employeeService.findAll(PageRequest.of(page, size)));
        return "admin/employee/list";
    }

    @GetMapping(value = "/employee/create")
    public String createEmployee(final Model model) {
        model.addAttribute("employee", new Employee());
        return "admin/employee/create";
    }

    @PostMapping(value = "/employee/create")
    public String processCreateEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
        if (result.hasFieldErrors())
            return "admin/employee/create";
        employeeService.save(employee);
        return "redirect:/admin/employees";
    }

    @GetMapping(value="/employee/edit/{id}")
    public String editEmployee(Model model, @PathVariable Long id) {
        model.addAttribute("employee", employeeService.findById(id));
        return "admin/employee/edit";
    }

    @PostMapping(value="/employee/update")
    public String processEditEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result) {
        if (result.hasFieldErrors())
            return "admin/employee/edit";
        employeeService.save(employee);
        return "redirect:/admin/employees";

    }

    @GetMapping(value="/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/admin/employees";
    }

}