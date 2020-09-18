package java2.animals;

import java.util.Date;

// abstract classes - cannot be instantiated
public abstract class Animal {
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
        // TODO: calculate the age of the animal
        return 3;
    }

    public String getSpecies() { return this.species; }

    public String toString() {
        return this.species + ", born: " + this.dateOfBirth.toString() + ", mass: " + this.mass + "kg";
    }

    public abstract void speak();
}
