package com.sourav.FileConverter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@XmlRootElement
// Using this because otherwise there would be conflict between the field and the getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"title","firstName","lastName","gender"})
public class Person {

    @XmlAttribute(name = "Title")
    private String title;

    @XmlAttribute(name = "FirstName")
    private String firstName;

    @XmlAttribute(name = "LastName")
    private String lastName;

    @XmlAttribute(name = "Gender")
    private String gender;

    //Need to read about this transient
    @XmlTransient
    private String ssn;

    @XmlTransient
    private long phone;

    @XmlTransient
    private String street_address;

    @XmlTransient
    private String email;

    public Person() {
    }

    public Person(String title, String firstName, String lastName, String gender, String ssn, long phone, String street_address, String email) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.ssn = ssn;
        this.phone = phone;
        this.street_address = street_address;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
