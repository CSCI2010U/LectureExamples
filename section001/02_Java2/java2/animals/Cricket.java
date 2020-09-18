package java2.animals;

import java.util.Date;

public class Cricket extends Animal {
    public Cricket(float mass, String foodSource, String species, Date dateOfBirth) {
        super(mass, foodSource, species, dateOfBirth);
    }

    public void speak() {
        System.out.println("cheeeep!");
    }

}
