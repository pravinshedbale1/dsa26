# 🏆 MASTER CHEATSHEET — Whiteboard Ready

> Print this. Pin it. Look at it every morning. This is your pattern DNA.

---

## 🔑 The 7 Golden Rules of Problem Solving

```
1. READ the problem twice. Underline constraints.
2. ASK clarifying questions (input size? sorted? duplicates? negative?)
3. THINK of 2-3 examples, including edge cases
4. BRUTE FORCE first — always. State its complexity.
5. OPTIMIZE — what's redundant? What data structure helps?
6. CODE — clean variable names, handle edges FIRST
7. DRY RUN — trace through your example step by step
```

---

## 🧠 Pattern Recognition — One-Liners

| # | Pattern | One-Line Trigger | Java Key Line |
|---|---------|-----------------|---------------|
| 1 | **HashMap Complement** | Need pair? Store & lookup complement | `map.getOrDefault(target-x, -1)` |
| 2 | **Frequency Count** | Count things | `map.merge(x, 1, Integer::sum)` |
| 3 | **Two Pointers** | Sorted + pair/triplet | `while (lo < hi)` |
| 4 | **Sliding Window (Fixed)** | Subarray of size K | `add right, remove left` |
| 5 | **Sliding Window (Variable)** | Longest/shortest subarray | `expand right, shrink left` |
| 6 | **Binary Search** | Sorted or monotonic predicate | `lo + (hi - lo) / 2` |
| 7 | **Monotonic Stack** | Next greater/smaller | `while (!stack.isEmpty() && stack.peek() < curr)` |
| 8 | **Fast/Slow Pointer** | Cycle? Middle? | `slow=next, fast=next.next` |
| 9 | **DFS** | Tree/graph depth-first | Recursion or explicit stack |
| 10 | **BFS** | Shortest path / level-order | Queue + visited |
| 11 | **Backtracking** | All combinations/permutations | `choose → explore → unchoose` |
| 12 | **Union-Find** | Groups / connectivity | `find(x)` with path compression |
| 13 | **Topo Sort** | Dependencies / ordering | Indegree + BFS (Kahn's) |
| 14 | **DP** | Overlapping subproblems | `dp[i] = f(dp[i-1], dp[i-2], ...)` |
| 15 | **Heap** | Top-K / streaming median | `PriorityQueue` |
| 16 | **Trie** | Prefix search / autocomplete | `TrieNode[] children = new TrieNode[26]` |

---

## ⚡ Complexity Cheat Sheet

```
O(1)        → HashMap lookup, array index
O(log n)    → Binary Search, balanced BST ops
O(n)        → Single pass, sliding window, two pointers
O(n log n)  → Sorting, heap of n elements
O(n²)       → Nested loops (brute force pairs)
O(2ⁿ)       → Subsets, recursive without memoization
O(n!)       → Permutations
```

---

## 🛡️ Edge Cases — ALWAYS Check

```
□ Empty input ([], "", null)
□ Single element
□ Two elements
□ All same values
□ Already sorted / reverse sorted
□ Negative numbers
□ Integer overflow (use long)
□ Duplicates
□ Very large input (10⁵ or 10⁶ — need O(n) or O(n log n))
```

---

## 💻 Code Implementation Tips

```java
// ✅ Binary Search — avoid overflow
int mid = lo + (hi - lo) / 2;  // NOT (lo + hi) / 2

// ✅ HashMap — safe get
map.getOrDefault(key, defaultValue);

// ✅ LinkedList — always use dummy node
ListNode dummy = new ListNode(0);
dummy.next = head;

// ✅ Tree — base case FIRST
if (root == null) return ...;

// ✅ Graph — check visited BEFORE processing
if (visited.contains(node)) return;
visited.add(node);

// ✅ Backtracking — add, recurse, remove
list.add(x);
backtrack(list, ...);
list.remove(list.size() - 1);

// ✅ DP — think about state and transition
// State: what changes? dp[i] = answer for first i elements
// Transition: dp[i] = Math.max(dp[i-1], dp[i-2] + val[i])
// Base: dp[0] = ..., dp[1] = ...
```

---

## 🚨 Interview Day Reminders

```
1. BREATHE. You've prepared for this.
2. Talk through your thinking — silence is deadly.
3. Start with brute force. It shows you understand the problem.
4. Ask: "Can I assume...?" for edge cases.
5. Write clean code, not clever code.
6. Test with a small example BEFORE saying "done".
7. If stuck, simplify the problem first.
```

---

_This cheatsheet grows as we learn new patterns. Updated weekly._
