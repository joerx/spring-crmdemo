package io.yodo.crmdemo.dao;

import io.yodo.crmdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

        return sess.createQuery("from Customer order by id asc", Customer.class).getResultList();
    }

    @Override
    public void createCustomer(Customer customer) {
        Session sess = sessionFactory.getCurrentSession();

        sess.save(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        Session sess = sessionFactory.getCurrentSession();

        return sess.get(Customer.class, customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session sess = sessionFactory.getCurrentSession();

        sess.update(customer);

    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session sess = sessionFactory.getCurrentSession();

        sess.delete(customer);
    }

    @Override
    public List<Customer> findCustomers(String query) {
        Session sess = sessionFactory.getCurrentSession();

        if (query == null || query.trim().length() == 0) {
            return sess.createQuery("from Customer", Customer.class).getResultList();

        } else {
            Query<Customer> q = sess.createQuery(
                    "from Customer where lower(firstName) like :query or lower(lastName) like :query ",
                    Customer.class
            );
            q.setParameter("query", "%"+query.toLowerCase()+"%");

            return q.getResultList();
        }
    }
}
