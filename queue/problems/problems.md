Queue using 2 Stacks
### Approach (Queue using 2 Stacks)

- Use **2 stacks (s1, s2)** to simulate a queue.  
- **isEmpty()** → just check if `s1` is empty.  
- **add(x):**  
  - Move all elements from `s1 → s2`  
  - Push new element into `s1`  
  - Move all elements back from `s2 → s1`  
  - Makes `add()` costly → O(N)  
- **remove():**  
  - If empty → return -1  
  - Else directly pop from `s1` (front of queue is always on top of `s1`) → O(1)  
- **peek():**  
  - Similar to `remove()` but return `s1.peek()` instead → O(1)  

### Complexity
- Enqueue (add) → O(N)  
- Dequeue (remove) → O(1)  
- Peek → O(1)  
- This is the **costly enqueue approach** of implementing queue using two stacks.  

-------------------------------------------------------------------------------------------

First_NonRepeatingChar_inAStreamOfCharacters

The primary goal is to process a stream (string) one character at a time and at each step, print the first character that has not repeated so far, or -1 if all characters have repeated.

### Step-by-Step Concept

- A frequency array (`freq[]`) of size 26 keeps track of how many times each lowercase letter appears. 
- A queue (`q`) stores the order in which characters arrive in the stream.
- For each character in the stream:
    - Increment its frequency.
    - Add it to the queue.
    - While the character at the front of the queue is repeating (i.e., its frequency is more than 1), remove it from the queue.
    - If the queue is empty after removals, print -1. Otherwise, print the front of the queue, which is the current non-repeating character.

### Example Execution

Suppose the input is `"aabccxb"`:

- 'a' arrives: 'a' is not repeating, print 'a'.
- 'a': Now 'a' has frequency 2; remove from queue, print -1.
- 'b': 'b' is unique so far, print 'b'.
- 'c': 'b' is still unique, print 'b'.
- 'c': 'c' now repeats, queue front is 'b', still non-repeating, print 'b'.
- 'x': 'b' still non-repeating, print 'b'.
- 'b' repeats, remove 'b' from queue, next non-repeating 'x', print 'x'.

### Why a Queue is Useful

- The queue maintains order.
- After each character, the front of the queue is checked to find the first non-repeating character quickly by popping out repeating elements.

### Efficiency

- Every character is processed once; removals from the queue only happen when the frequency is more than 1.
- Operations are efficient, making this approach suitable for streaming scenarios and interview questions.

--------------------------------------------------------------------------------------------------------------

Concept Explanation: Interleaving Two Halves of a Queue

**Goal:**
Given a queue of even length, rearrange its elements so that the first half and the second half are interleaved. That means, after interleaving, the queue alternates between elements from the first half and the second half.

#### Step-by-Step Logic
1. **Split the Queue:**
   - Move the first half of the queue into a separate queue (`first`). The remaining elements in the original queue (`q`) are the second half.
2. **Interleave:**
   - Alternately take one element from `first` (first half) and one from `q` (second half), and add them back to `q`.
   - This is done by removing from `first` and then from `q`, and adding both back to `q` in that order.

#### Example Walkthrough
Suppose the queue is:

    [1, 2, 3, 4, 5, 6, 7,9]

- After splitting, `first` = [1,2,3,4,5] ,  `q` = [6,7,8,9,5]
- Interleaving steps:
    - Add 1 (from `first`), then 6 (from `q`)
    - Add 2 (from `first`), then 7 (from `q`)
    - ... and so on
- Final queue: [1, 6, 2, 7, 3, 8, 4, 9,2]

#### Why This Works
- By splitting and then alternating, you ensure the original order is preserved within each half, but the two halves are woven together.
- The queue data structure is ideal here because it maintains order and allows efficient removal from the front and addition to the back.

#### Efficiency
- Each element is moved a constant number of times, so the time complexity is O(n), where n is the number of elements in the queue.
- Only a small amount of extra space is needed for the auxiliary queue.

#### Summary
- **Split** the queue into two halves.
- **Alternate** elements from each half to interleave.
- This is a classic queue manipulation problem, often asked in interviews to test understanding of queues and order maintenance.

--------------------------------------------------------------------------------------------------------------

### Concept Explanation: Reversing a Queue Using a Stack

**Goal:**
Reverse the order of elements in a queue so that the front becomes the rear and vice versa.

#### Step-by-Step Logic
1. **Transfer to Stack:**
   - Remove each element from the queue and push it onto a stack. This uses the stack's Last-In-First-Out (LIFO) property, so the last element removed from the queue will be on top of the stack.
2. **Transfer Back to Queue:**
   - Pop each element from the stack and add it back to the queue. Now, the order is reversed because the last element pushed onto the stack (which was the front of the queue) is now the first to be added back.

#### Example Walkthrough
Suppose the queue is:

    1 2 3 4 5 (front to rear)

- After moving to the stack: stack = [1, 2, 3, 4, 5]  (bottom to top)[1][2][3][4][5]
- After popping from the stack and adding back to the queue: queue = 5 4 3 2 1 (front to rear)

#### Why This Works
- A queue is **FIFO** (First-In-First-Out), while a stack is **LIFO** (Last-In-First-Out).
- By pushing all queue elements onto a stack, you reverse their order. Adding them back to the queue preserves this reversed order.[6][1]

#### Efficiency
- **Time Complexity:** $$O(n)$$, where $$n$$ is the number of elements, since each element is moved twice (once to the stack, once back to the queue).
- **Space Complexity:** $$O(n)$$ for the stack.

#### Summary
- **Push** all queue elements onto a stack.
- **Pop** from the stack and add back to the queue.
- The queue is now reversed.

