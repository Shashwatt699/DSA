
public class InvRotPyramid{

    static void IRpyramid(int n){
        for(int i=1 ; i<=n; i++){
            //For Spaces
            for(int j=1; j<=n-i;  j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        IRpyramid(4);
    }
}