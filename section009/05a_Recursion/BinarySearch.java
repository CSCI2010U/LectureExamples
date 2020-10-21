public class BinarySearch {
    // overloaded function - just for the convenience of the consumers of my function
    public static boolean binarySearch(int[] data, int toFind) {
        return binarySearch(data, toFind, 0, data.length - 1);
    }

    public static boolean binarySearch(int[] data, int toFind, int startIndex, int endIndex) {
        // no elements left to search
        if (endIndex < startIndex) {
            return false;
        }

        int middleIndex = (startIndex + endIndex) / 2;

        // found the element
        if (toFind == data[middleIndex]) {
            return true;
        } else if (toFind < data[middleIndex]) {
            // look in the left half of the list
            // endIndex = middleIndex - 1; // we'd do this if this were a loop
            return binarySearch(data, toFind, startIndex, middleIndex - 1);
        } else {
            // look in the right half of the list
            // startIndex = middleIndex + 1; // we'd do this if this were a loop
            return binarySearch(data, toFind, middleIndex + 1, endIndex);
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