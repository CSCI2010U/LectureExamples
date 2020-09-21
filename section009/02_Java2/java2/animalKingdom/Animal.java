package java2.animalKingdom;

// parent class:  Object (default)

// abstract class - cannot instantiate it
public abstract class Animal {
    private String sex;
    private String name;
    private long dateOfBirth;
    public float mass;
    public String species;
    public int numLegs;

    public Animal() {
    }

    public Animal(String name, String species, String sex, int numberOfLegs) {
        this.name = name;
        this.species = species;
        this.sex = sex;
        numLegs = numberOfLegs;
    }

    public int getAgeInYears()  {
        // TODO: subtract birth date from the current date
        return 1;
    }

    public String getName() { return name; }

    public abstract void speak();

    public String toString() {
        return this.name + " (" + this.species + ")";
    }
}
