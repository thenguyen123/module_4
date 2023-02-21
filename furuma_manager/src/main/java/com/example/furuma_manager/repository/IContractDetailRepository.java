package com.example.furuma_manager.repository;

import com.example.furuma_manager.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

}
