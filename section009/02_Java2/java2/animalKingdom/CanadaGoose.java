package java2.animalKingdom;

// concrete - a class you can instantiate (non-abstract)
public class CanadaGoose extends Animal {
    public CanadaGoose(String name, String sex) {
        super(name, "branta canadensis", sex, 2);
    }
    
    public void speak() {
        System.out.println("Honk!");
    }

    public void attackStudent() {
        System.out.println("Run for your lives!");
    }
}
