package Arrays;

public class Max_Subarray_KadanesAlgo {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0], globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            globalMax = Math.max(globalMax, max);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 4, 5, 3, -10, 3, 2 };
        System.out.println(maxSubArray(arr));
    }
}
