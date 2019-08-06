package io.yodo.crmdemo.dao;

import io.yodo.crmdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer createCustomer(Customer customer);
}
