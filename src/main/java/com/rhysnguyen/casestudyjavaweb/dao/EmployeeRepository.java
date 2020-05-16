package com.rhysnguyen.casestudyjavaweb.dao;

import com.rhysnguyen.casestudyjavaweb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
