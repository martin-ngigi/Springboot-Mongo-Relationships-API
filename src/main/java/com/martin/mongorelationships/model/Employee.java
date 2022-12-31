package com.martin.mongorelationships.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "employee")
public class Employee {
    public static final String  SEQUENCE_NAME="employees_sequence";

    @Id
    private Long id;
    private String name;
    private String gender;
    private String dob;
    private String country;

    @DocumentReference(lazy = true)
    //private Address primaryAddress; //OneToOne i.e. one customer has one address
    private List<Address> primaryAddress; // OneToMany i.e. one customer has many addresses

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //OneToOne i.e. one customer has one address
//    public Address getPrimaryAddress() {
//        return primaryAddress;
//    }


    public List<Address> getPrimaryAddress() {
        return primaryAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", country='" + country + '\'' +
                ", primaryAddress=" + primaryAddress +
                '}';
    }
}
