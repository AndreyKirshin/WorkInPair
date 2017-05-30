import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by 1 on 30.05.2017.
 */
public class MyArrayListTest {
    MyArrayList<Integer> listInt;

    @Before
    public void init() {
        listInt =  new MyArrayList<>();
    }
    @Test
    public void testAddToArrayList(){
        listInt.add(12);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(13);
        listInt.add(15);
        listInt.add(13);
        assertEquals((Integer)13, listInt.get(10));
        assertEquals((Integer)15, listInt.get(12));
        assertEquals(14,listInt.size());

        listInt.remove(10);
        listInt.remove(0);
        listInt.remove(13);
        assertEquals(null, listInt.get(10));
        System.out.println(listInt.toString());
        System.out.println(listInt.getCapacity());

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeOutOfBoundTest() throws Exception {
        listInt.add(12);
        listInt.remove(2);
    }
}