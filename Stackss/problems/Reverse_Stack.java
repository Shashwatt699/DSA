

import java.util.Stack;

public class Reverse_Stack {

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int Value = s.pop();
        reverseStack(s);
        pushAtTheBottom(s, Value);
    }

    public static void pushAtTheBottom(Stack<Integer> s, int Value){
        if(s.isEmpty()){
            s.push(Value);
            return;
        }
        int top =  s.pop();
        pushAtTheBottom(s, Value);
        s.push(top);
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        
        reverseStack(s);
        printStack(s);
    }
}
