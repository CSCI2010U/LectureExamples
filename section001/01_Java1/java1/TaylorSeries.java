package java1;

public class TaylorSeries {
    public static double pow(double base, int power) {
        double result = 1.0;

        for (int pow = 0; pow < power; pow++) {
            result *= base;
        }

        return result;
    }

    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // x - x**3 / 3! + x**5 / 5! - x**7 / 7! + x**9 / 9! - x**11 / 11! + x**13 / 13! - x**15 / 15!
    public static double sin(double x, int numIterations) {
        double result = 0.0;
        boolean positive = true;

        for (int i = 0; i < numIterations; i++) {
            int n = (i * 2) + 1;
            double term = pow(x, n) / factorial(n);

            if (positive) {
                result += term;
            } else {
                result -= term;
            }

            positive = !positive;
        }

        return result;
    }

    public static void main(String[] args) {
        // it is ok to implicitly case from float to double, here
        // the other way is not ok
        // analogy:  parking a small car in a truck garage is ok
        //           parking a truck in a small car garage is not ok
        double PI = 3.14159265359f;

        double eight_squared = pow(8.0, 2);
        double eight_cubed = pow(8.0, 3);

        long eight_factorial = factorial(8);

        System.out.printf("8^2 = %.1f\n", eight_squared);
        System.out.printf("8^3 = %.1f\n", eight_cubed);
        System.out.printf("8!  = %d\n", eight_factorial);

        System.out.printf("100!  = %d\n", factorial(100));

        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 1));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 2));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 3));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 4));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 5));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 6));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 7));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 8));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 9));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 10));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 11));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 12));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 13));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 14));
        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 15));

        System.out.printf("sin(PI)  = %.5f\n", sin(PI, 150));
    }
}
