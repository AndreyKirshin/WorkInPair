import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by 1 on 30.05.2017.
 */
public class MyLinkedListStackThisIter<E>  implements Iterable<E>{
    Entry<E> topElement;


    public void push(E element) {
        Entry<E> e = new Entry<>();
        e.storedElement = element;
        if(topElement == null){
            e.next = null;
        }else e.next = topElement;
        topElement = e;
    }

    public E pop() {
        Entry<E> popEntry = topElement;
        topElement= topElement.next;
        return popEntry.storedElement;
    }

    public E peek() {
        return null;
    }

    public int size() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            Entry<E> current = topElement;


            @Override
            public boolean hasNext() {
                return (current != null);
            }

            @Override
            public E next() {

                return current.next.storedElement;
            }
        };

        return it;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    class Entry<E>{
        Entry<E> next;
        E storedElement;
    }
}

