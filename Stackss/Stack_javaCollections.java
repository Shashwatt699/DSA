package Stackss;

import java.util.*;

public class Stack_javaCollections {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(32222);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
