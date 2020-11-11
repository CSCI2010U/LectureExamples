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

    public void insert(int newValue) {
        if (newValue < this.value) {
            // add the new element to the left sub-tree

            if (this.left == null) {
                // there is no left sub-tree, so this new
                // node will become our left sub-tree
                BSTNode newNode = new BSTNode();
                newNode.value = newValue;
                newNode.left = null;
                newNode.right = null;
                newNode.parent = this;
                this.left = newNode;
            } else {
                // we do have a left sub-tree, so insert the element there
                this.left.insert(newValue);
            }
        } else { // newValue >= this.value
            // add the new element to the right sub-tree

            if (this.right == null) {
                // there is no right sub-tree, so
                // add the element as our right sub-tree
                BSTNode newNode = new BSTNode();
                newNode.value = newValue;
                newNode.left = null;
                newNode.right = null;
                newNode.parent = this;
                this.right = newNode;
            } else {
                // there is a right sub-tree, so insert the element there
                this.right.insert(newValue);
            }
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
