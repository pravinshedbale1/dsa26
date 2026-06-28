# 🧩 PATTERN INDEX — "When You See X, Think Y"

> This is your **interview cheat sheet**. Before every problem, scan this table.
> As we cover new patterns, this grows. By Week 18, this is your ultimate weapon.

---

## Quick Pattern Lookup

| # | When You See... | Think... | Pattern Name | Template |
|---|----------------|----------|-------------|----------|
| 1 | "Find pair that sums to target" | Store complement in HashMap | **HashMap Complement** | `map.get(target - nums[i])` |
| 2 | "Check for duplicates" | HashSet for O(1) lookup | **HashSet Membership** | `set.add(x)` returns false if exists |
| 3 | "Count frequency of elements" | HashMap<element, count> or int[26] | **Frequency Count** | `map.merge(key, 1, Integer::sum)` |
| 4 | "Group elements by property" | HashMap<property, list> | **HashMap Grouping** | `map.computeIfAbsent(key, k -> new ArrayList<>()).add(val)` |
| 5 | "Find something in sorted array" | Binary search | **Binary Search** | `lo + (hi - lo) / 2` |
| 6 | "Minimum/maximum that satisfies condition" | Binary search on answer space | **Binary Search on Answer** | Define `canAchieve(mid)`, search [lo, hi] |
| 7 | "Sorted array + find pair/triplet" | Two pointers from both ends | **Two Pointers (Opposite)** | `left = 0, right = n-1` |
| 8 | "Remove/move elements in-place" | Slow/fast write pointer | **Two Pointers (Same Dir)** | `writePtr` advances only when condition met |
| 9 | "Contiguous subarray of fixed size" | Fixed sliding window | **Fixed Window** | Maintain sum, add right, remove left |
| 10 | "Longest/shortest subarray with condition" | Variable sliding window | **Variable Window** | Expand right, shrink left when invalid |
| 11 | "At most K distinct elements" | Sliding window + HashMap | **Window + HashMap** | Track counts, shrink when distinct > K |
| 12 | "Matching brackets / nesting" | Stack | **Stack Matching** | Push open, pop+check on close |
| 13 | "Next greater/smaller element" | Monotonic stack | **Monotonic Stack** | Stack stores indices in decreasing order |
| 14 | "Detect cycle in linked list" | Floyd's fast/slow pointers | **Fast/Slow Pointers** | `slow = slow.next, fast = fast.next.next` |
| 15 | "Reverse linked list" | 3-pointer technique | **Linked List Reversal** | `prev, curr, next` pointer dance |
| 16 | "Merge K sorted things" | Min-heap of size K | **K-Way Merge** | PriorityQueue with K heads |
| 17 | "Tree traversal" | DFS (pre/in/post) or BFS (level) | **Tree DFS/BFS** | Recursive DFS or Queue-based BFS |
| 18 | "Validate BST" | In-order traversal gives sorted | **BST Property** | `inorder(left) < root < inorder(right)` |
| 19 | "Top K / Kth largest" | Min-heap of size K or QuickSelect | **Top-K Pattern** | `PriorityQueue` size K |
| 20 | "Generate all combinations/subsets" | Backtracking: choose → explore → unchoose | **Backtracking** | Include/exclude at each step |
| 21 | "Connected components / reachability" | BFS/DFS from each unvisited | **Graph DFS/BFS** | `visited` set + adjacency list |
| 22 | "Prerequisites / ordering" | Topological sort | **Topological Sort** | Kahn's BFS (indegree) or DFS |
| 23 | "Dynamic groups / connectivity" | Union-Find | **Union-Find** | `find()` with path compression + `union()` by rank |
| 24 | "Overlapping subproblems + optimal substructure" | Dynamic Programming | **DP** | Define state → recurrence → base case |
| 25 | "Prefix lookup / autocomplete" | Trie | **Trie** | TrieNode with children[26] |
| 26 | "Overlapping intervals" | Sort by start + merge | **Interval Merge** | Compare curr.start with prev.end |
| 27 | "Longest consecutive sequence" in O(n) | HashSet + only count from starts | **Sequence Start Detection** | `if (!set.contains(n-1))` → count forward |
| 28 | "Encode/decode list of strings" with any chars | Prepend length + delimiter before each string | **Length-Prefix Encoding** | `len#string` — read length, then read exactly that many chars |
| 29 | "Validate grid rows/cols/boxes" for duplicates | HashSet per row, col, and box; box = (r/3)*3+(c/3) | **HashSet Validation** | `!rows[r].add(v) \|\| !cols[c].add(v) \|\| !boxes[idx].add(v)` |
| 30 | "Count subarrays with sum = K" | Prefix sum + HashMap\<sum, count\>; check if (currentSum - k) in map | **Prefix Sum + HashMap** | `map.put(0,1); if (map.containsKey(sum-k)) count += map.get(sum-k)` |
| 31 | "Longest subarray with equal X and Y" | Transform (0→-1, 1→1) + prefix sum; same sum at two indices = valid subarray | **Transform + Prefix Sum (Max Length)** | `map.put(0,-1); store FIRST occurrence only; maxLen = i - map.get(sum)` |
| 32 | "Maximum area/container between two lines" | Two pointers from ends, move the SHORTER side (shorter = bottleneck for area) | **Greedy Two Pointers (Max Area)** | `area = min(h[l], h[r]) * (r-l); move shorter side` |
| 33 | "How much water/rain trapped in elevation map" | Two pointers + track maxLeft/maxRight, process side with SMALLER max | **Two Pointers (Trapped Water)** | `water += max - height[ptr]; process side where max is smaller` |
| 34 | "Move/remove elements in-place, maintain order" | Write pointer (j) at 0, read pointer (i) scans; swap valid elements to j, advance j | **Two Pointers (Same Dir — Write Pointer)** | `if (nums[i] != 0) { swap(i, j); j++; }` |
| 35 | "Sort array with only 3 distinct values" | 3 pointers: lo, mid, hi. Mid scans. 0→swap lo, 1→skip, 2→swap hi. Don't advance mid after hi swap | **Dutch National Flag (3-Way Partition)** | `lo=0, mid=0, hi=n-1; route by nums[mid]` |

