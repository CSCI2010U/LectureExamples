public class Power {

    // 2 ^ 7
    // 2 * 2 ^ 6
    // 2 * (2 * 2 ^ 5)
    // 2 * (2 * (2 * 2 ^ 4))
    // ...

    // 2 ^ 6
    // 2 * 2^5
    // 2 * 2 * 2^4

    // 2 ^ 7
    // 2 * (2 ^ 3) ^ 2
    
    // 2 ^ 6
    // (2 ^ 3) ^ 2
    // 2 ^ 3 = ((2 ^ 1) ^ 2 * 2)
    // (2 ^ 2 * 2) ^ 2

    // T(n) = T(n/2) + O(1) = O(log n)
    public static float power(float x, int n) {
        if (n == 0) {
            return 1;
        }

        if ((n % 2) == 0) { // even power x^n => (x^(n/2))^2
            float y = power(x, n / 2);                                  // T(n / 2)
            return y * y;
        } else {            // odd power x^n => x * (x^((n-1)/2))^2
            float y = power(x, (n - 1) / 2);                            // T((n - 1) / 2)
            return x * y * y;
        }
    }

    public static void main(String[] args) {
        for (int n = 0; n < 16; n++) {
            System.out.printf("2^%d = %f\n", n, power(2, n));
        }
    }
}
