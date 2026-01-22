# Data Structures & Algorithms Cheat Sheet

## Table of Contents
1. [Recursion](#recursion)
2. [Searching Algorithms](#searching-algorithms)
3. [Sorting Algorithms](#sorting-algorithms)
4. [Linear Data Structures](#linear-data-structures)
5. [Hash-Based Data Structures](#hash-based-data-structures)
6. [Tree Data Structures](#tree-data-structures)
7. [Graph Data Structures](#graph-data-structures)
8. [Graph Algorithms](#graph-algorithms)

---

## Recursion

### Factorial Function
**Concept:** A recursive function that calculates n! (n factorial)

**Algorithm:**
- **Base Case:** If n == 0 or n == 1, return 1
- **Recursive Case:** return n × factorial(n - 1)

**Complexity:**
- Time: O(n)
- Space: O(n) due to call stack

---

## Searching Algorithms

### Linear Search
**Use Case:** Works on both sorted and unsorted arrays

**Implementation:** Simple iteration through array elements

**Complexity:**
- Time: O(n)
- Space: O(1)

### Binary Search
**Use Case:** Sorted arrays only

**Algorithm (Iterative):**
1. Initialize `low = 0`, `high = array.length - 1`
2. While `low <= high`:
    - Calculate `mid = low + (high - low) / 2`
    - If `array[mid] == target`, return `mid`
    - If `target < array[mid]`, set `high = mid - 1`
    - If `target > array[mid]`, set `low = mid + 1`
3. Return -1 if target not found

**Complexity:**
- Time: O(log n)
- Space: O(1) for iterative, O(log n) for recursive

---

## Sorting Algorithms

### Bubble Sort
**Concept:** Comparison-based sort that repeatedly swaps adjacent elements if they're in wrong order

**Algorithm:**
1. For i from 0 to n-1:
    - For j from 0 to n-i-2:
        - If `arr[j] > arr[j+1]`, swap them and set swapped flag
    - If no swaps occurred, break early (optimization)

**Complexity:**
- Time: O(n²)
- Space: O(1)

### Quick Sort
**Concept:** Divide-and-conquer algorithm using a pivot element

**Algorithm:**
```
quickSort(arr, low, high):
  If low < high:
    pi = partition(arr, low, high)
    quickSort(arr, low, pi - 1)
    quickSort(arr, pi + 1, high)

partition(arr, low, high):
  pivot = arr[high]
  i = low
  For j from low to high-1:
    If arr[j] <= pivot:
      Swap arr[i] and arr[j]
      i++
  Swap arr[i] and arr[high]
  Return i
```

**Complexity:**
- Time: O(n log n) average, O(n²) worst case
- Space: O(log n) due to recursion stack

### Merge Sort
**Concept:** Divide-and-conquer algorithm that divides array into halves, sorts them, and merges

**Algorithm:**
```
mergeSort(arr, left, right, temp):
  If left >= right, return
  mid = left + (right - left) / 2
  mergeSort(arr, left, mid, temp)
  mergeSort(arr, mid + 1, right, temp)
  If arr[mid] <= arr[mid + 1], return (already sorted)
  merge(arr, left, mid, right, temp)

merge(arr, left, mid, right, temp):
  Copy arr[left..right] to temp
  i = left, j = mid + 1, k = left
  While i <= mid AND j <= right:
    If temp[i] <= temp[j]:
      arr[k++] = temp[i++]
    Else:
      arr[k++] = temp[j++]
  Copy remaining elements from left half if any
```

**Complexity:**
- Time: O(n log n)
- Space: O(n) due to auxiliary array

---

## Linear Data Structures

### Singly Linked List

**Node Structure:**
```java
class SNode {
    int data;
    SNode next;
    
    SNode(int data) {
        this.data = data;
        this.next = null;
    }
}
```

**Operations:**

#### Insert at Head
```java
SNode head;

void insertAtHead(int data) {
    SNode newNode = new SNode(data);
    newNode.next = head;
    head = newNode;
}
```

#### Insert at Tail
```java
void insertAtTail(int data) {
    SNode newNode = new SNode(data);
    if (head == null) {
        head = newNode;
        return;
    }
    SNode curr = head;
    while (curr.next != null) {
        curr = curr.next;
    }
    curr.next = newNode;
}
```

#### Insert at Position
```java
void insertAtPosition(int data, int position) {
    if (position == 0) {
        insertAtHead(data);
        return;
    }
    SNode newNode = new SNode(data);
    SNode curr = head;
    for (int i = 0; i < position - 1 && curr != null; i++) {
        curr = curr.next;
    }
    if (curr == null) {
        insertAtTail(data);
        return;
    }
    newNode.next = curr.next;
    curr.next = newNode;
}
```

#### Delete from Head
```java
void deleteFromHead() {
    if (head != null) {
        head = head.next;
    }
}
```

#### Delete from Tail
```java
void deleteFromTail() {
    if (head == null) return;
    if (head.next == null) {
        head = null;
        return;
    }
    SNode curr = head;
    while (curr.next.next != null) {
        curr = curr.next;
    }
    curr.next = null;
}
```

### Stack (LIFO - Last In, First Out)
**Implementation:** Linked List-based
**Operations:** All operations focus on the top element
- Push: Add element to top
- Pop: Remove element from top
- Peek: View top element without removing

### Queue (FIFO - First In, First Out)
**Implementation:** Linked List-based
**Operations:** Focus on front and rear elements
- Enqueue: Add element to rear
- Dequeue: Remove element from front
- Peek: View front element without removing

---

## Hash-Based Data Structures

### HashMap
**Concept:** Key-value pair storage with O(1) average access time using hash functions

**Properties:**
- Stores elements as key-value pairs
- Keys are unique (duplicates overwrite existing values)
- Allows null keys and values (implementation dependent)
- No guaranteed order of elements

**Common Operations:**
```java
// Declaration
HashMap<String, Integer> map = new HashMap<>();

// Insert/Update
map.put("apple", 5);
map.put("banana", 3);

// Access
int value = map.get("apple");  // Returns 5
int valueOrDefault = map.getOrDefault("orange", 0);  // Returns 0

// Check existence
boolean hasKey = map.containsKey("apple");  // true
boolean hasValue = map.containsValue(5);  // true

// Remove
map.remove("banana");

// Iterate
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Size
int size = map.size();

// Clear
map.clear();
```

**Complexity:**
- Access/Insert/Delete: O(1) average, O(n) worst case
- Space: O(n)

**Use Cases:**
- Caching and memoization
- Counting frequencies
- Building indices
- Two-sum problems

### HashSet
**Concept:** Collection of unique elements with O(1) average access time

**Properties:**
- Stores unique elements only
- No duplicates allowed
- No guaranteed order
- Allows one null element (implementation dependent)

**Common Operations:**
```java
// Declaration
HashSet<String> set = new HashSet<>();

// Add elements
set.add("apple");
set.add("banana");
set.add("apple");  // Ignored - duplicate

// Check existence
boolean exists = set.contains("apple");  // true

// Remove
set.remove("banana");

// Size
int size = set.size();

// Iterate
for (String item : set) {
    System.out.println(item);
}

// Convert to array
String[] array = set.toArray(new String[0]);

// Set operations
HashSet<String> set2 = new HashSet<>();
set2.add("banana");
set2.add("cherry");

// Union
HashSet<String> union = new HashSet<>(set);
union.addAll(set2);

// Intersection
HashSet<String> intersection = new HashSet<>(set);
intersection.retainAll(set2);

// Difference
HashSet<String> difference = new HashSet<>(set);
difference.removeAll(set2);
```

**Complexity:**
- Add/Remove/Contains: O(1) average, O(n) worst case
- Space: O(n)

**Use Cases:**
- Removing duplicates
- Checking membership
- Finding unique elements
- Set operations (union, intersection, difference)

---

## Tree Data Structures

### Binary Tree

**Node Structure:**
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

**Traversals:**

#### Inorder (Left → Root → Right)
```java
void inorderTraversal(TreeNode root) {
    if (root == null) return;
    inorderTraversal(root.left);
    System.out.print(root.val + " ");
    inorderTraversal(root.right);
}
```

#### Preorder (Root → Left → Right)
```java
void preorderTraversal(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    preorderTraversal(root.left);
    preorderTraversal(root.right);
}
```

#### Postorder (Left → Right → Root)
```java
void postorderTraversal(TreeNode root) {
    if (root == null) return;
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    System.out.print(root.val + " ");
}
```

**Utility Functions:**

#### Height of Tree
```java
int height(TreeNode root) {
    if (root == null) return 0;
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
}
```

#### Count Nodes
```java
int countNodes(TreeNode root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
}
```

#### Example: Building a Binary Tree
```java
public class BinaryTreeExample {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        
        System.out.println("Root: " + root.val);
        System.out.println("Left Child: " + root.left.val);
        System.out.println("Right Child: " + root.right.val);
    }
}
```

### Binary Search Tree (BST)

**Properties:**
- Left subtree contains only nodes with values less than parent
- Right subtree contains only nodes with values greater than parent
- Both subtrees must also be BSTs

**Operations:**

#### Insert
```java
public TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val < root.val) {
        root.left = insert(root.left, val);
    } else if (val > root.val) {
        root.right = insert(root.right, val);
    }
    return root;
}
```

#### Search
```java
public boolean search(TreeNode root, int val) {
    if (root == null) return false;
    if (val == root.val) return true;
    if (val < root.val) {
        return search(root.left, val);
    } else {
        return search(root.right, val);
    }
}
```

#### Delete
```java
public TreeNode delete(TreeNode root, int val) {
    if (root == null) return null;
    if (val < root.val) {
        root.left = delete(root.left, val);
    } else if (val > root.val) {
        root.right = delete(root.right, val);
    } else {
        // Node with only one child or no child
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;
        
        // Node with two children: Get inorder successor
        root.val = minValue(root.right);
        
        // Delete the inorder successor
        root.right = delete(root.right, root.val);
    }
    return root;
}
```

---

## Graph Data Structures

### Graph Basics
**Concept:** A collection of nodes (vertices) connected by edges

**Types:**
- **Directed Graph (Digraph):** Edges have direction (A → B)
- **Undirected Graph:** Edges have no direction (A — B)
- **Weighted Graph:** Edges have weights/costs
- **Unweighted Graph:** All edges have equal weight

**Representations:**

#### Adjacency Matrix
```java
// For n vertices
int[][] adjMatrix = new int[n][n];

// Add edge from u to v (weighted)
adjMatrix[u][v] = weight;

// For undirected graph
adjMatrix[u][v] = weight;
adjMatrix[v][u] = weight;

// Check if edge exists
if (adjMatrix[u][v] != 0) {
    // Edge exists
}
```

**Complexity:**
- Space: O(V²)
- Check edge: O(1)
- Get all neighbors: O(V)

#### Adjacency List
```java
// Using ArrayList of ArrayLists
ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

// Initialize for n vertices
for (int i = 0; i < n; i++) {
    adjList.add(new ArrayList<>());
}

// Add edge from u to v
adjList.get(u).add(v);

// For undirected graph
adjList.get(u).add(v);
adjList.get(v).add(u);

// Weighted graph using pairs
class Edge {
    int dest;
    int weight;
    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

ArrayList<ArrayList<Edge>> weightedGraph = new ArrayList<>();
```

**Complexity:**
- Space: O(V + E)
- Check edge: O(degree of vertex)
- Get all neighbors: O(degree of vertex)

### Graph Traversals

#### Depth-First Search (DFS)
**Concept:** Explore as far as possible along each branch before backtracking

**Algorithm (Recursive):**
```java
void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
    visited[node] = true;
    System.out.print(node + " ");
    
    for (int neighbor : adjList.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, visited, adjList);
        }
    }
}

// Usage
boolean[] visited = new boolean[n];
dfs(startNode, visited, adjList);
```

**Algorithm (Iterative using Stack):**
```java
void dfsIterative(int start, int n, ArrayList<ArrayList<Integer>> adjList) {
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    
    stack.push(start);
    
    while (!stack.isEmpty()) {
        int node = stack.pop();
        
        if (!visited[node]) {
            visited[node] = true;
            System.out.print(node + " ");
            
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
```

**Complexity:**
- Time: O(V + E)
- Space: O(V) for recursion stack/visited array

**Use Cases:**
- Detecting cycles
- Topological sorting
- Finding connected components
- Solving maze problems

#### Breadth-First Search (BFS)
**Concept:** Explore all neighbors at current depth before moving to next depth

**Algorithm:**
```java
void bfs(int start, int n, ArrayList<ArrayList<Integer>> adjList) {
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[start] = true;
    queue.offer(start);
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");
        
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

**BFS with Level Tracking:**
```java
void bfsWithLevels(int start, int n, ArrayList<ArrayList<Integer>> adjList) {
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    int[] level = new int[n];
    
    visited[start] = true;
    queue.offer(start);
    level[start] = 0;
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                level[neighbor] = level[node] + 1;
                queue.offer(neighbor);
            }
        }
    }
}
```

**Complexity:**
- Time: O(V + E)
- Space: O(V) for queue and visited array

**Use Cases:**
- Shortest path in unweighted graphs
- Level-order traversal
- Finding connected components
- Social network distance

---

## Graph Algorithms

### Dijkstra's Algorithm
**Concept:** Find shortest path from source to all vertices in weighted graph with non-negative weights

**Algorithm:**
```java
class Node implements Comparable<Node> {
    int vertex;
    int distance;
    
    Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

int[] dijkstra(int start, int n, ArrayList<ArrayList<Edge>> graph) {
    int[] dist = new int[n];
    boolean[] visited = new boolean[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[start] = 0;
    pq.offer(new Node(start, 0));
    
    while (!pq.isEmpty()) {
        Node current = pq.poll();
        int u = current.vertex;
        
        if (visited[u]) continue;
        visited[u] = true;
        
        for (Edge edge : graph.get(u)) {
            int v = edge.dest;
            int weight = edge.weight;
            
            if (!visited[v] && dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                pq.offer(new Node(v, dist[v]));
            }
        }
    }
    
    return dist;  // dist[i] = shortest distance from start to i
}
```

**Path Reconstruction:**
```java
int[] dijkstraWithPath(int start, int n, ArrayList<ArrayList<Edge>> graph) {
    int[] dist = new int[n];
    int[] parent = new int[n];
    boolean[] visited = new boolean[n];
    
    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(parent, -1);
    
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[start] = 0;
    pq.offer(new Node(start, 0));
    
    while (!pq.isEmpty()) {
        Node current = pq.poll();
        int u = current.vertex;
        
        if (visited[u]) continue;
        visited[u] = true;
        
        for (Edge edge : graph.get(u)) {
            int v = edge.dest;
            int weight = edge.weight;
            
            if (!visited[v] && dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                parent[v] = u;
                pq.offer(new Node(v, dist[v]));
            }
        }
    }
    
    return parent;  // Reconstruct path using parent array
}

// Get path from start to end
ArrayList<Integer> getPath(int start, int end, int[] parent) {
    ArrayList<Integer> path = new ArrayList<>();
    for (int at = end; at != -1; at = parent[at]) {
        path.add(at);
    }
    Collections.reverse(path);
    
    if (path.get(0) == start) {
        return path;
    }
    return new ArrayList<>();  // No path exists
}
```

**Complexity:**
- Time: O((V + E) log V) with binary heap
- Space: O(V)

**Use Cases:**
- GPS navigation (shortest route)
- Network routing protocols
- Flight itinerary optimization

### Bellman-Ford Algorithm
**Concept:** Find shortest path from source, works with negative weights, detects negative cycles

**Algorithm:**
```java
int[] bellmanFord(int start, int n, ArrayList<int[]> edges) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    
    // Relax edges n-1 times
    for (int i = 0; i < n - 1; i++) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
            }
        }
    }
    
    // Check for negative cycles
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int weight = edge[2];
        
        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
            System.out.println("Negative cycle detected");
            return null;
        }
    }
    
    return dist;
}
```

**Complexity:**
- Time: O(V × E)
- Space: O(V)

### A* Pathfinding Algorithm
**Concept:** Informed search using heuristic to find shortest path efficiently

**Algorithm:**
```java
class AStarNode implements Comparable<AStarNode> {
    int x, y;
    int g;  // Cost from start
    int h;  // Heuristic to goal
    int f;  // g + h
    AStarNode parent;
    
    AStarNode(int x, int y, int g, int h, AStarNode parent) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = g + h;
        this.parent = parent;
    }
    
    public int compareTo(AStarNode other) {
        return this.f - other.f;
    }
}

