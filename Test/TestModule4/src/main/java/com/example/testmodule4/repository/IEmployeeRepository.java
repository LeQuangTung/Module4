package com.example.testmodule4.repository;

import com.example.testmodule4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(nativeQuery = true, value = "select * from Employee e order by e.age asc")
    Iterable<Employee> sortEmployeeByAgeAsc();
}
