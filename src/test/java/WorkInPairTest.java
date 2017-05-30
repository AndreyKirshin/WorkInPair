import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 25.05.2017.
 */
public class WorkInPairTest {
    @Test
    public void test() {
        WorkInPair workInPair = new WorkInPair();
        assertTrue(workInPair.matches("[{()}]"));
        assertTrue(workInPair.matches("[()]"));
        assertFalse(workInPair.matches("]["));
        assertFalse(workInPair.matches(")("));
        assertFalse(workInPair.matches("}{"));
        assertFalse(workInPair.matches("]["));
        assertTrue(workInPair.matches(""));
        assertTrue(workInPair.matches("s"));
        assertTrue(workInPair.matches("(dsf sdfs)"));
        assertTrue(workInPair.matches("[sdfsdf]"));
        assertTrue(workInPair.matches("{}"));
        assertTrue(workInPair.matches("{(a + d) +c}"));
        assertTrue(workInPair.matches("{()[]()}"));
        assertTrue(workInPair.matches("{()[{}]()}"));
        assertTrue(workInPair.matches("{([])}"));
        assertTrue(workInPair.matches("{([([])])}"));
        assertTrue(workInPair.matches("[([([])])]"));
        assertFalse(workInPair.matches("[(]"));
        assertFalse(workInPair.matches("[(}]"));
        assertFalse(workInPair.matches("[)"));
        assertFalse(workInPair.matches("[)]"));
        assertFalse(workInPair.matches("}{"));
        assertFalse(workInPair.matches(")("));
        assertFalse(workInPair.matches("]["));
        assertFalse(workInPair.matches("["));

    }

}