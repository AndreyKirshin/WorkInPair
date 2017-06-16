import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by 1 on 13.06.2017.
 */
public class OurQuickSortingTest {

    @Test
    public void testSort() {
        int a[] = new int[]{1, 5, 7, 3, 6, 8, 3, 2, 6, 0, -4, 2};
        int b[] = new int[]{-4, 0, 1, 2, 2, 3, 3, 5, 6, 6, 7, 8};
        OurQuickSorting t = new OurQuickSorting();
        //System.out.println(Arrays.toString(t.sortIn(a)));
        assertArrayEquals(b, t.sortIn(a));

    }
}