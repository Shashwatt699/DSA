Below is the documentation of Logic I understood and I will try my best to write my thoughts about it down.

1. Building a Node class,
   - Make a static class so you can access Node creation class from anywhere in the Code
   - Intialize int data and Node next pointer as per norms
   - Create a Constructor of same class name 'Node', pass data
   - allot data to the constructor's data and allot null value to next.

2. Building head, tail and size
    - These parameters are the backbone of a Linkedlist.
    - So we allot them as static to enable global access.
    - head and tail will be Node while size should be a integer.

3. Adding Element First in the LinkedList
    - Create a New-Node.
    - Make newNode's next point to head.
    - allot newNode as head (head = newNode).
  
4. Adding Last Element in the LinkedList
    - Create a New-Node.
    - connect next of tail to newNode (tail.next = newNode).
    - Allot newNode as tail (tail = newNode).

5. Adding Element at a index
    - Pass idx in the argument from the main func(ofc!).
    - Make int i and Node temp to reach the point before the req index.
    - run i till it is less than idx - 1, Make temp run to next alongside
    - Once reached at perfect index,.
    - make next of newnode point to temp's next(newNode.next = temp.next).
    - make temp of next point to newNode(temp.next = newNode).

6. Removing First Element from the LinkedList
    - just make head move to its next.(head = head.next)
    - here we lose the access of orig. head since no tracker is there on it.
    - So Java Garbage Collector removes it automatically.
    - head and tail are the nodes which keep the linked list in our reach.

7. Removing Last Element from the list
    - Make a Node named prev to reach the previous Node of tail
    - Run int i till it reaches size - 2
    - when reached, make prev.next point to null, This makes original Tail unreachable hence deleted
    - make prev the tail.

8. Iterative Searching for a key in Linked List
    -  Its easy, Just make int i and Node temp to run.
    -  run the loop until temp runs to null.
    -  when temp.data is found to be the key, return i as the index at that point.
    -  Until it is found, increse i and move temp to its next value.
    -  if not found return -1.

9. Recursive Searching for a key in Linked List
    - Basic Idea is to move head to next at each recusive call to the same function.
    - whenever head's data matches the key, return idx as 0;
    - Also most imp step is after recursive call, increase idx by 1;
    - So after each level the function automatically adds the value 1 to idx and return the index of the key. Imagine a CallStack for better understanding.

10. Reversing a LinkedList
    - Make 3 Nodes, prev, curr and next.
    - Understand that whenever we have to reverse a linked list there will be 3 Variables and 4 Steps.
    - Start a loop until curr reaches null
    - Step 1 is to make next as curr's next .(next = curr.next)
    - Step 2 is to reverse LL by making curr.next point to prev .(curr.next = prev)
    - Step 3 is to make prev Node point to the curr Node, To move forward.(prev = curr)
    - Step 4 is to make curr Node point to the next Node, To move Forward.(curr = next)
    - in the end make prev as head since curr will be at null acc to loop(head = prev).

11. Delete the Nth Node from the Last
    - Main formula is to find the prev node of the node to be deleted ie Nth from the last.
    - We can reach it by (int i=0 to (size - n)), So start a loop and reach there
    - make prev.next point to its next.next(prev.next = prev.next.next)
    - By doing above step we restrict the reach of Nth Node from last so it gets deleted automatically by JGC.
  
12. Find Middle Node of the Linked List - SLOW FAST Concept
    - Make 2 Nodes slow and fast
    - run slow 1 step and fast 2 step
    - Whenever fast reaches null(for even Nodes) or fast.next is null(for Odd), stop the loop.
    - wherever slow is, it is the Middle Node

13. Checking if Linked List is PalinDrome or Not
    - Find Middle Node
    - Reverse the second half of LL by same 3 variables 4 steps concept to reverse a LL.
    - Then start checking left and right side part by again running a loop until right reaches null
    - if it matches increament both left and right.

14. Detecting a Cycle in a Linked List — Floyd’s Cycle Detection (Tortoise and Hare Algorithm)
    - Objective:
        To check whether a linked list contains a cycle (loop), which means there is some node in the list that repeats by pointing back to a previous node instead of null.

    - Concept:
        Use two pointers:
        slow (tortoise): Moves one node at a time.
        fast (hare): Moves two nodes at a time.

    - Logic:
        Both pointers start from the head.
    In a loop, move slow by one (slow = slow.next) and fast by two (fast = fast.next.next).
    If at any point slow == fast, a cycle exists in the list.
    If fast reaches null or fast.next becomes null, the list ends and there’s no cycle.

    - Why it works:
    If there's a cycle, moving at different speeds guarantees that the two pointers will meet within the loop, just like two runners on a circular track will eventually coincide.

15. Removing a Cycle in a Linked List
- Objective:
    Remove the cycle and make the linked list linear—ending at null.

- Steps:
    Detect the Cycle:
    Repeat the cycle detection steps (slow/fast) until you find where slow meets fast inside the cycle (if any).

    Find the Entry Point (Start of Cycle):
    Reset slow to head, keep fast at the meeting point.
    Move both pointers one step at a time—keep track of the previous node to fast (prev).
    The point where slow meets fast is the start of the cycle.

    Remove the Cycle:
    Make prev.next = null. This breaks the cycle by cutting off the last node in the loop.

- Explanation:
    The math guarantees that after detection, moving both pointers at the same speed will bring them to the start node of the cycle.
    Cutting the prev.next removes the loop and restores the proper linked list.