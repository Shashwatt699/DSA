package DP;

// To find a nth number in fibonnaci series 
public class fibonacci {
    public static int fib_Memoization(int n, int[] f) { // Here Tc- O(n) instead of O(2^n) in recursion
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) { // It already has a value and is been calculated before
            return f[n];
        }
        f[n] = fib_Memoization(n - 1, f) + fib_Memoization(n - 2, f);
        return f[n];
    }

    public static int fib_Tabulation(int n){ // O(n)
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n]; // Ans
    }

    public static void main(String[] args) {
        int n = 6;
        int[] f = new int[n + 1];
        //System.out.println(fib_Memoization(n, f));
        System.out.println(fib_Tabulation(n));
    }
}
