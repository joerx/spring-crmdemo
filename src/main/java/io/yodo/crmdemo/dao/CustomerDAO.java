package io.yodo.crmdemo.dao;

import io.yodo.crmdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void createCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    List<Customer> findCustomers(String query);
}
