package com.martin.mongorelationships.controller;

import com.martin.mongorelationships.dao.AddressDAO;
import com.martin.mongorelationships.dao.EmployeeDAO;
import com.martin.mongorelationships.model.Address;
import com.martin.mongorelationships.model.Employee;
import com.martin.mongorelationships.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/address")
public class AddressController {
    @Autowired
    AddressDAO addressDAO;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    //http://localhost:8080/api/v1/address/create-address
    @PostMapping("/create-address")
    public Address create(@RequestBody Address address){
        address.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return addressDAO.save(address);
    }

    //http://localhost:8080/api/v1/address/address-list
    @GetMapping("/address-list")
    public List<Address> getAllAddress(){
        return addressDAO.findAll();
    }

    //http://localhost:8080/api/v1/address/get-address/1
    @GetMapping("get-address/{id}")
    public Address getAddressById(@PathVariable Long id){
        Optional<Address> address = addressDAO.findById(id);
        if (address.isPresent()){
            return address.get();
        }
        else {
            throw new RuntimeException("Address not found with id "+id);
        }
    }

    //http://localhost:8080/api/v1/address/update-address/1
    @PutMapping("/update-address/{id}")
    public  Address updateAddress(@RequestBody Address address, @PathVariable ("id") Long id){
        //validate data
        Address addressFromDb = addressDAO.findById(id)
                .orElseThrow(() -> new IllegalStateException("Error: address with id "+id+" does not exist."));

        //get data from request
        String name = address.getName();

        //set data
        addressFromDb.setName(name);

        return addressDAO.save(addressFromDb);
    }

    @DeleteMapping("delete-address/{id}")
    public String deleteAddress(@PathVariable("id") Long id){
        Optional<Address> address = addressDAO.findById(id);
        if (address.isPresent()){
            addressDAO.deleteById(id);
            return "Address deleted with id "+id;
        }
        else {
            throw new RuntimeException("Address not found with id "+id);
        }
    }

}
