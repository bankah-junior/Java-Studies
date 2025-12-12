
# **Queue in Java**

A queue is a linear data structure that follows the **First-In, First-Out (FIFO)** principle—similar to a line of people waiting for service. In Java, `Queue` is an interface in the Java Collections Framework, and several classes implement it to provide queue functionality.

---

## **Key Concepts**

* **FIFO (First-In, First-Out):** The element added first is removed first.
* **Front (Head):** The end of the queue where elements are removed.
* **Rear (Tail/Back):** The end where elements are inserted.
* **Enqueue:** Adding an element to the rear of the queue.
* **Dequeue:** Removing an element from the front of the queue.
* **IsEmpty:** Checks if the queue has no elements.
* **IsFull:** Checks if the queue is full (applicable for fixed-size queues).
* **Display:** Prints all the items in the queue.

---

## **Core Methods**

The `Queue` interface provides methods in two forms—one that throws exceptions and one that returns special values when operations fail.

| Operation | Throws Exception | Returns Special Value | Description                           |
| --------- | ---------------- | --------------------- | ------------------------------------- |
| Insert    | `add(E e)`       | `offer(E e)`          | Inserts an element into the queue     |
| Remove    | `remove()`       | `poll()`              | Retrieves and removes the head        |
| Inspect   | `element()`      | `peek()`              | Retrieves (without removing) the head |

---

## **Implementations in Java**

Since `Queue` is an interface, it must be implemented by a class:

* **LinkedList**
  Uses a linked list structure. Not capacity-restricted and grows dynamically.

* **PriorityQueue**
  Orders elements based on priority (natural order or custom `Comparator`). Not strictly FIFO.

* **ArrayDeque**
  A resizable array implementing `Deque`. Usually faster than `LinkedList` for queue operations.

* **BlockingQueue**
  Located in `java.util.concurrent`. Thread-safe queues with blocking operations when full or empty.

---

## **Common Applications**

Queues are used widely across computing for ordered processing:

* **CPU & Disk Scheduling** — Manages process/task order.
* **Printer Queues** — Ensures jobs print in order.
* **Data Buffering** — Useful in asynchronous data transfer (e.g., keyboard buffer).
* **Breadth-First Search (BFS)** — Traverses graphs level by level using a queue.

