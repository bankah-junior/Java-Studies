package com.amalitech.search.megaCorp.util;

import java.util.List;

public class LinearSearch {

    /**
     * Performs a linear search on the list to find the target value.
     *
     * @param list   The list to search within.
     * @param target The value to search for.
     * @return true if the target value is found, false otherwise.
     */
    public boolean linearSearch(List<Integer> list, int target) {
        if (list == null || list.isEmpty()) return false;

        for (int id : list) {
            if (id == target) {
                return true;
            }
        }

        return false;
    }
}
