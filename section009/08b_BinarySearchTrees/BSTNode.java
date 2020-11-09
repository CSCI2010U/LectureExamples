public class BSTNode {
    public int value;
    public BSTNode left;
    public BSTNode right;
    public BSTNode parent;

    public void print(int depth) {
        // in-order traversal (reverse)

        // recursively print the right sub-tree
        if (right != null) {
            right.print(depth + 1);
        }

        // print this root
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println("" + value);

        // recursively print the left sub-tree
        if (left != null) {
            left.print(depth + 1);
        }
    }
}
