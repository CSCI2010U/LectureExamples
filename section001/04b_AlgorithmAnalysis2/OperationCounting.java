public class OperationCounting {
    // list = [1.0, 2.0, 3.0]
    // prefixAverage1(list) => [1.0, 1.5, 2.0]

    public static double[] prefixAverage1(double[] elements) {              // worst case performance (+ avg + best)
        double[] averages = new double[elements.length];                    // O(1) (constant)
        for (int avgIndex = 0; avgIndex < elements.length; avgIndex++) {    // n iterations, 2 + 2n = O(n) operations
            double total = 0.0;                                                 // O(1)
            for (int sumIndex = 0; sumIndex <= avgIndex; sumIndex++) {          // (1, 2, 3, .. n) iterations (total: n(n+1)/2)
                total += elements[sumIndex];                                        // O(1)
            }
            averages[avgIndex] = total / (avgIndex + 1);                        // O(1) (total: O(n))
        }
        return averages;              
    }                                                              // TOTAL: O(n^2) (quadratic)

    public static double[] prefixAverage2(double[] elements) {
        double[] averages = new double[elements.length];                    // 4 = O(1)
        double total = 0.0;                                                 // 2 = O(1)
        for (int avgIndex = 0; avgIndex < elements.length; avgIndex++) {    // n iterations, 2 + 2n = O(n)
            total += elements[avgIndex];                                        // 3 = O(1)
            averages[avgIndex] = total / (avgIndex + 1);                        // 4 = O(1)
        }
        return averages;                                                    // 1 = O(1)
    }                                                         // TOTAL: 4 + 2 + 2 + 2n + 3n + 4n + 1 = 9n + 9 = O(n)
}