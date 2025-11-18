import java.util.*;

public class Lexicographically_smallest_string_of_length_N_and_sum_K {
    public static String smallestString(int N, int K) {
        char[] result = new char[N];

        for (int i = 0; i < N; i++) {

            for (char ch = 'a'; ch <= 'z'; ch++) {
                int value = ch - 'a' + 1;
                int remaining = K - value;
                int remainingPosition = N - i - 1;

                if (remaining >= remainingPosition * 1 && remaining <= remainingPosition * 26) {
                    result[i] = ch;
                    K -= value;
                    break;
                }
            }

        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(smallestString(5, 42));
        System.out.println(smallestString(3, 25));

    }
}
