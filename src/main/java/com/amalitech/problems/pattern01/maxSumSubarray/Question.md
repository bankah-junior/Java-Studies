## 🔹 Problem: Maximum Sum Subarray of Size `k` (Fixed-size Sliding Window)

**Statement:**  
Given an integer array `nums` and an integer `k`, find the **maximum sum** of any **contiguous subarray** of size exactly `k`.

**Constraints:**

*   `1 ≤ k ≤ nums.length`
*   `1 ≤ nums.length ≤ 100_000`
*   `-10^9 ≤ nums[i] ≤ 10^9` (values may be negative)
*   Return an `int` (you may assume sums fit in 32-bit; if you choose `long`, that’s fine too)

**Expected Complexity:**

*   **Time:** `O(n)`
*   **Space:** `O(1)` auxiliary

**Examples:**

1.  `nums = [2, 1, 5, 1, 3, 2], k = 3` → **9**  
    Explanation: best window is `[5, 1, 3]` with sum `9`.
2.  `nums = [-2, -1, -3, -4], k = 2` → **-3**  
    Explanation: windows: `[-2,-1] = -3`, `[-1,-3] = -4`, `[-3,-4] = -7`; max is `-3`.
3.  `nums = [4, -1, 2, 10], k = 4` → **15**  
    Explanation: only window is the whole array.

**Edge Cases to Consider:**

*   All numbers negative.
*   `k = 1` (should return the maximum element).
*   `k = nums.length` (sum of entire array).
*   Large arrays (performance).

***

## 🧩 Function Signature (Java)

Use this signature (feel free to change return type to `long` if you prefer):

```java
public class SlidingWindowFixed {

    /**
     * Returns the maximum sum of any contiguous subarray of size k.
     * Throws IllegalArgumentException if k <= 0 or k > nums.length.
     */
    public static int maxSumSubarrayOfSizeK(int[] nums, int k) {
        // Your implementation goes here
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void main(String[] args) {
        // Quick sanity tests – feel free to add more
        System.out.println(maxSumSubarrayOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3)); // expected 9
        System.out.println(maxSumSubarrayOfSizeK(new int[]{-2, -1, -3, -4}, 2));   // expected -3
        System.out.println(maxSumSubarrayOfSizeK(new int[]{4, -1, 2, 10}, 4));     // expected 15
        System.out.println(maxSumSubarrayOfSizeK(new int[]{5}, 1));                // expected 5
    }
}
```

***

## 🔜 Your Turn

1.  Explain your **thought process** (how you’ll maintain the window, how you’ll update the sum, and why it’s `O(n)`).
2.  Implement in **Java** and send your code.
3.  I’ll review for **correctness**, **edge cases**, and **complexity**.
4.  If needed, I’ll provide an **optimized** or **refactored** version.

Ready when you are!