// Manhattan distance heuristic
int heuristic(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
}

ArrayList<int[]> aStar(int[][] grid, int[] start, int[] goal) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    
    PriorityQueue<AStarNode> openSet = new PriorityQueue<>();
    int h = heuristic(start[0], start[1], goal[0], goal[1]);
    openSet.offer(new AStarNode(start[0], start[1], 0, h, null));
    
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    while (!openSet.isEmpty()) {
        AStarNode current = openSet.poll();
        
        if (current.x == goal[0] && current.y == goal[1]) {
            // Reconstruct path
            ArrayList<int[]> path = new ArrayList<>();
            while (current != null) {
                path.add(new int[]{current.x, current.y});
                current = current.parent;
            }
            Collections.reverse(path);
            return path;
        }
        
        if (visited[current.x][current.y]) continue;
        visited[current.x][current.y] = true;
        
        for (int[] dir : directions) {
            int nx = current.x + dir[0];
            int ny = current.y + dir[1];
            
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols 
                && grid[nx][ny] == 0 && !visited[nx][ny]) {
                int g = current.g + 1;
                int heuristic = heuristic(nx, ny, goal[0], goal[1]);
                openSet.offer(new AStarNode(nx, ny, g, heuristic, current));
            }
        }
    }
    
    return new ArrayList<>();  // No path found
}
```

**Complexity:**
- Time: O(b^d) where b is branching factor, d is depth
- Space: O(b^d)

**Use Cases:**
- Game pathfinding (NPCs, enemies)
- Robot navigation
- Map applications

### Common Graph Problems

#### Detect Cycle in Undirected Graph
```java
boolean hasCycleDFS(int node, int parent, boolean[] visited, 
                    ArrayList<ArrayList<Integer>> adjList) {
    visited[node] = true;
    
    for (int neighbor : adjList.get(node)) {
        if (!visited[neighbor]) {
            if (hasCycleDFS(neighbor, node, visited, adjList)) {
                return true;
            }
        } else if (neighbor != parent) {
            return true;
        }
    }
    return false;
}
```

#### Detect Cycle in Directed Graph
```java
boolean hasCycleDFS(int node, boolean[] visited, boolean[] recStack,
                    ArrayList<ArrayList<Integer>> adjList) {
    visited[node] = true;
    recStack[node] = true;
    
    for (int neighbor : adjList.get(node)) {
        if (!visited[neighbor]) {
            if (hasCycleDFS(neighbor, visited, recStack, adjList)) {
                return true;
            }
        } else if (recStack[neighbor]) {
            return true;
        }
    }
    
    recStack[node] = false;
    return false;
}
```

#### Topological Sort
```java
void topologicalSortUtil(int node, boolean[] visited, Stack<Integer> stack,
                         ArrayList<ArrayList<Integer>> adjList) {
    visited[node] = true;
    
    for (int neighbor : adjList.get(node)) {
        if (!visited[neighbor]) {
            topologicalSortUtil(neighbor, visited, stack, adjList);
        }
    }
    
    stack.push(node);
}

