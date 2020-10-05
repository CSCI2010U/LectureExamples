public class OperationCounting {
    // worst case analysis
    public static int linearSearch(int[] values, int toFind) { // n => values.length
        for (int i = 0; i < values.length; i++) {     // 2n + 2 = O(n), # of times: n
           if (values[i] == toFind) {                   // 2 = O(1) (constant), # of times: 0 or 1
               return i;                                    // 1 = O(1) (constant)
           }
        }
        return -1;                                    // 1 = O(1) (constant)
     }                                        // TOTAL: 2n + 2 + 2n + 1 = 4n + 3 = O(n)
   
     public static double[] prefixAverage1(double[] elements) {
        double[] averages = new double[elements.length];                 // 3 = O(1)
        for (int avgIndex = 0; avgIndex < elements.length; avgIndex++) { // #: n, 2 + 2n = O(n)
            double total = 0.0;                                             // 2 = O(1)
            for (int sumIndex = 0; sumIndex <= avgIndex; sumIndex++) {      // #: 1, 2, 3, = n/2
                total += elements[sumIndex];                                    // 3 = O(1)
            }
            averages[avgIndex] = total / (avgIndex + 1);                    // 4
        }
        return averages;                                                 // 1 = O(1)
    }                        // TOTAL: 3 + 2 + 2n + 2n + 2 + n + 3n^2/2 + 4n = 7 + 9n + 1.5n^2 = O(n^2)

    public static double[] prefixAverage2(double[] elements) {
        double[] averages = new double[elements.length];
        double total = 0.0;
        for (int avgIndex = 0; avgIndex < elements.length; avgIndex++) {
            total += elements[avgIndex];
            averages[avgIndex] = total / (avgIndex + 1);
        }
        return averages;
    }
}