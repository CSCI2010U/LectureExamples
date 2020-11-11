public class BinarySearchTree {
    private BSTNode root = null;

    public void printInOrder() {
        if (root == null) {
            System.out.println("null");
        } else {
            System.out.printf("Height:  %d\n", root.getHeight());
            System.out.printf("Balance: %d\n", root.getBalance());
            root.print(0);
        }
    }

    public void insert(int newValue) {
        if (root == null) {
            BSTNode newNode = new BSTNode();
            newNode.value = newValue;
            newNode.left = null;
            newNode.right = null;
            newNode.parent = null;

            root = newNode;
        } else {
            root.insert(newValue);
        }
    }

    /*
                        10
                5               15
            2       7       12      20
    */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // tree.insert(2);
        // tree.insert(5);
        // tree.insert(7);
        // tree.insert(10);
        // tree.insert(12);
        // tree.insert(15);
        // tree.insert(20);

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);
        tree.insert(11);

        tree.printInOrder();
    }
}