ArrayList<Integer> topologicalSort(int n, ArrayList<ArrayList<Integer>> adjList) {
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            topologicalSortUtil(i, visited, stack, adjList);
        }
    }
    
    ArrayList<Integer> result = new ArrayList<>();
    while (!stack.isEmpty()) {
        result.add(stack.pop());
    }
    return result;
}
```

---

## Quick Reference Table

| Data Structure | Access | Search | Insert | Delete | Space |
|---------------|--------|--------|--------|--------|-------|
| Array | O(1) | O(n) | O(n) | O(n) | O(n) |
| Linked List | O(n) | O(n) | O(1) | O(1) | O(n) |
| Stack | O(n) | O(n) | O(1) | O(1) | O(n) |
| Queue | O(n) | O(n) | O(1) | O(1) | O(n) |
| HashMap | - | O(1) avg | O(1) avg | O(1) avg | O(n) |
| HashSet | - | O(1) avg | O(1) avg | O(1) avg | O(n) |
| Binary Tree | O(n) | O(n) | O(n) | O(n) | O(n) |
| BST (balanced) | O(log n) | O(log n) | O(log n) | O(log n) | O(n) |
| Graph (Adj List) | - | O(V+E) | O(1) | O(E) | O(V+E) |
| Graph (Adj Matrix) | O(1) | O(V) | O(1) | O(1) | O(V²) |

| Algorithm | Best | Average | Worst | Space |
|-----------|------|---------|-------|-------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| Linear Search | O(1) | O(n) | O(n) | O(1) |
| DFS | O(V+E) | O(V+E) | O(V+E) | O(V) |
| BFS | O(V+E) | O(V+E) | O(V+E) | O(V) |
| Dijkstra's | O((V+E) log V) | O((V+E) log V) | O((V+E) log V) | O(V) |
| Bellman-Ford | O(VE) | O(VE) | O(VE) | O(V) |
| A* | O(b^d) | O(b^d) | O(b^d) | O(b^d) |