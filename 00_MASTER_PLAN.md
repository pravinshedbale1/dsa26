# 🗺️ DSA MASTERY — 17-WEEK MASTER PLAN (120 DAYS)

> **June 15, 2026 → October 11, 2026** | 119 Days | ~220-250 Problems
> **Goal**: Identify patterns, think brute → better → optimal, implement clean code, solve any unseen hard.
>
> ⚠️ _Plan reset on June 15, 2026. 7 prior problems (Two Sum, Contains Duplicate, Valid Anagram, Group Anagrams, Top K Frequent, Two Sum II, Product of Array Except Self) are kept as prior knowledge._

---

## How Each Session Works

### 📚 Phase A — Learn & Prepare (relaxed, collaborative)

```
1. ⏰ Spaced Repetition Check (5 min)
   └─ Quick recall of due problems — just pattern + approach, no full code

2. 🧠 Concept Teaching (if needed)
   └─ If the problem requires a new data structure or concept → teach it FIRST
   └─ Collaborative, relaxed — ask questions, build understanding
   └─ This is NOT the interview yet — this is preparation
```

### 🔴 Phase B — Interview Simulation (REAL PRESSURE)

> **⚠️ Once we enter Phase B, I become your interviewer. This is a REAL interview.**
> You are sitting across from a senior engineer at a top tech company.
> The clock is ticking. Every second of silence is noticed.

```
3. 🎯 Problem Drop (the interview begins)
   └─ I state the problem exactly as an interviewer would — concise, no hints
   └─ I give you 1-2 examples and constraints
   └─ ⏱️ TIMER STARTS NOW — you have a time limit:
       • Easy: 15 minutes
       • Medium: 25 minutes  
       • Hard: 40 minutes
   └─ I will remind you of time at 50% and 75% elapsed

4. 🗣️ Clarifying Questions (you drive this)
   └─ A good candidate asks clarifying questions BEFORE coding
   └─ If you jump straight to code → I'll note: "Are you sure you understand the problem fully?"
   └─ I answer your questions briefly, like a real interviewer would

5. 💪 Approach Discussion (think out loud)
   └─ "Walk me through your approach before you start coding"
   └─ I expect: brute force idea → why it's suboptimal → better approach
   └─ If you're silent too long → "What are you thinking?"
   └─ If you're stuck → I give ONE nudge, not the answer
   └─ If still stuck → I give a slightly bigger hint, but note it as an assist
   └─ INTERVIEWER PROBES:
       • "What's the time complexity of that?"
       • "Can you do better?"
       • "What if the input is 10^6 elements?"
       • "Why did you choose that data structure?"

6. 💻 Implementation (code under pressure)
   └─ FIRST: I create the Java file with class, method stub, and driver code (5 test cases)
   └─ You fill in ONLY the method body — everything else is ready
   └─ I watch your code as you write it:
       • If I see a bug forming → I stay SILENT (like a real interviewer)
       • If you ask "does this look right?" → "What do you think? Walk me through it"
       • I may ask mid-code: "What happens if the array is empty?"
   └─ After completion: run with `javac && java -ea` to verify
   └─ If tests fail → "Looks like some cases failed. Can you debug it?"
       • You get 3-5 minutes to debug — clock is still running

7. 🔍 Dry Run (interviewer asks you to trace)
   └─ "Walk me through your code with this input: [specific example]"
   └─ I expect step-by-step variable tracking
   └─ If you handwave → "Be more specific. What's the value of i at this point?"

8. ⚠️ Edge Cases (interviewer probes for thoroughness)
   └─ "What edge cases should we test?"
   └─ If you miss obvious ones → I'll ask pointed questions:
       • "What if the input is empty?"
       • "What about negative numbers?"
       • "What if all elements are the same?"
   └─ A great candidate proactively identifies edge cases

9. ⏱️ TIME CALLED — Interview Performance Summary
   └─ 🟢 HIRE / 🟡 LEAN HIRE / 🟠 LEAN NO HIRE / 🔴 NO HIRE
   └─ Scoring:
       • Approach clarity (did you think out loud?)
       • Solution correctness (did tests pass first try?)
       • Code quality (clean variable names, no dead code?)
       • Time management (finished within limit?)
       • Edge case awareness (did you identify them proactively?)
       • Communication (did you explain your thinking?)
       • Hints used (0 = great, 1 = okay, 2+ = needs work)
```

