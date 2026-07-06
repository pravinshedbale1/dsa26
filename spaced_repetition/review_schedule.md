# 📅 SPACED REPETITION — Review Schedule

> **System**: Leitner Box (5 levels)
> **Rule**: Correct recall → move up one box. Incorrect → back to Box 1.
>
> ⚠️ _Reset on June 15, 2026. Problems will be re-added as solved in the new plan._

---

## Box Definitions

| Box | Review Interval | Meaning |
|-----|----------------|---------|
| 📦 Box 1 | Every day | Just learned / got wrong |
| 📦 Box 2 | Every 3 days | Shaky — need more practice |
| 📦 Box 3 | Every 1 week | Getting comfortable |
| 📦 Box 4 | Every 2 weeks | Solid understanding |
| 📦 Box 5 | Every 1 month | Mastered — maintenance only |

---

## 📦 Box 1 — Review Daily

| Problem | Pattern | Added Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| 4Sum (LC #18) | Sort + Fix Two + Two Pointers | Jul 6 | Jul 6 | Jul 7 |
| Subarray Sum Equals K (LC #560) | Prefix Sum + HashMap | Jul 6 (demoted) | Jul 6 | Jul 7 |

---

## 📦 Box 2 — Review Every 3 Days

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Remove Duplicates (LC #26) | Two Pointers (Same Dir — Write Pointer) | Jul 6 | Jul 6 | Jul 9 |

---

## 📦 Box 3 — Review Weekly

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Container With Most Water (LC #11) | Greedy Two Pointers | Jul 6 | Jul 6 | Jul 13 |
| Trapping Rain Water (LC #42) | Two Pointers (maxLeft/maxRight) | Jul 6 | Jul 6 | Jul 13 |
| Move Zeroes (LC #283) | Two Pointers (Same Direction) | Jul 6 | Jul 6 | Jul 13 |
| Sort Colors (LC #75) | Dutch National Flag (3-way Partition) | Jul 6 | Jul 6 | Jul 13 |

---

## 📦 Box 4 — Review Bi-Weekly

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Valid Anagram (LC #242) | Frequency Count (int[26]) | Jun 28 | Jun 28 | Jul 12 |
| Two Sum II (LC #167) | Two Pointers (Opposite) | Jun 28 | Jun 28 | Jul 12 |
| Group Anagrams (LC #49) | HashMap Grouping (Freq Key) | Jun 28 | Jun 28 | Jul 12 |
| Top K Frequent (LC #347) | Freq Count + Bucket Sort | Jun 28 | Jun 28 | Jul 12 |
| Product Except Self (LC #238) | Prefix/Suffix Product | Jul 6 | Jul 6 | Jul 20 |
| Longest Consecutive Sequence (LC #128) | HashSet + Sequence Start | Jul 6 | Jul 6 | Jul 20 |
| Encode and Decode Strings (LC #271) | Length-Prefix Encoding | Jul 6 | Jul 6 | Jul 20 |
| Valid Sudoku (LC #36) | HashSet per Row/Col/Box | Jul 6 | Jul 6 | Jul 20 |
| Valid Palindrome (LC #125) | Two Pointers (Opposite Ends) | Jul 6 | Jul 6 | Jul 20 |
| 3Sum (LC #15) | Sort + Fix One + Two Pointers | Jul 6 | Jul 6 | Jul 20 |
| Contiguous Array (LC #525) | Prefix Sum + HashMap (Max Length Variant) | Jul 6 | Jul 6 | Jul 20 |
| Sort Characters By Frequency (LC #451) | Freq Count + Bucket Sort | Jul 6 | Jul 6 | Jul 20 |
| Two Sum (LC #1) | HashMap Complement | Jul 6 | Jul 6 | Jul 20 |
| Contains Duplicate (LC #217) | HashSet Membership | Jul 6 | Jul 6 | Jul 20 |

---

## 📦 Box 5 — Review Monthly (Mastered ✅)

| Problem | Pattern | Mastered Date | Last Review | Next Review |
|---------|---------|---------------|-------------|-------------|
| _empty_ | — | — | — | — |

---

## 🔔 Today's Review Queue

**Date**: July 6, 2026

### Spaced Repetition Recall (16 overdue problems):
- ✅ Remove Duplicates (LC #26) — Correct. Write/read pointer, overwrite non-dups. O(n)/O(1). → Promoted to Box 2
- ✅ Container With Most Water (LC #11) — Correct. Opposite pointers, move shorter side. O(n)/O(1). → Promoted to Box 3
- ✅ Trapping Rain Water (LC #42) — Correct. Two pointers + maxLeft/maxRight, process smaller max. O(n)/O(1). → Promoted to Box 3
- ✅ Move Zeroes (LC #283) — Correct. Write/read pointer, swap non-zero forward. O(n)/O(1). → Promoted to Box 3
- ✅ Sort Colors (LC #75) — Excellent. DNF 3-way partition, explained mid-increment invariant with reasoning. → Promoted to Box 3
- ✅ Product Except Self (LC #238) — Correct. Prefix into answer array, running suffix variable. O(n)/O(1). → Promoted to Box 4
- ✅ Longest Consecutive Sequence (LC #128) — Correct. HashSet, sequence start detection (no n-1). O(n)/O(n). → Promoted to Box 4
- ⚠️ Subarray Sum Equals K (LC #560) — Mixed up {0:1} (count) with {0:-1} (index). → DEMOTED to Box 1
- ✅ Encode and Decode Strings (LC #271) — Correct. Length-prefix: count#string. O(n)/O(n). → Promoted to Box 4
- ✅ Valid Sudoku (LC #36) — Correct. HashSet per row/col/box, box formula (r/3)*3+(c/3). → Promoted to Box 4
- ✅ Valid Palindrome (LC #125) — Correct. Two pointers inward, skip non-alphanumeric. O(n)/O(1). → Promoted to Box 4
- ✅ 3Sum (LC #15) — Correct. Sort + fix i + two pointers j,k. Dup skip placement correct. O(n²)/O(k). → Promoted to Box 4
- ✅ Contiguous Array (LC #525) — Correct. 0→-1, prefix sum, first occurrence only, {0:-1}. O(n)/O(n). → Promoted to Box 4
- ✅ Sort Characters By Frequency (LC #451) — Correct. Freq map + bucket sort, List[] n+1, right-to-left. O(n)/O(n). → Promoted to Box 4
- ✅ Two Sum (LC #1) — Correct. Check-before-insert, complement lookup. O(n)/O(n). → Promoted to Box 4
- ✅ Contains Duplicate (LC #217) — Correct. !set.add() idiom. O(n)/O(n). → Promoted to Box 4

### Problems Solved Today:
- ✅ 4Sum (LC #18) — 🟢 HIRE, NEW. Sort + fix two + two pointers. All 5 tests first try. Zero bugs, zero hints. ~10 min. Smart overflow handling with long split. Added to Box 1.

### Review Checklist:
For each problem due:
1. ❓ Can you name the pattern in <30 seconds?
2. ❓ Can you describe the optimal approach without looking?
3. ❓ Can you state the time and space complexity?
4. ❓ Can you write the core logic (not full code) from memory?

**If YES to all** → Move to next box
**If NO to any** → Back to Box 1

---

## 📊 Review Stats

| Metric | Value |
|--------|-------|
| Total problems in system | 21 |
| Box 1 (daily) | 2 |
| Box 2 (3-day) | 1 |
| Box 3 (weekly) | 4 |
| Box 4 (bi-weekly) | 14 |
| Box 5 (mastered) | 0 |
| Reviews completed today | 16 |
| Problems solved today | 1 |
| Streak (consecutive days) | 1 (gap from Jun 29 – Jul 6) |
