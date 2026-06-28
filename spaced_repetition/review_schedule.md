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
| Move Zeroes (LC #283) | Two Pointers (Same Direction) | Jun 28 | Jun 28 | Jun 29 |
| Sort Colors (LC #75) | Dutch National Flag (3-way Partition) | Jun 28 | Jun 28 | Jun 29 |

---

## 📦 Box 2 — Review Every 3 Days

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Container With Most Water (LC #11) | Greedy Two Pointers | Jun 28 | Jun 28 | Jul 1 |
| Trapping Rain Water (LC #42) | Two Pointers (maxLeft/maxRight) | Jun 28 | Jun 28 | Jul 1 |

---

## 📦 Box 3 — Review Weekly

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Subarray Sum Equals K (LC #560) | Prefix Sum + HashMap | Jun 25 | Jun 25 | Jul 2 |
| Encode and Decode Strings (LC #271) | Length-Prefix Encoding | Jun 25 | Jun 25 | Jul 2 |
| Valid Sudoku (LC #36) | HashSet per Row/Col/Box | Jun 25 | Jun 25 | Jul 2 |
| Product Except Self (LC #238) | Prefix/Suffix Product | Jun 23 | Jun 23 | Jun 30 |
| Longest Consecutive Sequence (LC #128) | HashSet + Sequence Start | Jun 23 | Jun 23 | Jun 30 |
| Valid Palindrome (LC #125) | Two Pointers (Opposite Ends) | Jun 28 | Jun 28 | Jul 5 |
| 3Sum (LC #15) | Sort + Fix One + Two Pointers | Jun 28 | Jun 28 | Jul 5 |
| Contiguous Array (LC #525) | Prefix Sum + HashMap (Max Length Variant) | Jun 28 | Jun 28 | Jul 5 |
| Sort Characters By Frequency (LC #451) | Freq Count + Bucket Sort | Jun 28 | Jun 28 | Jul 5 |
| Two Sum (LC #1) | HashMap Complement | Jun 28 | Jun 28 | Jul 5 |
| Contains Duplicate (LC #217) | HashSet Membership | Jun 28 | Jun 28 | Jul 5 |

---

## 📦 Box 4 — Review Bi-Weekly

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Valid Anagram (LC #242) | Frequency Count (int[26]) | Jun 28 | Jun 28 | Jul 12 |
| Two Sum II (LC #167) | Two Pointers (Opposite) | Jun 28 | Jun 28 | Jul 12 |
| Group Anagrams (LC #49) | HashMap Grouping (Freq Key) | Jun 28 | Jun 28 | Jul 12 |
| Top K Frequent (LC #347) | Freq Count + Bucket Sort | Jun 28 | Jun 28 | Jul 12 |

---

## 📦 Box 5 — Review Monthly (Mastered ✅)

| Problem | Pattern | Mastered Date | Last Review | Next Review |
|---------|---------|---------------|-------------|-------------|
| _empty_ | — | — | — | — |

---

## 🔔 Today's Review Queue

**Date**: June 28, 2026

### Spaced Repetition Recall (12 problems):
- ✅ Container With Most Water (LC #11) — Perfect recall. Two pointers, move shorter side, O(n)/O(1). → Promoted to Box 2
- ✅ Trapping Rain Water (LC #42) — Solid recall. Logic correct, said "minLeft" instead of "maxLeft" (naming, not concept). → Promoted to Box 2
- ✅ Contiguous Array (LC #525) — Excellent recall. Transform 0→-1, first-occurrence HashMap, {0:-1} init with reasoning. → Promoted to Box 3
- ✅ Sort Characters By Frequency (LC #451) — Perfect recall. Bucket sort, List[] size n+1, iterate right-to-left. → Promoted to Box 3
- ✅ Two Sum (LC #1) — Perfect. Check-before-insert, complement lookup. → Stays Box 3
- ✅ Contains Duplicate (LC #217) — Perfect. !set.add() idiom. → Stays Box 3
- ✅ Valid Palindrome (LC #125) — Perfect. Skip non-alphanumeric, compare lowercase. → Promoted to Box 3
- ✅ 3Sum (LC #15) — Excellent. All 3 prior bugs addressed. → Promoted to Box 3
- ✅ Valid Anagram (LC #242) — Correct approach. Missed length early-exit in chat (claims fast typing). SC said O(n) instead of O(1). → Promoted to Box 4
- ✅ Two Sum II (LC #167) — Perfect. Sorted → two pointers, O(n)/O(1). → Promoted to Box 4
- ✅ Group Anagrams (LC #49) — Perfect. Freq key + HashMap grouping. → Promoted to Box 4
- ✅ Top K Frequent (LC #347) — Perfect. Bucket sort + freq map. → Promoted to Box 4

### Problems Solved Today:
- ✅ Move Zeroes (LC #283) — 🟢 HIRE, NEW. Same-direction write/read pointer, swap non-zeroes forward. Zero bugs, zero hints. ~4 min.
- ✅ Sort Colors (LC #75) — 🟢 HIRE, NEW. Dutch National Flag 3-way partition. lo/mid/hi pointers. Zero bugs, zero hints. ~6 min. Clean swap helper.

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
| Total problems in system | 19 |
| Box 1 (daily) | 2 |
| Box 2 (3-day) | 2 |
| Box 3 (weekly) | 11 |
| Box 4 (bi-weekly) | 4 |
| Box 5 (mastered) | 0 |
| Reviews completed today | 12 |
| Problems solved today | 2 |
| Streak (consecutive days) | 10 |
