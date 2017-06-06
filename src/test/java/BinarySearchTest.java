import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 30.05.2017.
 */
public class BinarySearchTest {
    @Test
    public void biSort() throws Exception {

        assertEquals(new BinarySearch(17, new int[]{2, 5, 8, 11, 14, 17, 20, 31}).getResult(), 5);
        assertEquals(new BinarySearch(11, new int[]{2, 5, 7, 8, 11, 14, 17, 20, 31}).getResult(), 4);
        assertEquals(new BinarySearch(22, new int[]{2, 5, 7, 8, 11, 14, 17, 20, 31}).getResult(), -1);
        assertEquals(new BinarySearch(221, new int[]{2, 5, 8, 11, 14, 17, 20, 31}).getResult(), -1);
        assertEquals(new BinarySearch(11, new int[]{2, 5, 8, 11, 14, 17, 20, 31}).getResult(), 3);
        assertEquals(new BinarySearch(1, new int[]{2, 5, 8, 11, 14, 17, 20, 31}).getResult(), -1);
        assertEquals(new BinarySearch(31, new int[]{2, 5, 8, 11, 14, 17, 20, 31}).getResult(), 7);

    }

}