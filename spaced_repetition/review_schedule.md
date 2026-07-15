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
| _empty_ | — | — | — | — |

---

## 📦 Box 2 — Review Every 3 Days

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Minimum Window Substring (LC #76) | Variable Sliding Window + Need/Formed Counter | Jul 16 | Jul 16 | Jul 19 |
| Longest Repeating Character Replacement (LC #424) | Variable Sliding Window + Max Frequency | Jul 16 | Jul 16 | Jul 19 |
| Fruit Into Baskets (LC #904) | Variable Sliding Window + At-Most-K-Distinct (HashMap) | Jul 16 | Jul 16 | Jul 19 |
| Minimum Size Subarray Sum (LC #209) | Variable Sliding Window (Shortest) | Jul 14 | Jul 14 | Jul 17 |
| Permutation in String (LC #567) | Fixed Sliding Window + Freq Match | Jul 14 | Jul 14 | Jul 17 |

---

## 📦 Box 3 — Review Weekly

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Max Sum Subarray of Size K | Fixed Sliding Window | Jul 16 | Jul 16 | Jul 23 |
| Longest Substring Without Repeating (LC #3) | Variable Sliding Window + HashSet/HashMap-Index-Jump | Jul 16 | Jul 16 | Jul 23 |
| Partition Labels (LC #763) | Greedy + Last Occurrence Map | Jul 13 | Jul 13 | Jul 20 |
| Container With Most Water (LC #11) | Greedy Two Pointers | Jul 6 | Jul 13 | Jul 20 |
| Trapping Rain Water (LC #42) | Two Pointers (maxLeft/maxRight) | Jul 6 | Jul 13 | Jul 20 |
| Move Zeroes (LC #283) | Two Pointers (Same Direction) | Jul 6 | Jul 13 | Jul 20 |
| Sort Colors (LC #75) | Dutch National Flag (3-way Partition) | Jul 6 | Jul 13 | Jul 20 |
| Remove Duplicates (LC #26) | Two Pointers (Same Dir — Write Pointer) | Jul 11 | Jul 11 | Jul 18 |
| 4Sum (LC #18) | Sort + Fix Two + Two Pointers | Jul 11 | Jul 11 | Jul 18 |
| Subarray Sum Equals K (LC #560) | Prefix Sum + HashMap | Jul 11 | Jul 11 | Jul 18 |
| Boats to Save People (LC #881) | Sort + Greedy Two Pointers (Pairing) | Jul 11 | Jul 11 | Jul 18 |
| 3Sum Closest (LC #16) | Sort + Fix One + Two Pointers (Closest) | Jul 11 | Jul 11 | Jul 18 |

---

## 📦 Box 4 — Review Bi-Weekly

| Problem | Pattern | Moved Date | Last Review | Next Review |
|---------|---------|------------|-------------|-------------|
| Valid Anagram (LC #242) | Frequency Count (int[26]) | Jun 28 | Jul 13 | Jul 27 |
| Two Sum II (LC #167) | Two Pointers (Opposite) | Jun 28 | Jul 13 | Jul 27 |
| Group Anagrams (LC #49) | HashMap Grouping (Freq Key) | Jun 28 | Jul 13 | Jul 27 |
| Top K Frequent (LC #347) | Freq Count + Bucket Sort | Jun 28 | Jul 13 | Jul 27 |
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

**Date**: July 16, 2026

### Spaced Repetition Recall (5 problems — 3 Box 1 overdue + 2 Box 2 due today):
- ✅ Minimum Window Substring (LC #76) — Approach/pattern perfect (need/formed counter, exact `==`/strict `<`). Complexity wrong: said O(m·n), corrected to O(m+n) time, O(1) space (bounded ASCII). → **Promoted to Box 2**
- ✅ Longest Repeating Character Replacement (LC #424) — Perfect, including full self-synthesized "why stale maxFreq is harmless" argument (prior gap from Jul 14 now resolved — no nudges needed). → **Promoted to Box 2**
- ✅ Fruit Into Baskets (LC #904) — Perfect. HashMap count, shrink+remove-at-zero, O(n)/O(1). → **Promoted to Box 2**
- ✅ Max Sum Subarray of Size K — Perfect. windowSum + new - old, O(n)/O(1). → **Promoted to Box 3**
- ✅ Longest Substring Without Repeating (LC #3) — Perfect, described the HashMap-index-jump variant (more optimal than the HashSet expand/shrink used originally) — valid alternate approach. O(n)/O(min(n,charset)). → **Promoted to Box 3**

### Previous Queue (July 14, 2026 — 2 problems — Box 1 due):
- ✅ Minimum Size Subarray Sum (LC #209) — Approach correct (shrink-and-update-min). Bug caught: said `sum > target` instead of `sum >= target` (counterexample: [1,4,4], target=4 — strict `>` misses the exact-match window and reports 2 instead of 1). Corrected. → Promoted to Box 2
- ✅ Permutation in String (LC #567) — Perfect. need[]/window[] running freq, equality check at fixed window size, slide by remove-left/add-right. O(n)/O(1). → Promoted to Box 2

### Previous Queue (July 13, 2026 — 11 problems — 7 overdue + 4 due):
- ✅ Max Sum Subarray of Size K — Perfect. Fixed sliding window, add/remove, track max. O(n)/O(1). → Promoted to Box 2
- ✅ Longest Substring Without Repeating (LC #3) — Solid. Variable window + HashSet, expand/shrink. O(n)/O(n). → Promoted to Box 2
- ✅ Partition Labels (LC #763) — Needed probe on cut condition (i==end, not just last occ of current char). Approach correct after clarification. → Promoted to Box 3
- ✅ Valid Anagram (LC #242) — Perfect. Length early-exit FIRST. int[26], increment/decrement. O(n)/O(1). → Stays Box 4
- ✅ Two Sum II (LC #167) — Perfect. Two pointers opposite, move based on sum comparison. O(n)/O(1). → Stays Box 4
- ✅ Group Anagrams (LC #49) — Solid. Freq key + HashMap grouping. O(n·k)/O(n·k). → Stays Box 4
- ✅ Top K Frequent (LC #347) — Perfect. Bucket sort, List[] n+1, collect right-to-left. O(n)/O(n). → Stays Box 4
- ✅ Container With Most Water (LC #11) — Solid after probe. Move shorter side. O(n)/O(1). → Stays Box 3
- ✅ Trapping Rain Water (LC #42) — Excellent. min(maxL, maxR) - h[i], process smaller max. O(n)/O(1). → Stays Box 3
- ✅ Move Zeroes (LC #283) — Perfect. Write/read pointer, swap non-zero forward. O(n)/O(1). → Stays Box 3
- ✅ Sort Colors (LC #75) — Excellent. DNF lo/mid/hi, mid stays after hi swap. O(n)/O(1). → Stays Box 3

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
| Total problems in system | 31 |
| Box 1 (daily) | 0 |
| Box 2 (3-day) | 5 |
| Box 3 (weekly) | 12 |
| Box 4 (bi-weekly) | 14 |
| Box 5 (mastered) | 0 |
| Reviews completed today | 5 |
| Problems solved today | 0 (so far — new problem pending) |
| Re-solves today | 0 |
| Streak (consecutive days) | 3 |
