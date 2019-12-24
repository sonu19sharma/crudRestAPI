package com.example.employees.detail.restapi.repository;

import com.example.employees.detail.restapi.dao.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
