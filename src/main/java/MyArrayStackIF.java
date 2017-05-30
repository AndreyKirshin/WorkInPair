/**
 * Created by 1 on 30.05.2017.
 */
public interface MyArrayStackIF<E> {
    void push(E element);
    E pop();
    E peek();
    int size();
}
