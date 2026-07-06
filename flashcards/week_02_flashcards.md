# 📝 Week 2 Flashcards — Two Pointers & Sorting

> Write these on your whiteboard. Glance every morning.

---

## Card 1: Two Pointers — Opposite Ends (Palindrome)
```
🔍 TRIGGER: "Is it a palindrome?" or "compare from both ends"
💡 IDEA:   Left at 0, right at n-1. Skip non-alphanumeric. Compare lowercase chars.
📝 CODE:   while (left < right) { if (!isLetterOrDigit) continue; compare toLowerCase }
⏱️ TIME:   O(n)  |  SPACE: O(1)
⚠️ EDGE:   Empty string, all non-alphanumeric, single character
```

---

## Card 2: Sort + Fix One + Two Pointers (3Sum)
```
🔍 TRIGGER: "Find all triplets that sum to target" or "k-sum variants"
💡 IDEA:   Sort array. Fix element i, two-pointer j=i+1 and k=n-1 for remaining pair.
📝 CODE:   Skip duplicate i: if (i > 0 && nums[i] == nums[i-1]) continue;
           Skip duplicate j/k: INSIDE else block, AFTER adding triplet
⏱️ TIME:   O(n²)  |  SPACE: O(k) where k = number of triplets
⚠️ TRAP:   j and k MUST be initialized INSIDE the i loop. Each if/else branch self-contained.
```

---

## Card 3: Greedy Two Pointers — Max Area (Container With Most Water)
```
🔍 TRIGGER: "Maximum area between two lines" or "maximize container"
💡 IDEA:   Two pointers at ends. Area = min(h[l], h[r]) * (r-l). Move the SHORTER side.
📝 WHY:    Moving taller side can only decrease area (shorter side is still bottleneck).
           Moving shorter side: width shrinks but height MIGHT increase → chance of bigger area.
⏱️ TIME:   O(n)  |  SPACE: O(1)
⚠️ EDGE:   Two elements only, all same height, strictly increasing/decreasing
```

---

## Card 4: Two Pointers — Trapping Rain Water
```
🔍 TRIGGER: "How much water is trapped" or "elevation map after rain"
💡 IDEA:   Water at bar i = min(maxLeft, maxRight) - height[i].
           Two pointers from ends. Track maxLeft and maxRight.
           Process the side with the SMALLER max (that's the bottleneck for water level).
📝 CODE:   if (height[left] < height[right]) → update maxLeft or add water, left++
           else → update maxRight or add water, right--
⏱️ TIME:   O(n)  |  SPACE: O(1)
⚠️ KEY:    Smaller max is the bottleneck → safe to compute water on that side.
           Can also solve with prefix max arrays: O(n)/O(n), but two-pointer is optimal.
```

---

## Card 5: Container vs Trapping — Know the Difference
```
🔍 CONTAINER WITH MOST WATER:
   • Find MAX area between TWO lines
   • Move the SHORTER side (shorter side = area bottleneck)
   • Area = min(h[l], h[r]) × width

🔍 TRAPPING RAIN WATER:
   • Find TOTAL water above ALL bars
   • Process side with SMALLER MAX (smaller max = water level bottleneck)
   • Water at bar = max - height[bar]

💡 Same skeleton, different greedy reasoning!
```

---

## Card 6: Two Pointers — Same Direction / Write Pointer (Move Zeroes)
```
🔍 TRIGGER: "Move/remove elements in-place" or "partition array by condition"
💡 IDEA:   Write pointer (j) marks next valid position. Read pointer (i) scans all.
           When read finds valid element → swap with write position → advance write.
📝 CODE:   int j = 0; for (int i = 0; i < n; i++) { if (nums[i] != 0) swap(i, j); j++; }
⏱️ TIME:   O(n)  |  SPACE: O(1)
⚠️ REUSE:  Same skeleton for Remove Duplicates, Remove Element — only the if condition changes.
```

---

## Card 7: Dutch National Flag — 3-Way Partition (Sort Colors)
```
🔍 TRIGGER: "Sort array with only 3 distinct values" or "3-way partition"
💡 IDEA:   3 pointers: lo=0, mid=0, hi=n-1. Mid scans and routes elements.
           nums[mid]==0 → swap(mid,lo), lo++, mid++
           nums[mid]==1 → mid++
           nums[mid]==2 → swap(mid,hi), hi--
📝 KEY:    DON'T increment mid after swap with hi (unexamined element!)
           Safe to increment mid after swap with lo (lo ≤ mid, already scanned)
⏱️ TIME:   O(n) single pass  |  SPACE: O(1)
⚠️ REGIONS: [0..lo) = 0s, [lo..mid) = 1s, [mid..hi] = unknown, (hi..n-1] = 2s
```

---

## Card 8: Sort + Fix Two + Two Pointers (4Sum)
```
🔍 TRIGGER: "Find all quadruplets that sum to target" or "extend 3Sum to 4 elements"
💡 IDEA:   Sort array. Fix i and j, two-pointer k=j+1 and l=n-1 for remaining pair.
📝 CODE:   Skip dup i: if (i > 0 && nums[i] == nums[i-1]) continue;
           Skip dup j: if (j > i+1 && nums[j] == nums[j-1]) continue;
           Skip dup k/l: INSIDE else block, AFTER adding quadruplet
⏱️ TIME:   O(n³)  |  SPACE: O(k) where k = number of quadruplets
⚠️ TRAP:   OVERFLOW! Sum of 4 ints can exceed Integer.MAX_VALUE.
           Use long: long sum = nums[i] + nums[j]; sum += nums[k] + nums[l];
           Or cast: (long) nums[i] + nums[j] + nums[k] + nums[l]
🔗 GENERALIZE: kSum = fix (k-2) elements + two pointers. Each extra fix adds O(n).
```

---

_Cards grow as we solve more Week 2 problems._