---

## Pattern Decision Tree

```
Is the input SORTED?
├── YES → Binary Search or Two Pointers
│   ├── Finding exact value? → Binary Search
│   ├── Finding pair? → Two Pointers (opposite ends)
│   └── Finding boundary/min-max? → Binary Search on Answer
│
├── NO but can SORT help?
│   ├── Need pairs/triplets? → Sort + Two Pointers
│   └── Need to group/merge? → Sort + process
│
└── NO, order matters
    ├── Contiguous subarray? → Sliding Window
    ├── Need pairs/lookups? → HashMap/HashSet
    ├── Nesting/matching? → Stack
    ├── Tree structure? → DFS/BFS
    ├── Graph connections? → BFS/DFS/Union-Find
    └── Optimal value? → DP or Greedy
```

---

## Complexity Quick Reference

| Pattern | Typical Time | Typical Space |
|---------|-------------|---------------|
| HashMap lookup | O(n) | O(n) |
| Two Pointers | O(n) | O(1) |
| Sliding Window | O(n) | O(k) |
| Binary Search | O(log n) | O(1) |
| Monotonic Stack | O(n) | O(n) |
| BFS/DFS (graph) | O(V + E) | O(V) |
| Topological Sort | O(V + E) | O(V) |
| Backtracking | O(2^n) or O(n!) | O(n) |
| DP (1D) | O(n) | O(n) → O(1) optimized |
| DP (2D) | O(n*m) | O(n*m) → O(n) optimized |
| Heap operations | O(n log k) | O(k) |
| Trie | O(L) per word | O(N*L) |

---

_This index grows as we learn. Every new pattern gets added here during our sessions._
