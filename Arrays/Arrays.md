
- Trapping Rainwater

Trapping Rainwater – Two Pointer Approach (Optimized)

Idea

The amount of water trapped at an index depends on the minimum of:

* The tallest bar to its **left**, and
* The tallest bar to its **right**,
  minus the height at that index.

Instead of precomputing `leftMax[]` and `rightMax[]` arrays, we can solve this in **one pass** with **two pointers**.

---

### **Algorithm**

1. Initialize:

   * `left = 0` (start pointer)
   * `right = n-1` (end pointer)
   * `leftMax = 0`, `rightMax = 0`
   * `trappedRainwater = 0`

2. While `left <= right`:

   * If `height[left] <= height[right]`:

     * If `height[left] >= leftMax`:
       update `leftMax = height[left]`
     * Else:
       add `leftMax - height[left]` to trapped water
     * Move `left++`
   * Else (process right side):

     * If `height[right] >= rightMax`:
       update `rightMax = height[right]`
     * Else:
       add `rightMax - height[right]` to trapped water
     * Move `right--`

3. Return `trappedRainwater`.

---

### **Why this works**

* At each step, the side with the **smaller height** is processed.
* This guarantees that the water trapped there depends only on the **tallest wall from that side**, since the opposite side is taller and won’t be the limiting factor.
* This avoids building extra arrays and gives **O(n) time** and **O(1) space**.

---

### **Example**

Input: `height = [4, 2, 0, 6, 3, 2, 5]`
Step-by-step trapped water:

* At index 1 → 2 units
* At index 2 → 4 units
* At index 4 → 3 units
* At index 5 → 4 units
* At index 6 → 1 unit
  **Total = 14 units**

---

Complexity

* Time: O(n) (each element processed once)
* Space: O(1) (constant extra variables)

-------------------------------------------------------------------------------------------------------------------

MAX SUBARRAY KADANES ALGORITHM

-------------------------------------------------------------------------------------------------------------------
REVERSE ROTATED ARRAY


-------------------------------------------------------------------------------------------------------------------

3 Sum

This Java solution uses the **Two Pointer** technique after sorting the array to efficiently find all unique triplets $$ (a, b, c) $$ in the array such that $$ a + b + c = 0 $$. Here’s the step-by-step approach:

### 1. **Sort the Input Array**
- The array is sorted first.
- Sorting makes it easy to avoid duplicates and efficiently find pairs that sum with the current element to zero.

### 2. **Iterate with a Fixed Pointer (`i`)**
- Loop through the array from `i = 0` to `nums.length - 3`.
- For each index `i`, treat `nums[i]` as the first element of a potential triplet.
- If `nums[i] == nums[i-1]` (and `i > 0`), skip this iteration to avoid duplicate triplets.

### 3. **Initialize Two Pointers: `left` and `right`**
- Set `left = i + 1` and `right = nums.length - 1`, pointing to elements immediately after and at the end.
- The goal is to find two numbers between `left` and `right` such that `nums[left] + nums[right] == -nums[i]`.

### 4. **While Loop to Find Pairs That Sum to Target**
- Loop while `left < right`.
- Calculate `sum = nums[i] + nums[left] + nums[right]`.

  - If `sum == 0`:
    - Found a valid triplet: add `[nums[i], nums[left], nums[right]]` to the result list.
    - Move `left` and `right` past any duplicates to ensure unique triplets.
    - Increment `left` and decrement `right` to check for other pairs.

  - If `sum < 0`: Increment `left` to try a larger value.
  - If `sum > 0`: Decrement `right` to try a smaller value.

### 5. **Return the Result**
- After all iterations, return the result list containing all unique triplets.

***

**Key Points**
- **Sorting:** Essential for avoiding duplicates and enabling the two-pointer search.
- **Skipping Duplicates:** Both the outer and inner loops skip duplicate elements using conditions.
- **Two-Pointer Search:** Efficiently narrows down possible pairs in $$O(n)$$ time after fixing one element.

**Time Complexity**: $$O(n^2)$$, as the main loop runs $$O(n)$$ times and for each, the two-pointer search takes up to $$O(n)$$.
