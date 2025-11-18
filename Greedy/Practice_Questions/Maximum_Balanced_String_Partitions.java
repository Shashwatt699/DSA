import java.util.*;

public class Maximum_Balanced_String_Partitions {
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";

        char[] chars = str.toCharArray();
        int count = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'L' && chars[i + 1] == 'R') {
                count++;
            }
        }

        System.out.println("The Maximum Balanced String Partitions are : " + count);
    }
}
