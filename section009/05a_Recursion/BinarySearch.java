// linear recursion   - one recursive call
// tail recursion     - one recursive call, recursion is the last step
// binary recursion   - two recursive calls
// multiple recursion - more than two recursive calls

public class BinarySearch {
    // overloaded function - just for the convenience of the consumers of my function
    public static boolean binarySearch(int[] data, int toFind) {
        return binarySearch(data, toFind, 0, data.length - 1);
    }

    // [1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39]    (n = 20)
    // [1,3,5,7,9,11,13,15,17,19] toFind=14  (n = 10)
    // [11,13,15,17,19]                      (n = 5)
    // [11,13]                               (n = 2)
    // [13]                                  (n = 1)
    // []                                    (n = 0)
    // 
    // T(n) = O(log n)  (but how do I know this?)
    // T(n) = T(n/2) + O(1)  (recurrence - T is defined in terms of T)

    // linear recursion, also tail recursion
    public static boolean binarySearch(int[] data, int toFind, int startIndex, int endIndex) {
        // no elements left to search
        if (endIndex < startIndex) {                                            // O(1)
            return false;                                                       // O(1)
        }

        int middleIndex = (startIndex + endIndex) / 2;                          // O(1)

        // found the element
        if (toFind == data[middleIndex]) {                                      // O(1)
            return true;                                                            // O(1)
        } else if (toFind < data[middleIndex]) {                                // O(1)
            // look in the left half of the list
            // endIndex = middleIndex - 1; // we'd do this if this were a loop  // depends on binarySearch
            return binarySearch(data, toFind, startIndex, middleIndex - 1);         // T(n/2)
        } else {
            // look in the right half of the list
            // startIndex = middleIndex + 1; // we'd do this if this were a loop
            return binarySearch(data, toFind, middleIndex + 1, endIndex);           // T(n/2)
        }
    }


    public static void main(String[] args) {
        int[] list = {2,4,6,8,10,12,14,16,18,20};
        System.out.println("Is 8 in the list? " + binarySearch(list, 8));
        System.out.println("Is 20 in the list? " + binarySearch(list, 20));
        System.out.println("Is 2 in the list? " + binarySearch(list, 2));
        System.out.println("Is 7 in the list? " + binarySearch(list, 7));
    }
}