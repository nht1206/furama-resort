package com.rhysnguyen.casestudyjavaweb.dao;

import com.rhysnguyen.casestudyjavaweb.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long > {

}
