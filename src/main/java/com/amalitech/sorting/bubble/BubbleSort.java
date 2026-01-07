package com.amalitech.sorting.bubble;


public class BubbleSort {

    // Function to perform Bubble Sort
    public static int bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        int numberOfSwaps = 0;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements if out of order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    numberOfSwaps++;
                    swapped = true;
                }
            }

            // If no swaps were made, the array is already sorted
            if (!swapped) {
                break;
            }
        }
        return numberOfSwaps;
    }

    // Demo
    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};

        int numberOfSwaps = bubbleSort(numbers);

        System.out.println("Number of Swaps: " + numberOfSwaps);

        System.out.print("Sorted Array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
