import java.util.*;

public class Rough {
    public static void main(String[] args) {
        int[] start = { 0, 1, 3, 5, 5, 8 };
        int[] end = { 6, 2, 4, 7, 9, 9 };
        // Here EndTime is Not Sorted
        // So we Sort it in a 2-d Array
        int[][] activities = new int[start.length][3];

        // Lets fill this activities 2d array
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i; // Col 1 is for storing Index of the activity
            activities[i][1] = start[i];// Col 2 is for storing Starting Time of the activity
            activities[i][2] = end[i]; // Col 3 is for storing Ending Time of the activity
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // Sorting it using Comparator

        int maxAct = 0; // For tracking number of activities
        List<Integer> ans = new ArrayList<>(); // To keep the indexes of Activities added

        maxAct = 1; // Always Include 1st activity.
        ans.add(activities[0][0]); // Adding obvious Index 0 to the List.

        int lastEndTime = activities[0][2];

        for (int i = 0; i < end.length; i++) {
            if (activities[i][1] >= lastEndTime) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }

        System.out.println("The Maximum number of activies which can be performed by a single person are " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();

    }
}
