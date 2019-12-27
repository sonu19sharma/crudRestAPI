package com.example.employees.detail.restapi.controller;

import com.example.employees.detail.restapi.dao.Employee;
import com.example.employees.detail.restapi.services.EmployessServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/employess")
public class EmployeeController {

    @Autowired
    public EmployessServices projectServices;

    @GetMapping("/employess")
    public ResponseEntity<?> findAllemployee(){
       if (projectServices.findAllEmployee().size()>0)
           return new ResponseEntity<List<Employee>>(projectServices.findAllEmployee(), HttpStatus.OK);
       return new ResponseEntity<List<Employee>>(HttpStatus.valueOf("No Employee available"));
    }

    @GetMapping("/employess/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        if(projectServices.findById(id)==null)
            return new ResponseEntity<Employee>(HttpStatus.valueOf("No such user exists"));
        return new ResponseEntity<Employee>(projectServices.findById(id),HttpStatus.OK);
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
