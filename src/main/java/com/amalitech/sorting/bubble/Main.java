package com.amalitech.sorting.bubble;

public class Main {
    public static void main(String[] args) {

        BubbleSort solution = new BubbleSort();

        int[] nums1 = {3, 1, 2};
        System.out.println(solution.minimumFinalLength(nums1));

        int[] nums2 = {4, 2, 1, 3};
        System.out.println(solution.minimumFinalLength(nums2));

        int[] nums3 = {1, 2, 3};
        System.out.println(solution.minimumFinalLength(nums3));
    }
}