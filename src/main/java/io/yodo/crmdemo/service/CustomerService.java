package io.yodo.crmdemo.service;

import io.yodo.crmdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void createCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
