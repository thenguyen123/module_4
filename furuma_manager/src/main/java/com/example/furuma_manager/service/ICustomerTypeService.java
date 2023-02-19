package com.example.furuma_manager.service;

import com.example.furuma_manager.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
