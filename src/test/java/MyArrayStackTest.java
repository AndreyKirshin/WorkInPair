import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 30.05.2017.
 */
public class MyArrayStackTest {

    @Test
    public void testPushToStack() {
        MyArrayStack <Integer> stack = new MyArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.last);

        assertEquals((Integer)3,stack.peek());
        assertEquals((Integer)3,stack.pop());

        System.out.println(stack);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.last);

    }

}