package com.rhysnguyen.casestudyjavaweb.dao;

import com.rhysnguyen.casestudyjavaweb.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
