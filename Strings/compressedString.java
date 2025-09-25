

public class compressedString {

    static StringBuilder compress(String str){
        //String newStr = "";
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            //newStr += str.charAt(i);
            sb.append(str.charAt(i));
            if(count > 1){
                sb.append(count.toString()); //Converting Integer object into String and then adding it to the newStr
            }
        }
        return sb;
    }
    public static void main(String[] args) {
        String str = "aaabbcccdd";
        System.out.println(compress(str));
    }
}
