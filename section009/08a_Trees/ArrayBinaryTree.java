public class ArrayBinaryTree {
    private int[] values;

    public ArrayBinaryTree(int[] initialValues) {
        this.values = initialValues;
    }

    public int get(int index) {
        return values[index];
    }


    public int getLeftChild(int index) {
        return index * 2 + 1;
    }

    public int getRightChild(int index) {
        return index * 2 + 2;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public static void main(String[] args) {
        /*
                        7
                3               12
            1       5       10      15
        */

        /*
        child index    parent index
        5           -> 2
        6           -> 2
        1           -> 0
        3           -> 1
        */
        int[] startValues = new int[] {7, 3, 12, 1, 5, 10, 15};
        ArrayBinaryTree tree = new ArrayBinaryTree(startValues);

        int index = 6;
        System.out.printf("%d's parent is %d\n", tree.get(index), tree.get(tree.getParent(index)));
    }
}