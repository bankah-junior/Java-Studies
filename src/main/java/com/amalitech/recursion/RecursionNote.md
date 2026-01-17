# 🔁 Recursion

## 📘 What is Recursion?

**Recursion** is a programming technique where a **function calls itself** to solve a problem by breaking it down into **smaller subproblems** of the same type.

Instead of solving a big problem all at once, recursion:
- Solves a **simpler version** of the problem
- Uses the solution of the smaller problem to solve the original one

---

## 🧠 Key Components of Recursion

Every recursive solution must have **two essential parts**:

### 1️⃣ Base Case
- The condition where the recursion **stops**
- Prevents infinite function calls

### 2️⃣ Recursive Case
- The part where the function **calls itself**
- Moves the problem closer to the base case

> ❗ Without a base case, recursion will run forever and cause a **stack overflow**.

---

## ✏️ Simple Example

### Printing Numbers from `n` to `1`

```java
void printNumbers(int n) {
    if (n == 0) {          // Base case
        return;
    }
    System.out.println(n);
    printNumbers(n - 1);   // Recursive call
}
````

**Call Flow for `printNumbers(3)`**

```
printNumbers(3)
 → printNumbers(2)
   → printNumbers(1)
     → printNumbers(0)  ← stops here
```

---

## 🧮 Classic Recursion Example: Factorial

### Definition

```
factorial(n) = n × factorial(n-1)
factorial(0) = 1
```

### Code

```java
int factorial(int n) {
    if (n == 0) {          // Base case
        return 1;
    }
    return n * factorial(n - 1);
}
```

### Execution for `factorial(4)`

```
4 × factorial(3)
 → 3 × factorial(2)
   → 2 × factorial(1)
     → 1 × factorial(0)
```

---

## 🧱 Recursion Call Stack

Each recursive call is stored in the **call stack**:

* Last function called → executed first
* Uses **LIFO (Last In, First Out)**

⚠️ Deep recursion can cause:

* Stack overflow
* High memory usage

---

## 🔄 Types of Recursion

### 1️⃣ Direct Recursion

A function calls itself directly.

```java
void fun() {
    fun();
}
```

---

### 2️⃣ Indirect Recursion

Functions call each other.

```java
void A() {
    B();
}

void B() {
    A();
}
```

---

### 3️⃣ Tail Recursion

Recursive call is the **last statement** in the function.

```java
void tail(int n) {
    if (n == 0) return;
    tail(n - 1);
}
```

✔ Easier to optimize
✔ Often converted to loops by compilers

---

### 4️⃣ Non-Tail Recursion

```java
int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);
}
```

---

## 📊 Recursion vs Iteration

| Feature          | Recursion                     | Iteration    |
| ---------------- | ----------------------------- | ------------ |
| Code readability | High                          | Medium       |
| Memory usage     | Higher                        | Lower        |
| Performance      | Slower                        | Faster       |
| Uses stack       | Yes                           | No           |
| Best for         | Tree, Graph, Divide & Conquer | Simple loops |

---

## 🧠 When to Use Recursion?

✔ Tree traversals
✔ Graph algorithms
✔ Divide and Conquer (Merge Sort, Quick Sort)
✔ Backtracking (N-Queens, Sudoku)
✔ Mathematical problems

---

## ❌ Common Mistakes

* Missing base case
* Base case never reached
* Too deep recursion
* Incorrect return values

---

## 📝 Recursion Template

```java
returnType function(parameters) {
    if (baseCondition) {
        return baseValue;
    }
    return function(modifiedParameters);
}
```

---

## 🏁 Summary

* Recursion = function calling itself
* Must have **base case + recursive case**
* Uses the **call stack**
* Powerful but must be used carefully

> 💡 *Think of recursion as solving the problem from the smallest possible case upward.*

---
