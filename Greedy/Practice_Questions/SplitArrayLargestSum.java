import java.util.*;

public class SplitArrayLargestSum {

    // public API: returns minimum possible largest subarray sum when splitting into k parts
    public static long splitArray(int[] nums, int k) {
        long low = 0;     // at least the max element
        long high = 0;    // at most the sum of all elements

        for (int x : nums) {
            low = Math.max(low, x);
            high += x;
        }

        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                ans = mid;         // mid is feasible, try smaller
                high = mid - 1;
            } else {
                low = mid + 1;     // mid too small, increase
            }
        }
        return ans;
    }

    // Greedy check: can we split nums into <= k subarrays such that each subarray sum <= maxAllowed?
    private static boolean canSplit(int[] nums, int k, long maxAllowed) {
        int parts = 1;
        long currentSum = 0;

        for (int x : nums) {
            if (currentSum + x <= maxAllowed) {
                currentSum += x;
            } else {
                // start a new part
                parts++;
                currentSum = x;
                if (parts > k) return false;
            }
        }
        return true;
    }

    // quick test
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2};
        int k1 = 2;
        System.out.println(splitArray(arr1, k1)); // expected 2

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 3;
        System.out.println(splitArray(arr2, k2)); // expected 4

        // additional example
        int[] arr3 = {7,2,5,10,8};
        int k3 = 2;
        System.out.println(splitArray(arr3, k3)); // expected 18 (classic example)
    }
}
