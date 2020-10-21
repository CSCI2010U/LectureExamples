// binary recursive (two recursive calls)
public class Fibonacci {
    public static int binaryFibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return binaryFibonacci(n - 1) + binaryFibonacci(n - 2);
    }
}
