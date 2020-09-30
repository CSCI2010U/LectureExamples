package java2;

interface UnaryFunction {
    double execute(double argument);
}

class Tripler implements UnaryFunction {
    public double execute(double argument) {
        return argument * 3;
    }
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
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        TaylorSeriesLambda lambda = new TaylorSeriesLambda();
        long f = lambda.factorial(10);

        // x - x**3 / 3! + x**5 / 5! - x**7 / 7! + x**9 / 9! - x**11 / 11! + x**13 / 13!
        // using lambda notation
        UnaryFunction f1 = (double x) -> { return x; };
        UnaryFunction f3 = (double x) -> { return x - lambda.pow(x,3) / lambda.factorial(3); };
        UnaryFunction f5 = (double x) -> { return x - lambda.pow(x,3) / lambda.factorial(3) + lambda.pow(x,5) / lambda.factorial(5); };
        UnaryFunction f7 = (double x) -> { return x - lambda.pow(x,3) / lambda.factorial(3) + lambda.pow(x,5) / lambda.factorial(5) - lambda.pow(x,7) / lambda.factorial(7); };

        double x = 3.14159265359 / 2.0;
        System.out.printf("sin(%f) == %f\n", x, f1.execute(x));
        System.out.printf("sin(%f) == %f\n", x, f3.execute(x));
        System.out.printf("sin(%f) == %f\n", x, f5.execute(x));
        System.out.printf("sin(%f) == %f\n", x, f7.execute(x));
    }
}
