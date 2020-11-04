// binary recursion (two recursive calls)
public class BinarySum {
    public static int binarySum(int[] array, int startIndex, int numElements, int depth) {
        // the depth param and this code are just for illustrating the recursive calls
        for (int i = 0 ; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.printf("binarySum(array, %d, %d)\n", startIndex, numElements);

        if (numElements == 1) {
            return array[startIndex];
        }

        // calculate the sum of the first half of the list
        int firstHalfSum = binarySum(array, startIndex, numElements / 2, depth + 1);

        // calculate the sum of the second half of the list
        int secondHalfSum = binarySum(array, startIndex + numElements / 2, (int)Math.ceil((float)numElements / 2.0), depth + 1);

        // add the two sums together for our result
        return firstHalfSum + secondHalfSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        int sum = binarySum(array, 0, array.length, 0);
        System.out.println("Sum: " + sum);
    }
}
