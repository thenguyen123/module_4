package com.example.furuma_manager.repository;

import com.example.furuma_manager.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachRepository  extends JpaRepository<AttachFacility,Integer> {
}
