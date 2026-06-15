# 📜 PROBLEM HISTORY — Every Problem Solved

> Track every problem with date, approach, result, and confidence level.

---

## Legend

| Symbol | Meaning |
|--------|---------|
| ✅ | Solved optimally on first try |
| ⚡ | Solved with hints/guidance |
| 🔄 | Needed significant help |
| ❌ | Could not solve |
| ⭐ | Starred for extra review |

---

## Problem Log

| # | Date | Problem | LC# | Difficulty | Pattern Used | Approaches Covered | Time | Space | Result | Confidence (1-5) | Spaced Rep Box | Notes |
|---|------|---------|-----|-----------|-------------|-------------------|------|-------|--------|------------------|---------------|-------|
| 1 | May 8 | Two Sum | 1 | Easy | HashMap Complement | Brute O(n²)/O(1) → Optimal O(n)/O(n) | O(n) | O(n) | ✅ | 4 | Box 1 | Clean solve, zero bugs |
| 2 | May 8 | Contains Duplicate | 217 | Easy | HashSet Membership | Brute O(n²)/O(1) → Sort O(n log n)/O(1) → HashSet O(n)/O(n) | O(n) | O(n) | ✅ | 4 | Box 1 | Used idiomatic !set.add(n) |
| 3 | May 8 | Valid Anagram | 242 | Easy | Frequency Count (int[26]) | Sort O(n log n)/O(n) → Freq array O(n)/O(1) | O(n) | O(1) | ✅ | 4 | Box 1 | Clean solve, check==0 before decrement |
| 4 | May 8 | Group Anagrams | 49 | Medium | HashMap Grouping | Sort key O(n·k log k) → Freq key O(n·k) | O(n·k) | O(n·k) | ⚡ | 3 | Box 1 | 3 bugs in brute force (missing sort, arr.toString(), Collection cast). Optimal clean. |
| 5 | May 17 | Top K Frequent Elements | 347 | Medium | Freq Count + Bucket Sort | Sort O(n log n) → Bucket Sort O(n) | O(n) | O(n) | ⚡ | 3 | Box 1 | Brute (sort by freq) clean. Bucket sort: 2 bugs (int[] vs List[], inner loop bounds). |
| 6 | Jun 3 | Two Sum (re-solve) | 1 | Easy | HashMap Complement | Optimal O(n)/O(n) | O(n) | O(n) | ✅ | 5 | Box 2 | Clean re-solve, zero bugs. ~4 min. |
| 7 | Jun 3 | Contains Duplicate (re-solve) | 217 | Easy | HashSet Membership | HashSet O(n)/O(n) | O(n) | O(n) | ✅ | 5 | Box 2 | Flawless. !set.add(n) idiom. ~2 min. |
| 8 | Jun 3 | Valid Anagram (re-solve) | 242 | Easy | Frequency Count (int[26]) | Freq array O(n)/O(1) | O(n) | O(1) | ⚡ | 4 | Box 2 | Missed length early-exit AGAIN (3rd time). Fixed after probe. |
| 9 | Jun 3 | Two Sum II (NEW) | 167 | Medium | Two Pointers (Opposite) | Brute O(n²)/O(1) → Two Ptr O(n)/O(1) | O(n) | O(1) | ✅ | 4 | Box 1 | First two-pointer problem. Clean implementation, zero bugs. |
| 10 | Jun 15 | Two Sum (re-solve, new plan) | 1 | Easy | HashMap Complement | Optimal O(n)/O(n) | O(n) | O(n) | ⚡ | 4 | Box 1 | 🟡 LEAN HIRE. Initial bug (returned [0,0]) debugged. Zero hints. Clean variable names. |
| 11 | Jun 15 | Contains Duplicate (re-solve, new plan) | 217 | Easy | HashSet Membership | HashSet O(n)/O(n) | O(n) | O(n) | ✅ | 5 | Box 1 | 🟢 HIRE. Flawless first-try. !set.add(n) idiom. ~3 min. Zero bugs, zero hints. |

---

## Weekly Aggregates

| Week | Problems Solved | ✅ | ⚡ | 🔄 | ❌ | Avg Confidence | Top Pattern |
|------|----------------|----|----|----|----|----------------|------------|
| Pre-plan | 3 (re-solves) + 1 new | 2 | 1 | 0 | 0 | 4.7 | HashMap/HashSet |
| W1 D1 | 2 (complete) | 1 | 1 | 0 | 0 | 4.5 | HashMap/HashSet |
| ... | — | — | — | — | — | — | — |
