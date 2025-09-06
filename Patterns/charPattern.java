import java.util.Scanner;

public class charPattern {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pyramid length: ");
        int n = sc.nextInt();

        for(int line = 1; line <= n; line++){
            for(char ch = 'A'; ch < 'A' + line; ch++){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}