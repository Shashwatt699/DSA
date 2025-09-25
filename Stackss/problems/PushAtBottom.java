import java.util.*;

public class PushAtBottom {

    public static void pushAtTheBottom(Stack<Integer> s, int data){
        //Base Case
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtTheBottom(s, data);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtTheBottom(s, 4);
        while(s.size() != 0){
            System.out.println(s.pop());
        }
    }
}
