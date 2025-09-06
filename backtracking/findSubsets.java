package backtracking;

public class findSubsets {

    static void findSubsetss(String str, String ans, int i) {
        // Base Case
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        // Yes Choice
        findSubsetss(str, ans + str.charAt(i), i + 1);
        // No Choice
        findSubsetss(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsetss(str, "", 0);
    }
}
