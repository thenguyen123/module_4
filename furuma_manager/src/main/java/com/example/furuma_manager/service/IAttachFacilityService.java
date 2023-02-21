package com.example.furuma_manager.service;

import com.example.furuma_manager.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

}
