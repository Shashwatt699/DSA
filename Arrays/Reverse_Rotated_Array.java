package Arrays;
import java.util.Arrays;

public class Reverse_Rotated_Array {
    public static void rotate(int[] nums, int k) {
        int p = k % nums.length - 1;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, p);
        reverseArray(nums, p + 1, nums.length - 1);
    }

    public static void reverseArray(int nums[], int si, int ei) {
        while (si < ei) {
            int temp = nums[ei];
            nums[ei] = nums[si];
            nums[si] = temp;
            si++;
            ei--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 1, 2, 3, 4 };
        int k = 3;
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
        
    }
}
