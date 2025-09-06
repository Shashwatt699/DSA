import java.util.*;

public class hollowRectangle{

    static void makeHR(int rows, int cols){

        for(int i=1; i<=rows ; i++){
            for(int j=1 ; j<=cols; j++ ){
                if(i == rows || j == 1 || i == 1 || j == cols){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    } 
    
    public static void main(String args[]){
        System.out.println("Enter the number of rows : ");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns : ");
        int cols = sc.nextInt();
        sc.close();

        makeHR(rows, cols);
    }
}