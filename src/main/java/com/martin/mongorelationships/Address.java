package com.martin.mongorelationships;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String country;

    public Address() {
    }

    public Address(
             String addressLineOne,
             String addressLineTwo,
             String city,
             String country) {
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.country = country;
    }
}
