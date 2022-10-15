package org.SDA.Immutability;

public class MutableEmployee {
    private Integer id;
    private String firstName;
    private String surName;
    private String role;

    public MutableEmployee(Integer id, String firstName, String surName, String role) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
