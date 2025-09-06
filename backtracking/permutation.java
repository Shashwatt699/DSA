package backtracking;

public class permutation {

    public static void findPermutaion(String str, String ans) {
        // Base Case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        // Recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // abcde => "ab"+ "de" = "abde" // to Remove a character
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutaion(newStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutaion(str, "");
    }
}
