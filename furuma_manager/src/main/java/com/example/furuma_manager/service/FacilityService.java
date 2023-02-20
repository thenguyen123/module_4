package com.example.furuma_manager.service;

import com.example.furuma_manager.model.Facility;
import com.example.furuma_manager.repository.IFacilityRepository;
import com.example.furuma_manager.repository.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService{
    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public Page<Facility> findAll(String name, String type, Pageable pageable) {
        return facilityRepository.findAd(name,type,pageable);
    }

    @Override
    public boolean save(Facility facility) {
        return false;
    }
}
