package com.martin.mongorelationships.dao;

import com.martin.mongorelationships.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends MongoRepository<Employee, Long> {

}
