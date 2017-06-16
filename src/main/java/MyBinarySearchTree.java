import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 1 on 09.06.2017.
 */
public class MyBinarySearchTree<E extends Comparable<E>> {
    public Node top;
    int size;

    public MyBinarySearchTree() {
        top = null;
    }


    class Node {
        E data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void add(E data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            size++;
            return;
        }
        Node curr = top;
        while (true) {
            if (data.compareTo(top.data) < 0) {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    size++;
                    curr.left = newNode;
                    return;
                }
            } else if (data.compareTo(top.data) > 0) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = newNode;
                    size++;
                    return;
                }
            } else {
                System.out.println("Такой уже есть)");
                return;
            }
        }
    }

    public boolean depthFirstSearch(E element) {
        if (top == null)
            return false;
        Node curr = top;
        while (true) {
            if (element.compareTo(curr.data) < 0) {
                if (curr.left != null) {
                    curr = curr.left;
                } else return false;
            } else if (element.compareTo(curr.data) > 0) {
                if (curr.right != null) {
                    curr = curr.right;
                } else return false;
            } else return true;
        }
    }

    public boolean breadthFirstSearch(E element) {
        if (top == null)
            return false;
        Node curr = top;
        Queue<Node> queue = new LinkedList<>();
        queue.add(top);
        while (!queue.isEmpty()) {
            if (element.compareTo(curr.data) != 0) {
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                curr = queue.poll();
            } else return true;

        }
        return false;
    }

    public List<E> breadthTraversal() {
        List<E> result = new ArrayList<>();
        if (top == null)
            return result;
        Node curr = top;
        Queue<Node> queue = new LinkedList<>();
        queue.add(top);
        while (!queue.isEmpty()) {
            curr = queue.remove();
            result.add(curr.data);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }

        }
        return result;
    }
}
