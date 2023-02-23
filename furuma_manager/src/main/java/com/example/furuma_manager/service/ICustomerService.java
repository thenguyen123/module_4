package com.example.furuma_manager.service;

import com.example.furuma_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll( String name, String email, String type,Pageable pageable);
    boolean save(Customer customer);
    boolean deleteById(int id);
    boolean update(Customer customer);
    Customer findById(int id);
    String checkData(String email,String idCard,String phone);
    List<Customer> findAllList();
}
