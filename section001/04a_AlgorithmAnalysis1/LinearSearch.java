package algorithm_analysis;

import java.util.Random;

enum AnalysisType { BEST, WORST, AVERAGE }
enum Algorithm { LINEAR_SEARCH, BINARY_SEARCH }

public class LinearSearch {
    
    public static int[] generateRandomList(int n) {
        int[] values = new int[n];

        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt((int)n);
        }

        return values;
    }

    public static int[] generateConsecutiveList(int n) {
        int[] values = new int[n];

        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }

        return values;
    }

    public static int linearSearch(int[] values, int toFind) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == toFind) {
                return i;
            }
        }
        return -1; // not found
    }

    public static int binarySearch(int[] values, int toFind) {
        return binarySearch(values, toFind, 0, values.length - 1);
    }

    public static int binarySearch(int[] values, int toFind, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return -1; // not found
        }

        //System.out.printf("Searching from %d to %d.\n", startIndex, endIndex);
        int mid = (startIndex + endIndex) / 2;

        if (toFind == values[mid]) {
            return mid;
        } else if (toFind < values[mid]) {
            return binarySearch(values, toFind, startIndex, mid - 1);
        } else {
            return binarySearch(values, toFind, mid + 1, endIndex);
        }
    }

    public static void print(int[] values) {
        System.out.print("{ ");
        for (int i = 0; i < values.length; i++) {
            if (i < 10 || i >= (values.length - 10)) {
                System.out.printf("%d ", values[i]);
            } else if (i == 10) {
                System.out.print("... ");
            }
        }
        System.out.println("}");
    }

    public static double performanceCheck(int n, int iterations, Algorithm algorithm, AnalysisType type, boolean debug) {
        int[] values = null;
        if (algorithm == Algorithm.LINEAR_SEARCH) {
            values = generateRandomList(n);
        } else if (algorithm == Algorithm.BINARY_SEARCH) {
            values = generateConsecutiveList(n);
        }
        if (debug) {
            print(values);
        }

        int foundCount = 0;

        Random random = new Random();
        
        double duration = 0.0;
        double startTime = 0.0;
        double endTime = 0.0;
        int index = 0;
        if (algorithm == Algorithm.LINEAR_SEARCH) {
            for (int i = 0; i < iterations; i++) {
                int toFind = random.nextInt(n); // for average
                if (type == AnalysisType.BEST) {
                    toFind = values[0];
                } else if (type == AnalysisType.WORST) {
                    toFind = -1; // not found
                }
        
                startTime = (double)System.nanoTime();
                index = linearSearch(values, toFind);
                endTime = (double)System.nanoTime();

                duration += endTime - startTime;

                if (index >= 0) {
                    foundCount++;
                }
            }
        } else if (algorithm == Algorithm.BINARY_SEARCH) {
            for (int i = 0; i < iterations; i++) {
                int randomNumber = random.nextInt(n); // for average
                int toFind = 0;

                if (type == AnalysisType.BEST) {
                    toFind = values[values.length / 2];
                } else if (type == AnalysisType.WORST) {
                    toFind = n + 1; // not found
                } else {
                    toFind = randomNumber;
                }
        
                startTime = (double)System.nanoTime();
                index = binarySearch(values, toFind);
                endTime = (double)System.nanoTime();

                duration += endTime - startTime;

                if (index >= 0) {
                    foundCount++;
                }
            }
        }

        // if (debug) {
            System.out.printf("Found the element %d out of %d times.\n", foundCount, iterations);
        // }

        return (duration / 1000000.0) / iterations;
    }

    public static void main(String[] args) {
        int linearIterations = 100;
        int binaryIterations = 10000000;
        boolean debug = false;

        for (int n = 1000000; n <= 1000000000; n *= 10) {
            System.out.printf("\nRunning performance check for n = %d.\n", n);

            double linearBestDuration = performanceCheck(n, linearIterations, Algorithm.LINEAR_SEARCH, AnalysisType.BEST, debug);
            double linearAverageDuration = performanceCheck(n, linearIterations, Algorithm.LINEAR_SEARCH, AnalysisType.AVERAGE, debug);
            double linearWorstDuration = performanceCheck(n, linearIterations, Algorithm.LINEAR_SEARCH, AnalysisType.WORST, debug);
            System.out.printf("Linear search running times:  (best: %fms, average: %fms, worst: %fms)\n", linearBestDuration, linearAverageDuration, linearWorstDuration);

            double binaryBestDuration = performanceCheck(n, binaryIterations, Algorithm.BINARY_SEARCH, AnalysisType.BEST, debug);
            double binaryAverageDuration = performanceCheck(n, binaryIterations, Algorithm.BINARY_SEARCH, AnalysisType.AVERAGE, debug);
            double binaryWorstDuration = performanceCheck(n, binaryIterations, Algorithm.BINARY_SEARCH, AnalysisType.WORST, debug);
            System.out.printf("Binary search running times:  (best: %fms, average: %fms, worst: %fms)\n", binaryBestDuration, binaryAverageDuration, binaryWorstDuration);
        }
    }
}