import java.util.*;
public class QueueUsingDeque {
    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5); // 2 3 4 5
        System.out.println("Front in queue is " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