This is a classic queue and stack interview problem, and the stack's LIFO property is the key to reversing the order efficiently.

--------------------------------------------------------------------------------------------------------------

#### Generating Binary Numbers Using a Queue

**Problem:**
Generate all binary numbers from 1 to $$N$$ (as strings), in order.

**Approach:**
- Use a queue to build binary numbers in sequence.
- Start by adding "1" to the queue.
- For each step (repeat $$N$$ times):
  1. Remove the front string from the queue and print it.
  2. Add two new strings to the queue: the current string + "0" and the current string + "1".
- This process mimics a level-order (BFS) traversal of a binary tree, ensuring numbers are generated in order.

**Example (N = 5):**
- Output: `1 10 11 100 101`

**Why it works:**
- Each number is generated by appending '0' and '1' to previous numbers, so the queue always holds the next numbers in order.
- The method is efficient: **Time Complexity:** $$O(N)$$, **Space Complexity:** $$O(N)$$.

**Key Points to Remember:**
- Queue is used to maintain the order of generation.
- For each number, generate its next two binary children.
- Stop after printing $$N$$ numbers.

**Pseudocode:**
```java
Queue<String> q = new LinkedList<>();
q.add("1");
while (n-- > 0) {
    String s = q.remove();
    print(s);
    q.add(s + "0");
    q.add(s + "1");
}
```

**Tip:**
- This is a classic use of queues for sequence generation, especially when the next state depends on the current state in a tree-like fashion.

-----------------------------------------------------------------------------------------------------------------
JOB SEQUENCING PROBLEM

### Problem statement
Given N jobs, each with an ID, a deadline, and a profit, schedule jobs on a single machine so that total profit is maximized, assuming each job takes exactly one unit of time and only one job can run at any time. A job can be done at any integer time slot t such that 1 ≤ t ≤ its deadline. The objective is to select a subset and an order of jobs that maximizes the sum of profits.

### Key assumptions
- Each job requires unit processing time and runs non-preemptively.  
- Deadlines are positive integers and denote the latest permissible time slot.  
- Only one machine is available, so at most one job can be scheduled per time slot.

### Greedy insight
Maximizing total profit is achieved by giving priority to higher-profit jobs while placing them as late as possible within their deadlines to keep earlier slots free for other jobs. This leads to classic greedy strategies that are both optimal for the unit-time single-machine setting.

### Approach A: Sort by profit, place late
- Sort jobs by profit in descending order.  
- Maintain a schedule array of size equal to the maximum deadline (all slots initially empty).  
- For each job in sorted order, place it at the latest free slot ≤ its deadline; if none exists, skip it.  
- Time complexity: sorting $$ O(n \log n) $$ plus at most $$ O(n \cdot D) $$ to scan backwards per job; with Disjoint Set Union (DSU) to find the latest free slot, it becomes $$ O(n \log n) $$.

### Approach B: Deadline-sweep with max-heap
- Sort jobs by deadline in ascending order.  
- Sweep from the largest deadline to the smallest; at index i, compute how many slots are available between deadline[i] and deadline[i-1] (or 1 and deadline).  
- Push jobs into a max-heap keyed by profit as they enter the sweep boundary; pop the best jobs to fill the newly available slots.  
- Time complexity: sorting $$ O(n \log n) $$ and heap operations $$ O(n \log n) $$.

### When to prefer each
- Approach A is straightforward and pairs nicely with either a boolean slot array or DSU for near-optimal performance.  
- Approach B is ideal when reasoning in “deadline windows,” and it naturally handles many ties in deadlines via a single max-heap.

### Pseudocode (Approach A: profit-first)

jobs = [(id, deadline, profit)]  // input
sort jobs by profit descending
M = max(deadline over jobs)
slots = array of length M filled with empty
pick = empty list
for job in jobs:
  for t from min(M, job.deadline) down to 1:
    if slots[t] is empty:
      slots[t] = job
      pick.add(job)
      break
return pick and sum(profit in pick)


### Pseudocode (Approach B: heap + windows)
jobs = [(id, deadline, profit)]
sort jobs by deadline ascending
maxHeap = empty max-heap by profit
result = empty list
for i from n-1 down to 0:
  if i == 0:
    slots = jobs[i].deadline
  else:
    slots = jobs[i].deadline - jobs[i-1].deadline
  push jobs[i] into maxHeap
  while slots > 0 and maxHeap not empty:
    best = pop maxHeap
    result.add(best)
    slots -= 1
// result holds the selected jobs (optionally sort by time for printing)
```

### Example walkthrough
Jobs: (a, d=2, p=100), (b, d=1, p=19), (c, d=2, p=27), (d, d=1, p=25), (e, d=3, p=15).  
- Approach A: sort by profit → a(100), c(27), d(25), b(19), e(15).  
- Place a at slot 2; place c at slot 1; d cannot fit (slot 1 taken); b cannot fit (slot 1 taken); place e at slot 3.  
- Final schedule by time: [c, a, e] with total profit $$ 27 + 100 + 15 = 142 $$.

### Complexity
- Approach A: $$ O(n \log n) $$ with DSU; naive slot scanning is $$ O(n \cdot D) $$ after sorting.  
- Approach B: $$ O(n \log n) $$ due to sorting and heap operations.

### Common pitfalls
- Treating deadlines as 0-indexed; the standard formulation is 1-indexed time slots.  
- Using integer subtraction in comparators for ordering profits can overflow; prefer Comparator.comparingInt and reversed.  
- Using queue remove() instead of poll(); remove() throws on empty, poll() returns null.  
- Forgetting that “as late as possible” placement is crucial to keep earlier slots available for other jobs.

