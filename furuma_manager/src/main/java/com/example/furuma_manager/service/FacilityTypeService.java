package com.example.furuma_manager.service;

import com.example.furuma_manager.model.FacilityType;
import com.example.furuma_manager.repository.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService{
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
