package org.SDA.Reflection;

public class Student {
    private String firstName;
    private String surName;
    private Integer indexNr;
    private String degree;

    public Student() {

    }

    public Student(String firstName, String surName, Integer indexNr, String degree) {
        this.firstName = firstName;
        this.surName = surName;
        this.indexNr = indexNr;
        this.degree = degree;
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

    public Integer getIndexNr() {
        return indexNr;
    }

    public void setIndexNr(Integer indexNr) {
        this.indexNr = indexNr;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
