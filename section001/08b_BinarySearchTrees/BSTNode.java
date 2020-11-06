public class BSTNode {
    public BSTNode left = null;
    public BSTNode right = null;
    public BSTNode parent = null;
    public int value = 0;

    public void insert(int value) {
        // variant of binary search
        if (value < this.value) {
            // add this value to the left sub-tree
            if (left == null) {
                // there is currently no left child, so
                // make this new node the left child
                BSTNode newNode = new BSTNode();
                newNode.value = value;
                newNode.parent = this;
                left = newNode;
            } else {
                // there is already a left child, so
                // ask that node to insert the value
                left.insert(value);
            }
        } else { // value >= this.value
            // add this value to the right sub-tree

            // TODO: Do the same that we did for the left sub-tree, above
        }
    }

    public void print(int depth) {
        // in-order traversal (reverse)

        // recursively print the right sub-tree
        if (right != null) {
            right.print(depth + 1);
        }

        // print the current node
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(value);

        // recurisively print the left sub-tree
        if (left != null) {
            left.print(depth + 1);
        }
    }
}
