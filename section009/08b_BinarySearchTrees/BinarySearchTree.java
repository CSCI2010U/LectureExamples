public class BinarySearchTree {
    private BSTNode root = null;

    public void printInOrder() {
        if (root == null) {
            System.out.println("null");
        } else {
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
            // TODO: Implement insert
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(7);
        tree.insert(3);
        tree.insert(10);

        tree.printInOrder();
    }
}