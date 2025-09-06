public class diagonal {

    static void printDiagonal(int matrix[][]) {

        // brute force
        int sum = 0;
        // for(int i=0; i<=matrix.length; i++){
        // for(int j=0; j<=matrix[0].length; j++){
        // //PD
        // if(i == j){
        // sum += matrix[i][j];
        // }
        // //SD
        // else if(i+j == matrix.length-1){
        // sum += matrix[i][j];
        // }
        // }
        // }

        // OPTIMIZED CODE O(n)
        for (int i = 0; i < matrix.length; i++) {
            // PD
            sum += matrix[i][i];

            // SD
            if (i != matrix.length - 1 - i)
                sum += matrix[i][matrix.length - 1 - i];
        }

        System.out.println(sum);

    }

    static boolean staicaseSearch(int matrix[][], int key) {
        // Starting from TOP Right //O(n+m)
        // int row = 0, col = matrix.length - 1;

        // while (row < matrix.length && col >= 0) {
        //     if (matrix[row][col] == key) {
        //         System.out.println("Found key at (" + row + "," + col + ")");
        //         return true;
        //     }

        //     else if (key > matrix[row][col]) {
        //         row++;
        //     } else if (key < matrix[row][col]) {
        //         col--;
        //     }
        // }
        // System.out.println("Key not found");
        // return false;

        
        
        //Starting from BOTTOM LEFT O(n+m)
        int row = matrix.length-1 , col = 0;

        while(row >= 0 && col < matrix[0].length ){
            //Found
            if(matrix[row][col] == key){
                System.out.println("Found key at (" + row + "," + col + ")");
                return true;
            }

            else if(key < matrix[row][col]){
                row--;
            }
            else if(key > matrix[row][col]){
                col++;
            }
        }
        System.out.println("Key not found beb!");
        return false;
    }

    public static void main(String args[]) {
        int matrix[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };

        // printDiagonal(matrix);
        System.out.println(staicaseSearch(matrix, 40));
    }
}
