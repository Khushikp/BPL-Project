package com.example.bpl;

public class User {

    String name, email, phone, address, city, pincode, country, gender;
    int imageId;

    public User(String name,
                String email, String phone, String address, String city, String pincode, String country, String gender, int imageId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.country = country;
        this.gender = gender;
        this.imageId = imageId;
    }
}
