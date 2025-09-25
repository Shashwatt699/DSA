

import java.util.ArrayList;

public class Design_a_Stack_With_Increment_Operation {
    private ArrayList<Integer> list;
    private int maxSize;

    public Design_a_Stack_With_Increment_Operation(int maxSize) {
        list = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (list.size() < maxSize) {
            list.add(x);
        }
    }

    public int pop() {
        if (list.size() == 0) {
            return -1;
        }
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, list.size()); i++) {
            list.set(i, list.get(i) + val);
        }
    }
}
