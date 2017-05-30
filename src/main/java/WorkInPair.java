import java.util.*;

/**
 * Created by 1 on 25.05.2017.
 */
public class WorkInPair {

    Stack stack = new Stack();
    Map<Character, Character> map = new HashMap<Character, Character>();


    public boolean matches(String s) {

        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char b;
            if (map.containsValue(c)) {
                stack.push(c);
            }
            //System.out.println(c);
            if (map.containsKey(c)) {
                try {
                    b = (Character) stack.pop();
//                    System.out.println(b);
                    if (map.get(c) != b) return false;
                } catch (EmptyStackException ep) {
                }
            }
        }
        return stack.empty();
    }
}