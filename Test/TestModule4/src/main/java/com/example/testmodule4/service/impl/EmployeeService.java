package com.example.testmodule4.service.impl;

import com.example.testmodule4.model.Employee;
import com.example.testmodule4.repository.IEmployeeRepository;
import com.example.testmodule4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Iterable<Employee> sortByAge() {
        return iEmployeeRepository.sortEmployeeByAgeAsc();
    }
}
