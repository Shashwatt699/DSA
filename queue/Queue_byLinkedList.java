public class Queue_byLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;
        static int size = 0;

        // Check If queue is empty
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Add in queue
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
            size++;
        }

        // Remove from queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is already Empty");
                return -1;
            }

            int front = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
            return front;
        }

        // Peek at first Element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is  Empty");
                return -1;
            }else{
                return head.data;
            }
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
