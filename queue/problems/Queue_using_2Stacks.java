package problems;

import java.util.Stack;

public class Queue_using_2Stacks {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // Is the queue empty
        public static boolean isEmpty() { // O(1)
            return s1.isEmpty();
        }

        // Add a element in the Queue
        public static void add(int data) { // O(N)
            // 4 Steps
            // check if s1 is empty if not then push s1 elements to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            // then when s1 is empty push the data in the s1
            s1.push(data);
            // return back the elements of s1 from s2
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove a element from the queue
        public static int remove() { // O(1)
            if (s1.empty()) {
                System.out.println("Queue is already Empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() { // O(1)
            if (s1.empty()) {
                System.out.println("Queue is already Empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
