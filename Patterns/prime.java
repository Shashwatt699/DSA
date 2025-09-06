import java.util.Scanner;

public class prime {

    public static boolean checkPrime(int n){
        for(int i=2 ; i<n-1; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number to check if its prime or not: ");
        int n = sc.nextInt();
        System.out.println(checkPrime(n));
        sc.close();
    }
}
