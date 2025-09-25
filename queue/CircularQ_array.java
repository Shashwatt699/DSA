public class CircularQ_array {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front; // Track this time for Changes

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // isEmpty Operation
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front; // If next of rear is front then queue is full
        }

        // Add Operation Used 0(1) here instead of O(n)
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            // When adding 1st Element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
           
        }

        // Remove Operation
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is already Empty");
                return -1;
            }
            int result = arr[front];

            // last element delete
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
            
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("The Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
