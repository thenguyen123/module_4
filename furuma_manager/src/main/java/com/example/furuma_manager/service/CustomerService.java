package com.example.furuma_manager.service;

import com.example.furuma_manager.model.Customer;
import com.example.furuma_manager.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(String name, String email, String type, Pageable pageable) {
        return customerRepository.findAll(name, email, type, pageable);
    }

    @Override
    public boolean save(Customer customer) {
        if (customer != null) {
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Customer customer = findById(id);
        if (customer == null) {
            return false;
        }
        customer.setDelete(true);
        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        if (customer == null) {
            return false;
        }
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public String checkData(String email, String idCard, String phone) {
        List<Customer> list = customerRepository.findAll();
        for (Customer c : list) {
            if (c.getEmail().equals(email)) {
                return "email duplicates";
            }
            if (c.getIdCard().equals(idCard)) {

                return "Id Card duplicates";
            }
            if (c.getPhoneNumber().equals(phone)) {
                return "phone number duplicate";
            }
        }
        return null;
    }
}
