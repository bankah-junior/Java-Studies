package com.amalitech.search.binarySearch;

public class BinarySearchRecursive {

    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1; // not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, high, target);
        } else {
            return binarySearch(arr, low, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] sortedNumbers = {2, 4, 7, 10, 14, 21};
        int target = 21;

        int result = binarySearch(sortedNumbers, 0, sortedNumbers.length - 1, target);

        System.out.println(result != -1 ? "Found at index: " + result : "Not found.");
    }
}
