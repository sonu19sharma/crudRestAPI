package com.example.employees.detail.restapi.controller;

import com.example.employees.detail.restapi.dao.Employee;
import com.example.employees.detail.restapi.services.EmployessServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/employess")
public class EmployeeController {

    @Autowired
    public EmployessServices projectServices;

    @GetMapping("/employess")
    public List findAllemployee(){
        return projectServices.findAllEmployee();
    }

    @GetMapping("/employess/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        return projectServices.findById(id);
    }

    @PostMapping("/employess")
    public String createEmployee(@Valid @RequestBody Employee employee){
        projectServices.addEmployeeDetail(employee);
        return "Created";
    }

    @PutMapping("/employees/{id}")
    public Employee UpdateEmployee(@Valid @RequestBody Employee employee, @PathVariable Long id){
        return projectServices.updateEmployee(employee,id);
    }
    @DeleteMapping("/employess/{id}")
    public void deleteEmployee(@PathVariable Long id){
        projectServices.deleteEmployee(id);
    }
}