### 📦 Phase C — Debrief & Learn (relaxed again)

```
10. 📦 Pattern Extraction
    └─ "This problem taught us the _____ pattern"
    └─ When will you see this again?

11. 📝 State Update
    └─ Update CONVERSATION_STATE.md
    └─ Create/update flashcard
    └─ Add to spaced repetition
```

### 🎭 Interview Pressure Rules (NON-NEGOTIABLE)

```
• I do NOT give away the answer — ever. I nudge, I probe, I wait.
• If you're struggling, I give at most 2 hints. After that: "Let's move on and revisit."
• I track hints given per problem and note them in the session log.
• I use intentional silence — if you stop talking, I wait 10+ seconds before prompting.
• I ask follow-up questions that a real interviewer would:
    - "Can you optimize this further?"
    - "What if memory is constrained?"
    - "How would you test this?"
    - "What's the worst case?"
• I give a HIRE/NO-HIRE rating after every problem — this is your feedback loop.
• The goal is NOT to make you feel bad — it's to build pressure tolerance
  so the real interview feels EASY by comparison.
```

---

## ⚙️ Daily Structure

| Activity | Time | Description |
|----------|------|-------------|
| **Spaced Repetition** | 5-10 min | Review due problems (pattern + approach recall) |
| **New Problems** | 60-90 min | 2-3 problems with full interview simulation |
| **Code Practice** | 20-30 min | Re-implement a solved problem from scratch without looking |
| **Flashcard Review** | 5 min | Quick look at whiteboard notes |

---

# 🟢 PHASE 1 — FOUNDATION & PATTERN RECOGNITION (Weeks 1-6)

> **Goal**: Master the fundamental patterns. Solve any Easy instantly, most Mediums comfortably.
> **Focus**: Build pattern recognition muscle + overcome code implementation gap.

---

## Week 1: Arrays & Hashing (June 15 – June 21)

### Core Concepts to Master
- Arrays: memory layout, indexing, traversal, in-place modification
- HashMap: how hashing works, collision handling, O(1) average lookup
- HashSet: uniqueness checking, set operations
- Frequency counting pattern

### Problem Progression

