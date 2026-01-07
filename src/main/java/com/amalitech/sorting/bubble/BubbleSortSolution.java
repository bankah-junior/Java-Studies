package com.amalitech.sorting.bubble;

class BubbleSortSolution {
    public int minimumFinalLength01(int[] nums) {
        int n = nums.length;
        int i = n - 1;

        // Find longest non-decreasing suffix
        while (i > 0 && nums[i - 1] <= nums[i]) {
            i--;
        }

        return i + 1;
    }

    // Returns the final length after repeated bubble passes and removals
    public int minimumFinalLength02(int[] nums) {
        int[] arr = nums.clone();

        int currentLength = arr.length;

        while (true) {
            boolean swapped = false;

            // Single bubble pass on the active prefix [0 .. currentLength - 1]
            for (int i = 0; i < currentLength - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped) {
                // Last element of active range is now fixed in sorted position
                currentLength--;
            } else {
                break;
            }
        }

        return currentLength;
    }
}
