package com.martin.mongorelationships.dao;

import com.martin.mongorelationships.model.Address;
import com.martin.mongorelationships.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends MongoRepository<Address, Long> {

}
