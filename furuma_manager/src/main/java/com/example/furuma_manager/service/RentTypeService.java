package com.example.furuma_manager.service;

import com.example.furuma_manager.model.FacilityType;
import com.example.furuma_manager.model.RentType;
import com.example.furuma_manager.repository.IFacilityTypeRepository;
import com.example.furuma_manager.repository.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
