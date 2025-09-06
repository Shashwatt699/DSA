import java.util.*;

public class factoriyal {
    public static long factorial(long number){
        long f = 1;
        for(long i=1 ; i<=number ; i++){
            f = f * i;
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number you want Factorial of ");
        long n = sc.nextLong();
        System.out.println(factorial(n));
        sc.close();
    }
}
