public class BinarySearchTree {
    private BSTNode root = null;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        if (root == null) {
            BSTNode rootNode = new BSTNode();
            rootNode.value = value;
            root = rootNode;
        } else {
            root.insert(value);
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("null");
        } else {
            root.print(0);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        tree.print();
    }
}
