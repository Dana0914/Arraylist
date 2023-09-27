package arraylistpractice;

public class MyArrayList implements MyList {
    private Object[] items;
    private int size;
    public MyArrayList() {
        items = new Object[10];
        size = 0;
    }

    @Override
    public void add(String value) {
        if (items.length >= size) {
            increaseCapacity();
        }
        items[size++] = value;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        if (items.length >= size) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = value;
        size++;
    }

    @Override
    public void set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        items[index] = value;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        return (String) items[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        for (int i = index; i < size-1; i++) {
                items[i] = items[i + 1];
        }
        size--;

    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
    public void increaseCapacity() {
        int newCapacity = (int) (size * 1.5 + 1);
        Object[] newItem = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newItem[i] = items[i];
        }
        items = newItem;

    }
    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < size; i++) {
            elements.append(items[i]).append(", ");
        }
        return "ArrayList{" +
                elements.substring(0, elements.length() - 2) +
                '}';
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
