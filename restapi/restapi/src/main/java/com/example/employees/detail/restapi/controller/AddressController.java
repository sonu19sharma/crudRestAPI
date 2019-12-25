package com.example.employees.detail.restapi.controller;

import com.example.employees.detail.restapi.dao.Address;
import com.example.employees.detail.restapi.services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    public AddressServices addressServices;

    @GetMapping("/employess/{id}/address")
    public List<Address> getAddress(@PathVariable Long id){
        return addressServices.getAddress(id);
    }

    @PostMapping("/employess/{id}/address")
    public void addAddress(@PathVariable Long id, @RequestBody Address address){
        addressServices.addAddress(id,address);
    }

    @DeleteMapping("/employess/{id}/address")
    public void deleteAddress(@PathVariable Long id){
        addressServices.deleteAddress(id);
    }
    @DeleteMapping("/employess/{id}/addresstype/{type}")
    public void deleteAddressbyType(@PathVariable Long id,@PathVariable String type){
        addressServices.deleteAddressType(id,type);
    }
    @PutMapping("/employess/{id}/addresstype/{type}")
    public void updateAddress(@PathVariable Long id,@RequestBody Address address,@PathVariable String type){
        addressServices.updateAddress(id,address,type);
    }
}
