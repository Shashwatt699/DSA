import java.util.*;

public class rough {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += Character.getNumericValue(input.charAt(i)) ;
        }

        // replicate fibonacci series
        int a = 0;
        int b = 1;

        while (b < sum) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        if (b == sum) {
            System.out.println(input + sum);
        } else {
            System.out.println(input + b);
        }
    }
}