TRIANGLE

### 1. **Question Explanation (Intuitively)**

You are given a triangle shaped array like this:

```
   [2]
  [3, 4]
 [6, 5, 7]
[4, 1, 8, 3]
```

- **Goal:** Start from the top (`2`), and move to the row below, choosing *adjacent* indices (i or i+1). 
- **Constraint:** At each step, you may move to either index `i` or `i+1` in the next row.
- **Find:** The minimum total path sum from top to bottom.

***

### 2. **Example Walkthrough**

**Input:** triangle = [,,,][1]

Let's visualize the triangle:

```
     2
    3 4
   6 5 7
  4 1 8 3
```

**One minimum path example:**

- Start at 2 (Top)
- Move to 3 (Left child, index 0)
- Move to 5 (Right child, index 1 - adjacent to previous 3)
- Move to 1 (Left child, index 1 - adjacent to previous 5)

So path is: **2 → 3 → 5 → 1 = 11**

***

### 3. **Step-by-Step Visual Algorithm (Bottom Up Dynamic Programming)**

**Why Bottom Up?**  
- From the last row, you know the cost to "end" at any cell, so you work upwards to accumulate minimum paths.

#### **Step 1: Copy the input triangle**

We'll work our way from the bottom **to the top**.

Start with:
```
   2
  3 4
 6 5 7
4 1 8 3
```

#### **Step 2: Process second last row**

Take the row above the last: ``

For each element, add the **minimum** of its two children (below):

- `6` (children: 4, 1):  `6 + min(4,1) = 6 + 1 = 7`
- `5` (children: 1, 8):  `5 + min(1,8) = 5 + 1 = 6`
- `7` (children: 8, 3):  `7 + min(8,3) = 7 + 3 = 10`

Update the row:
```
7, 6, 10
```

New triangle:
```
   2
  3 4
 7 6 10
4 1 8 3
```

#### **Step 3: Process the next row up**

Row `` and new children ``:

- `3` (children: 7,6):  `3 + min(7,6) = 3 + 6 = 9`
- `4` (children: 6,10): `4 + min(6,10) = 4 + 6 = 10`

Update the row:
```
9, 10
```

New triangle:
```
   2
  9 10
 7 6 10
4 1 8 3
```

#### **Step 4: Process the top row**

Only one element `2` (children: 9,10):

- `2 + min(9,10) = 2 + 9 = 11`

Triangle now:
```
   11
  9 10
 7 6 10
4 1 8 3
```

#### **Step 5: The Answer**

The top element now holds the answer: **11** (minimum path sum).

***

### 4. **Why is Bottom-Up Efficient?**

- **Space efficient:** Updates in-place, can be done with O(n) extra space where n is number of rows.
- **Avoids redundant recalculation** by always building on previously computed minimums.



 1. **Visual Summary of Steps**

| Step                    | Visual                       | Calculation         |
|-------------------------|------------------------------|---------------------|
| Start                   | `2 | 3 4 | 6 5 7 | 4 1 8 3`  | Initial triangle    |
| Last row merged up      | `2 | 3 4 | 7 6 10 | 4 1 8 3` | Bottom up           |
| Next row up             | `2 | 9 10 | 7 6 10 | 4 1 8 3`| Keep merging        |
| Final top value         | `11 | 9 10 | 7 6 10 | 4 1 8 3`| Minimum path is 11  |


(https://leetcode.com/problems/triangle/description/?envType=daily-question&envId=2025-09-25)

---------------------------------------------------------------------------------------------------------------------------------------------------

