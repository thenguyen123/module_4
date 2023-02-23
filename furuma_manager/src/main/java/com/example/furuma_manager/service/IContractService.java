package com.example.furuma_manager.service;

import com.example.furuma_manager.dto.IContractDto;
import com.example.furuma_manager.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<IContractDto> getAllContract(Pageable pageable);
    boolean save(Contract contract);
}
