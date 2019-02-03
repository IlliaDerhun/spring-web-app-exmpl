package com.github.illiaderhun.dto;

import com.github.illiaderhun.entity.Customer;

import java.util.List;

public interface CustomerDTO {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(Integer theId);

    void deleteCustomer(Integer theId);
}
