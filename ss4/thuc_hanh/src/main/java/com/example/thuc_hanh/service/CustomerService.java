package com.example.thuc_hanh.service;

import com.example.thuc_hanh.model.Customer;
import com.example.thuc_hanh.repository.CustomerRepository;
import com.example.thuc_hanh.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private static final ICustomerRepository customerRepository=new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
customerRepository.save(customer);
    }

    @Override
    public Customer finById(int id) {
        return customerRepository.finById(id);
    }

    @Override
    public void update(int id, Customer customer) {
customerRepository.update(id,customer);
    }

    @Override
    public void remove(int id) {
customerRepository.remove(id);
    }
}
