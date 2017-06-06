import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by 1 on 02.06.2017.
 */
public class MyHashMapTest {
    @Test
    public void put() throws Exception {
        MyHashMap<Integer, Integer> target = new MyHashMap<>(1);
        target.put(5, 6);
        target.put(7, 12);
        target.put(13, 11);
        target.put(70, 2);
        System.out.println(Arrays.toString(target.table));

        MyHashMap<Integer, Integer> target1 = new MyHashMap<>(12);
        target1.put(1, 12);
        target1.put(12, 3);
        target1.put(13, 4);
        target1.put(13, 6);
        System.out.println(Arrays.toString(target1.table));





    }

}