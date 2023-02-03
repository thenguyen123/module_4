package com.example.thuc_hanh.repository;

import com.example.thuc_hanh.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer finById(int id);
    void update(int id, Customer customer);
    void remove(int id);
}
