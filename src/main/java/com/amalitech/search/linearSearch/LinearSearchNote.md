# **Linear Search in Java**

Linear Search is a simple searching algorithm that checks each element in a list one by one until the target element is found or the entire list has been traversed. It works on **both sorted and unsorted** data structures.

---

## **Key Concepts**

* **Sequential Search:** Every element is checked one after another.
* **Works on Any List:** Arrays, ArrayLists, or linked structures.
* **No Pre-sorting Required:** Unlike Binary Search, data does not need to be sorted.
* **Time Complexity:**

    * **Best Case:** O(1) (target is the first element)
    * **Worst Case:** O(n) (target is last or not present)
* **Space Complexity:** O(1) (no extra memory needed)

---

## **Algorithm Steps**

1. Start from the first element of the list.
2. Compare each element with the target value.
3. If a match is found, return the index (or true).
4. If the end of the list is reached and no match is found, return -1 (or false).

---

## **Java Implementation (Array)**

```java
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
```

---

## **Advantages**

* Simple and easy to implement.
* Works on both sorted and unsorted lists.
* Ideal for small datasets.

---

## **Disadvantages**

* Inefficient for large lists due to O(n) time.
* Checks every element even if the target is near the end.

---

## **Common Applications**

* Searching in unsorted data.
* Finding the presence of an element in small or medium-sized lists.
* Useful when the dataset is dynamic (frequent insertions/deletions) and sorting isn’t practical.

