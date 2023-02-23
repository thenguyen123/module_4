package com.example.furuma_manager.service;

import com.example.furuma_manager.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    boolean save(ContractDetail contractDetail);
List<ContractDetail> findById(int id);

}
