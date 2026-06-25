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

_Cards grow as we solve more Week 2 problems._
