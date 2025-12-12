package com.amalitech.search.megaCorp.util;

import java.util.List;

public class BinarySearch {

    /**
     * Performs a binary search on a sorted list to find the target value.
     *
     * @param sortedList The sorted list to search within.
     * @param target     The value to search for.
     * @return true if the target value is found, false otherwise.
     */
    public boolean binarySearch(List<Integer> sortedList, int target) {
        if (sortedList == null || sortedList.isEmpty()) return false;

        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = sortedList.get(mid);

            if (midValue == target) return true;
            if (midValue < target) left++;
            else right--;
        }

        return false;
    }
}
