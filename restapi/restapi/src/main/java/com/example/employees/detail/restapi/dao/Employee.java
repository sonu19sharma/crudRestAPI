package com.example.employees.detail.restapi.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Employee {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @NotBlank
    private String designation;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dob;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "table_map",joinColumns = @JoinColumn(name="emp_id"),inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Collection<Address> address=new ArrayList<>();

    public Collection<Address> getAddress(){
        return address;
    }

    public void setAddress(Collection<Address> address) {
        this.address = address;
    }

    public Long getEmp_id() {
        return id;
    }

    public void setEmp_id(Long emp_id) {
        this.id = emp_id;
    }


}
