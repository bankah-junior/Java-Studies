# 🔍 Key Insight (The Core Observation)

An element will be **removed** if, at some point, it needs to **move right** to get sorted.

Bubble Sort only moves elements:

* **Left** → smaller elements
* **Right** → larger elements (via swaps)

👉 Therefore:

> Any element that is **greater than a smaller element to its right** will eventually be bubbled to the end and removed.

So the elements that **remain at the end** must satisfy:

> They form a prefix where the array is already **non-decreasing**
> i.e., `nums[i] ≤ nums[i+1] ≤ nums[i+2] ...`

---

# 🎯 What Are We Really Looking For?

We want the **longest suffix that is already sorted** (non-decreasing).

The process stops when the remaining array is already sorted.

So the answer is simply:

> **The length of the longest sorted suffix**

---

# 🧠 How to Compute It (Efficiently)

1. Start from the **right end** of the array
2. Move left while the order is **non-decreasing**
3. Stop when you find a violation

---

# ✅ Algorithm

```text
Start from i = n - 1
While i > 0 and nums[i-1] ≤ nums[i]:
    i--

Answer = i + 1
```

---

# 🧪 Example Walkthroughs

### Example 1

```
nums = [3, 1, 2]
```

Check from right:

* 1 ≤ 2 ✅
* 3 ≤ 1 ❌ (stop)

Remaining sorted suffix = `[1, 2]`
✅ Final length = **2**

---

### Example 2

```
nums = [4, 2, 1, 3]
```

Check from right:

* 1 ≤ 3 ✅
* 2 ≤ 1 ❌ (stop)

Remaining sorted suffix = `[1, 2]`
✅ Final length = **2**

---

# 🧩 Java Implementation

```java
class Solution {
    public int minimumFinalLength(int[] nums) {
        int n = nums.length;
        int i = n - 1;

        // Find longest non-decreasing suffix
        while (i > 0 && nums[i - 1] <= nums[i]) {
            i--;
        }

        return i + 1;
    }
}
```

---

# ▶️ Usage in `main` Class

```java
public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums1 = {3, 1, 2};
        System.out.println(solution.minimumFinalLength(nums1)); // 2

        int[] nums2 = {4, 2, 1, 3};
        System.out.println(solution.minimumFinalLength(nums2)); // 2
    }
}
```

---

# ⏱ Complexity Analysis

| Metric     | Value        |
| ---------- | ------------ |
| Time       | **O(n)**     |
| Space      | **O(1)**     |
| Simulation | ❌ Not needed |

---

# 🏆 Why This Solution Is Strong

✔ No Bubble Sort simulation
✔ Linear time
✔ Uses invariant of Bubble Sort behavior
✔ Clean & interview-ready
✔ Works for all constraints
