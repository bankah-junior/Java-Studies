# Bubble Sort

## Overview

Bubble Sort is a simple **comparison-based sorting algorithm**. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This process continues until the array is sorted.

The algorithm gets its name because **larger elements "bubble up" to the end** of the array after each pass.

---

## How Bubble Sort Works

1. Start from the beginning of the array.
2. Compare each pair of adjacent elements.
3. Swap them if the left element is greater than the right element.
4. After one full pass, the largest element is placed at the end.
5. Repeat the process for the remaining unsorted portion of the array.

---

## Example

Input:

```
[5, 1, 4, 2, 8]
```

Pass 1:

```
[1, 4, 2, 5, 8]
```

Largest element `8` is fixed at the end.

Pass 2:

```
[1, 2, 4, 5, 8]
```

Array becomes sorted.

---

## Pseudocode

```
for i from 0 to n-1
    for j from 0 to n-i-2
        if arr[j] > arr[j+1]
            swap(arr[j], arr[j+1])
```

---

## Optimized Bubble Sort

If no swaps occur during a pass, the array is already sorted.

```
for i from 0 to n-1
    swapped = false
    for j from 0 to n-i-2
        if arr[j] > arr[j+1]
            swap(arr[j], arr[j+1])
            swapped = true
    if not swapped
        break
```

---

## Time Complexity

| Case                       | Complexity |
| -------------------------- | ---------- |
| Best Case (already sorted) | O(n)       |
| Average Case               | O(n²)      |
| Worst Case (reverse order) | O(n²)      |

---

## Space Complexity

* **O(1)** (In-place sorting)

---

## Stability

* **Stable**: Equal elements retain their relative order.

---

## Advantages

* Easy to understand and implement
* No extra memory required
* Useful for educational purposes

---

## Disadvantages

* Very slow for large datasets
* Not suitable for real-world applications

---

## When to Use Bubble Sort

* Teaching basic sorting concepts
* Very small datasets
* When simplicity is more important than efficiency

---

## Summary

Bubble Sort is a simple but inefficient sorting algorithm. While it is rarely used in production, it is important for understanding fundamental sorting principles and algorithm analysis.
