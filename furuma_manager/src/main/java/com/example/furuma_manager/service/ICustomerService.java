package com.example.furuma_manager.service;

import com.example.furuma_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll( String name, String email, String type,Pageable pageable);
    boolean save(Customer customer);
    boolean deleteById(int id);
    boolean update(Customer customer);
    Customer findById(int id);
}
