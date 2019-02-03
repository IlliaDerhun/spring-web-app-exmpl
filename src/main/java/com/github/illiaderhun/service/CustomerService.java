package com.github.illiaderhun.service;

import com.github.illiaderhun.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(Integer theId);

    void deleteCustomer(Integer theId);
}
