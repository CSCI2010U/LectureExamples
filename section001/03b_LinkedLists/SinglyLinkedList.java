public class SinglyLinkedList {
    class SLLNode {
        public String value;
        public SLLNode next;
    }

    private SLLNode head = null;

    public void insertAtBeginning(String newValue) {
        // create a new node for our value
        SLLNode newNode = new SLLNode();
        newNode.value = newValue;

        // point the next pointer to the old 'head'
        newNode.next = head;

        // change the head pointer
        head = newNode;
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

    public void insertAtEnd(String newValue) {
        // create a new node for our value
        SLLNode newNode = new SLLNode();
        newNode.value = newValue;
        newNode.next = null;

        // navigate to the end of the list
        SLLNode current = head;

        while ((current != null) && (current.next != null)) {
            current = current.next;
        }

        // link in our new node
        if (current == null) {
            // the list was empty (special case)
            head = newNode;
        } else {
            // we're at the end of a non-empty list
            current.next = newNode;
        }
    }

    public void insertAtIndex(int index, String newValue) {
        // special case - insert at the beginning
        if (index == 0) {
            insertAtBeginning(newValue);
            return;
        }

        // walk to the correct position in the list
        int currentIndex = 0;
        SLLNode current = head;
        SLLNode prev = null;
        while ((currentIndex < index) && (current != null)) {
            currentIndex++;
            prev = current;
            current = current.next;
        }
   
        // if the index was too large
        if (currentIndex < index) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
   
        // insert between the two elements
        SLLNode newNode = new SLLNode();
        newNode.next = current;
        newNode.value = newValue;
        prev.next = newNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd("Rick");
        list.insertAtEnd("Morty");
        list.insertAtBeginning("Jane");
        list.insertAtEnd("Xavier");
        list.insertAtBeginning("Tatiana");
        list.insertAtEnd("Kumar");
        list.insertAtIndex(3, "Carla");
  
        System.out.println(list);

        list.insertAtIndex(20, "Invalid Index"); // run time error
    }
}