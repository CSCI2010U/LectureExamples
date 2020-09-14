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
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    /*
    factorial(3)
    -> 3 * factorial(2)
            -> 2 * factorial(1)
                    -> 1
            -> 2 * 1 = 2
    -> 3 * 2 = 6
    */

    // sin(x) = x**1/1! - x**3 / 3! + x**5 / 5! - x**7 / 7! + x**9 / 9! - x**11 / 11! + x**13 / 13! - x**15 / 15! + x**17 / 17! - x**19 / 19!
    public static double sin(double x, int numIterations) {
        double result = 0.0;
        boolean addTerm = true;

        for (int i = 0; i < numIterations; i++) {
            int n = (i * 2) + 1;
            double term = pow(x, n) / factorial(n);

            if (addTerm) {
                result += term;
                // addTerm = false;
            } else {
                result -= term;
                // addTerm = true;
            }
            addTerm = !addTerm;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.printf("2.5^3 = %f\n", pow(2.5, 3));
        System.out.printf("5! = %d\n", factorial(5));

        final double PI = 3.14159265359;

        System.out.printf("Approximation for sin(PI): %.5f\n", sin(PI, 1));
        System.out.printf("Approximation for sin(PI): %.5f\n", sin(PI, 2));
        System.out.printf("Approximation for sin(PI): %.5f\n", sin(PI, 3));
        System.out.printf("Approximation for sin(PI): %.5f\n", sin(PI, 4));
        System.out.printf("Approximation for sin(PI): %.5f\n", sin(PI, 5));
        System.out.printf("Approximation for sin(PI): %.5f\n", sin(PI, 6));
        System.out.printf("Approximation for sin(PI): %.5f\n", sin(PI, 7));
        System.out.printf("Approximation for sin(PI): %.5f\n", sin(PI, 8));
        System.out.printf("Approximation for sin(PI): %.8f\n", sin(PI, 9));
        System.out.printf("Approximation for sin(PI): %.8f\n", sin(PI, 10));
        System.out.printf("Approximation for sin(PI): %.8f\n", sin(PI, 11));
        System.out.printf("Approximation for sin(PI): %.8f\n", sin(PI, 12));
    }
}
