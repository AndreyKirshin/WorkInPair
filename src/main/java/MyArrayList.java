import java.util.Arrays;

/**
 * Created by 1 on 30.05.2017.
 */
public class MyArrayList<E> implements MyArrayListainterface<E> {
    private int capacity = 10;
    private int length;
    private Object objects[] = new Object[capacity];

    @Override
    public void add(E obj) {
        if (length >= capacity) {
            capacity *= 2;
            Object objectsNew[] = new Object[capacity];
            System.arraycopy(objects, 0, objectsNew, 0, length);
            objects = objectsNew;
        }
        objects[length++] = obj;
    }

    @Override
    public void remove(int i) {
        if (i > length) throw new ArrayIndexOutOfBoundsException();
        else objects[i] = null;
    }

    @Override
    public E get(int i) {
        return (E) objects[i];
    }

    @Override
    public int size() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(i).append(" ").append(objects[i]).append("\n");
        }
        return stringBuilder.toString();
    }
}
