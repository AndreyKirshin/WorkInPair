import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by 1 on 09.06.2017.
 */
public class MyBinarySearchTreeTest {
    @Test
    public void add() throws Exception {
        MyBinarySearchTree<Integer> target = new MyBinarySearchTree<>();
        target.add(1);
        target.add(2);
        target.add(3);
        target.add(-6);

        assertEquals(4, target.size);
    }

    @Test
    public void depthFirstSearchTest() throws Exception {
        MyBinarySearchTree<Integer> target = new MyBinarySearchTree<>();
        target.add(1);
        target.add(2);
        target.add(3);
        target.add(-6);

        assertTrue(target.depthFirstSearch(-6));
        assertTrue(target.depthFirstSearch(2));
        assertFalse(target.depthFirstSearch(5));
    }

    @Test
    public void breadthFirstSearchTest() throws Exception {
        MyBinarySearchTree<Integer> target = new MyBinarySearchTree<>();
        target.add(1);
        target.add(2);
        target.add(3);
        target.add(-6);

        assertTrue(target.breadthFirstSearch(-6));
        assertTrue(target.breadthFirstSearch(2));
        assertTrue(target.breadthFirstSearch(1));
        assertTrue(target.breadthFirstSearch(3));
        assertFalse(target.breadthFirstSearch(5));
    }

    @Test
    public void breadthTraversal() throws Exception {
        MyBinarySearchTree<Integer> target = new MyBinarySearchTree<>();
        target.add(10);
        target.add(2);
        target.add(5);
        target.add(1);
        target.add(5);
        target.add(12);
        target.add(16);
        target.add(7);

        Object[] src = target.breadthTraversal().toArray();
        Object[] test = new Object[] {10, 2, 15, 1, 5, 12, 16, 7};
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(test));
        assertArrayEquals(test, src);
    }
}