| Day | Problem | Difficulty | Pattern | Approach Focus | Status |
|-----|---------|-----------|---------|---------------|--------|
| D1 | **Two Sum** (LC #1) | Easy | HashMap complement | Brute O(n²) → HashMap O(n) | 💾 Pre-plan |
| D1 | **Contains Duplicate** (LC #217) | Easy | HashSet | Sort O(n log n) → HashSet O(n) | 💾 Pre-plan |
| D2 | **Valid Anagram** (LC #242) | Easy | Frequency array | Sort → Frequency count (int[26]) | 💾 Pre-plan |
| D2 | **Two Sum II (Sorted)** (LC #167) | Medium | Two pointers on sorted | Binary search → Two pointers | 💾 Pre-plan |
| D3 | **Group Anagrams** (LC #49) | Medium | HashMap with sorted key | Brute → Sorted string key → Char count key | 💾 Pre-plan |
| D3 | **Top K Frequent Elements** (LC #347) | Medium | HashMap + Heap/Bucket | Sort O(n log n) → Heap O(n log k) → Bucket O(n) | 💾 Pre-plan |
| D4 | **Product of Array Except Self** (LC #238) | Medium | Prefix/Suffix | Division O(n) → Prefix+Suffix O(n) no division | 💾 Pre-plan |
| D4 | **Longest Consecutive Sequence** (LC #128) | Medium | HashSet + sequence start | Sort O(n log n) → HashSet O(n) | |
| D5 | **Encode and Decode Strings** (LC #271) | Medium | Delimiter design | Length-prefix encoding | |
| D5 | **Valid Sudoku** (LC #36) | Medium | HashSet per row/col/box | Brute → Single pass with 3 HashSets | |
| D6 | **Subarray Sum Equals K** (LC #560) | Medium | Prefix sum + HashMap | Brute O(n²) → Prefix sum HashMap O(n) | |
| D6 | Review + weak problem re-solve | — | — | Spaced repetition of D1-D5 | |
| D7 | **🔥 Weekly Challenge**: Solve 2 unseen problems using only patterns learned | — | — | Pattern recognition test | |

### Week 1 Implementation Templates
- HashMap complement lookup
- Frequency counting (int[] vs HashMap)
- Prefix sum technique

---

## Week 2: Two Pointers & Sorting (June 22 – June 28)

### Core Concepts to Master
- Two pointer technique: opposite ends, same direction
- Sorting as a preprocessing step
- Partitioning (Dutch National Flag)
- In-place array manipulation

### Problem Progression

| Day | Problem | Difficulty | Pattern | Approach Focus |
|-----|---------|-----------|---------|---------------|
| D1 | **Valid Palindrome** (LC #125) | Easy | Two pointers inward | Clean char handling + two pointers |
| D1 | **Two Sum II** (LC #167) | Medium | Sorted + two pointers | Why two pointers work on sorted data |
| D2 | **3Sum** (LC #15) | Medium | Sort + fix one + two pointers | Brute O(n³) → Sort + 2ptr O(n²) + skip duplicates |
| D2 | **Container With Most Water** (LC #11) | Medium | Greedy two pointers | Brute O(n²) → Greedy shrink shorter side O(n) |
| D3 | **Trapping Rain Water** (LC #42) | Hard | Two pointers / prefix max | Brute O(n²) → Prefix arrays O(n) → Two ptr O(n)/O(1) |
| D3 | **Move Zeroes** (LC #283) | Easy | Partition / write pointer | Two pass → Single pass write pointer |
| D4 | **Sort Colors** (LC #75) | Medium | Dutch National Flag | Count sort → 3-way partition O(n) |
| D4 | **Remove Duplicates from Sorted Array** (LC #26) | Easy | Slow/fast write pointer | In-place with write pointer |
| D5 | **4Sum** (LC #18) | Medium | Sort + fix two + two pointers | Extend 3Sum pattern |
| D5 | **Boats to Save People** (LC #881) | Medium | Sort + greedy two pointers | Greedy pair heaviest with lightest |
| D6 | Review + re-solve struggles | — | — | Spaced repetition W1 + W2 |
| D7 | **🔥 Weekly Challenge**: 2 unseen two-pointer problems | — | — | — |

---

## Week 3: Sliding Window (June 29 – July 5)

### Core Concepts to Master
- Fixed-size window
- Variable-size window (expand/shrink)
- Window with HashMap/frequency tracking
- When sliding window vs two pointers

### Problem Progression

| Day | Problem | Difficulty | Pattern | Approach Focus |
|-----|---------|-----------|---------|---------------|
| D1 | **Maximum Sum Subarray of Size K** | Easy | Fixed window | Brute O(n*k) → Sliding O(n) |
| D1 | **Longest Substring Without Repeating** (LC #3) | Medium | Variable window + HashSet | Brute O(n³) → Sliding + HashSet O(n) |
| D2 | **Minimum Size Subarray Sum** (LC #209) | Medium | Variable window shrink | Brute O(n²) → Expand/shrink O(n) |
| D2 | **Permutation in String** (LC #567) | Medium | Fixed window + freq match | Frequency array comparison |
| D3 | **Minimum Window Substring** (LC #76) | Hard | Variable window + freq | Classic hard sliding window |
| D3 | **Longest Repeating Character Replacement** (LC #424) | Medium | Variable window + max freq | Window validity: len - maxFreq <= k |
| D4 | **Fruit Into Baskets** (LC #904) | Medium | At most K distinct | HashMap tracking distinct count |
| D4 | **Max Consecutive Ones III** (LC #1004) | Medium | Variable window | At most K zeros flipped |
| D5 | **Subarrays with K Different Integers** (LC #992) | Hard | Exactly K = AtMost(K) - AtMost(K-1) | Advanced sliding window trick |
| D5 | **Sliding Window Maximum** (LC #239) | Hard | Monotonic deque | Deque maintaining decreasing order |
| D6 | Review + W1-W2 spaced repetition | — | — | — |
| D7 | **🔥 Weekly Challenge**: 2 unseen sliding window problems | — | — | — |

---

## Week 4: Stack & Queue (July 6 – July 12)

### Core Concepts to Master
- Stack for matching/nesting problems
- Monotonic stack (next greater/smaller element)
- Queue for BFS-like processing
- Stack to simulate recursion

### Problem Progression

| Day | Problem | Difficulty | Pattern | Approach Focus |
|-----|---------|-----------|---------|---------------|
| D1 | **Valid Parentheses** (LC #20) | Easy | Stack for matching | Push open, pop on close, check match |
| D1 | **Min Stack** (LC #155) | Medium | Auxiliary stack for min | Two stacks / store pairs |
| D2 | **Evaluate Reverse Polish Notation** (LC #150) | Medium | Stack for expression eval | Operand push, operator pop-2 |
| D2 | **Daily Temperatures** (LC #739) | Medium | Monotonic decreasing stack | Stack stores indices, pop when warmer found |
| D3 | **Next Greater Element I** (LC #496) | Easy | Monotonic stack + HashMap | Build next-greater map |
| D3 | **Largest Rectangle in Histogram** (LC #84) | Hard | Monotonic increasing stack | Stack for left/right boundaries |
| D4 | **Car Fleet** (LC #853) | Medium | Stack + sorting | Sort by position, merge by time |
| D4 | **Implement Queue using Stacks** (LC #232) | Easy | Two stacks | Amortized O(1) by lazy transfer |
| D5 | **Asteroid Collision** (LC #735) | Medium | Stack simulation | Handle collision rules on stack |
| D5 | **Maximal Rectangle** (LC #85) | Hard | Histogram per row + monotonic stack | Build heights → largest rectangle |
| D6 | Review + spaced repetition | — | — | — |
| D7 | **🔥 Weekly Challenge** | — | — | — |

---

## Week 5: Linked List (July 13 – July 19)

### Core Concepts to Master
- Singly vs doubly linked list
- Pointer manipulation (prev, curr, next)
- Fast/slow pointer technique (Floyd's)
- Dummy node trick
- In-place reversal

### Problem Progression

| Day | Problem | Difficulty | Pattern | Approach Focus |
|-----|---------|-----------|---------|---------------|
| D1 | **Reverse Linked List** (LC #206) | Easy | Iterative 3-pointer | prev/curr/next manipulation |
| D1 | **Merge Two Sorted Lists** (LC #21) | Easy | Dummy node + merge | Compare and link |
| D2 | **Linked List Cycle** (LC #141) | Easy | Fast/slow pointers | Floyd's cycle detection |
| D2 | **Linked List Cycle II** (LC #142) | Medium | Floyd's + phase 2 | Find cycle start |
| D3 | **Remove Nth Node From End** (LC #19) | Medium | Two pointers with gap | Advance fast N steps first |
| D3 | **Reorder List** (LC #143) | Medium | Find mid + reverse + merge | Combines 3 patterns |
| D4 | **Merge K Sorted Lists** (LC #23) | Hard | Min-heap / divide & conquer | Priority queue of K heads |
| D4 | **Copy List with Random Pointer** (LC #138) | Medium | HashMap clone / interleave | Old→New mapping |
| D5 | **LRU Cache** (LC #146) | Medium | HashMap + Doubly Linked List | O(1) get and put |
| D5 | **Add Two Numbers** (LC #2) | Medium | Carry arithmetic | Digit-by-digit with carry |
| D6 | Review + spaced repetition | — | — | — |
| D7 | **🔥 Weekly Challenge** | — | — | — |

---

## Week 6: Binary Search (July 20 – July 26)

### Core Concepts to Master
- Classic binary search (exact match)
- Binary search on answer space
- Binary search on rotated arrays
- Upper bound / lower bound (bisect)
- Search space reduction

### Problem Progression

| Day | Problem | Difficulty | Pattern | Approach Focus |
|-----|---------|-----------|---------|---------------|
| D1 | **Binary Search** (LC #704) | Easy | Classic template | lo, hi, mid — exact match |
| D1 | **Search Insert Position** (LC #35) | Easy | Lower bound | Where would target go? |
| D2 | **Search in Rotated Sorted Array** (LC #33) | Medium | Modified binary search | Identify sorted half first |
| D2 | **Find Minimum in Rotated Sorted** (LC #153) | Medium | Binary search for pivot | Compare mid with hi |
| D3 | **Koko Eating Bananas** (LC #875) | Medium | Binary search on answer | Predicate: canFinish(speed) |
| D3 | **Search a 2D Matrix** (LC #74) | Medium | Flatten to 1D binary search | row = mid/cols, col = mid%cols |
| D4 | **Time Based Key-Value Store** (LC #981) | Medium | Binary search on timestamps | Floor search |
| D4 | **Find Peak Element** (LC #162) | Medium | Binary search on unsorted | Move toward increasing side |
| D5 | **Median of Two Sorted Arrays** (LC #4) | Hard | Binary search on partition | Partition such that left ≤ right |
| D5 | **Split Array Largest Sum** (LC #410) | Hard | Binary search on answer | canSplit(maxSum, m) |
| D6 | **🎯 PHASE 1 CHECKPOINT** | — | — | Solve 5 mixed unseen problems (timed 15 min each) |
| D7 | Review all Phase 1 patterns + update confidence | — | — | Update CONVERSATION_STATE |

---

# 🟡 PHASE 2 — ADVANCED PATTERNS & TREES/GRAPHS (Weeks 7-12)

> **Goal**: Master tree/graph patterns, heap, and backtracking. Handle most Mediums under 20 min.

---

## Week 7: Binary Trees — DFS (July 27 – August 2)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Invert Binary Tree** (LC #226) + **Maximum Depth** (LC #104) | Easy | Recursive DFS |
| D2 | **Same Tree** (LC #100) + **Subtree of Another Tree** (LC #572) | Easy/Med | Compare trees recursively |
| D3 | **Diameter of Binary Tree** (LC #543) + **Balanced Binary Tree** (LC #110) | Easy/Med | Height + diameter relationship |
| D4 | **Lowest Common Ancestor** (LC #236) + **Path Sum** (LC #112) | Med | Recursive LCA, root-to-leaf |
| D5 | **Binary Tree Maximum Path Sum** (LC #124) + **Count Good Nodes** (LC #1448) | Hard/Med | Global max with DFS |
| D6 | Review + spaced repetition | — | — |
| D7 | Weekly challenge | — | — |

## Week 8: Binary Trees — BFS + BST (August 3 – August 9)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Level Order Traversal** (LC #102) + **Right Side View** (LC #199) | Med | BFS with queue |
| D2 | **Zigzag Level Order** (LC #103) + **Average of Levels** (LC #637) | Med/Easy | BFS variations |
| D3 | **Validate BST** (LC #98) + **Kth Smallest in BST** (LC #230) | Med | Inorder = sorted |
| D4 | **Serialize/Deserialize BT** (LC #297) + **Construct BT from Preorder+Inorder** (LC #105) | Hard/Med | Tree serialization |
| D5 | **BST Iterator** (LC #173) + **Lowest Common Ancestor of BST** (LC #235) | Med/Med | Controlled inorder, BST property |
| D6-D7 | Review + challenge | — | — |

## Week 9: Heap / Priority Queue (August 10 – August 16)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Kth Largest Element** (LC #215) + **Last Stone Weight** (LC #1046) | Med/Easy | Max heap, QuickSelect |
| D2 | **K Closest Points** (LC #973) + **Top K Frequent** (LC #347 revisit) | Med | Min-heap of size K |
| D3 | **Find Median from Data Stream** (LC #295) | Hard | Two-heap pattern |
| D4 | **Merge K Sorted Lists** (LC #23 revisit) + **Task Scheduler** (LC #621) | Hard/Med | K-way merge, greedy+heap |
| D5 | **Reorganize String** (LC #767) + **K Closest in Sorted Array** (LC #658) | Med | Greedy with heap |
| D6-D7 | Review + challenge | — | — |

## Week 10: Backtracking (August 17 – August 23)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Subsets** (LC #78) + **Subsets II** (LC #90) | Med | Include/exclude, skip duplicates |
| D2 | **Permutations** (LC #46) + **Permutations II** (LC #47) | Med | Swap-based, used[] array |
| D3 | **Combination Sum** (LC #39) + **Combination Sum II** (LC #40) | Med | Unbounded vs bounded, duplicates |
| D4 | **Word Search** (LC #79) + **Palindrome Partitioning** (LC #131) | Med | Grid backtracking, string partition |
| D5 | **N-Queens** (LC #51) + **Sudoku Solver** (LC #37) | Hard | Constraint satisfaction |
| D6-D7 | Review + challenge | — | — |

## Week 11: Graphs — BFS/DFS (August 24 – August 30)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Number of Islands** (LC #200) + **Clone Graph** (LC #133) | Med | Grid DFS, graph DFS+clone |
| D2 | **Pacific Atlantic Water Flow** (LC #417) + **Surrounded Regions** (LC #130) | Med | Multi-source BFS/DFS |
| D3 | **Course Schedule** (LC #207) + **Course Schedule II** (LC #210) | Med | Topological sort (Kahn's + DFS) |
| D4 | **Word Ladder** (LC #127) + **Rotting Oranges** (LC #994) | Hard/Med | BFS shortest path, multi-source BFS |
| D5 | **Accounts Merge** (LC #721) + **Graph Valid Tree** (LC #261) | Med | Union-Find applications |
| D6-D7 | Review + challenge | — | — |

## Week 12: Advanced Graphs + Union-Find (August 31 – September 6)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Network Delay Time** (LC #743) + **Cheapest Flights** (LC #787) | Med | Dijkstra, Bellman-Ford |
| D2 | **Swim in Rising Water** (LC #778) + **Path with Min Effort** (LC #1631) | Hard/Med | Binary search + BFS / Dijkstra |
| D3 | **Redundant Connection** (LC #684) + **Min Cost to Connect** (LC #1135) | Med | Union-Find, MST (Kruskal) |
| D4 | **Alien Dictionary** (LC #269) + **Longest Increasing Path** (LC #329) | Hard | Topo sort on chars, DFS+memo |
| D5 | **Critical Connections** (LC #1192) | Hard | Tarjan's (bridges) |
| D6 | **🎯 PHASE 2 CHECKPOINT** | — | Solve 5 mixed tree/graph/heap problems (timed) |
| D7 | Full review of Phase 1+2 patterns | — | — |

---

# 🔴 PHASE 3 — DP, HARD PATTERNS & INTERVIEW SIMULATION (Weeks 13-18)

> **Goal**: Master DP, tackle any Hard, and build interview-day muscle memory.

---

## Week 13: Dynamic Programming — 1D (September 7 – September 13)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Climbing Stairs** (LC #70) + **House Robber** (LC #198) | Easy/Med | Fibonacci-style DP |
| D2 | **House Robber II** (LC #213) + **Decode Ways** (LC #91) | Med | Circular DP, counting DP |
| D3 | **Coin Change** (LC #322) + **Coin Change 2** (LC #518) | Med | Min coins (unbounded), count ways |
| D4 | **Longest Increasing Subsequence** (LC #300) + **Word Break** (LC #139) | Med | LIS, substring DP |
| D5 | **Maximum Product Subarray** (LC #152) + **Partition Equal Subset Sum** (LC #416) | Med | Track min/max, 0/1 knapsack |
| D6-D7 | Review + challenge | — | — |

## Week 14: Dynamic Programming — 2D & Strings (September 14 – September 20)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Unique Paths** (LC #62) + **Minimum Path Sum** (LC #64) | Med | Grid DP |
| D2 | **Longest Common Subsequence** (LC #1143) + **Edit Distance** (LC #72) | Med/Hard | Two-string DP |
| D3 | **Longest Palindromic Substring** (LC #5) + **Palindromic Substrings** (LC #647) | Med | Expand around center / DP |
| D4 | **Interleaving String** (LC #97) + **Distinct Subsequences** (LC #115) | Hard | Two-string DP advanced |
| D5 | **Burst Balloons** (LC #312) + **Regular Expression Matching** (LC #10) | Hard | Interval DP, string matching DP |
| D6-D7 | Review + challenge | — | — |

## Week 15: Tries, Intervals & Greedy (September 21 – September 27)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **Implement Trie** (LC #208) + **Word Search II** (LC #212) | Med/Hard | Trie + DFS |
| D2 | **Design Add/Search Words** (LC #211) + **Longest Word in Dict** (LC #720) | Med | Trie with wildcards |
| D3 | **Merge Intervals** (LC #56) + **Insert Interval** (LC #57) | Med | Sort + merge |
| D4 | **Non-overlapping Intervals** (LC #435) + **Meeting Rooms II** (LC #253) | Med | Greedy interval, sweep line |
| D5 | **Jump Game** (LC #55) + **Jump Game II** (LC #45) + **Gas Station** (LC #134) | Med | Greedy proofs |
| D6-D7 | Review + challenge | — | — |

## Week 16: Advanced Mixed Problems (September 28 – October 4)

| Day | Problem | Difficulty | Pattern |
|-----|---------|-----------|---------|
| D1 | **LFU Cache** (LC #460) + **LRU Cache** (revisit) | Hard | Complex data structure |
| D2 | **Skyline Problem** (LC #218) + **Trapping Rain Water** (revisit) | Hard | Sweep line + heap |
| D3 | **Word Ladder II** (LC #126) + **Longest Valid Parentheses** (LC #32) | Hard | BFS+backtrack, stack DP |
| D4 | **Maximal Rectangle** (LC #85) + **Largest Rectangle** (revisit) | Hard | Stack combinations |
| D5 | Company-tagged hard problems (2-3 problems) | Hard | Mixed patterns |
| D6-D7 | Review + challenge | — | — |

## Week 17: Mock Interview Marathon + Final Polish (October 5 – October 11)

| Day | Focus |
|-----|-------|
| D1 | **Mock 1**: 2 problems (45 min each) — Any pattern, timed, explain aloud |
| D2 | **Mock 2**: 2 problems — Focus on weak patterns identified in state file |
| D3 | **Mock 3**: 2 hard problems — Full interview simulation with edge cases |
| D4 | **Mock 4**: Company-tagged problems (Google/Amazon/Meta style) |
| D5 | **Mock 5**: Speed round — 4 mediums in 60 minutes |
| D6 | **Mock 6**: Full interview day simulation — 2 coding rounds back to back |
| D7 | Review all mocks, identify final weak spots |

### Final Polish Days (Oct 8 – Oct 11)

| Day | Focus |
|-----|-------|
| D5 | **Weak Area Blitz**: Re-solve problems from the struggle log |
| D6 | **Speed Drills**: 3 mediums per hour, pattern recognition in <2 min |
| D7 | **Pattern Review**: Walk through entire pattern_index.md from memory |
| D8 | **Light review only** — Re-read flashcards, rest, build confidence |

---

## 📊 Milestone Checkpoints

| Date | Milestone | Success Criteria |
|------|-----------|-----------------
| Jun 21 (W1) | Arrays/Hashing solid | Solve any Easy <10 min, recognize HashMap patterns |
| Jul 26 (W6) | Phase 1 complete | All basic patterns known, Mediums <25 min, code from logic |
| Aug 23 (W10) | Backtracking + Trees done | Tree/graph medium <20 min, can write DFS/BFS from memory |
| Sep 6 (W12) | Phase 2 complete | All patterns covered, can approach any Hard |
| Sep 27 (W15) | DP + Advanced done | Solve DP mediums, recognize DP state/transition |
| Oct 4 (W16) | Advanced mixed done | Can tackle any Hard |
| **Oct 11 (W17)** | **🎯 INTERVIEW READY** | **Solve any unseen hard with optimal approach** |

---

## 📚 Spaced Repetition Rules

| Box | Review After | Promotion Criteria |
|-----|-------------|-------------------|
| **Box 1** (New) | 1 day | Solve correctly + explain pattern |
| **Box 2** (Learning) | 3 days | Solve correctly without hints |
| **Box 3** (Reviewing) | 1 week | Solve optimally + code from memory |
| **Box 4** (Familiar) | 2 weeks | Instant pattern recognition |
| **Box 5** (Mastered) | 1 month | Can teach this to someone else |

**Rule**: If you get a problem wrong or can't recall the approach → back to Box 1.
