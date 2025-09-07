package LinkedLists;

public class LinkedList {

    // Initialize the Node class for the Linked List
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // Step 1 - Create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Step 2 - newnode's next = head
        newNode.next = head; // This step links the new node to the linked list

        // Step 3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        // Step 1 - create a newNode
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2- connect next of tail to newNode
        tail.next = newNode;

        // Step 3 - tail = newNode
        tail = newNode;
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data); // To handle changing data of head Also
            return;
        }
        int i = 0;
        Node newNode = new Node(data);
        size++;
        Node temp = head;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i = idx -1 ; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev : i = size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // Tail Data
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;

    }

    public int helperFunc(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helperFunc(head.next, key);

        if (idx == -1) { // Key Not Found
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key) {
        return helperFunc(head, key);
    }

    public void reverse() { // O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthNodeFromEnd(int n) {
        // finding size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // Case
        if (sz == n) {
            head = head.next;
            return;
        }

        int idx = 1;
        int idxToFind = sz - n;
        Node prev = head;
        while (idx < idxToFind) {
            prev = prev.next;
            idx++;
        }

        prev.next = prev.next.next;
        return;
    }

    public Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // Slow is the middle
    }

    public boolean checkPalindrome() {
        // Step 1 - Find midNode
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = findMidNode(head);

        // Step 2 - Reverse Second Half
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // Step 3 - Check if first and second halves are equal
        while (right != null) {
            if(left.data != right.data){
                return false;
            }

            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;
        while(fast != slow){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

        // put prev's next to null to remove the cycle
        prev.next = null;
    } 

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        LinkedList pl = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.add(2, 9);
        ll.addLast(8);
        ll.addLast(12);
        ll.removeFirst();
        ll.removeLast();
        ll.addFirst(0);
        ll.add(3, 4);
        ll.print();
        System.out.println(size);
        System.out.println(ll.itrSearch(9));
        System.out.println(ll.recSearch(8));
        ll.reverse();
        ll.print();
        ll.deleteNthNodeFromEnd(4);
        ll.print();

        pl.addFirst(1);
        pl.addLast(2);
        pl.addLast(2);
        pl.addLast(1);
        pl.addFirst(1);
        pl.addLast(2);
        pl.addLast(3);
        pl.addLast(1);
        pl.isCycle();
        pl.print();
        System.out.println(pl.checkPalindrome());
    }

}
