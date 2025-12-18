# Bubble Sort Question: Optimized Swaps

## Question Title

**Minimum Array Length for a Sorted Array**

---

## Problem Description

You are given an unsorted array of **positive integers** `nums`.

You can perform a single operation called a **Bubble Pass**.

### Bubble Pass Definition

A Bubble Pass consists of iterating through the array from left to right (index `i` from `0` to `n - 2`) and performing the following operation:

* If `nums[i] > nums[i + 1]`, swap `nums[i]` and `nums[i + 1]`.

---

## Process Rules

* After **each full Bubble Pass**:

    * If **any swaps occurred**, the **last element** of the array (which is now guaranteed to be the largest unsorted element) is considered **sorted** and is **removed** from the array.
    * The Bubble Pass process is then repeated on the remaining array.

* If a Bubble Pass completes with **no swaps**, the array is considered fully sorted, and the process stops.

---

## Task

Return the **minimum final length** of the array when this process stops.

---

## Example 1

**Input:**

```
nums = [3, 1, 2]
```

**Step 1 (Bubble Pass on `[3, 1, 2]`):**

* Swap `(3, 1)` → `[1, 3, 2]`
* Swap `(3, 2)` → `[1, 2, 3]`
* Swaps occurred → remove last element `3`
* Remaining array: `[1, 2]`

**Step 2 (Bubble Pass on `[1, 2]`):**

* No swaps occurred
* Process stops

**Output:**

```
2
```

---

## Example 2

**Input:**

```
nums = [4, 2, 1, 3]
```

**Step 1 (Bubble Pass):**

```
[2, 1, 3, 4]
```

* Swaps occurred → remove `4`
* Remaining array: `[2, 1, 3]`

**Step 2 (Bubble Pass):**

```
[1, 2, 3]
```

* Swaps occurred → remove `3`
* Remaining array: `[1, 2]`

**Step 3 (Bubble Pass on `[1, 2]`):**

* No swaps occurred
* Process stops

**Output:**

```
2
```

---

## Constraints

* `1 ≤ nums.length ≤ 10³`
* `1 ≤ nums[i] ≤ 10⁹`

---

## Hint

Focus on what condition determines whether an element must be part of the **final remaining sorted subarray**, or whether it will eventually be **bubbled out** during the process.
