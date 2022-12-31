package com.martin.mongorelationships;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Hobby {

    public Hobby() {
    }

    private String name;

    public Hobby( String name) {
        this.name = name;
    }
}