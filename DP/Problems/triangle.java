package DP.Problems;

import java.util.List;

public class triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        // This is a Bottom Up Approach
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {

                int below = triangle.get(i + 1).get(j);
                int belowRight = triangle.get(i + 1).get(j + 1);

                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(below, belowRight));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String args[]){
        
    }
}
