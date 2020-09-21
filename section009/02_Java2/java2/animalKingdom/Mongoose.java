package java2.animalKingdom;

public class Mongoose extends Animal {
    public Mongoose(String name, String sex) {
        super(name, "herpestes", sex, 4);
    }
    
    public void speak() {
        System.out.println("Monhonk!");
    }

    public void eatSnake() {
        System.out.println("Nom nom");
    }
}
