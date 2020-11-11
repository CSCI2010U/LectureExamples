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
                // ask the left node to insert the value
                left.insert(value);
            }
        } else { // value >= this.value
            // add this value to the right sub-tree

            if (this.right == null) {
                // there is currently no right child, so
                // make this new node the right child
                BSTNode newNode = new BSTNode();
                newNode.value = value;
                newNode.parent = this;
                this.right = newNode;
            } else {
                // there is already a right child, so
                // ask the right node to insert the value
                this.right.insert(value);
            }
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

    public int getHeight() {
        int leftHeight = 0;
        if (this.left != null) {
            leftHeight = this.left.getHeight();
        }

        int rightHeight = 0;
        if (this.right != null) {
            rightHeight = this.right.getHeight();
        }

        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    public int getBalance() {
        int leftHeight = 0;
        if (this.left != null) {
            leftHeight = this.left.getHeight();
        }

        int rightHeight = 0;
        if (this.right != null) {
            rightHeight = this.right.getHeight();
        }
        
        return leftHeight - rightHeight;
    }
}
