package com.example.employees.detail.restapi.services;

import com.example.employees.detail.restapi.dao.Address;
import com.example.employees.detail.restapi.dao.Employee;
import com.example.employees.detail.restapi.repository.AddressRepository;
import com.example.employees.detail.restapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AddressServices {

    @Autowired
    public EmployeeRepository employeeRepository;
    public AddressRepository addressRepository;
    Employee employee;

    public List<Address> getAddress(Long id){
        return (List<Address>) employeeRepository.findById(id).get().getAddress();
    }

    public Employee addAddress(Long id,Address address){
        employee= employeeRepository.findById(id).get();
        employee.getAddress().add(address);
        return updateEmployeeAddress(id);
//        return employeeRepository.findById(id).map(employee1 ->{
//            employee1.setAddress(employee.getAddress());
//            return employeeRepository.save(employee1);
//        }).orElseGet(()->{
//            employee.setEmp_id(id);
//            return employeeRepository.save(employee);
//        });//        return employeeRepository.findById(id).map(employee ->{
//            employee.
//            return employeeRepository.save(employee););
//                    employeeRepository.

    }

    public void deleteAddress(Long id){
        employee= employeeRepository.findById(id).get();
        employee.getAddress().clear();

//        addressRepository.deleteById(id);
        updateEmployeeAddress(id);
//        employeeRepository.findById(id).map(employee1 ->{
//            employee1.setAddress(employee.getAddress());
//            return employeeRepository.save(employee1);
//        }).orElseGet(()->{
//            employee.setEmp_id(id);
//            return employeeRepository.save(employee);
//        });
    }

    public void updateAddress(Long id, Address address,String type){
        Collection collections=  employeeRepository.findById(id).get().getAddress();
        ArrayList<Address> collection=new ArrayList<>(collections);
        for (int i=0;i<collection.size();i++){
            Address addresstemp=(Address) collection.get(i);
            if (addresstemp.getAddresstype().equals(type)) {
                addresstemp.setAddressline1(address.getAddressline1());
                addresstemp.setAddressline2(address.getAddressline2());
                addresstemp.setAddressline3(address.getAddressline3());
                addresstemp.setCity(address.getCity());
                addresstemp.setCountry(address.getCountry());
                addresstemp.setPin(address.getPin());
                addresstemp.setState(address.getState());
            }
        }
        employee=employeeRepository.findById(id).get();
        employee.setAddress(collection);
        updateEmployeeAddress(id);
    }

//    crud operation by address type started
    public void deleteAddressType(Long id,String addresstypes){
        Collection collections=  employeeRepository.findById(id).get().getAddress();
        ArrayList<Address> collection=new ArrayList<>(collections);
        for (int i=0;i<collection.size();i++){
            Address address=(Address) collection.get(i);
            if (address.getAddresstype().equals(addresstypes))
                collection.remove(i);
        }
        employee=employeeRepository.findById(id).get();
        employee.getAddress().clear();
        employee.setAddress(collection);
        updateEmployeeAddress(id);
//        employeeRepository.findById(id).map(employee1 ->{
//            employee1.setAddress(employee.getAddress());
//            return employeeRepository.save(employee1);
//        }).orElseGet(()->{
//            employee.setEmp_id(id);
//            return employeeRepository.save(employee);
//        });

    }
    //    crud operation by address type end
    public Employee updateEmployeeAddress(Long id){
        return employeeRepository.findById(id).map(employee1 ->{
            employee1.setAddress(employee.getAddress());
            return employeeRepository.save(employee1);
        }).orElseGet(()->{
            employee.setEmp_id(id);
            return employeeRepository.save(employee);
        });
    }
}
