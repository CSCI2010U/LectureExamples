package java2;

import java.util.Date;

import java2.animals.Animal;
import java2.animals.Cricket;
import java2.animals.Giraffe;

class ABC {
    // private class, only accessible inside this file
}

public class Test {
    static class DEF {
        // inner class (not really used in this course)
    }

    public static void main(String[] args) {
        ABC abc = new ABC();
        DEF def = new DEF();

        TaylorSeriesLambda lambda = new TaylorSeriesLambda();
        long f = lambda.factorial(10);

        // Animal giraffe = new Animal(140.0f, "Leaves", "Giraffe", new Date());
        // Giraffe giraffe = new Animal(140.0f, "Leaves", "Giraffe", new Date()); // invalid - parent into child
        Animal giraffe = new Giraffe(140.0f, "Leaves", "Giraffe", new Date()); // valid - child into parent
        // Giraffe giraffe = new Giraffe(140.0f, "Leaves", "Giraffe", new Date());

        // System.out.println(giraffe.mass);
        // System.out.println(giraffe.getAgeInYears());
        // System.out.println(giraffe.getSpecies());
        System.out.println(giraffe);
        giraffe.speak();

        Animal cricket = new Cricket(0.01f, "Carrots", "Cricket", new Date());
        System.out.println(cricket);
        cricket.speak();
    }
}
