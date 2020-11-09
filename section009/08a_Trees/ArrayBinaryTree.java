public class ArrayBinaryTree {
    private int[] values;

    public ArrayBinaryTree(int[] initialValues) {
        this.values = initialValues;
    }

    public int get(int index) {
        return values[index];
    }

    public int getRootIndex() {
        return 0;
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

    public void printInOrder() {
        printNode(getRootIndex(), 0);
    }

    private void printNode(int index, int depth) {
        if (index < 0 || index >= values.length) {
            return;
        }
    
        // in-order traversal (reversed; right to left)

        // print the right sub-tree
        printNode(getRightChild(index), depth + 1);

        // visit (print) this node 
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println("" + get(index));

        // print the left sub-tree
        printNode(getLeftChild(index), depth + 1);
    }

    private void printNodeFlat(int index) {
        if (index < 0 || index >= values.length) {
            return;
        }
    
        // in-order traversal (left to right)

        // print the left sub-tree
        printNodeFlat(getLeftChild(index));

        // visit (print) this node 
        System.out.println("" + get(index));

        // print the right sub-tree
        printNodeFlat(getRightChild(index));
    }

    public static void main(String[] args) {
        /*
                        7
                3               12
            1       5       10      15
        */

        /*
        15
    12
        10
7
        5
    3
        1
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

        tree.printInOrder();
    }
}