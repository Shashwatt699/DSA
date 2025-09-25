package LinkedLists;

public class DoubleLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // remove Last
    public int removeFirst() {

        if (size == 0) {
            System.out.println("The DLL is Empty Sir");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // add Last Homework
    public int addLast(int data) {
        int val = data;
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = null;
        return val;
    }

    // remove Last Homework
    public int removeLast() {
        int i = 0;
        Node temp = head;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;

        temp.next = null;
        return val;
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(4);
        dll.addFirst(5);
        dll.addFirst(23);
        dll.print();
        System.out.print("The Size is " + dll.size + " and ");
        System.out.println("The removed value is " + dll.removeFirst());
        dll.print();
        System.out.println("The added data is " + (dll.addLast(5)));
        dll.print();
        System.out.println("The data removed is " + (dll.removeLast()));
        dll.print();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        dll.reverse();
        dll.print();
    }
}
