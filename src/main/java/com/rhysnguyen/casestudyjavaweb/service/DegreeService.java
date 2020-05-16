package com.rhysnguyen.casestudyjavaweb.service;

import com.rhysnguyen.casestudyjavaweb.entity.Degree;

import java.util.List;

public interface DegreeService {
    List<Degree> findAll();
    Degree findById(Long id);
    void save(Degree degree);
    void delete(Long id);
}
