package com.example.furuma_manager.service;

import com.example.furuma_manager.model.Customer;
import com.example.furuma_manager.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService  {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public boolean save(Customer customer) {
        if(customer!=null){
            customerRepository.save(customer);
            return true;
        } return false;
    }
}
