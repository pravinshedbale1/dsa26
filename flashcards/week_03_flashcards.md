# 📝 Week 3 Flashcards — Sliding Window

> Write these on your whiteboard. Glance every morning.

---

## Card 1: Fixed-Size Sliding Window (Max Sum Subarray of Size K)
```
🔍 TRIGGER: "Contiguous subarray of fixed size K" or "max/min sum of K elements"
💡 IDEA:   Build first window of size K. Slide: add right, remove left. Track max/min.
📝 CODE:   windowSum += nums[i]; if (i - j + 1 == k) { update max; windowSum -= nums[j]; j++; }
⏱️ TIME:   O(n)  |  SPACE: O(1)
⚠️ EDGE:   k == array length (single window), all negatives
```

---

## Card 2: Variable-Size Sliding Window + HashSet (Longest Substring Without Repeating)
```
🔍 TRIGGER: "Longest substring without repeating" or "longest with unique chars"
💡 IDEA:   Expand right (add to set). If duplicate found, shrink left (remove from set) until valid.
📝 CODE:   while (right < n) { if set.contains(rightChar) → remove left, left++, continue; 
           maxWindow = max(maxWindow, right-left+1); set.add(rightChar); right++; }
⏱️ TIME:   O(n)  |  SPACE: O(min(n, charset))
⚠️ WHY O(n): Each element enters/leaves the set at most once → O(2n) = O(n) amortized
⚠️ EDGE:   Empty string, all same chars, all unique chars
```

---

