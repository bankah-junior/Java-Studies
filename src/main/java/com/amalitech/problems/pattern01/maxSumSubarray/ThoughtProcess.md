The way I understand the problem is that we need to find the maximum sum of any contiguous subarray of size `k` within a given array of integers.
Contiguous subarray means that the elements are next to each other in the original array.

with this example `nums = [2, 1, 5, 1, 3, 2], k = 3` → **9**
What will happen is 
1. We will start by calculating the sum of the first `k` elements, which is `2 + 1 + 5 = 8`.
2. Then, we will slide the window one element to the right 
3. So, the new window will be `[1, 5, 1]` with a sum of `1 + 5 + 1 = 7`.
4. We will continue this process until we have considered all possible windows of size `k`.
5. During this process, we will keep track of the maximum sum we have encountered.
6. In this case, the maximum sum is `9`, which occurs with the window `[5, 1, 3]`.



## 🧠 Thought Process (Based on My Implementation)

1.  **Validate Inputs**
    *   Ensure `k` is within valid bounds: `1 ≤ k ≤ nums.length`.
    *   Ensure the array length is within expected constraints: `1 ≤ nums.length ≤ 100,000`.
    *   If any of these fail, throw an `IllegalArgumentException`.

2.  **Handle Quick Edge Cases Up Front**
    *   If `k == 1`, the answer is simply the **maximum element** in the array (since any single element is a valid subarray). Compute this using `Arrays.stream(nums).max().getAsInt()`.
    *   If `k == nums.length`, the only possible window is the **entire array**, so return the **sum** of all elements using `Arrays.stream(nums).sum()`.

3.  **Evaluate Every Valid Window of Size `k` (Brute Force)**
    *   Iterate `i` from `0` to the last valid starting index for a window of size `k`.
        *   For each `i`, compute the `endIndex = i + k - 1`.
        *   If `endIndex` would fall outside the array (`>= nums.length`), stop the loop.
    *   For each starting index `i`, compute the **sum of the subarray** `nums[i..endIndex]` by looping from `j = i` to `j = endIndex`, accumulating into `currentSum`.

4.  **Track the Maximum**
    *   After computing each window’s sum, update `maxSum = Math.max(maxSum, currentSum)` to keep the best sum seen so far.

5.  **Return the Result**
    *   After checking all valid windows, return `maxSum` as the maximum sum of any contiguous subarray of size `k`.

***

## ⏱️ Complexity (as implemented)

*   **Time:** `O(n * k)` — because for each starting index, you recompute the full window sum from scratch.
*   **Space:** `O(1)` auxiliary — only a few variables are used regardless of input size.

***
