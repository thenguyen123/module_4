package com.example.furuma_manager.service;

import com.example.furuma_manager.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(String name, String type, Pageable pageable);
    boolean save(Facility facility);
    boolean delete(int id);
    Facility findById(int id);
    List<Facility> findAllList();


}
