package com.example.furuma_manager.service;

import com.example.furuma_manager.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> findAll(String name, String type, Pageable pageable);
    boolean save(Facility facility);

}
