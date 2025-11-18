import java.util.*;

public class StackUsingDeque {
    static class Stack{
        Deque<Integer> deque = new LinkedList<>();
        
        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(22);
        s.push(25);
        s.push(355);
        System.out.println("The topa is  "+s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
