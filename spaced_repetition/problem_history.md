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
| 12 | Jun 17 | Valid Anagram (re-solve) | 242 | Easy | Frequency Count (int[26]) | Freq array O(n)/O(1) | O(n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. Length early-exit FIRST LINE. All tests first try. Zero bugs, zero hints. ~5 min. |
| 13 | Jun 17 | Two Sum II (re-solve) | 167 | Medium | Two Pointers (Opposite) | Two Ptr O(n)/O(1) | O(n) | O(1) | ⚡ | 4 | Box 1 | 🟡 LEAN HIRE. Initial 0-indexed bug, self-debugged. Zero hints. ~5 min. |
| 14 | Jun 17 | Group Anagrams (re-solve) | 49 | Medium | HashMap Grouping (Freq Key) | Freq key O(n·k)/O(n·k) | O(n·k) | O(n·k) | ✅ | 5 | Box 1 | 🟢 HIRE. All 5 tests first try. Zero bugs, zero hints. ~6 min. Arrays.toString() correct. |
| 15 | Jun 17 | Top K Frequent (re-solve) | 347 | Medium | Freq Count + Bucket Sort | Bucket Sort O(n)/O(n) | O(n) | O(n) | ✅ | 5 | Box 1 | 🟢 HIRE. All 5 tests first try. Zero bugs, zero hints. ~16 min. List[] correct. Minor: missing inner ptr guard. |
| 16 | Jun 18 | Product Except Self (re-solve) | 238 | Medium | Prefix/Suffix Product | Two-array O(n)/O(n) → Optimal O(n)/O(1) | O(n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. All 5 tests first try. Zero bugs, zero hints. ~11 min. O(1) space optimization flawless. |
| 17 | Jun 18 | Longest Consecutive Sequence (NEW) | 128 | Medium | HashSet + Sequence Start | Sort O(n log n) → HashSet O(n)/O(n) | O(n) | O(n) | ✅ | 4 | Box 1 | 🟢 HIRE. NEW problem. All 5 tests first try. Zero bugs, zero hints. ~10 min. Iterated set not nums (smart). |
| 18 | Jun 20 | Encode and Decode Strings (NEW) | 271 | Medium | Length-Prefix Encoding | Length-prefix O(n)/O(n) | O(n) | O(n) | ⚡ | 4 | Box 1 | 🟢 HIRE. NEW problem. All 5 tests first run. 1 hint (decode structure). Cleaned up nits (unused var, debug print). |
| 19 | Jun 20 | Valid Sudoku (NEW) | 36 | Medium | HashSet per Row/Col/Box | HashSet O(81)/O(81) = O(1)/O(1) | O(1) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW problem. All 5 tests first try. Zero bugs, zero hints. ~15 min. Elegant !set.add() triple check. Box index formula derived independently. |
| 20 | Jun 21 | Subarray Sum Equals K (NEW) | 560 | Medium | Prefix Sum + HashMap | Brute O(n²)/O(1) → Optimal O(n)/O(n) | O(n) | O(n) | ✅ | 4 | Box 1 | 🟢 HIRE. NEW problem. All 5 tests passed (caught incorrect test case!). Zero hints. Concept teach on prefix sum first. Used prefixSum array instead of running variable (minor optimization). |
| 21 | Jun 22 | Contiguous Array (NEW, UNSEEN) | 525 | Medium | Prefix Sum + HashMap (Max Length) | Brute O(n³)/O(1) → Optimal O(n)/O(n) | O(n) | O(n) | ✅ | 4 | Box 1 | 🟡 LEAN HIRE. UNSEEN weekly challenge. Zero hints, zero bugs, all 5 first try. Key: treat 0 as -1 → subarray sum=0. Store first occurrence only. ~45 min (over 25 min limit). |
| 22 | Jun 22 | Sort Characters By Frequency (NEW, UNSEEN) | 451 | Medium | Freq Count + Bucket Sort | Sort O(n log n) → Bucket Sort O(n)/O(n) | O(n) | O(n) | ✅ | 5 | Box 1 | 🟢 HIRE. UNSEEN weekly challenge. Zero hints, zero bugs, all 5 first try. ~3 min. Instant pattern transfer from Top K Frequent. StringBuilder, null-check buckets, getOrDefault. |
| 23 | Jun 23 | Valid Palindrome (NEW) | 125 | Easy | Two Pointers (Opposite Ends) | Two Ptr O(n)/O(1) | O(n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW. Two pointers inward, skip non-alphanumeric with continue. All 5 tests first try. Zero bugs, zero hints. ~6 min. Clean Character.isLetterOrDigit() + toLowerCase(). |
| 24 | Jun 23 | 3Sum (NEW) | 15 | Medium | Sort + Fix One + Two Pointers | Brute O(n³) → Sort + 2ptr O(n²)/O(k) | O(n²) | O(k) | ⚡ | 3 | Box 1 | 🟡 LEAN HIRE. NEW. 2 hints: k scope outside loop, extra j++/k-- outside if/else. Approach correct, code structure struggled. Dup skip for i independent, j/k needed guidance. All 5 tests after fixes. ~20 min. |
| 25 | Jun 25 | Container With Most Water (NEW) | 11 | Medium | Greedy Two Pointers | Brute O(n²) → Two Ptr O(n)/O(1) | O(n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW. All 5 tests first try. Zero bugs, zero hints. ~4 min. Greedy: move shorter side. Clean naming. |
| 26 | Jun 25 | Trapping Rain Water (NEW) | 42 | Hard | Two Pointers (maxLeft/maxRight) | Brute O(n²) → Prefix arrays O(n)/O(n) → Two Ptr O(n)/O(1) | O(n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW HARD. All 5 tests first try. Zero bugs, zero hints. ~5 min. Articulate reasoning: smaller max = bottleneck. Proactive null check. |
| 27 | Jun 28 | Move Zeroes (NEW) | 283 | Easy | Two Pointers (Same Direction) | Brute O(n²) → Write/Read Ptr O(n)/O(1) | O(n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW. All 5 tests first try. Zero bugs, zero hints. ~4 min. Clean swap-based write pointer. First same-direction two pointer problem. |
| 28 | Jun 28 | Sort Colors (NEW) | 75 | Medium | Dutch National Flag (3-way Partition) | Sort O(n log n) → DNF O(n)/O(1) | O(n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW. All 5 tests first try. Zero bugs, zero hints. ~6 min. Clean swap helper. Knew not to increment mid after hi swap. |
| 29 | Jun 29 | Remove Duplicates from Sorted Array (NEW) | 26 | Easy | Two Pointers (Same Dir — Write Pointer) | Brute O(n)/O(n) → Write Ptr O(n)/O(1) | O(n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW. Initial off-by-one (k=3), self-debugged. Zero hints. ~3.5 min. Clean ++j overwrite. Pattern transfer from Move Zeroes. |
| 30 | Jul 6 | 4Sum (NEW) | 18 | Medium | Sort + Fix Two + Two Pointers | Brute O(n⁴) → Sort + Fix Two + 2ptr O(n³)/O(k) | O(n³) | O(k) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW. All 5 tests first try. Zero bugs, zero hints. ~10 min. Clean extension of 3Sum. Smart overflow handling: split sum into two int pairs combined as long. Correct dup skipping for all 4 pointers. |
| 31 | Jul 7 | Boats to Save People (NEW) | 881 | Medium | Sort + Greedy Two Pointers (Pairing) | Brute O(n²) → Sort + Greedy 2ptr O(n log n)/O(1) | O(n log n) | O(1) | ✅ | 5 | Box 1 | 🟢 HIRE. NEW. 1 bug (forgot sort), self-debugged. Zero hints. ~4 min. Greedy: heaviest always boards, lightest pairs if weight fits. Clean left<=right for odd-person-out. |

---

## Weekly Aggregates

| Week | Problems Solved | ✅ | ⚡ | 🔄 | ❌ | Avg Confidence | Top Pattern |
|------|----------------|----|----|----|----|----------------|------------|
| Pre-plan | 3 (re-solves) + 1 new | 2 | 1 | 0 | 0 | 4.7 | HashMap/HashSet |
| W1 D1 | 2 (complete) | 1 | 1 | 0 | 0 | 4.5 | HashMap/HashSet |
| W1 D2 | 2 (complete) | 1 | 1 | 0 | 0 | 4.5 | Frequency Count / Two Pointers |
| W1 D3 | 2 (complete) | 2 | 0 | 0 | 0 | 5.0 | HashMap Grouping / Bucket Sort |
| W1 D4 | 2 (complete) | 2 | 0 | 0 | 0 | 4.5 | Prefix/Suffix / HashSet Sequence |
| W1 D5 | 2 (complete) | 1 | 1 | 0 | 0 | 4.5 | Length-Prefix / HashSet Validation |
| W1 D6 | 1 (complete) | 1 | 0 | 0 | 0 | 4.0 | Prefix Sum + HashMap |
| W1 D7 | 2 (complete) 🎉 | 2 | 0 | 0 | 0 | 4.5 | Prefix Sum variant + Bucket Sort |
| **W1 TOTAL** | **13** | **11** | **2** | **0** | **0** | **4.6** | **All Arrays & Hashing patterns** |
| W2 D1 | 2 (complete) | 1 | 1 | 0 | 0 | 4.0 | Two Pointers (Opposite) / Sort+2ptr |
| W2 D2 | 2 (complete) | 2 | 0 | 0 | 0 | 5.0 | Greedy Two Pointers / Two Ptr maxL/maxR |
| W2 D3 | 2 (complete) | 2 | 0 | 0 | 0 | 5.0 | Same-Dir Two Ptr / Dutch National Flag |
| W2 D4 | 2 (complete) | 2 | 0 | 0 | 0 | 5.0 | Write Pointer + Sort+Fix Two+2ptr |
| W2 D5 | 1 (complete) | 1 | 0 | 0 | 0 | 5.0 | Sort + Greedy Two Pointers (Pairing) |
| ... | — | — | — | — | — | — | — |

