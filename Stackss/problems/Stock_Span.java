
import java.util.Stack;

public class Stock_Span {

    public static void StockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1; // 1 day gap for the first day base case
        s.push(0); // index of first element

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && stocks[s.peek()] < currPrice) { // if curr price is more than the price in the top element index of stack then pop the top
                s.pop();
            }
            if (s.isEmpty()) { // Means there is no one else bigger than it
                span[i] = i + 1;
            } else {    // Just substract the current i from the index of previous highest value and put in span[i]
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        StockSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i]);
        }
    }
}
