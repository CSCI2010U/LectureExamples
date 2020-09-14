package java1;

public class SavingsCalculator {
    public static void main(String[] args) {
        // calculate annual interest earned
        double principle = 1000.0;
        float principle2 = 1000.0f;
        double interestRate = 0.035;
        int numYears = 10;

        for (int year = 0; year < numYears; year++) {
            principle += interestRate * principle;
        }

        /*
        %f - floats and doubles
        %d - integers and longs
        %s - strings

        printf("Hello world!");
        printf("Interest rate: %f, principle: %f\n", interestRate, principle);
        */

        System.out.print("Interest rate: " + interestRate + ", principle: " + principle + "\n");
        System.out.printf("Interest rate: %.3f, principle: %.2f\n", interestRate, principle);

        // how long will it take to save 1 million dollars?
        principle = 0.0;
        interestRate = 0.035;
        numYears = 0;
        double annualContribution = 5000.0;

        while (principle < 1000000.0) {
            principle += interestRate * principle + annualContribution;
            numYears++;
        }

        System.out.printf("It took %d years to save a million bucks!\n", numYears);
    }
}
