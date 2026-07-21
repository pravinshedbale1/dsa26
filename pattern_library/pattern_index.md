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
| 11 | "At most K distinct elements" | Sliding window + HashMap<value,count>; shrink when map.size() > K; remove key entirely at count 0 (not just decrement) so size() stays accurate | **Window + HashMap** | `map.put(v,cnt+1); while (map.size()>k) { if (map.get(left)==1) remove; else decrement; left++; }` (proven Jul 14 — Fruit Into Baskets) |
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
| 36 | "Find all quadruplets summing to target" | Sort + fix 2 outer loops + two pointers inner. Generalize kSum: fix (k-2) + 2ptr. Watch for int overflow → use long | **Sort + Fix Two + Two Pointers (kSum)** | `for i { for j { k=j+1, l=n-1; while (k<l) }}` |
| 37 | "Minimum boats/pairs to carry all with weight limit" | Sort + greedy pair heaviest with lightest. Heaviest always needs a slot; lightest joins if fits | **Sort + Greedy Two Pointers (Pairing)** | `sort; l=0, r=n-1; if (a[l]+a[r]<=limit) l++; r--; boats++` |
| 38 | "Smallest window in s containing all chars of t (with counts)" | Variable window + need/window freq maps + formed/required counters (avoids full map comparison every step) | **Sliding Window + Need/Formed Counter** | `need` from t; `formed++` when `window[c]==need[c]` (exact); shrink while `formed==required`, `formed--` when `window[c]<need[c]` (strict) |
| 39 | "Longest substring of one letter after replacing at most k chars" | Variable window; replacements needed = windowSize - maxFreq(letter). Valid when <= k. Stale maxFreq is harmless — result only grows | **Sliding Window + Max Frequency** | `maxFreq = max(maxFreq, ++freq[right]); if (windowSize - maxFreq > k) { freq[left]--; left++; }` |
| 40 | "Longest subarray/substring with at most K distinct values" | Variable window + HashMap\<value,count\>; shrink while map.size() > K; remove key entirely at count 0 | **Sliding Window + At-Most-K-Distinct** | `map.merge(v,1,Integer::sum); while (map.size()>k) { if(map.get(l)==1) map.remove(l); else map.merge(l,-1,Integer::sum); l++; }` |
| 41 | "Longest run of 1s after flipping at most k 0s" | Variable window; specialization of Max Frequency trick to a 2-value alphabet — track zeroCount directly instead of windowSize-maxFreq | **Sliding Window + Zero Count** | `if (nums[right]==0) zeroCount++; if (zeroCount > k) { if (nums[left]==0) zeroCount--; left++; }` |
| 42 | "Count subarrays with EXACTLY K distinct values" | Can't count "exactly" with one window (no threshold). Compose: exactly(K) = atMost(K) - atMost(K-1). atMost(K) = At-Most-K-Distinct shrink loop, but SUM (right-left+1) each step instead of tracking a max — every window ending at right down to `left` is valid too | **Exactly-K Trick** | `atMostKDistinct(nums,k) - atMostKDistinct(nums,k-1)`; inside helper: `count += right - left + 1` |
| 43 | "Max (or min) of every window of size k" | Decreasing deque of indices — new element evicts smaller-and-older ones from the back (they can never win again); front expires when out of window; front = window max in O(1). Amortized O(n): each index pushed once, popped ≤ once | **Fixed Window + Monotonic Deque** | `if (front <= right-k) pollFirst(); while (nums[peekLast()] < nums[right]) pollLast(); offerLast(right); ans[right-k+1] = nums[peekFirst()]` |
| 44 | "Count subarrays where product/sum meets a threshold" (positive elements) | Variable window; shrink while invalid; every window ending at right is valid down to left → add (right-left+1) each step, don't just track a max | **Sliding Window — Count Subarrays** | `product *= nums[right]; while (product >= k) { product /= nums[left]; left++; } count += right-left+1;` |
| 45 | "Remove elements from BOTH ends to hit an exact target" | Reframe: what's left over after removing a prefix+suffix is one contiguous middle slice. Find the LONGEST subarray summing to (total - target) via a normal variable window; answer = n - longestWindow | **Reframe as Longest-Subarray Window** | `target = total - x; expand/shrink to find sum == target; return n - maxLen (or -1)` |
| 46 | "Design a stack/structure with O(1) getMin/getMax" | Auxiliary stack running in parallel: push the new value if it's a new min, else repeat the current min (use >=, not >, so ties repeat too); pop both together so they never desync | **Auxiliary Stack (Running Min/Max)** | `if (minStack.isEmpty() \|\| minStack.peek() >= v) minStack.push(v); stack.push(v);` |

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
