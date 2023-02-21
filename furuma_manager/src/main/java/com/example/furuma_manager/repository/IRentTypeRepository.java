package com.example.furuma_manager.repository;

import com.example.furuma_manager.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
