package com.pv.api;

public class Person {

    private String name;
    private String lastname;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String sayHello() {
        return "Hello, my name is " + name + " " + lastname;
    }

    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public void setName(String name) { this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
}