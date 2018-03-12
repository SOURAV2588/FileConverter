package com.sourav.FileConverter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String ssn;
    private long phone;
    private String street_address;
    private String email;
}
