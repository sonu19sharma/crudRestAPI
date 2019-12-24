package com.example.employees.detail.restapi.services;

import com.example.employees.detail.restapi.dao.Employee;
import com.example.employees.detail.restapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployessServices {

    @Autowired
    public EmployeeRepository employeeRepository;

    public void addEmployeeDetail(Employee employee){
//        if(employeeRepository.findById(employee.getId()).get()!= null) {
            employeeRepository.save(employee);
//        }
    }

    public List<Employee> findAllEmployee(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }

    public Employee updateEmployee(Employee newemployee,Long id){
        return employeeRepository.findById(id).map(employee ->{
            employee.setFirstName(newemployee.getFirstName());
            employee.setLastName(newemployee.getLastName());
            employee.setDesignation(newemployee.getDesignation());
            employee.setDob(newemployee.getDob());
            return employeeRepository.save(employee);
        }).orElseGet(()->{
            newemployee.setEmp_id(id);
            return employeeRepository.save(newemployee);
        });
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
