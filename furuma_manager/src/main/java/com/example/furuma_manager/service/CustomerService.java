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
    public Page<Customer> findAll( String name, String email, String type,Pageable pageable) {
        return customerRepository.findAll(name, email, type, pageable);
    }

    @Override
    public boolean save(Customer customer) {
        if(customer!=null){
            customerRepository.save(customer);
            return true;
        } return false;
    }

    @Override
    public boolean deleteById(int id) {
        Customer customer=findById(id);
        if(customer==null){
            return false;
        }
        customer.setDelete(true);
      customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        if(customer==null){
            return false;
        }
      customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }
}
