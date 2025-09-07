package LinkedLists;

import java.util.LinkedList;

public class JavaCollectionsFrameworks {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(2);
        ll.addLast(4);
        ll.addLast(6);
        System.out.println(ll);
        ll.remove();
        System.out.println(ll);
    }
}
