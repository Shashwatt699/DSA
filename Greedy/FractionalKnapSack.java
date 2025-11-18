import java.util.*;

public class FractionalKnapSack {
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;

        double ratio[][] = new double[val.length][2]; // 2-d array to store index and ratios of all items

        // Start filling the 2d Array
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i; // 0th Column for Storing Index
            ratio[i][1] = val[i] / (double) weight[i]; // 1st Column for Storing Ratio
        }

        // Sorting the 2-D Ratio Array in ascending array on the basis of Ratio stored in Col-1
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalValue = 0;
        for (int i = ratio.length - 1; i >= 0; i--) { // bcoz array is in ascending we start from last instead of making it descending
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) { // Include The Full Item
                finalValue += val[idx];
                capacity -= weight[idx];
            } else { // Include Fractional Item
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("The Final Value is "+ finalValue);
    }
}
