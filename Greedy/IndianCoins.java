import java.util.*;

public class IndianCoins {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        // Integer[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        // Arrays.sort(coins, Comparator.reverseOrder()); // The comparator needs array
        // in Integer class to sort it.

        int coinCount = 0;
        int amount = 45267;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    amount -= coins[i];
                    coinCount++;
                    ans.add(coins[i]);
                }
            }
        }

        System.out.println("The Total Number of Coins Required are " + coinCount);
        System.out.print("The coins used are : ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
