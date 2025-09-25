import java.util.*;

public class next_Greater_Element { // WE FIND NEXT GREATER IN THE RIGHT SIDE OF THE PARTICULAR ELEMENT

    public static void main(String[] args) {
        int arr[] = { 5, 7, 2, 1, 8 };
        int greaterElements[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                greaterElements[i] = -1;
            } else {
                greaterElements[i] = arr[s.peek()];
            }

            s.push(i);
        }

        // print the greaterElements array
        for (int i = 0; i < greaterElements.length; i++) {
            System.out.print(greaterElements[i] + " ");
        }
    }
}

// This Method gives time complexity of O(n) which is optimized as compared to
// brute force approach of nested Loops
