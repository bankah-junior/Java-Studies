package com.amalitech.search.linearSearch;

public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // return the index of the target
            }
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] numbers = {3, 8, 2, 5, 9};
        int target = 5;

        int result = linearSearch(numbers, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
}