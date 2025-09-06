package Strings;

public class palindrome {
    
    static boolean checkPalindrome(String str){
        for(int i=0 ; i<str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "shashwat";
        System.out.println(checkPalindrome(str));
    }
}
