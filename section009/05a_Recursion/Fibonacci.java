// binary recursive (two recursive calls)
public class Fibonacci {
    public static int binaryFibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return binaryFibonacci(n - 1) + binaryFibonacci(n - 2);
    }

    static class FibResult {
        public int i, j;

        public FibResult(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static FibResult linearFibonacci(int n) {
        if (n == 1) {
            return new FibResult(n, 0);
        } else {
            FibResult result = linearFibonacci(n - 1);
            return new FibResult(result.i + result.j, result.i);
        }
    }

    public static void main(String[] args) {
        for (int n = 0; n < 10; n++) {
            System.out.printf("fib(%d) = %d\n", n, binaryFibonacci(n));
        }
    }
}
