# 📖 Sliding Window — Concept Knowledge

> This file is populated through our conversations. Each section captures what you understood, not textbook definitions.

---

## Core Concept

### What is a Sliding Window?

A **sliding window** is a technique where you maintain a **subarray/substring** that moves across the input, processing elements as they enter and leave the window — avoiding redundant recomputation.

**The key idea**: instead of recomputing from scratch for every possible subarray (brute force O(n²) or O(n³)), you **reuse** the work from the previous window position by:
- **Adding** the new element entering the window (right side)
- **Removing** the element leaving the window (left side)

This transforms O(n²) brute force into O(n).

### The Mental Model

Think of it like a physical window sliding across a row of numbers:

```
Array: [2, 1, 5, 1, 3, 2]    Window size k=3

Step 1: [2, 1, 5] 1  3  2    sum = 8
Step 2:  2 [1, 5, 1] 3  2    sum = 8 - 2 + 1 = 7  (remove left, add right)
Step 3:  2  1 [5, 1, 3] 2    sum = 7 - 1 + 3 = 9
Step 4:  2  1  5 [1, 3, 2]   sum = 9 - 5 + 2 = 6
```

Notice: we never resum the entire window. We just **subtract** what leaves and **add** what enters.

---

## Two Types of Sliding Window

### 1. Fixed-Size Window

**When to use**: The problem specifies an exact window size (k).

**Template**:
```java
// Fixed window of size k
int windowSum = 0;

// Build the first window
for (int i = 0; i < k; i++) {
    windowSum += nums[i];
}
int maxSum = windowSum;

// Slide: remove left, add right
for (int i = k; i < nums.length; i++) {
    windowSum += nums[i];       // add new element entering window
    windowSum -= nums[i - k];   // remove element leaving window
    maxSum = Math.max(maxSum, windowSum);
}
```

**Key points**:
- Window always has exactly `k` elements
- Two phases: **build** first window, then **slide**
- Each slide: `+1 element` on right, `-1 element` on left
- Time: O(n), Space: O(1)

**Example problems**: Max Sum Subarray of Size K, Maximum Average Subarray

---

### 2. Variable-Size Window (Expand/Shrink)

**When to use**: You're looking for the **longest** or **shortest** subarray/substring that satisfies some condition.

**Template**:
```java
// Variable window — find longest/shortest subarray with condition
int left = 0;

for (int right = 0; right < n; right++) {
    // EXPAND: add nums[right] to window state

    while (/* window is INVALID */) {
        // SHRINK: remove nums[left] from window state
        left++;
    }

    // UPDATE: window [left, right] is valid — update answer
    // For LONGEST: maxLen = Math.max(maxLen, right - left + 1)
    // For SHORTEST: minLen = Math.min(minLen, right - left + 1)
}
```

**Key points**:
- `right` pointer always moves forward (expands window)
- `left` pointer moves forward only when window becomes **invalid** (shrinks window)
- The window `[left, right]` is always valid after the shrink loop
- Time: O(n) — each element is added and removed at most once
- **Longest**: update answer AFTER shrinking (when window is valid)
- **Shortest**: update answer INSIDE shrink loop (when window just becomes valid) or right after condition check

**Example problems**: Longest Substring Without Repeating Characters, Minimum Size Subarray Sum, Minimum Window Substring

---

## When Sliding Window vs Two Pointers?

This is a critical distinction that often confuses people:

| Feature | Sliding Window | Two Pointers (Opposite Ends) |
|---------|---------------|------------------------------|
| **Direction** | Both pointers move LEFT → RIGHT | Pointers move TOWARD each other |
| **What they define** | A contiguous subarray [left, right] | Two positions being compared |
| **Input sorted?** | Usually NOT required | Often requires sorted input |
| **Problem type** | "Find subarray/substring with property X" | "Find pair/triplet with property X" |
| **Example** | Longest substring without repeating | Two Sum II, Container With Most Water |

**Rule of thumb**: 
- If the problem asks about a **contiguous subarray or substring** → think Sliding Window
- If the problem has **sorted input** and asks about **pairs** → think Two Pointers

---

## Window State Tracking

Different problems require different ways to track what's in the window:

| Tracking Method | When to Use | Example |
|----------------|-------------|---------|
| **Running sum** (int) | Sum-based windows | Max Sum Subarray of Size K |
| **HashSet** | Uniqueness constraint | Longest Substring Without Repeating |
| **HashMap (char → count)** | Frequency tracking | Minimum Window Substring, Permutation in String |
| **int[26] or int[128]** | Fixed charset frequency | Permutation in String (optimized) |
| **Counter variable** | "At most K distinct" windows | Fruit Into Baskets, Subarrays with K Different Integers |

---

## Amortized O(n) — Why Sliding Window is Linear

Even though there's a `while` loop inside the `for` loop, the total work is O(n):
- `right` moves from 0 to n-1: **n increments total**
- `left` also moves from 0 to at most n-1: **at most n increments total**
- Each element is visited at most **twice** (once by right, once by left)
- Total: O(2n) = O(n)

