import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by 1 on 15.06.2017.
 */
public class OurPriorityQueueTest {
    @Test
    public void insert() throws Exception {
        OurPriorityQueue target = new OurPriorityQueue();
        target.insert(14);
        target.insert(21);
        target.insert(-1);
        target.insert(35);
        target.insert(35);
        target.insert(1001);
        target.insert(0);
        target.insert(12);

        System.out.println(Arrays.toString(target.massive));
    }

    @Test
    public void delMax() throws Exception {
        OurPriorityQueue target = new OurPriorityQueue();
        target.insert(14);
        target.insert(21);
        target.insert(-1);
        target.insert(35);
        target.insert(35);
        target.insert(1001);
        target.insert(0);
        target.insert(12);

        System.out.println(Arrays.toString(target.massive));
        System.out.println(target.size);

        System.out.println(target.delMax());
        System.out.println(Arrays.toString(target.massive));

        System.out.println(target.delMax());
        System.out.println(Arrays.toString(target.massive));

        System.out.println(target.delMax());
        System.out.println(Arrays.toString(target.massive));

        System.out.println(target.delMax());

        System.out.println(Arrays.toString(target.massive));


    }

}