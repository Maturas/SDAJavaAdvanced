package org.SDA.Polymorphism;

public abstract class Animal {
    protected String name;

    protected Animal(String name) {
        this.name = name;
    }

    public void sleep() {
        System.out.println("Zzz");
    }

    public abstract void makeNoise();
}
