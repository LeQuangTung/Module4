package com.example.customer_manager.repository;

import com.example.customer_manager.model.Customer;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Component
public class CustomerRepository implements ICustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id = :id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) throws Exception {
        try {
            if (customer.getId() != null) {
                entityManager.merge(customer);
            } else {
                entityManager.persist(customer);
            }
        } catch (ConstraintViolationException e) {
            throw new Exception();
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public void insertWithStoredProcedure(Customer customer) {
        String sql = "call insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("name", customer.getName());
        query.executeUpdate();
    }
}
