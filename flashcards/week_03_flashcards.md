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

## Card 3: Variable-Size Sliding Window — SHORTEST (Minimum Size Subarray Sum, LC #209)
```
🔍 TRIGGER: "Shortest/minimum subarray" with a sum/count condition
💡 IDEA:   Expand right until valid. Then SHRINK left while still valid — update min DURING shrinking.
📝 CODE:   while (sum >= target) { minLen = min(minLen, right-left+1); sum -= nums[left]; left++; }
⏱️ TIME:   O(n)  |  SPACE: O(1)
⚠️ KEY:    Init minLen = Integer.MAX_VALUE. Return MAX_VALUE ? 0 : minLen.
⚠️ VS LONGEST: Longest updates during EXPANDING. Shortest updates during SHRINKING.
```

---

## Card 4: Fixed Sliding Window + Frequency Match (Permutation in String, LC #567)
```
🔍 TRIGGER: "Does s2 contain a permutation/anagram of s1?" or "fixed-length substring match"
💡 IDEA:   Window size = s1.length(). Maintain running int[26] for window. Compare with s1's int[26].
📝 CODE:   need[] from s1. Slide window on s2: window[right]++, when size==k: Arrays.equals(need,window), window[left]--, left++
⏱️ TIME:   O(m)  |  SPACE: O(1)  (int[26] is constant)
⚠️ KEY:    Maintain RUNNING freq array (add/remove) — don't rebuild each time (that's O(m·k)).
⚠️ COMPARE: Arrays.equals(int[], int[]) for O(26) = O(1) comparison.
```

---
