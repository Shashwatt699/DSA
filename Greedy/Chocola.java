import java.util.*;

public class Chocola {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer[] costVer = { 2, 1, 3, 1, 4 }; // m-1
        Integer[] costHor = { 4, 1, 2 }; // n-1

        Arrays.sort(costVer, Collections.reverseOrder());// Descending Order
        Arrays.sort(costHor, Collections.reverseOrder());// Descending Order

        // Collections.sort(costVer, (obj1, obj2) -> obj2 - obj1 ); -> Only for Lists not Arrays.

        int h = 0, v = 0; // Pointers to track index on both arrays.
        int hp = 1, vp = 1; // To track both Vertical and Horizontal Cuts.
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) { // Horizontal Cut is Expensive so make it first
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else { // Vertical Cut is Expensive so make it first
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) { // Left Out Horizontal Cuts
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) { // Left Out Vertical Cuts
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("The Minimum Cost is : " + cost);

    }
}
