import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_JCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q1 = new ArrayDeque<>();
        //Queue is a inteface and is initialized by a Class such as LinkedList and Array Deque
        q.add(1);                                                         
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
