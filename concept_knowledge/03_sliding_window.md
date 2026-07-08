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

_To be filled during problem-solving sessions_

---

## Key Insights (Aha! Moments)

_To be filled during problem-solving sessions_

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
- Variable Window (Longest) → Longest Substring Without Repeating Characters, Longest Repeating Character Replacement
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
| D5 | Subarrays with K Different Integers (LC #992) | Exactly K trick | HashMap + sliding window |
| D5 | Sliding Window Maximum (LC #239) | Fixed + Monotonic Deque | Deque |