This is the same amortized reasoning as Longest Consecutive Sequence!

---

## Common Mistakes (Your Struggle Log)

| Date | Mistake | Fix |
|------|---------|-----|
| Jul 13 | Permutation in String: rebuilt freq array from scratch at each window position (O(m·k)) | Maintain RUNNING freq array — add right char, remove left char. Same as running sum in fixed window. |
| Jul 13 | Min Size Subarray: used `target` instead of `minLength` in Math.min() (typo) | Double-check variable names in Math.min/max calls. Self-caught. |
| Jul 13 | Initially said "update answer during expanding" for shortest window | SHORTEST → update during SHRINKING. LONGEST → update during EXPANDING. |
| Jul 14 | Longest Repeating Char Replacement: could execute the optimal template correctly but needed 2 nudges to explain why a stale `maxFreq` can't cause a wrong answer | Drill the invariant explicitly next time: `result` is monotonic non-decreasing, so staleness can only cause coasting at an already-earned length, never inflate the answer |
| Jul 20 | Subarrays with K Distinct re-solve: moved `right++` before `ans += right-left+1` in `atMostKDistinct` — overcounts every call by exactly `nums.length`. All 5 driver tests still passed. | When a helper is only ever used inside `f(a) - f(b)`, an identical systematic bug in both calls cancels out and is invisible to tests on the composed result. Always trace/assert the helper in isolation, not just the composition. |

---

## Key Insights (Aha! Moments)

1. **Running freq array = running sum for frequencies** — just like you don't resum all k elements, don't rebuild the freq array. Add/remove as window slides.
2. **LONGEST vs SHORTEST update timing** — Longest updates when window is valid (expanding). Shortest updates when window is still valid during shrinking.
3. **Integer.MAX_VALUE for min-finding** — standard init. If unchanged → no valid window found → return 0.
4. **Arrays.equals(int[], int[])** — O(26) = O(1) for fixed charset comparison. Clean alternative to manual loop.
5. **Amortized O(n)** — same reasoning across all variable windows: each element enters/leaves at most once.
6. **need/formed counter (Jul 14, Minimum Window Substring)** — instead of comparing two full frequency maps every window position, track a running counter of how many distinct chars are currently satisfied (`formed`) vs how many need to be (`required`). Window is valid when `formed == required`.
7. **Exact equality on the way up, strict inequality on the way down** — bump `formed` only when `window[c]` first reaches `need[c]` (`==`), drop it only when `window[c]` first falls below (`<`). Using `>=`/`<=` instead re-triggers on every subsequent add/remove of an already-(un)satisfied char, inflating/deflating the counter incorrectly. Same transition-moment logic as Arrays.equals() timing in Permutation in String, generalized to counters.
8. **HashMap → int[128] when charset is bounded ASCII letters** — same optimization as Permutation in String's int[26], just wider range to cover upper+lower case.
9. **Stale maxFreq is harmless (Jul 14, Longest Repeating Character Replacement)** — replacements needed to make a window one repeated letter = `windowSize - maxFreq`. Track `maxFreq` as a running high-water mark (`Math.max`, never decremented on shrink). When invalid, shift left by exactly 1 (`if`, not `while`) — window length only ever grows or holds steady, never shrinks. Because `result = Math.max(result, windowSize)` is monotonic non-decreasing, a stale `maxFreq` (no longer the true max of the current window's contents) can only make the window coast at a length already bagged — it can never inflate `result` beyond what was genuinely achieved earlier. The algorithm isn't verifying "is this window valid right now" — it's only detecting "has a strictly bigger window become possible," which requires a genuine frequency increase.
10. **HashMap.size() as the distinct-count proxy (Jul 14, Fruit Into Baskets)** — "at most K distinct values" just means shrink while `map.size() > K`. The gotcha: when a count hits 0 during shrinking, you must `remove()` the key, not just leave it at 0 — an entry with count 0 still counts toward `map.size()`, which would make the window look like it has more distinct values than it actually does and corrupt the shrink condition. Same family as Longest Substring Without Repeating (HashSet) and Minimum Window Substring (need/formed) — different data structure, same "make the validity check O(1) instead of recomputing distinctness from scratch" idea.
11. **Max-frequency trick specialized to a binary alphabet (Jul 16, Max Consecutive Ones III)** — LRCR's `windowSize - maxFreq <= k` generalizes over any alphabet size. With only 2 possible values (0/1), "flip the minority element" is always "flip the 0s," so the max-over-26-letters computation collapses to a single `zeroCount` counter — no frequency array needed. Also: since at most one zero enters the window per iteration of the outer loop, `if` and `while` are provably identical for the shrink step (never more than one shrink needed) — a good instance of "prove the loop bound instead of defaulting to `while` out of habit."
12. **Counting all valid windows, not just the widest (Jul 17, Subarrays with K Different Integers)** — At-Most-K-Distinct's shrink loop finds, for each `right`, the smallest `left` such that `[left,right]` is valid. The new insight: every `[left', right]` for `left' = left..right` is *also* valid, since moving left further only removes elements (can't raise distinct count). So instead of `max(result, right-left+1)` (Fruit Into Baskets — find the longest), sum `right-left+1` (find the count of all valid windows ending at right). Same shrink mechanic, different accumulation turns a "longest" template into a "count" template. Combined with `exactly(K) = atMost(K) - atMost(K-1)` (set subtraction: ≤K minus ≤K-1 leaves precisely =K), this composes into the exactly-K trick without needing a fundamentally new window mechanic.

