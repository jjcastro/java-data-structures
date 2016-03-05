package linearDS;

/**
 * Created by Juanjo on 3/5/16.
 */
public class ArrayList<E> {

    /**
     * Number of elements in the list
     */
    private int size;

    /**
     * Array of data
     */
    private E[] data;

    /**
     * Creates a new ArrayList of capacity 10
     */
    public ArrayList() {
        size = 0;
        data = (E[])(new Object[10]);
    }

    public int size() {
        return size;
    }

    /**
     * Add a new element
     * @param element
     */
    public void add(E element) {
        if(data.length < size + 1) {
            grow();
        }
        data[size] = element;
        size++;
    }

    /**
     * Add a new element at index
     * @param element
     * @param index
     */
    public void addAtIndex(E element, int index) throws ArrayIndexOutOfBoundsException {
        checkIndex(index);
        if(data.length < size + 1) {
            grow();
        }
        for(int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    /**
     * Remove element at index
     * @param index
     * @throws Exception If index is not in list
     */
    public void removeAtIndex(int index) throws ArrayIndexOutOfBoundsException {
        checkIndex(index);
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size] = null;
        if(size > 0) size--;
    }

    /**
     * Remove a specific element
     * @param element
     */
    public void remove(E element) {
        for(int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                removeAtIndex(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String res = "{";
        for(int i = 0; i < size; i++) {
            if(data[i] != null) {
                res += data[i];
            } else {
                res += "null";
            }
            res += (i == size - 1 ? "" : ", ");
        }
        return res + "}\n";
    }

    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index exceeds size of list.");
        }
    }

    private void grow() {
        E[] newData = (E[])(new Object[data.length * 2]);
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
