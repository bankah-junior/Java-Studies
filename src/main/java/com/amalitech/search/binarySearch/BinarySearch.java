package com.amalitech.search.binarySearch;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // prevents overflow

            if (arr[mid] == target) {
                return mid; // found the target
            }
            if (arr[mid] < target) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] sortedNumbers = {2, 4, 7, 10, 14, 21};
        int target = 10;

        int result = binarySearch(sortedNumbers, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
}
