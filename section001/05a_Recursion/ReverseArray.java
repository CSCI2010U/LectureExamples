public class ReverseArray {
    public static void reverseArray(String[] array) {
        // convenience function - easier to call
        reverseArray(array, 0, array.length - 1);
    }

    // linear recursion (one recursive call), tail recursion (recursive call is last operation)
    // T(n) = T(n - 2) + O(1) = O(n)

    // T(n)
    // T(n - 2) + k
    // (T(n - 4) + k) + k
    // ((T(n - 6) + k) + k) + k
    // k + k + ... + k     (n/2 times)
    // kn/2 = O(n)
    public static void reverseArray(String[] array, int i, int j) {
        if (i < j) {                                                    // O(1)
            // swap the elements at positions i and j (first and last)
            String temp = array[i];                                         // O(1)
            array[i] = array[j];                                            // O(1)
            array[j] = temp;                                                // O(1)

            // recursively reverse the rest of the elements (between i and j)
            reverseArray(array, i + 1, j - 1);                              // T(n - 2)
        }
    }

    public static void reverseArrayLoop(String[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            // swap the elements at positions i and j (first and last)
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String[] array = {"a", "b", "c", "d", "e"};

        // reverseArray(array);
        reverseArrayLoop(array);

        for (String element: array) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }
}
