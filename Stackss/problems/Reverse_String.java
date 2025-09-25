

import java.util.*;

public class Reverse_String {

    public static StringBuilder reverseString(String str) {
        // Make a Stack and add the string's characters in the stack
        Stack<Character> s = new Stack<>();
        int idx=0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        // Now they are in stack and In order to reverse them we make another string and start putting them in the string
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "sher";
        StringBuilder result = reverseString(str);
        System.out.println(result);
    }
}
