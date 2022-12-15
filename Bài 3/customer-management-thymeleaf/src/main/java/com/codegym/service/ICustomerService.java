package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Department;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    List<Department> findAllDepartment();

    void save(Customer customer);

    Customer findById(int id);
    Department findByIdDepartment(int id);

    void update(int id, Customer customer);

    void remove(int id);

    List<Customer> searchByName(String name);
}
