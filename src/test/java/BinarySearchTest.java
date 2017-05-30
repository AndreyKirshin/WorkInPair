import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 30.05.2017.
 */
public class BinarySearchTest {
    @Test
    public void biSort() throws Exception {
        assertEquals(4, BinarySearch.biSort(11, new int[]{2, 5, 7, 8, 11, 14, 17, 20, 31}));
        assertEquals(-1, BinarySearch.biSort(22, new int[]{2, 5, 7, 8, 11, 14, 17, 20, 31}));
        assertEquals(-1, BinarySearch.biSort(221, new int[]{2, 5, 8, 11, 14, 17, 20, 31}));
        assertEquals(3, BinarySearch.biSort(11, new int[]{2, 5, 8, 11, 14, 17, 20, 31}));

    }

}