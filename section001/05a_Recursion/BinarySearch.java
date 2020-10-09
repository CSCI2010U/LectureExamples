public class BinarySearch {
    // T(n) = 4n^2 + 8n + 9 = O(n^2)
    // T(n) - running *T*ime of the algorithm
    // n - input size

    // overloaded function - just for the convenience of the consumers of my function
    public static boolean binarySearch(int[] data, int toFind) {
        return binarySearch(data, toFind, 0, data.length - 1);
    }

    // actual binary search implementation
    // T(n) = k lg n + c
    // n - number of elements in the list
    public static boolean binarySearch(int[] data, int toFind, int startIndex, int endIndex) {
        // no elements left to search
        if (endIndex < startIndex) {                                                // O(1)
            return false;                                                           // O(1)
        }

        int middleIndex = (startIndex + endIndex) / 2;                              // O(1)

        // found the element
        if (toFind == data[middleIndex]) {                                          // O(1)
            return true;                                                            // O(1)
        } else if (toFind < data[middleIndex]) {                                    // O(1)
            // look in the left half of the list
            // endIndex = middleIndex - 1; // we'd do this if this were a loop
            return binarySearch(data, toFind, startIndex, middleIndex - 1);         // T(n/2)
        } else {
            // look in the right half of the list
            // startIndex = middleIndex + 1; // we'd do this if this were a loop
            return binarySearch(data, toFind, middleIndex + 1, endIndex);           // T(n/2)
        }
    }       // worst case performance:  T(n) = T(n/2) + O(1)    (recurrence equation)

    public static int linearSum(int[] A, int n) {
        if (n == 0) {
            return 0;
        }

        return linearSum(A, n - 1) + A[n - 1];
    }

    public static void main(String[] args) {
        int[] list = {2,4,6,8,10,12,14,16,18,20};
        System.out.println("Is 8 in the list? " + binarySearch(list, 8));
        System.out.println("Is 20 in the list? " + binarySearch(list, 20));
        System.out.println("Is 2 in the list? " + binarySearch(list, 2));
        System.out.println("Is 7 in the list? " + binarySearch(list, 7));

        System.out.println("Sum of the list " + linearSum(list, list.length));
        
    }
}