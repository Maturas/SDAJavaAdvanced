package org.SDA.Polymorphism;

public class Example {
    public static void example() {
        // Perceived type is defined by variable's type
        // Actual type is defined by object's type
        // Perceived type: dog - Actual type: type
        Dog dog = new Dog("Rex", 12, "German Shepherd");
        Cat cat = new Cat("Garfield");

        dog.sleep();
        cat.sleep();

        dog.makeNoise(); // Woof woof
        cat.makeNoise(); // Meow

        dog.apport();
        // cat.apport();

        // dog.lickFur();
        cat.lickFur();

        // Upcasting (implicit casting) - cast an object to a type higher in the type hierarchy (one of its super-types)
        Animal animalDog = dog;
        Animal animalCat = cat;

        animalDog.sleep();
        animalCat.sleep();

        animalDog.makeNoise(); // Woof woof
        animalCat.makeNoise(); // Meow

        // Downcasting (explicit casting) - cast an object to a type lower in type hierarchy (one of its subtypes)
        Dog downcastedDog = (Dog) animalDog;
        Cat downcastedCat = (Cat) animalCat;

        downcastedDog.apport(); // I can again use Dog's unique features
        downcastedCat.lickFur(); // I can again use Cat's unique features

        try {
            // ClassCastException will be thrown
            Dog catThatWantsToBeADog = (Dog) animalCat;
            Cat dogThatWantsToBeACat = (Cat) animalDog;
        }
        catch (ClassCastException e) {
            System.out.println("You can't change animals' species!");
        }

        apportIfDog(animalDog); // Animal parameter expected, Animal parameter provided
        apportIfDog(animalCat); // Animal parameter expected, Animal parameter provided
        apportIfDog(dog); // Animal parameter expected, Dog parameter provided, auto-upcasted to Animal
        apportIfDog(cat); // Animal parameter expected, Cat parameter provided, auto-upcasted to Animal

        // When a dog is perceived as an Animal, we don't know that he can apport
        // animalDog.apport();
        // When a cat is perceived as an Animal, we don't know that he can lick fur
        // animalCat.lickFur();
    }

    private static void apportIfDog(Animal animal) {
        if (animal instanceof Dog) {
            Dog safelyDowncastedDog = (Dog) animal;
            safelyDowncastedDog.apport();
        }
        else {
            System.out.println("Given Animal is not a Dog!");
        }
    }
}
