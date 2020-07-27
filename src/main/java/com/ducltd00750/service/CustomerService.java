package com.ducltd00750.service;

import com.ducltd00750.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);
}
