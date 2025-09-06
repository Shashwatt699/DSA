package ArrayLists;

import java.util.ArrayList;

public class PairSum {

    public static boolean findPairSum1(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size() - 1;

        while (lp != rp) {
            // Case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // Case 2
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            }

            // Case 3
            if (list.get(lp) + list.get(rp) > target) {
                rp--;
            }
        }
        return false;
    }

    public static boolean findPairSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        int lp = bp + 1;
        int rp = bp;

        while (lp != rp) {
            // Case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // Case 2
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % list.size(); // Approach exclusive
            }

            // Case 3
            if (list.get(lp) + list.get(rp) > target) {
                rp = (list.size() + rp - 1) % list.size(); // Approach exclusive
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 19;
        // System.out.println(findPairSum1(list, target));
        System.out.println(findPairSum2(list, target));

    }
}