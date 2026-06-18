# 📊 Longest Consecutive Sequence — Analysis

## Problem Info
| Field | Value |
|-------|-------|
| **LeetCode** | #128 |
| **Difficulty** | Medium |
| **Pattern** | HashSet + Sequence Start Detection |
| **Date** | June 18, 2026 (NEW) |
| **Result** | 🟢 HIRE |
| **Time Taken** | ~10 min |
| **Hints Used** | 0 |
| **Bugs** | 0 |

---

## Approaches

### Brute Force — O(n log n) time, O(1) space
Sort the array → scan for consecutive runs, track max length.

### Optimal — O(n) time, O(n) space ✅
1. Dump all elements into a **HashSet**
2. For each number, check if it's a **sequence start** (`num - 1` NOT in set)
3. If it's a start, count forward: `num+1`, `num+2`, ... until chain breaks
4. Track max length

---

## Complexity Nuances 🔍 — WHY IS THIS O(n)?

This is the trickiest part. It looks like O(n²) because there's a nested while loop, but it's actually O(n).

| Point | Detail |
|-------|--------|
| **The illusion** | Outer for loop × inner while loop = O(n²)? NO. |
| **The truth** | The inner while loop only runs from **sequence starts**. Each element is part of exactly one sequence. |
| **The math** | Every element is either SKIPPED (continuation → 0 inner loop steps) or COUNTED (as part of exactly one chain). Total inner loop steps across ALL outer iterations = n. |
| **Total** | O(n) outer loop + O(n) total inner loop = **O(n)** |

### Concrete example:
```
nums = [1, 2, 3, 4, 100, 200]   (6 elements)

Element 1:   is 0 in set? NO → START → count 1→2→3→4 = 4 steps
Element 2:   is 1 in set? YES → SKIP = 0 steps
Element 3:   is 2 in set? YES → SKIP = 0 steps
Element 4:   is 3 in set? YES → SKIP = 0 steps
Element 100: is 99 in set? NO → START → count 100 = 1 step
Element 200: is 199 in set? NO → START → count 200 = 1 step

Total inner loop steps: 4 + 0 + 0 + 0 + 1 + 1 = 6 = n ✅
```

**Analogy**: "I have n stairs. I climb them in groups (sequences), but each stair is climbed exactly once."

---

## Key Code

```java
Set<Integer> set = new HashSet<>();
for (int n : nums) set.add(n);

int longestSequenceCount = 0;

for (int n : set) {                    // iterate set, not nums (handles duplicates)
    if (!set.contains(n - 1)) {        // is this a sequence START?
        int count = 1;
        while (set.contains(n + 1)) {  // count forward
            n = n + 1;
            count++;
        }
        longestSequenceCount = Math.max(count, longestSequenceCount);
    }
}
```

---

## Session Notes

- **No mistakes** — zero bugs, zero hints on a NEW problem 🔥
- **Smart choice**: Iterated over `set` instead of `nums` — naturally handles duplicates without extra logic (Test 5: all 5s → correctly returns 1)
- **O(n) reasoning**: Initially didn't understand during concept teach, needed concrete step-by-step counting example to click
- **Minor style**: `int count = 0` declared outside `if` but only used inside — could be tighter scope

---

## Concept That Was Initially Confusing

**"Why is a nested loop O(n)?"**

The key insight: not all nested loops are O(n²). When the inner loop's **total work across all outer iterations** is bounded by n (because each element is processed at most once), the overall complexity is O(n). This is the **amortized analysis** concept.

Other problems with this same pattern:
- Two Pointers (while loop inside, but left + right together traverse n)
- Sliding Window (shrink inside expand, but each element enters/exits once)

---

## Pattern: HashSet + Sequence Start Detection

**When to use**: "Find longest consecutive sequence" in unsorted data in O(n).

**Key insight**: Only start counting from sequence starts (`num - 1` not in set). This ensures each element is visited at most twice total.

**Trigger words**: "consecutive", "sequence", "unsorted", "O(n)"
