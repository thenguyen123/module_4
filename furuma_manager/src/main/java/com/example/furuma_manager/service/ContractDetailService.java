package com.example.furuma_manager.service;

import com.example.furuma_manager.model.ContractDetail;
import com.example.furuma_manager.repository.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService{
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public boolean save(ContractDetail contractDetail) {
        if(contractDetail==null){
            return false;
        }contractDetailRepository.save(contractDetail);
        return true;
    }

    @Override
    public List<ContractDetail> findById(int id) {
        return contractDetailRepository.findByContract_Id(id);
    }
}
