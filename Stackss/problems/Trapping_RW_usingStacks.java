import java.util.Stack;

public class Trapping_RW_usingStacks {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int trapped = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int width = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[bottom];
                trapped += width * h;
            }
            stack.push(i);
        }
        return trapped;
    }
    public static void main(String[] args) {
        

    }
}