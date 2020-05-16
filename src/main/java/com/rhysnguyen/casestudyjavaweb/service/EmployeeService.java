package com.rhysnguyen.casestudyjavaweb.service;

import com.rhysnguyen.casestudyjavaweb.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Long id);
    void save(Employee employee);
    void delete(Long id);
}
