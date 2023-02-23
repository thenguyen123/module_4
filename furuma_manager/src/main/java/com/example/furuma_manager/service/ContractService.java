package com.example.furuma_manager.service;

import com.example.furuma_manager.dto.IContractDto;
import com.example.furuma_manager.model.Contract;
import com.example.furuma_manager.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService{
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Page<IContractDto> getAllContract(Pageable pageable) {
        return contractRepository.getAll(pageable);
    }

    @Override
    public boolean save(Contract contract) {
        if(contract==null){
            return false;
        }contractRepository.save(contract);
        return true;
    }
}
