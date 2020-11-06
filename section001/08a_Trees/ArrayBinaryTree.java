public class ArrayBinaryTree {
    private String[] values;

    public ArrayBinaryTree(String[] initialValues) {
        values = initialValues;
    }

    public String get(int index) {
        return values[index];
    }

    public int getRootIndex() {
        return 0;
    }

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

    public void printInOrder() {
        printNode(0, 0);
    }

    private void printNode(int index, int depth) {
        if ((index < 0 || index >= values.length)) {
            return;
        }

        // in-order traversal (but in reverse - smaller values at the bottom)

        // recursively traverse the right sub-tree
        printNode(getRightChild(index), depth + 1);

        // 'visit' the parent node
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(get(index));

        // recursively traverse the left sub-tree
        printNode(getLeftChild(index), depth + 1);

    }

    private void printNodeFlat(int index) {
        if ((index < 0 || index >= values.length)) {
            return;
        }

        // in-order traversal

        // recursively traverse the left sub-tree
        printNodeFlat(getLeftChild(index));

        // 'visit' the parent node
        System.out.println(get(index));

        // recursively traverse the right sub-tree
        printNodeFlat(getRightChild(index));

    }

    /*
                7
        3               12
    1       5       9       20

    [7,3,12,1,5,9,20]
    */
    public static void main(String[] args) {
        String[] startValues = new String[] {"7","3","12","1","5","9","20"};
        ArrayBinaryTree tree = new ArrayBinaryTree(startValues);

        int rootIndex = tree.getRootIndex();
        System.out.println("Root node: " + tree.get(rootIndex));
        System.out.println("Root node's left child: " + tree.get(tree.getLeftChild(rootIndex)));
        System.out.println("Root node's right child: " + tree.get(tree.getRightChild(rootIndex)));
        
        int nineIndex = 2;
        System.out.println("12 node's left child: " + tree.get(tree.getLeftChild(nineIndex)));
        System.out.println("12 node's right child: " + tree.get(tree.getRightChild(nineIndex)));
        System.out.println("12 node's parent: " + tree.get(tree.getParent(nineIndex)));

        tree.printInOrder();
    }
}