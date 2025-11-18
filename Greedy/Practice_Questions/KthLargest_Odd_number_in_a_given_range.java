import java.util.*;

public class KthLargest_Odd_number_in_a_given_range {
    public static void main(String[] args) {
        int L = -3, R = 3, K = 1;

        int oddNumCount = 1;
        int ans = 0;

        while (R > L) {
            if (R % 2 != 0 && oddNumCount == K) {
                ans = R;
                break;
            }
            R--;
        }

        System.out.println("The Kth Largest Odd Number in a given Range is : " + ans);
    }
}
