package com.amalitech.problems.pattern01.maxSumSubarray;

public class MySolution {

    /**
     * Returns the maximum sum of any contiguous subarray of size k.
     * Throws IllegalArgumentException if k <= 0 or k > nums.length.
     */
    public static int maxSumSubarrayOfSizeK(int[] nums, int k) {
        int arrLength = nums.length;
        int maxSum = Integer.MIN_VALUE;

        if (k < 1 || k > arrLength) {
            throw new IllegalArgumentException("k must be between 1 and " + arrLength);
        }

        if (arrLength < 1 || arrLength > 100_000) {
            throw new IllegalArgumentException("Array length must be between 1 and 100,000");
        }

        if (k == 1) {
            maxSum = java.util.Arrays.stream(nums).max().getAsInt();
            return maxSum;
        }

        if (k == arrLength) {
            maxSum = java.util.Arrays.stream(nums).sum();
            return maxSum;
        }

        for (int i = 0; i <= arrLength - 1; i++) {
            int currentSum = 0; // to store sum of current subarray and reset for each new starting index
            int endIndex = (i < 0 ? 1 : i) + k - 1; // calculate end index of subarray
            if (endIndex >= arrLength) {
                break;
            }
            for (int j = i; j <= endIndex; j++) {
                currentSum += nums[j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Quick sanity tests – feel free to add more
        System.out.println(maxSumSubarrayOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3)); // expected 9
        System.out.println(maxSumSubarrayOfSizeK(new int[]{-2, -1, -3, -4}, 2));   // expected -3
        System.out.println(maxSumSubarrayOfSizeK(new int[]{4, -1, 2, 10}, 4));     // expected 15
        System.out.println(maxSumSubarrayOfSizeK(new int[]{5}, 1));                // expected 5
    }
}
