import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 30.05.2017.
 */
public class MyLinkedListStackTest {
    @Test
    public void push() throws Exception {
        MyLinkedListStack<Integer> target = new MyLinkedListStack<>();
        target.push(12);
        target.push(12);
        target.push(12);
        target.push(13);
        assertEquals((Integer) 13, target.pop());
        assertEquals((Integer) 12, target.pop());

    }

}