// T is a placeholder for the type of our data
public class GenericArrayList<T> {
    // Java won't let you create an array of T type, but since all classes
    // inherit from Object, we can make an array of Object, instead
    private Object[] elements;
    private int numElements;

    public GenericArrayList(int startSize) {
        elements = new Object[startSize];
        numElements = 0;
    }

    private void resizeIfNecessary() {
        if ((numElements + 1) >= elements.length) {
            // make a new, larger array
            Object[] newArray = new Object[elements.length * 2];

            // copy over the elements from the old array to the new
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }

            // replace the array
            elements = newArray;
        }
    }

    public void insertAtEnd(T newElement) {
        resizeIfNecessary();

        elements[numElements] = newElement;
        numElements++;
    }

    public void insertAtBeginning(T newElement) {
        resizeIfNecessary();

        // move all the elements to the right by one
        for (int i = numElements - 1; i >= 0; i--) {
            elements[i + 1] = elements[i];
        }

        // put our new value in the newly created empty space
        elements[0] = newElement;
        numElements++;
    }

    public void insertAtIndex(int index, T newElement) {
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

    public String toString() {
        String result = "[ ";
        for (int i = 0; i < numElements; i++) {
            result += elements[i] + " ";
        }
        return result + "]";
    }

    public static void main(String[] args) {
        GenericArrayList<String> list = new GenericArrayList<>(5);

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