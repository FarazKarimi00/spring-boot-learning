package com.learning.hibernateFundamentals.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address(){}

    public Address(String houseNumber,
                   String street,
                   String city,
                   String state,
                   String pincode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
