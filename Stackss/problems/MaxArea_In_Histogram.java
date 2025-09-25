import java.util.*;

public class MaxArea_In_Histogram {

    public static void maxArea(int arr[]) {
        int maximumArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        // For Next Smaller Right
        Stack<Integer> s = new Stack<>();
        // We start from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // For Next Smaller Left
        s = new Stack<>();
        // We start from left to right
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Lets Calculate Area
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maximumArea = Math.max(currArea, maximumArea);
        }

        System.out.println(maximumArea);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 }; // heights of histogram
        maxArea(arr);
    }
}
