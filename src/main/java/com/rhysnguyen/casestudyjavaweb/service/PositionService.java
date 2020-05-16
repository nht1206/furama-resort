package com.rhysnguyen.casestudyjavaweb.service;

import com.rhysnguyen.casestudyjavaweb.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    Position findById(Long id);
    void save(Position position);
    void delete(Long id);
}
