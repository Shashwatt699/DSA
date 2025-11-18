package problems;

import java.util.*;

public class InterLeave_2Halves_ofAQueue {

    public static void interleave(Queue<Integer> q) {
        Queue<Integer> first = new LinkedList<>();
        int size = q.size();

        for (int i = 0; i < size / 2; i++) { // Transfer half the elements of first half of queue q to queue first
            first.add(q.remove());
        }

        while (!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
        }

    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interleave(q);

        // print Queue
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
