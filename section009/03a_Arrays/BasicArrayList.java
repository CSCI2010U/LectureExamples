public class BasicArrayList {
    private String[] elements;
    private int numElements;

    public BasicArrayList(int initialSize) {
        // creating an array with space for some strings, but not creating strings
        elements = new String[initialSize];
        numElements = 0;

        // String s = new String("");
    }

    private void resizeIfNecessary() {
        if ((numElements + 1) >= elements.length) {
            // create a new array (double the size)
            String[] newArray = new String[elements.length * 2];

            // copy over the elements, from the old array to the new array
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }

            // replace the array
            elements = newArray;
        }
    }

    public void insertAtEnd(String newElement) {
        resizeIfNecessary();

        elements[numElements] = newElement;
        numElements++;
    }

    public String toString() {
        // output like this:  [ abc def ghi ]
        String result = "[ ";

        // for (String element: elements) {
        //     result += element + " ";
        // }
        for (int i = 0; i < numElements; i++) {
            result += elements[i] + " ";
        }

        return result + "]";
    }

    public void insertAtBeginning(String newElement) {
        resizeIfNecessary();

        // move all the elements to the right by one
        for (int i = numElements - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }

        // put our new value in the newly created empty space
        elements[0] = newElement;
        numElements++;
    }

    public void insertAtIndex(int index, String newElement) {
        // throw an exception if the user tries to insert at an invalid index
        if (index >= numElements) {
           throw new ArrayIndexOutOfBoundsException("No such index: " + index);
        }
  
        resizeIfNecessary();
  
        // move all of the elements forward one position
        for (int i = numElements - 1; i >= index; i--) {
           elements[i+1] = elements[i];
        }
  
        // add the element to the specified index
        elements[index] = newElement;
        numElements++;
     }

    public static void main(String[] args) {
        BasicArrayList list = new BasicArrayList(5);

        list.insertAtEnd("Rick");
        list.insertAtEnd("Morty");
        list.insertAtBeginning("Jane");
        list.insertAtEnd("Xavier");
        list.insertAtBeginning("Tatiana");
        list.insertAtEnd("Kumar");
        list.insertAtIndex(3, "Carla");
  
        System.out.println(list);
  
        // list.insertAtIndex(20, "Invalid Index");
    }
}