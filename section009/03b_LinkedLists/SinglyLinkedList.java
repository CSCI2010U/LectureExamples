public class SinglyLinkedList {
    class SLLNode {
        public String value;
        public SLLNode next;
    }

    private SLLNode head = null; // initially empty

    public void insertAtBeginning(String newValue) {
        // create a node for our new value
        SLLNode newNode = new SLLNode();
        newNode.value = newValue;

        // insert the value before the existing first value
        newNode.next = head;

        // update the head reference
        head = newNode;
    }

    public void insertAtEnd(String newValue) {
        if (head == null) {
            insertAtBeginning(newValue);
            return;
        }

        // walk to the end of the list
        SLLNode current = head;
        SLLNode prev = null;
        while (current != null) {
            prev = current;
            current = current.next;
        }

        // create a new node
        SLLNode newNode = new SLLNode();
        newNode.value = newValue;
        newNode.next = null;

        // add it after the last element
        prev.next = newNode;
    }

    public String toString() {
        String result = "[ ";

        SLLNode current = head;
        while (current != null) {
            result += current.value + " ";
            current = current.next;
        }

        return result + "]";
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd("Rick");
        list.insertAtEnd("Morty");
        list.insertAtBeginning("Jane");
        list.insertAtEnd("Xavier");
        list.insertAtBeginning("Tatiana");
        list.insertAtEnd("Kumar");
        // list.insertAtIndex(3, "Carla");
  
        System.out.println(list);
    }
}