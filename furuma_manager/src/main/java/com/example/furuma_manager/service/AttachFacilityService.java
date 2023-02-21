package com.example.furuma_manager.service;

import com.example.furuma_manager.model.AttachFacility;
import com.example.furuma_manager.repository.IAttachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService{
    @Autowired
    private IAttachRepository attachRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachRepository.findAll();
    }
}
