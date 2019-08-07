package io.yodo.crmdemo.service;

import io.yodo.crmdemo.dao.CustomerDAO;
import io.yodo.crmdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        customerDAO.createCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        customerDAO.deleteCustomer(customer);
    }

    @Override
    @Transactional
    public List<Customer> findCustomers(String query) {
        return customerDAO.findCustomers(query);
    }
}
