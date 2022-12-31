package com.martin.mongorelationships;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
//@ToString(exclude = {"id", "dateOfBirth"})
@Document(collection = "people")
public class Person {

    public static final String  SEQUENCE_NAME="person_sequence";

    @Id
    private Long id;
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private Address address; //OneToOne i.e. One Person can have one address
    private String profession;
    private int salary;
    private List<Hobby> hobbies; //OneToMany One Person can have many hobbies

    public Person() {
    }

    @JsonCreator
    public Person(
             String firstName,
             String secondName,
             String dateOfBirth,
             Address address,
             String profession,
             int salary,
            @JsonProperty("hobbies") final List<Hobby> hobbies) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.profession = profession;
        this.salary = salary;
        this.hobbies = hobbies;
    }


}
