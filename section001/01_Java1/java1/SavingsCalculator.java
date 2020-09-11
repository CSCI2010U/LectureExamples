package java1;

// static -- attached to the class
// non-static -- attached to the instances of the class

public class SavingsCalculator {
    public int age = 21;
    public int birthYear = 1999;
    public float gpa = 2.9f;

    public static String message = "Hello!";

    public static void main(String[] args) {
        System.out.printf("Savings!\n");

        // non-static field cannot be access inside static method
        //System.out.printf("age: %d\n", age);

        SavingsCalculator calc = new SavingsCalculator();
        calc.sayHello();
        System.out.println("age: " + calc.age + ", birth year: " + calc.birthYear + ", GPA: " + calc.gpa); // yuck!
        System.out.printf("age: %d, birth year: %d, GPA: %.2f\n", calc.age, calc.birthYear, calc.gpa); // easier
        System.out.printf("%s\n", message);

        // actual savings calculator
        double principle = 1000.0;
        double interestRate = 0.035;
        int numYears = 10;

        for (int year = 0; year < numYears; year++) {
            principle += interestRate * principle;
        }
        System.out.printf("Principle amount after %d years of interest at interest rate %.3f%% is $%.2f\n", numYears, interestRate, principle);

        // how long will it take save a million dollars
        principle = 0.0;
        interestRate = 0.035;
        numYears = 0;
        double annualContribution = 5000.0;
        while (principle < 1000000.0) {
            principle += interestRate * principle + annualContribution;
            numYears++;
        }
        System.out.printf("It will take %d years to save a million bucks!", numYears);
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
