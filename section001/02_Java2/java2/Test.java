package java2;

import java.util.Date;

import java2.animals.Animal;

public class Test {
    public static void main(String[] args) {
        TaylorSeriesLambda lambda = new TaylorSeriesLambda();
        long f = lambda.factorial(10);

        Animal bonobo = new Animal(40.0f, "Insects, fruit", "Bonobo", new Date());
        System.out.println(bonobo.mass);
        System.out.println(bonobo.getAgeInYears());
        System.out.println(bonobo.getSpecies());
    }
}
