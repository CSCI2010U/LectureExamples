public class Power {

    // x^4 = (x^2)^2
    // x^6 = (x^3)^2
    // x^12 = (x^6)^2

    // x^11 = x * x^10 = x * (x^5)^2
    // x^17 = x * x^16 = x * (x^8)^2

    // T(n) = T(n/2) + O(1)
    public static float power(float x, int n) {
        if (n == 0) {
            return 1f;
        }

        if ((n % 2) == 0) {     // even exponent
            float y = power(x, n / 2);                  // T(n/2)
            return y * y;
        } else {                // odd exponent
            float y = power(x, (n - 1) / 2);            // T(n/2)
            return x * y * y;
        }
    }

    // linear recursive, but not tail recursive
    // T(n) = T(n - 1) + O(1)
    public static float powerLame(float x, int n) {
        if (n == 0) {
            return 1f;
        }

        return x * powerLame(x, n - 1);                 // T(n - 1)
    }

    public static void main(String[] args) {
        for (int n = 0; n <= 10; n++) {
            System.out.printf("2^%d = %f\n", n, power(2, n));
        }
    }
}
