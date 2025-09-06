import java.util.Scanner;

public class palindrome {

    public static boolean checkPalindrome(int number){
        int reverse =0, LD;
        int og = number;
        while(number>0){
            LD = number%10;
            reverse = (reverse*10) + LD;
            number /= 10;
        }

        if(og == reverse){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number to check if it is palindrome or not: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(checkPalindrome(number));
        sc.close();
    }
}
