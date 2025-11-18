import java.util.*;

public class DequeImplementation {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(45);
        System.out.println(deque);
    }
}