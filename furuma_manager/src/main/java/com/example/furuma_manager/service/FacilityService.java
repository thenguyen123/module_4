package com.example.furuma_manager.service;

import com.example.furuma_manager.model.Facility;
import com.example.furuma_manager.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(String name, String type, Pageable pageable) {
        return facilityRepository.findAd(name, type, pageable);
    }

    @Override
    public boolean save(Facility facility) {
        if (facility == null) {
            return false;
        }
        facilityRepository.save(facility);
        return true;
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        Facility facility=findById(id);
        if (facility == null) {
            return false;
        }
        facility.setDelete(true);
        facilityRepository.save(facility);
        return true;
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).orElse(null);
    }
}
