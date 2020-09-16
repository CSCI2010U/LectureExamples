package java2.animals;

import java.util.Date;

public class Animal {
    public float mass;
    private String foodSource;
    private String species;
    private Date dateOfBirth;

    public Animal() {

    }

    public Animal(float mass, String foodSource, String species, Date birthDate) {
        this.mass = mass;
        this.foodSource = foodSource;
        this.species = species;
        dateOfBirth = birthDate;
    }

    public int getAgeInYears() {
        // calculate the age of the animal
        return dateOfBirth.getYear();
    }

    public String getSpecies() { return this.species; }

}
