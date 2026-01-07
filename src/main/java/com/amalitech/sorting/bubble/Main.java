package com.amalitech.sorting.bubble;

public class Main {
    public static void main(String[] args) {

        BubbleSortSolution solution = new BubbleSortSolution();

        int[] nums1 = {3, 1, 2};
        System.out.println(solution.minimumFinalLength02(nums1));

        int[] nums2 = {4, 2, 1, 3};
        System.out.println(solution.minimumFinalLength02(nums2));

        int[] nums3 = {1, 2, 3};
        System.out.println(solution.minimumFinalLength02(nums3));

        int[] nums4 = {3, 1, 4, 5, 2};
        System.out.println(solution.minimumFinalLength01(nums4));
    }
}