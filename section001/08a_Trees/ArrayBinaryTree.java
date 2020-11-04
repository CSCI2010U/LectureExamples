public class ArrayBinaryTree {
    private String[] values;

    public ArrayBinaryTree(String[] initialValues) {
        values = initialValues;
    }

    public String get(int index) {
        return values[index];
    }

    /*
                7
        3               12
    1       5       9       20

    [7,3,12,1,5,9,20]
    */
    public int getParent(int index) {
        // 6 -> 2
        // 5 -> 2
        // 2 -> 0
        // 4 -> 1
        return (index - 1) / 2;
    }

    public int getLeftChild(int index) {
        return (index * 2) + 1;
    }

    public int getRightChild(int index) {
        return (index * 2) + 2;
    }

    public static void main(String[] args) {
        String[] startValues = new String[] {"7","3","12","1","5","9","20"};
        ArrayBinaryTree tree = new ArrayBinaryTree(startValues);
    }
}