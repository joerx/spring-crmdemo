package io.yodo.crmdemo.dao;

import io.yodo.crmdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // Field injection is not recommended, see https://blog.marcnuri.com/field-injection-is-not-recommended/
    // Key drawbacks:
    // - fields cannot be final
    // - tight coupling of class with DI container
    // - components should expose dependencies explicitly, via either ctor or setters
    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Session sess = sessionFactory.getCurrentSession();

        return sess.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Session sess = sessionFactory.getCurrentSession();

        sess.save(customer);

        return customer;
    }
}
