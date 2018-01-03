/**
 *  * This is an ArrayList class that behaves just like an ArrayList interface.
 * This class has a no-arg Constructor and can also accept a type parameter to
 * specify the object.
 *
 * @ Version: Rathtana Dong
 * @ Version: 3/8/17
 */
public class ArrayList <E> {
    //private instance Variables
    private Object[] arrayList = new Object[100];
    private int numElement = 0;


    /**
     * Method that allow you to add an Object to a specific index of the array.
     * This method will make sure that all of the elements will shift
     * accordingly when a new object is added to a certain index.
     * It will alsoLast but not least, It will update the size of the array.
     *
     * @param type (E)
     * @param index  type int
     * @throws PizzaException if the index you wish to is out of bound.
     */
    public void insert(E type, int index) {
        //Resize the array  when it reaches its initial capacity of 100
        if (numElement == arrayList.length) {
            doubleArraySize();
        }
        //Adding to an existing index that already contains a value
        if (arrayList[index] != null) {
            //Shift the original object and object in front of it 1 index
            // forward to make room.
            for (int i = numElement; i > index; i--) {
                arrayList[i] = arrayList[i - 1];
            }
            //add the object to that index
            arrayList[index] = type;
            //increase by 1 because we added another element
            numElement++;
        }
        //Avoiding index out of bound. ArrayList only allows element to be
        // added to an index that will increase it size by one each time.
        else if (numElement == index) {
            //add the object to that index
            arrayList[index] = type;
            //increase by 1 because we added another element
            numElement++;
        }
        //Can't add to an index of the ArrayList that is out of bound
        else {
            throw new PizzaException("Index Out of Bound!");
        }
    }

    /**
     * This method is for removing object at a specific index. It will make sure
     * that all of the elements will shift accordingly to fill
     * the element that was removed. It will also update the size for the Array.
     *
     * @param index type int
     * @return Object at the specific index
     * @throws PizzaException for Index Out of Bound
     */
    public Object remove(int index) {
        //index Out of Bound. Index can't equal or be bigger than
        // the size of the array.
        if (index >= numElement) {
            throw new PizzaException("Index out of Bound!");
        }
        //Retrieve the value from that index
        Object value = arrayList[index];
        for (int i = index; i < numElement; i++) {
            //replace the last index to null because everything
            // it will be shifted one backward
            if (numElement - index == 1) {
                arrayList[i] = null;
            } else {
                //shifting 1 index down to fill the the removed element
                arrayList[i] = arrayList[i + 1];
            }
        }
        //one element was removed
        numElement--;
        //return the value of the removed element
        return value;
    }

    /**
     * A method that return the size of the ArrayList.
     *
     * @return numElement type int
     */
    public int size() {
        //numElement is the size of the array
        return numElement;

    }

    /**
     * A toString method of ArrayList that return a string representation.
     * This will return all the values as string in each index of the Array
     *
     * @return s type String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        //to avoid printing null
        if (numElement > 0) {
            s.append(arrayList[0]);
            for (int i = 1; i < numElement; i++) {

                s.append("\n" + arrayList[i]);

            }
        }
        return s.toString();
    }
    /**
     * A boolean method that allows you to check if the ArrayList is empty.
     *
     * @return true if Array is empty and false otherwise
     */
    public boolean isEmpty() {
        if (numElement == 0) {
            return true;
        }
        return false;
    }

    /**
     * A method that tells you the index that contains the input Object.
     * It will return the index of the object
     * or -1 if no the object doesn't exist
     *
     * @param object (E)
     * @return index type int if object was found or -1 otherwise
     */
    public int indexOff(E object) {
        for (int i = 0; i < numElement; i++) {
            if (object == arrayList[i]) {
                return i;
            }
        }
        //object doesn't contain in any of the index
        return -1;
    }

    /**
     * A boolean equals method that compares input object to the instance
     * object. The object must be the same type and has the exact same
     * characteristic in ordered to be true.
     *
     * @param object type object
     * @return true if object are the same and false otherwise
     */
    @Override
    public boolean equals(Object object) {
        //Checking to see if the object is the same type
        if (object != null && object instanceof ArrayList) {
            //Casting the type on the object for comparison
            ArrayList that = (ArrayList) object;
            //checking to make sure the size is the same
            if (numElement == that.numElement) {
                //Loop through all the index to compare the object in the index
                for (int i = 0; i < numElement; i++) {
                    //if one index is not the same then stop comparing
                    // and return false
                    if (!arrayList[i].equals(that.arrayList[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * A method that give you the object that contains in the index that
     * was passed in.
     *
     * @param index type int
     * @return Object type object
     * @throws PizzaException for Index out of bound
     */
    public Object get(int index) {
        //throw exception for trying to get an index that doesn't exist
        if(index >= numElement) {
            throw new PizzaException("Index out of Bound!");
        }
        //returning the object that was found at that index
        return arrayList[index];
    }

    /**
     * A swap method that takes in the 2 index to swap the value between the
     * two.
     * @param startIndex (int) left most index in the array
     * @param endIndex (int) right most index in the array
     */
    public void swap(int startIndex, int endIndex) {
        if(startIndex != endIndex) {
            Object temp = arrayList[startIndex];
            arrayList[startIndex] = arrayList[endIndex];
            arrayList[endIndex] = temp;
        }
    }
    /**
     * A private method tht will resize the initial array size by
     * doubling its size of the array
     */
    private void doubleArraySize() {
        //double the size of the original array
        Object[] newArray = new Object[numElement * 2];
        for(int i =0; i < numElement; i++) {
            //transferring all the values to a new bigger array
            newArray[i] = arrayList[i];
        }
        //setting arrayList reference to the new bigger array
        arrayList = newArray;
    }
}
