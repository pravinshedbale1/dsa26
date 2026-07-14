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

## Card 5: Variable Window + Need/Formed Counter (Minimum Window Substring, LC #76)
```
🔍 TRIGGER: "Smallest window in s containing all chars of t (with duplicates)"
💡 IDEA:   need[] = freq of t. window[] = running freq in [left,right]. required = distinct chars in need.
           formed = distinct chars currently satisfied. Window valid when formed == required.
📝 CODE:   window[c]++; if (window[c]==need[c]) formed++;
           while (formed==required) { record min; window[left]--; if (window[left] < need[left]) formed--; left++; }
⏱️ TIME:   O(n+m)  |  SPACE: O(k) (k = distinct chars in t; int[128] → O(1))
⚠️ KEY:    Use EXACT equality (==) to bump formed, STRICT (<) to drop it — each fires only once,
           at the transition moment. Using >=/<= double-counts and breaks formed==required.
⚠️ EDGE:   t longer/has more of a char than s exists → return "". Char in t absent from s entirely.
```

---

## Card 6: Variable Window + Max Frequency (Longest Repeating Character Replacement, LC #424)
```
🔍 TRIGGER: "Longest substring of same letter after replacing at most k chars"
💡 IDEA:   replacements needed = windowSize - maxFreq(letter in window). Valid when that <= k.
           Expand right, track running int[26] freq + maxFreq (never decreases). If invalid, shift
           left by exactly 1 (if, not while) — window length only ever grows or stays the same.
📝 CODE:   maxFreq = max(maxFreq, ++freq[right]); if (windowSize - maxFreq > k) { freq[left]--; left++; }
           result = max(result, windowSize);
⏱️ TIME:   O(n)  |  SPACE: O(1)  (int[26] fixed)
⚠️ KEY:    maxFreq can go STALE after a shrink (no longer the true max of current window) — harmless,
           because result can only grow, never shrink. Staleness just makes the window "coast" at its
           already-earned length instead of shrinking further; it can never inflate the reported answer.
⚠️ EDGE:   k == 0 (no replacements allowed), k >= s.length() (whole string works), all same char.
```

---

## Card 7: Variable Window + At-Most-K-Distinct (Fruit Into Baskets, LC #904)
```
🔍 TRIGGER: "Longest subarray/substring with at most K distinct values/types"
💡 IDEA:   HashMap<value, countInWindow>. Expand right, increment count. Invalid when
           map.size() > K. Shrink left: decrement count, REMOVE KEY ENTIRELY at count 0
           (leaving a stale 0-count key would inflate map.size() and break the check).
📝 CODE:   map.put(v, map.getOrDefault(v,0)+1);
           while (map.size() > k) { if (map.get(left)==1) map.remove(left); else map.merge(left,-1,Integer::sum); left++; }
           result = max(result, right-left+1);
⏱️ TIME:   O(n)  |  SPACE: O(k)  (at most K+1 keys ever in map)
⚠️ KEY:    Generalizes cleanly: swap `> 2` for `> k` for any "at most K distinct" variant.
⚠️ EDGE:   K >= total distinct values in array (whole array is the answer), all same value.
```

---
