package com.example.furuma_manager.repository;

import com.example.furuma_manager.model.Customer;
import com.example.furuma_manager.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

}
