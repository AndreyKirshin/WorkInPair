/**
 * Created by 1 on 30.05.2017.
 */
public class MyArrayStack<E> implements MyArrayStackIF<E> {
    Object objects[];
    int last;

    public MyArrayStack(int length) {
        objects = new Object[length];
    }

    @Override
    public void push(E element) {
        if(last>=objects.length) {
            Object objectsNew [] = new Object[objects.length*2];
            System.arraycopy(objects,0,objectsNew,0,objects.length);
            objects = objectsNew;
        }
        objects[last] = element;
        last++;
    }

    @Override
    public E pop() {
        E element = (E)objects[last-1];
        objects[last-1]=null;
        last--;
        return element;
    }

    @Override
    public E peek() {
        return (E)objects[last-1];
    }

    @Override
    public int size() {
        return objects.length;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < last; i++) {
            stringBuilder.append(i).append(" ").append(objects[i]).append("\n");
        }
        return stringBuilder.toString();
    }
}
