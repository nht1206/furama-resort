package com.rhysnguyen.casestudyjavaweb.dao;

import com.rhysnguyen.casestudyjavaweb.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
