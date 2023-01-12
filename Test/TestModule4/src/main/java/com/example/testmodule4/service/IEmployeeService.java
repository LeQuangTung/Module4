package com.example.testmodule4.service;

import com.example.testmodule4.model.Employee;

public interface IEmployeeService extends IGeneralService<Employee,Long> {
    Iterable<Employee> sortByAge();
}
