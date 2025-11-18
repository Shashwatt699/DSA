import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        // End time basis Sorted
        int maxAct = 0; // Stores number of activities to include
        ArrayList<Integer> ans = new ArrayList<>(); // For storing the activity's Index

        ans.add(0);// Put 1st activity's index directly in Arraylist
        maxAct = 1;// and add to maxAct
        int lastEnd = end[0]; // This is for checking out the rest of the activities in the array

        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("The Maximum number of activies which can be performed by a single person are " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}
