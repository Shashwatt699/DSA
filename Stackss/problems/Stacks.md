
# Stock Span Problem - Approach & Intuition

### Problem Understanding
The Stock Span problem asks: For each day's stock price, find how many consecutive days (including the current day) the stock price was less than or equal to the current day's price.

### Key Intuition
The key insight is that we need to find the **nearest greater element to the left** for each element. The span for day `i` is the number of days between the current day and the day where a greater price was found.

### **Approach Breakdown**

#### **1. Stack-Based Solution (Your Implementation)**
```java
// Time Complexity: O(n) - each element pushed and popped at most once
// Space Complexity: O(n) - for the stack
```

**Core Logic:**
1. **Stack stores indices** of prices (not the prices themselves)
2. **For each day i:**
   - Pop all indices from stack where `stocks[stack.peek()] < stocks[i]`
   - These are prices smaller than current price, so they can't be the "previous greater"
   - After popping, if stack is empty: span = i + 1 (all previous days had smaller prices)
   - If stack not empty: span = i - stack.peek() (distance to the nearest greater price)
   - Push current index to stack

#### **2. Why This Works**

**Example with `[100, 80, 60, 70, 60, 85, 100]`:**

| Day | Price | Stack State | Span Calculation                    | Span |
| --- | ----- | ----------- | ----------------------------------- | ---- |
| 0   | 100   | [0]         | First day                           | 1    |
| 1   | 80    | [0,1]       | 80 < 100, so span = 1-0 = 1         | 1    |
| 2   | 60    | [0,1,2]     | 60 < 80, so span = 2-1 = 1          | 1    |
| 3   | 70    | [0,1,3]     | Pop 2 (60<70), span = 3-1 = 2       | 2    |
| 4   | 60    | [0,1,3,4]   | 60 < 70, so span = 4-3 = 1          | 1    |
| 5   | 85    | [0,5]       | Pop 4,3,1 (all <85), span = 5-0 = 5 | 5    |
| 6   | 100   | [6]         | Pop 5,0 (all <100), span = 6+1 = 7  | 7    |

### **3. Alternative Approaches**

#### **Brute Force (O(n²)):**
```java
for (int i = 0; i < n; i++) {
    int span = 1;
    for (int j = i-1; j >= 0 && stocks[j] <= stocks[i]; j--) {
        span++;
    }
    result[i] = span;
}
```

#### **Using Previous Greater Element:**
```java
// Find previous greater element for each index
// Then calculate span as difference between indices
```

### **4. Why Stack is Optimal**

1. **Monotonic Stack Property:** We maintain a stack where elements are in decreasing order
2. **Efficient Removal:** We can quickly remove all smaller elements in one pass
3. **Immediate Access:** The top of stack always gives us the nearest greater element

### **5. Edge Cases to Consider**

- **First element:** Always has span = 1
- **All increasing prices:** Each span = index + 1
- **All decreasing prices:** Each span = 1
- **Equal prices:** Included in span (≤ condition)

### **6. Time & Space Analysis**

- **Time:** O(n) - Each element is pushed once and popped once
- **Space:** O(n) - Worst case when all elements are in decreasing order

### **7. Real-World Applications**

- **Financial Analysis:** Understanding stock price trends
- **Technical Analysis:** Identifying support/resistance levels
- **Data Stream Processing:** Finding patterns in streaming data



-----------------------------------------------------------------------------------------------------------------

MAXIMUM AREA IN HISTOGRAM


### Core Intuition
- For each bar at index i with height h, the largest rectangle that uses this bar as the limiting (shortest) height extends left until a bar strictly smaller than h, and right until a bar strictly smaller than h.
- So you need:
  - NSL[i]: closest index to the left with height < arr[i] (or -1 if none)
  - NSR[i]: closest index to the right with height < arr[i] (or n if none)
- Width for bar i = NSR[i] - NSL[i] - 1
- Area for bar i = arr[i] × width
- Answer is the maximum area over all i.

### Why Monotonic Stacks
- You can find NSL/NSR for all bars in O(n) by maintaining a stack of indices with increasing heights:
  - For NSR: traverse right→left, pop while stack top height ≥ current, then current’s NSR is the new top (or n).
  - For NSL: traverse left→right, pop while stack top height > current, then current’s NSL is the new top (or -1).
- Your use of `>=` on the right and `>` on the left is intentional and correct. This asymmetry ensures equal heights don’t block both sides simultaneously, preventing double counting and producing a maximal continuous width for equal-height runs.

### Walkthrough on a sample
For `[2,1,5,6,2,3]`:
- NSL = [-1, -1, 1, 2, 1, 4]
- NSR = [1, 6, 4, 4, 6, 6]
- Widths = [1-(-1)-1, 6-(-1)-1, 4-1-1, 4-2-1, 6-1-1, 6-4-1] = [1,6,2,1,4,1]
- Areas = [2,6,10,6,8,3] → max = 10

### Complexity
- Time: O(n) (each index pushed/popped at most once)
- Space: O(n) for stacks and arrays

### Edge Cases
- Empty array: max area = 0
- All increasing or all decreasing heights are handled naturally
- Very large heights: consider `long` for area to avoid overflow if inputs can be large

### Alternative Single-Pass Stack Method (same O(n))
- Maintain stack of indices with increasing heights while scanning left→right.
- When current height < height at stack top, pop and compute area using the popped height as limiting bar:
  - height = arr[top]
  - right boundary = current index
  - left boundary = new stack top (or -1)
  - width = right - left - 1
- After the loop, flush remaining stack similarly using right boundary = n.

This matches your implementation’s result; your NSL/NSR approach is clean and easy to reason about.

-----------------------------------------------------------------------------------------------------------

TRAPPING RAINWATER USING STACKS

Step-by-step Visual:
Step 1: You scan each elevation bar. Each time you find a bar taller than the one on the stack’s top, that means there’s possibly water to trap above previous dips.

Step 2: Pop from the stack (which forms the “bottom” of a pit), then peek to get the new “left” wall on the stack. Compute the trapped water for this pit as:

width=i−left−1

height=min(height[left],height[i])−height[bottom]

Add area to the answer

Step 3: Keep pushing current indices into stack for future boundary reference.

See below for step-by-step visual representation for the input example:

Step-by-step water trapping visualization for [0,1,0,2,1,0,1,3,2,1,2,1] using stack algorithm
Logical explanation:

The stack keeps track of indices with non-decreasing bar heights.

When a bar higher than the previous is found, that means a pit (valley) is closed, and water can be trapped.

The total water at each step is calculated by the area between current boundary and previous boundary, reduced by the “bottom” of the valley.