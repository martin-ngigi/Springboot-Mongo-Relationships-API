package com.martin.mongorelationships.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "address")
public class Address {
    public static final String  SEQUENCE_NAME="address_sequence";

    @Id
    private Long id;
    private String name;

    //@DocumentReference(lazy = true, lookup = "{ 'primaryAddress' : ?#{#self._id} }")
    @DocumentReference(lazy = true, lookup = "{ 'primaryAddress' : ?#{#self.id} }") // changed _id to id
    @ReadOnlyProperty
    private Employee employee; //ManyToOne Relationship. i.e. Many addresses belong to one employee

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

    public Employee getEmployee() {
        return employee;
    }
}
