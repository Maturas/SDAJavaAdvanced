package org.SDA.Polymorphism;

public class Dog extends Animal {
    private Integer age;

    private String breed;

    public Dog(String name, Integer age, String breed) {
        super(name);
        this.age = age;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", name, age, breed);
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof woof");
    }

    public void apport() {
        System.out.println("Apporting a thrown stick!");
    }

    public Integer getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }
}
