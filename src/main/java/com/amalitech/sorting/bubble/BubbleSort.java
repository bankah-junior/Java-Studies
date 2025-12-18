package com.amalitech.sorting.bubble;

class BubbleSort {
    public int minimumFinalLength(int[] nums) {
        int n = nums.length;
        int i = n - 1;

        // Find longest non-decreasing suffix
        while (i > 0 && nums[i - 1] <= nums[i]) {
            i--;
        }

        return i + 1;
    }
}
