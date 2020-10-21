// [1,2,3,4,5]
//  |       |
//  i       j
//
// 1. Swap elements at i and j
// [5,2,3,4,1]
//  |       |
//  i       j
// 2. recursively solve for i + 1 to j - 1
// [5,2,3,4,1]
//    |   |
//    i   j


// [5,4,3,2,1]
//      |
//     i,j

// [1,2,3,4]
// [4,2,3,1]
// [4,3,2,1]


// f(n) = n^2 is O(g(n) = n^3)      n^3 is OMEGA(n^2)
// big-oh O(): f grows the same or slower than g
// big-theta : f grows exactly the same as g
// big-omega : f grows the same or faster than g

public class ReverseArray {
    // tail recursion, linear recursion
    // T(n) = O(n)
    // T(n) = T(n - 2) + O(1)

    // T(10) = T(8) + c = T(6) + c + c = T(4) + c + c + c = T(2) + c + c + c + c = c + c + c + c + c = 5c
    // T(8) = T(6) + c
    // T(6) = T(4) + c
    // T(4) = T(2) + c
    // T(2) = T(0) + c
    // T(0) = 0
    // T(n) = n / 2
    public static void reverseArray(int[] array, int i, int j) {
        if (i < j) {                                    // O(1)
            // swap elements at i and j
            int temp = array[i];                        // O(1)
            array[i] = array[j];
            array[j] = temp;

            // recursively solve for i + 1, j - 1
            reverseArray(array, i + 1, j - 1);          // T(n - 2)
        }
    }

    // iterative version (easy to convert tail recursive functions to iteration)
    public static void reverseArrayLoop(int[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            // swap elements at i and j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i++;
            j--;
        }
    }

    // not recursive
    // convenience function, so I don't have to pass the indices
    public static void reverseArray(int[] array) {
        reverseArray(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        reverseArray(array);

        for (int element: array) {
            System.out.printf("%d ", element);
        }
        System.out.println("");
    }
}
