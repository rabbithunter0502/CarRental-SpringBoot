package com.ducltd00750.service;

import com.ducltd00750.entity.Customer;
import com.ducltd00750.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }
}
