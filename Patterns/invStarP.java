import java.util.Scanner;

public class invStarP {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter no. of rows you want : ");
        int n = sc.nextInt();

        for(int line=1 ; line<=n; line++){
            for(int star=n ; star>=line; star--){
                System.out.print("*");
            }
        System.out.println();
        }
        sc.close();
    }
}
