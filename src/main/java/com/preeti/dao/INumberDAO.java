package com.preeti.dao;

import com.preeti.entity.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INumberDAO extends JpaRepository<NumberEntity, String> {
}
