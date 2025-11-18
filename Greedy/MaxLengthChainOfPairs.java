import java.util.*;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) { // O(nlogn)
        int[][] pairs = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1])); // Sort according to 2nd element of the pair

        int totalPairs = 1; // Including the 1st pair  
        int lastpairElement = pairs[0][1]; // Taking 2nd element for comparing to 1st element of next

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastpairElement) {
                totalPairs++;
                lastpairElement = pairs[i][1];
            }
        }

        System.out.println("The maximum length chain of pairs is " + totalPairs);

    }
}
