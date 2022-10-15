package org.SDA.Polymorphism;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("Meow");
    }

    public void lickFur() {
        // TODO
    }
}