13. **Monotonic Deque for window max/min (Jul 18, Sliding Window Maximum)** — first new *data structure* of Week 3. Deque (double-ended queue, `ArrayDeque` in Java) of **indices** kept in decreasing value order front→back, so the front is always the current window's max in O(1). Two eviction rules, one per end: (a) BACK — before pushing index `right`, pop every index whose value ≤ the newcomer ("younger and taller": the newcomer is at least as big AND stays in the window longer, so the older-smaller ones can never be a window max again — note BOTH conditions are required; smaller-but-newer elements survive because they outlive the front); (b) FRONT — pop when the front index slides out of `[right-k+1, right]`; an `if` suffices since the window advances one step per iteration. Amortized O(n): each index pushed once, popped at most once — same argument as variable-window shrink loops and Longest Consecutive Sequence. Space is bounded by the window size, **O(k)**, not O(n) — the deque can never hold more than k indices even in the worst case (fully decreasing array); O(n) is only a valid bound in the coincidental case k==n, not the tight one.

14. **Composition bugs that cancel out (Jul 20, Subarrays with K Distinct re-solve)** — when a solution is structured as `f(a) - f(b)` (e.g., `exactly(K) = atMost(K) - atMost(K-1)`), a systematic off-by-one bug *inside* `f` that adds the same constant to every call is invisible in the subtracted result — it cancels. Concretely: moving the count-accumulation line to after `right++` instead of before makes every `atMostKDistinct(nums, k)` call return `trueValue + nums.length`, and since both `atMost(K)` and `atMost(K-1)` get the same `+ n` inflation, the difference is still correct. All driver tests (which only exercise the composed `exactly(K)`) pass despite the helper being wrong. **Lesson**: whenever a solution is built from a subtracted/composed pair of calls to the same helper, test the helper directly on a small case, not just the final composed answer.

---

## Interview Tips

1. If you see "subarray" or "substring" → consider sliding window
2. If asked for "longest" → variable window, update answer after shrinking
3. If asked for "shortest" → variable window, update answer during shrinking
4. Fixed window if problem gives you the window size k
5. Always ask: "What makes the window invalid?" — this determines your shrink condition
6. Don't forget edge cases: empty string, window bigger than input, all same characters

---

## Related Patterns

- Fixed Window → Maximum Sum Subarray of Size K, Permutation in String
- Variable Window (Longest) → Longest Substring Without Repeating Characters, Longest Repeating Character Replacement, Max Consecutive Ones III (binary-alphabet specialization of LRCR)
- Variable Window (Shortest) → Minimum Size Subarray Sum, Minimum Window Substring
- Variable Window + HashMap → Fruit Into Baskets, Subarrays with K Different Integers
- Exactly K trick → atMost(K) - atMost(K-1) — for "exactly K distinct" problems

---

## Week 3 Problem Map

| Day | Problem | Type | Window State |
|-----|---------|------|-------------|
| D1 | Max Sum Subarray of Size K | Fixed | Running sum |
| D1 | Longest Substring Without Repeating (LC #3) | Variable + HashSet | HashSet tracking |
| D2 | Minimum Size Subarray Sum (LC #209) | Variable (Shortest) | Running sum |
| D2 | Permutation in String (LC #567) | Fixed + Freq Match | int[26] comparison |
| D3 | Minimum Window Substring (LC #76) | Variable + Freq | HashMap tracking |
| D3 | Longest Repeating Char Replacement (LC #424) | Variable + Max Freq | Frequency + max count |
| D4 | Fruit Into Baskets (LC #904) | Variable + At Most K | HashMap distinct count |
| D4 | Max Consecutive Ones III (LC #1004) | Variable | Zero count |
| D5 | Subarrays with K Different Integers (LC #992) | Exactly K trick | ✅ HashMap + sliding window (sum right-left+1) |
| D5 | Sliding Window Maximum (LC #239) | Fixed + Monotonic Deque | ✅ Decreasing deque of indices, front = max |
| D6 | Sliding Window Maximum — re-solve | Fixed + Monotonic Deque | ✅ Clean 2nd attempt, zero bugs |
| D6 | Subarrays with K Distinct — re-solve | Exactly K trick | ⚠️ Found composition bug invisible to driver tests, self-corrected |
