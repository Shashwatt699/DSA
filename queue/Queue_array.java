class Queue_array {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // isEmpty Operation
        public static boolean isEmpty() {
            return rear == -1;
        }

        // Add Operation
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is Full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
            size++;
        }

        // Remove Operation
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is already Empty");
                return -1;
            }
            int front = arr[0];
            // Making each element acquire the space behind it in array
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            size--;
            return front;
        }

        public static int peek() {
            if(isEmpty()){
                System.out.println("The Queue is Empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}