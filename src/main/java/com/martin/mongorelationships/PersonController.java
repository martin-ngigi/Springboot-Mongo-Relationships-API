package com.martin.mongorelationships;

import com.martin.mongorelationships.model.Employee;
import com.martin.mongorelationships.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/person")
public class PersonController {
    /**
     * Documentation link -> https://lankydan.dev/2017/05/29/embedded-documents-with-spring-data-and-mongodb
     */

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private PersonRepository personRepository;

    //http://localhost:8080/api/v1/person/create-person
    @PostMapping("/create-person")
    public Person create(@RequestBody Person person){
        person.setId(sequenceGeneratorService.generateSequence(Person.SEQUENCE_NAME));
        return personRepository.save(person);
    }
}
