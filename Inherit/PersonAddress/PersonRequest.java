package com.example.Inherit.PersonAddress;

import java.util.List;

public class PersonRequest {
    private String name;
    private List<String> addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
