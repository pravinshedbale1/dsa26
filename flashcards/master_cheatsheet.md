# 🧠 ALL PATTERNS & TRICKS — Complete Study Guide

> **Everything you've learned from 17 problems across 9 sessions.**
> Study this before every session. This is your interview weapon.

---

## 📋 TABLE OF CONTENTS

1. [Pattern Quick Reference](#-pattern-quick-reference)
2. [Deep Dive: Arrays & Hashing Patterns](#-arrays--hashing-patterns)
3. [Deep Dive: Two Pointers & Sorting Patterns](#-two-pointers--sorting-patterns)
4. [Tricks & Techniques](#-tricks--techniques)
5. [Common Gotchas & Bug Patterns](#-common-gotchas--bug-patterns)
6. [Java Idioms You Should Know](#-java-idioms)
7. [Decision Flowchart](#-decision-flowchart)
8. [Complexity Rules](#-complexity-rules)

---

## 🎯 Pattern Quick Reference

### Patterns You've MASTERED (Confidence 5)

| # | Pattern | Trigger | Core Idea | TC/SC |
|---|---------|---------|-----------|-------|
| 1 | HashMap Complement | "Pair summing to target" | `map.containsKey(target - x)` | O(n)/O(n) |
| 2 | HashSet Membership | "Duplicates?" | `!set.add(x)` returns true if dup | O(n)/O(n) |
| 3 | Frequency Count | "Count/compare chars" | `int[26]` or `HashMap<E, count>` | O(n)/O(1) or O(k) |
| 4 | HashMap Grouping | "Group by property" | Key = transform, Value = list | O(n·k)/O(n·k) |
| 5 | Bucket Sort | "Top K by frequency, O(n)" | Frequency AS array index | O(n)/O(n) |
| 6 | Prefix/Suffix Product | "Everything except self" | Left pass in array, right pass with running var | O(n)/O(1) |
| 7 | Prefix Sum + HashMap | "Count subarrays with sum K" | `sum - k` in map? → subarray found | O(n)/O(n) |
| 8 | Transform + Prefix Sum | "Equal count of X and Y" | 0→-1, 1→+1, then "sum = 0" variant | O(n)/O(n) |
| 9 | Length-Prefix Encoding | "Serialize strings with any chars" | `length#content` | O(n)/O(n) |
| 10 | HashSet Validation | "Validate grid rows/cols/boxes" | `(r/3)*3 + (c/3)` for box index | O(1)/O(1) |
| 11 | Two Pointers (Opposite) | "Sorted + pair" | `left=0, right=n-1`, move based on sum | O(n)/O(1) |
| 12 | Greedy Two Ptr (Area) | "Max container area" | Move SHORTER side (bottleneck) | O(n)/O(1) |
| 13 | Two Ptr (Trapped Water) | "Water on elevation map" | Process side with SMALLER max | O(n)/O(1) |
| 14 | Two Ptr (Same Dir) | "Move/remove in-place" | Write ptr + read ptr, swap valid elements | O(n)/O(1) |
| 15 | Dutch National Flag | "Sort 3 values" | lo/mid/hi, mid scans and routes | O(n)/O(1) |

### Patterns Learned but Need Practice (Confidence 3-4)

| # | Pattern | Trigger | Core Idea | TC/SC |
|---|---------|---------|-----------|-------|
| 14 | HashSet + Sequence Start | "Longest consecutive, O(n)" | `!set.contains(n-1)` → start of chain | O(n)/O(n) |
| 15 | Sort + Fix One + 2Ptr | "All triplets summing to 0" | Sort + for i → two-ptr j,k | O(n²)/O(k) |

---

## 🔷 Arrays & Hashing Patterns

### Pattern 1: HashMap Complement Lookup
```
TRIGGER:  "Find pair that sums to target"
PROBLEMS: Two Sum (LC #1)

APPROACH:
  For each element x, check if (target - x) already exists in the map.
  If yes → found pair. If no → store x with its index.

KEY TRICK:
  ✅ Check BEFORE inserting → avoids pairing element with itself
  ✅ map.containsKey(target - nums[i]) → O(1) lookup

CODE SKELETON:
  Map<Integer, Integer> map = new HashMap<>();
  for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement))
          return new int[]{map.get(complement), i};
      map.put(nums[i], i);
  }

EDGE CASES:
  • Duplicates: [3, 3] target=6 → works because we check before insert
  • Negative numbers: [-1, 0, 1] target=0 → same logic
  • No solution: return empty or throw
```

---

### Pattern 2: HashSet Membership
```
TRIGGER:  "Check for duplicates" or "has this been seen?"
PROBLEMS: Contains Duplicate (LC #217), Valid Sudoku helper

APPROACH:
  Iterate. If add() returns false → duplicate found.

KEY TRICK:
  ✅ !set.add(x) → combines "check" and "insert" in ONE call
  ✅ Shorter than: if (set.contains(x)) return true; set.add(x);

CODE SKELETON:
  Set<Integer> set = new HashSet<>();
  for (int n : nums) {
      if (!set.add(n)) return true;  // duplicate!
  }
  return false;
```

---

### Pattern 3: Frequency Counting
```
TRIGGER:  "Count occurrences", "anagram", "most frequent"
PROBLEMS: Valid Anagram (LC #242), Group Anagrams helper, Top K helper

TWO FLAVORS:
  🅰️ int[26] — when input is lowercase a-z only
     int[] freq = new int[26];
     freq[c - 'a']++;
     ⚠️ This is O(1) space, NOT O(n)!

  🅱️ HashMap — when charset is unknown/large
     map.merge(key, 1, Integer::sum);
     OR: map.put(key, map.getOrDefault(key, 0) + 1);

KEY TRICKS:
  ✅ For anagram: increment for string1, decrement for string2
  ✅ int[26] beats HashMap when charset is fixed (no boxing, cache-friendly)
  ✅ Arrays.toString(int[]) → creates usable HashMap key from freq array

🚨 RECURRING TRAP:
  ALWAYS check lengths first! if (s.length() != t.length()) return false;
  This was missed 3 times before becoming habit.
```

---

### Pattern 4: HashMap Grouping
```
TRIGGER:  "Group elements by shared property"
PROBLEMS: Group Anagrams (LC #49)

APPROACH:
  Find what makes elements "the same" → that's your key.
  Map<Key, List<Element>>.

KEY DESIGN CHOICES:
  • Sorted string key: O(k log k) per word, simpler code
  • Frequency array key: O(k) per word, Arrays.toString(freqArr)

KEY TRICKS:
  ✅ computeIfAbsent(key, k -> new ArrayList<>()).add(val)
  ✅ new ArrayList<>(map.values()) to convert Collection→List
  
🚨 GOTCHA:
  char[].toString() → memory address! Use new String(arr) or String.valueOf()
```

---

### Pattern 5: Bucket Sort (Frequency as Index)
```
TRIGGER:  "Top K by frequency" in O(n), "sort by frequency"
PROBLEMS: Top K Frequent (LC #347), Sort Chars By Frequency (LC #451)

APPROACH:
  1. Build frequency map: element → count
  2. Create buckets: List[] of size n+1 (max freq = array length)
  3. Place elements into bucket[freq]
  4. Walk from right → left, collect top K

KEY TRICKS:
  ✅ List[] NOT int[] — multiple elements can share same frequency
  ✅ Array size is n+1 (index 0 to n, since max freq = n)
  ✅ Walk right→left for highest frequency first
  ✅ Guard inner loop: if (ptr >= k) break

CODE SKELETON:
  List<Integer>[] buckets = new List[nums.length + 1];
  for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      int freq = e.getValue();
      if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
      buckets[freq].add(e.getKey());
  }
  // Collect from right to left
  for (int i = buckets.length - 1; i >= 0 && ptr < k; i--) {
      if (buckets[i] != null) {
          for (int val : buckets[i]) {
              result[ptr++] = val;
              if (ptr >= k) break;  // ← DON'T FORGET THIS
          }
      }
  }
```

---

### Pattern 6: Prefix/Suffix Product
```
TRIGGER:  "Product of everything except current element", no division allowed
PROBLEMS: Product of Array Except Self (LC #238)

APPROACH:
  Pass 1 (left→right): Build prefix products INTO the answer array
  Pass 2 (right→left): Multiply by running suffix variable

KEY TRICKS:
  ✅ Base case is 1 (multiplicative identity), NOT the element itself
  ✅ answer[i] = answer[i-1] * nums[i-1] (prefix)
  ✅ Running variable for suffix: product *= nums[i+1] after updating answer[i]
  ✅ This gives O(1) extra space (output array doesn't count)

🧠 INSIGHT:
  "Two passes, not two arrays. Output array does double duty."
```

---

### Pattern 7: Prefix Sum + HashMap
```
TRIGGER:  "Count subarrays with sum = K"
PROBLEMS: Subarray Sum Equals K (LC #560)

APPROACH:
  Running prefix sum. At each position, check if (sum - k) exists in map.
  If yes → that many subarrays end here with sum K.

KEY TRICKS:
  ✅ Initialize: map.put(0, 1) — handles subarrays starting at index 0
  ✅ Store count, not just existence: map.put(sum, map.getOrDefault(sum, 0) + 1)
  ✅ This is "Two Sum on running sums" — same complement pattern!

🧠 WHY {0: 1}?
  If running sum itself = K, then sum - K = 0.
  Without {0: 1} in the map, you'd miss subarrays from index 0.
```

---

### Pattern 8: Transform + Prefix Sum (Max Length Variant)
```
TRIGGER:  "Longest subarray with equal count of X and Y"
PROBLEMS: Contiguous Array (LC #525) — equal 0s and 1s

APPROACH:
  1. Transform: 0 → -1, 1 → +1
  2. Now "equal 0s and 1s" = "subarray sum = 0"
  3. Same prefix sum at two indices → subarray between them sums to 0
  4. Store FIRST occurrence of each sum (for max length)

KEY DIFFERENCE FROM PATTERN 7:
  ┌─────────────────────────────────────────────────────┐
  │ COUNT subarrays:  store sum→count,  init {0: 1}     │
  │                   always update count                │
  │ MAX LENGTH:       store sum→first_index, init {0:-1} │
  │                   NEVER overwrite (keep first only)  │
  └─────────────────────────────────────────────────────┘

🧠 INSIGHT:
  "Transform-and-reduce: convert unfamiliar problem → known pattern"
```

---

### Pattern 9: Length-Prefix Encoding
```
TRIGGER:  "Encode/decode list of strings with any characters"
PROBLEMS: Encode and Decode Strings (LC #271)

APPROACH:
  Encode: for each string, prepend length + "#" + content
  Decode: find "#", parse length, extract substring of that length

KEY TRICKS:
  ✅ indexOf('#', startPos) — start searching from current position
  ✅ Length makes delimiter unambiguous — even if string contains "#"
  ✅ Jump pointer by: i = hashPos + length + 1

🧠 INSIGHT:
  "Count, don't scan. Same principle as HTTP Content-Length."
```

---

### Pattern 10: HashSet Validation (Row/Col/Box)
```
TRIGGER:  "Validate Sudoku" or "check grid for duplicates per region"
PROBLEMS: Valid Sudoku (LC #36)

APPROACH:
  HashSet[] for each row (9), column (9), and box (9).
  Single pass through all cells. Check all three sets per cell.

KEY FORMULA:
  ✅ Box index = (row / 3) * 3 + (col / 3)
  ✅ row/3 → which box ROW (0, 1, 2)
  ✅ col/3 → which box COL (0, 1, 2)
  ✅ Multiply box-row by 3, add box-col → unique 0–8

KEY TRICKS:
  ✅ Reuses !set.add() idiom from Contains Duplicate
  ✅ Can combine all 3 checks in one boolean expression
  ✅ Skip '.' cells (empty cells are always valid)
```

---

### Pattern 11: HashSet + Sequence Start Detection
```
TRIGGER:  "Longest consecutive sequence" in O(n)
PROBLEMS: Longest Consecutive Sequence (LC #128)

APPROACH:
  Dump all into HashSet. For each element, if (num - 1) NOT in set,
  it's the START of a sequence. Count forward: num+1, num+2...

KEY TRICKS:
  ✅ if (!set.contains(n - 1)) → only count from sequence starts
  ✅ Iterate over SET not ARRAY → naturally handles duplicates
  ✅ Inner while loop is NOT O(n²) — it's amortized O(n)!

🧠 AMORTIZED O(n) EXPLANATION:
  Each element is consumed by exactly one sequence.
  Inner loop total across ALL outer iterations = n.
  Same principle as sliding window's inner shrink loop.
```

---

## 🔷 Two Pointers & Sorting Patterns

### Pattern 12: Two Pointers — Opposite Ends
```
TRIGGER:  "Sorted array + find pair", "palindrome check"
PROBLEMS: Two Sum II (LC #167), Valid Palindrome (LC #125)

APPROACH:
  left = 0, right = n-1. Move based on condition.
  For sum: too small → left++, too big → right--
  For palindrome: compare chars, skip non-alphanumeric

KEY TRICKS:
  ✅ ONLY works on sorted data (or symmetric structures like palindromes)
  ✅ "Sorted input = free info. Don't waste it with HashMap."
  ✅ Skip non-alphanumeric: Character.isLetterOrDigit(c)
  ✅ Case-insensitive: Character.toLowerCase(c)
  ✅ Use continue (not nested if) for cleaner skip logic

🚨 GOTCHA:
  Check output format! 0-indexed vs 1-indexed results.
  Two Sum II expects 1-indexed: return new int[]{left+1, right+1}
```

---

### Pattern 13: Sort + Fix One + Two Pointers (3Sum / kSum)
```
TRIGGER:  "Find all triplets summing to target", "k-Sum variants"
PROBLEMS: 3Sum (LC #15)

APPROACH:
  1. Sort the array
  2. Fix element i (outer loop 0 to n-2)
  3. Two pointers j=i+1, k=n-1 (inner loop)
  4. Skip duplicates at ALL levels

DUPLICATE HANDLING:
  ✅ For i: if (i > 0 && nums[i] == nums[i-1]) continue;
  ✅ For j/k: INSIDE the else block, AFTER adding the triplet:
     while (j < k && nums[j] == nums[j-1]) j++;
     while (j < k && nums[k] == nums[k+1]) k--;

🚨 THREE BUGS YOU HIT (and fixed):
  1. k initialized OUTSIDE the for loop → not reset per i
     FIX: j = i+1, k = n-1 INSIDE the i loop
  
  2. Extra j++/k-- OUTSIDE if/else → double movement
     FIX: Each branch (sum<0, sum>0, sum==0) is self-contained
  
  3. Duplicate skip at TOP of while loop → skips before checking
     FIX: Only skip AFTER finding a valid triplet (inside else)

🧠 RULE: Each if/else branch should be SELF-CONTAINED.
   Don't put shared logic outside the branches.
```

---

### Pattern 14: Greedy Two Pointers — Max Area
```
TRIGGER:  "Maximum area/container between two lines"
PROBLEMS: Container With Most Water (LC #11)

APPROACH:
  Two pointers from both ends. Calculate area.
  Move the SHORTER side inward.

FORMULA:
  area = min(height[left], height[right]) × (right - left)

WHY MOVE THE SHORTER SIDE?
  ┌──────────────────────────────────────────────────────┐
  │ Height is limited by the SHORTER side (the min).     │
  │                                                      │
  │ Move TALLER side:                                    │
  │   • Width shrinks                                    │
  │   • Height CAN'T increase (still limited by shorter) │
  │   • Area can ONLY decrease → never worth it!         │
  │                                                      │
  │ Move SHORTER side:                                   │
  │   • Width shrinks                                    │
  │   • Height MIGHT increase → chance of bigger area    │
  └──────────────────────────────────────────────────────┘
```

---

### Pattern 15: Two Pointers — Trapping Rain Water
```
TRIGGER:  "How much water/rain is trapped", "elevation map"
PROBLEMS: Trapping Rain Water (LC #42) ⭐ HARD

CORE INSIGHT:
  Water above bar i = min(maxLeft, maxRight) - height[i]
  The SMALLER of the two max walls is the bottleneck.

APPROACH:
  Two pointers from ends. Track maxLeft and maxRight.
  Always process the side with the SMALLER max.

WHY PROCESS THE SMALLER MAX?
  If maxLeft < maxRight:
    • We KNOW the right side has something taller (or equal)
    • So maxLeft is definitely the bottleneck for left pointer
    • Safe to compute water at left: maxLeft - height[left]

CODE SKELETON:
  while (left < right) {
      if (height[left] < height[right]) {
          if (height[left] >= maxLeft)
              maxLeft = height[left];     // new wall, no water
          else
              water += maxLeft - height[left];  // trapped!
          left++;
      } else {
          // mirror logic for right side
          right--;
      }
  }

CONTAINER vs TRAPPING — COMPARISON:
  ┌────────────────────────┬──────────────────────────────┐
  │ CONTAINER WITH WATER   │ TRAPPING RAIN WATER          │
  ├────────────────────────┼──────────────────────────────┤
  │ MAX area between 2     │ TOTAL water above ALL bars   │
  │ Move SHORTER side      │ Process SMALLER MAX side     │
  │ area = min(h) × width  │ water = max - height[bar]    │
  │ One area calculation    │ Accumulate at each bar       │
  └────────────────────────┴──────────────────────────────┘
   Same skeleton. Different greedy reasoning.
```

---

### Pattern 16: Two Pointers — Same Direction (Write Pointer)
```
TRIGGER:  "Move/remove elements in-place", "partition by condition"
PROBLEMS: Move Zeroes (LC #283), Remove Duplicates, Remove Element

APPROACH:
  Two pointers both start at 0.
  Read pointer (i) scans every element.
  Write pointer (j) marks where next valid element goes.
  When valid element found → swap(i, j), advance j.

KEY INSIGHT:
  ✅ The write pointer only advances for valid elements
  ✅ Everything before j is "processed and valid"
  ✅ Everything from j onward is "to be overwritten"
  ✅ Same skeleton reused — only the IF condition changes per problem

CODE SKELETON:
  int j = 0;
  for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {  // ← change this condition per problem
          swap(nums, i, j);
          j++;
      }
  }
```

---

### Pattern 17: Dutch National Flag (3-Way Partition)
```
TRIGGER:  "Sort array with 3 distinct values", "3-way partition"
PROBLEMS: Sort Colors (LC #75)

APPROACH:
  3 pointers: lo=0, mid=0, hi=n-1
  mid scans and decides where each element belongs:
    nums[mid] == 0 → swap(mid, lo), lo++, mid++
    nums[mid] == 1 → mid++
    nums[mid] == 2 → swap(mid, hi), hi--

CRITICAL RULES:
  ✅ DON'T increment mid after swap with hi
     → element from hi is unexamined
  ✅ SAFE to increment mid after swap with lo
     → lo ≤ mid always, element from lo already scanned (0 or 1)

REGIONS:
  [0..lo)     = all 0s (red)
  [lo..mid)   = all 1s (white)
  [mid..hi]   = unknown (being processed)
  (hi..n-1]   = all 2s (blue)

CODE SKELETON:
  int lo = 0, mid = 0, hi = nums.length - 1;
  while (mid <= hi) {
      if (nums[mid] == 0)      { swap(mid, lo); lo++; mid++; }
      else if (nums[mid] == 1) { mid++; }
      else                     { swap(mid, hi); hi--; }
  }
```

---

## 🔧 Tricks & Techniques

### Trick 1: Early Exit — Size/Length Check
```
WHEN:    Comparing two inputs (strings, arrays)
WHAT:    First line = check if sizes differ
CODE:    if (s.length() != t.length()) return false;
WHY:     Without this, "abc" vs "ab" could return TRUE (WRONG!)
STATUS:  Was a recurring miss (3 times). Now RESOLVED.
```

### Trick 2: !set.add() — Check + Insert in One Call
```
WHEN:    Need to check existence AND insert if new
WHAT:    set.add() returns false if already present
CODE:    if (!set.add(x)) → duplicate found
USED IN: Contains Duplicate, Valid Sudoku (triple check)
```

### Trick 3: getOrDefault — Safe HashMap Access
```
WHEN:    Building frequency maps, avoiding null checks
CODE:    map.getOrDefault(key, 0) + 1
ALT:     map.merge(key, 1, Integer::sum)
```

### Trick 4: computeIfAbsent — Auto-Create Lists
```
WHEN:    Building HashMap<Key, List<Value>>
CODE:    map.computeIfAbsent(key, k -> new ArrayList<>()).add(val)
BEATS:   if (!map.containsKey(key)) map.put(key, new ArrayList<>());
```

### Trick 5: Arrays.toString() for Array Keys
```
WHEN:    Using arrays as HashMap keys (e.g., freq arrays)
CODE:    Arrays.toString(new int[26])  → "[0, 0, 1, ...]"
🚨 NOT: arr.toString() → returns memory address!
🚨 NOT: char[].toString() → also memory address!
USE:     new String(charArr) or String.valueOf(charArr)
```

### Trick 6: Iterate Set Instead of Array for Dedup
```
WHEN:    Input has duplicates but logic needs unique elements
CODE:    for (int n : set) instead of for (int n : nums)
USED IN: Longest Consecutive Sequence
WHY:     Naturally avoids processing duplicates without extra logic
```

### Trick 7: Running Variable for O(1) Space
```
WHEN:    Need two passes over array with accumulation
WHAT:    First pass builds into output array. Second pass uses a running variable.
USED IN: Product Except Self (suffix product as running variable)
WHY:     Eliminates need for second array → O(1) extra space
```

### Trick 8: Integer Division Collapse
```
WHEN:    Mapping ranges to groups (0-2→0, 3-5→1, 6-8→2)
CODE:    group = index / groupSize
USED IN: Valid Sudoku box index: (row/3)*3 + (col/3)
WHY:     Integer division naturally "floors" → collapses 3 values into 1
```

### Trick 9: Transform-and-Reduce
```
WHEN:    Problem seems new but matches a known pattern after transformation
EXAMPLE: "Equal 0s and 1s" → treat 0 as -1 → "subarray sum = 0" → known!
USED IN: Contiguous Array (LC #525)
🧠 KEY:  "Can I transform this into something I already know?"
```

### Trick 10: Amortized Analysis — Nested Loop ≠ O(n²)
```
WHEN:    See a while loop inside a for loop and panic about O(n²)
RULE:    If the inner loop's TOTAL work across ALL iterations = O(n), it's O(n)
USED IN: Longest Consecutive Sequence, Sliding Window, Two Pointers
TEST:    "How many times is each element visited total?" If ≤ 2 → amortized O(n)
```

### Trick 11: Null/Empty Guard at Top
```
WHEN:    Any problem where input could be null or empty
CODE:    if (height == null || height.length == 0) return 0;
WHY:     Proactive edge case handling. Interviewers notice this!
USED IN: Trapping Rain Water (you added this proactively — good habit)
```

### Trick 12: Defensive Inner Loop Guard
```
WHEN:    Nested loop fills a fixed-size result array
CODE:    if (ptr >= k) break;
WHY:     Without it → ArrayIndexOutOfBoundsException
USED IN: Top K Frequent (bucket sort inner loop)
```

---

## 🚨 Common Gotchas & Bug Patterns

### Bug 1: Variable Scope in Loops
```
SYMPTOM:  Variable not reset per iteration of outer loop
EXAMPLE:  3Sum — k initialized OUTSIDE the for-i loop
FIX:      Always initialize loop-dependent vars INSIDE the loop
RULE:     If a variable depends on the outer iteration, it goes INSIDE
```

### Bug 2: Self-Contained Branches
```
SYMPTOM:  Shared logic outside if/else causes double execution
EXAMPLE:  3Sum — extra j++/k-- outside the if/else branches
FIX:      Each branch handles its own pointer movements
RULE:     Ask: "Should this run ALWAYS or only in ONE case?"
```

### Bug 3: Duplicate Skip Placement
```
SYMPTOM:  Skipping duplicates before checking for valid result
EXAMPLE:  3Sum — j/k dup skip at top of while loop
FIX:      Only skip duplicates AFTER recording a valid result
RULE:     Find result FIRST, then skip to avoid finding it again
```

### Bug 4: 0-indexed vs 1-indexed Output
```
SYMPTOM:  Off-by-one in returned indices
EXAMPLE:  Two Sum II expects [1,2] but you return [0,1]
FIX:      Re-read the output specification before returning
RULE:     "What format does the output expect?"
```

### Bug 5: Writing to Wrong Variable
```
SYMPTOM:  Modifying input array instead of result array
EXAMPLE:  Two Sum — wrote to nums[] instead of result[]
FIX:      Double-check target variable name before assignment
```

### Bug 6: char[].toString() Trap
```
SYMPTOM:  HashMap key is memory address, not string content
EXAMPLE:  Group Anagrams — arr.toString() → "[C@1a2b3c"
FIX:      new String(arr) or String.valueOf(arr)
RULE:     Java arrays don't have useful toString(). Always wrap.
```

### Bug 7: int[] vs List[] for Multi-Value Buckets
```
SYMPTOM:  Later values overwrite earlier ones at same index
EXAMPLE:  Top K Frequent — int[freq] = element overwrites
FIX:      Use List<Integer>[] when multiple values map to same index
RULE:     "Can multiple things share this index?" → use List
```

---

## ☕ Java Idioms

```java
// HashMap — frequency counting
map.merge(key, 1, Integer::sum);
map.put(key, map.getOrDefault(key, 0) + 1);

// HashMap — auto-create lists
map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);

// HashSet — check + insert in one shot
if (!set.add(element)) { /* duplicate found */ }

// Array → String (for HashMap keys)
String key = Arrays.toString(freqArray);     // int[] → "[1, 0, 2, ...]"
String key = new String(sortedCharArray);    // char[] → "abc"
// ⚠️ NEVER: charArray.toString() → gives memory address

// Collection → List
new ArrayList<>(map.values());  // NOT: (List) map.values()

// Character utilities
Character.isLetterOrDigit(c);
Character.toLowerCase(c);

// Sorting
Arrays.sort(array);                          // sorts int[] in-place
Arrays.sort(array, (a, b) -> map.get(b) - map.get(a));  // custom comparator

// Math
Math.max(a, b);  Math.min(a, b);

// StringBuilder (for string building in loops)
StringBuilder sb = new StringBuilder();
sb.append(str);
sb.toString();
```

---

## 🌳 Decision Flowchart

```
📥 READ THE PROBLEM
│
├── Is input SORTED?
│   ├── Finding exact value? ───────────→ Binary Search
│   ├── Finding pair/triplet? ──────────→ Two Pointers (opposite ends)
│   └── Finding boundary/min-max? ──────→ Binary Search on Answer
│
├── Can SORTING help?
│   ├── Need pairs/triplets? ───────────→ Sort + Two Pointers
│   ├── Need to group/merge? ───────────→ Sort + process
│   └── Need K-sum? ───────────────────→ Sort + Fix (K-2) + Two Pointers
│
├── Is it about SUBARRAYS?
│   ├── Sum = K (count)? ──────────────→ Prefix Sum + HashMap (count)
│   ├── Equal X and Y (max length)? ───→ Transform + Prefix Sum (first idx)
│   ├── Fixed size window? ────────────→ Sliding Window (fixed)
│   └── Variable condition? ───────────→ Sliding Window (variable)
│
├── Is it about PAIRS/LOOKUPS?
│   ├── Find complement? ─────────────→ HashMap Complement
│   ├── Check duplicates? ────────────→ HashSet Membership
│   ├── Group by property? ───────────→ HashMap Grouping
│   └── Top K by frequency? ──────────→ Freq Map + Bucket Sort
│
├── Is it about SEQUENCES?
│   ├── Longest consecutive? ──────────→ HashSet + Sequence Start
│   ├── Product except self? ──────────→ Prefix/Suffix Product
│   └── Encode/decode strings? ────────→ Length-Prefix
│
├── Is it about AREA/WATER?
│   ├── Max container area? ───────────→ Greedy Two Ptr (move shorter)
│   └── Trapped rain water? ───────────→ Two Ptr + maxL/maxR (smaller max)
│
├── Nesting/matching? ─────────────────→ Stack
├── Tree structure? ───────────────────→ DFS / BFS
├── Graph connections? ────────────────→ BFS / DFS / Union-Find
└── Overlapping subproblems? ──────────→ DP
```

---

## 📊 Complexity Rules

### Time Complexity Targets by Input Size

| Input Size | Target TC | What Works |
|------------|-----------|------------|
| n ≤ 10 | O(n!) | Brute force, permutations |
| n ≤ 20 | O(2ⁿ) | Backtracking, bitmask |
| n ≤ 500 | O(n³) | Triple nested loops |
| n ≤ 5000 | O(n²) | Double nested loops |
| n ≤ 10⁶ | O(n log n) | Sorting, heap |
| n ≤ 10⁷ | O(n) | Single pass, two pointer, sliding window |
| n > 10⁷ | O(log n) or O(1) | Binary search, math |

### Common Pattern Complexities

| Pattern | Time | Space |
|---------|------|-------|
| HashMap/HashSet lookup | O(n) | O(n) |
| Two Pointers | O(n) | O(1) |
| Prefix Sum | O(n) build, O(1) query | O(n) |
| Sorting | O(n log n) | O(log n) |
| Bucket Sort | O(n) | O(n) |
| Binary Search | O(log n) | O(1) |
| Sliding Window | O(n) | O(k) |
| Monotonic Stack | O(n) | O(n) |
| BFS/DFS (graph) | O(V + E) | O(V) |
| Backtracking | O(2ⁿ) or O(n!) | O(n) |
| DP (1D) | O(n) | O(n) → O(1) |
| DP (2D) | O(n·m) | O(n·m) → O(n) |
| Heap operations | O(n log k) | O(k) |

---

## 🏅 Your Stats

| Metric | Value |
|--------|-------|
| Total problems | 19 |
| 🟢 HIRE | 16 |
| 🟡 LEAN HIRE | 3 |
| 🟠 LEAN NO HIRE | 0 |
| 🔴 NO HIRE | 0 |
| Current streak | 14 🟢 HIRE consecutive |
| Hardest solved | Trapping Rain Water (Hard) — flawless |
| Fastest solve | Sort Chars By Freq — ~3 min |

---

_Last updated: June 28, 2026 — Session #10_
