package com.rhysnguyen.casestudyjavaweb.service;

import com.rhysnguyen.casestudyjavaweb.dao.DegreeRepository;
import com.rhysnguyen.casestudyjavaweb.entity.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeServiceImpl implements DegreeService {
    DegreeRepository degreeRepository;
    @Autowired
    public void setDegreeRepository(DegreeRepository degreeRepository){
        this.degreeRepository = degreeRepository;
    }
    @Override
    public List<Degree> findAll() {
        return degreeRepository.findAll();
    }

    @Override
    public Degree findById(Long id) {
        return degreeRepository.getOne(id);
    }

    @Override
    public void save(Degree degree) {
        degreeRepository.save(degree);
    }

    @Override
    public void delete(Long id) {
        degreeRepository.deleteById(id);
    }
}
