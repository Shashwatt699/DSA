import java.util.*;

public class MinAbsoluteDifferencePairs {
    public static void main(String[] args) { // O(nlogn)
        int[] A = { 1, 4, 7, 8 };
        int[] B = { 2, 3, 5, 6 };

        Arrays.sort(A);
        Arrays.sort(B);

        int Answer = 0;
        for (int i = 0; i < A.length; i++) {
            Answer += Math.abs(A[i] - B[i]);
        }

        System.out.println("The Minimum absolute difference of Pairs "+ Answer); // 6
    }
}
