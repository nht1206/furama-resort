package com.rhysnguyen.casestudyjavaweb.service;

import com.rhysnguyen.casestudyjavaweb.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department findById(Long id);
    void save(Department department);
    void delete(Long id);
}
