/**
 * Created by 1 on 30.05.2017.
 */
public class MyLinkedListStack<E>  {
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

    class Entry<E>{
        Entry<E> next;
        E storedElement;
    }
}

