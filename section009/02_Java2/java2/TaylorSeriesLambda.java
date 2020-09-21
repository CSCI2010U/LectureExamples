package java2;

import java2.animalKingdom.*;

interface UnaryFunction {
    double doIt(double arg);
}

public class TaylorSeriesLambda {
    public double pow(double base, int power) {
        double result = 1.0;

        for (int pow = 0; pow < power; pow++) {
            result *= base;
        }

        return result;
    }

    public long factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        TaylorSeriesLambda lambda = new TaylorSeriesLambda();
        double f = lambda.factorial(10);

        // x**1 / 1! - x**3 / 3! + x**5 / 5! - x**7 / 7! + x**9 / 9!

        // instantiate our interface
        UnaryFunction f1 = (double x) -> { return x; };
        UnaryFunction f3 = (double x) -> { return x - lambda.pow(x, 3) / lambda.factorial(3); };
        UnaryFunction f5 = (double x) -> { return x - lambda.pow(x, 3) / lambda.factorial(3) + lambda.pow(x, 5) / lambda.factorial(5); };

        double x = 3.14159265359 / 2.0;

        System.out.printf("sin(%f) == %f\n", x, f1.doIt(x));
        System.out.printf("sin(%f) == %f\n", x, f3.doIt(x));
        System.out.printf("sin(%f) == %f\n", x, f5.doIt(x));

        Animal untitled = new CanadaGoose("Glenda", "female");
        // System.out.println(untitled.getName());
        // System.out.println(untitled.numLegs);
        // System.out.println(untitled.getAgeInYears());
        System.out.println(untitled);
        untitled.speak();
        // untitled.attackStudent(); // can't execute on an animal variable

        Mongoose mandy = new Mongoose("Mandy", "female");
        System.out.println(mandy);
        mandy.speak();
        mandy.eatSnake();
    }
}