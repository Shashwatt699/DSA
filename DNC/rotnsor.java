package DNC;

public class rotnsor {
    public static int search(int arr[], int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;

        // Case Found
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on Line 1
        if (arr[si] <= arr[mid]) {
            // Case A : left
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            }
            // Case B : Right
            else {
                return search(arr, tar, mid + 1, ei);
            }
        }

        // mid on Line 2
        else {
            // Case C
            if (tar >= arr[mid] && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                // Case D
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6; // op -> 4
        System.out.println(search(arr, target, 0, arr.length - 1));
    }
}
