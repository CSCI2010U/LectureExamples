package java2.animals;

import java.util.Date;

// concrete class - can be instantiated
public class Giraffe extends Animal {
    public Giraffe(float mass, String foodSource, String species, Date dateOfBirth) {
        super(mass, foodSource, species, dateOfBirth);
    }

    public void speak() {
        System.out.println("blagghhhh!");
    }
}
