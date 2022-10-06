package com.example.study.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable // JPA 의 내장 타입이기때문에 내장될 수 있다.
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
