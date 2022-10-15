package org.SDA.Polymorphism;

public class Dog extends Animal {
    protected Dog(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof woof");
    }

    public void apport() {
        System.out.println("Apporting a thrown stick!");
    }
}
