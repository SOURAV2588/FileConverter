package com.sourav.FileConverter.model;


import java.util.ArrayList;
import java.util.List;

public class PersonList {

    private List<Person> list;

    public PersonList() {
        list = new ArrayList<Person>();
    }

    public void add(Person person){
        list.add(person);
    }
}
