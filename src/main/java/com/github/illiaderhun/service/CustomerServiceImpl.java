package com.github.illiaderhun.service;

import com.github.illiaderhun.dto.CustomerDTO;
import com.github.illiaderhun.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDTO customerDTO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDTO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDTO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(Integer theId) {
        return customerDTO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer theId) {
        customerDTO.deleteCustomer(theId);
    }
}
