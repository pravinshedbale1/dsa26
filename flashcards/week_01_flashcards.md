# 📝 Week 1 Flashcards — Arrays & Hashing

> Write these on your whiteboard. Glance every morning.

---

## Card 1: HashMap Complement Lookup
```
🔍 TRIGGER: "Find pair that sums to target"
💡 IDEA:   For each element, check if (target - element) is in map
📝 CODE:   map.containsKey(target - nums[i])
⏱️ TIME:   O(n)  |  SPACE: O(n)
⚠️ EDGE:   Duplicates, single element, negative numbers
```

---

## Card 2: HashSet for Uniqueness
```
🔍 TRIGGER: "Check for duplicates" or "distinct elements"
💡 IDEA:   HashSet.add() returns false if element exists
📝 CODE:   if (!set.add(nums[i])) → duplicate found
⏱️ TIME:   O(n)  |  SPACE: O(n)
⚠️ EDGE:   Empty array, all same values
```

---

## Card 3: Frequency Counting
```
🔍 TRIGGER: "Count occurrences" or "most frequent" or "anagram"
💡 IDEA:   HashMap<element, count> or int[26] for lowercase
📝 CODE:   map.merge(key, 1, Integer::sum)
           OR int[] freq = new int[26]; freq[c - 'a']++
⏱️ TIME:   O(n)  |  SPACE: O(k) where k = unique elements
⚠️ EDGE:   Empty string, unicode characters
```

---

## Card 4: Prefix Sum
```
🔍 TRIGGER: "Subarray sum" or "product except self"
💡 IDEA:   prefix[i] = sum of elements 0 to i-1
           subarray sum [i,j] = prefix[j+1] - prefix[i]
📝 CODE:   prefix[0] = 0; prefix[i] = prefix[i-1] + nums[i-1]
⏱️ TIME:   O(n) build, O(1) query  |  SPACE: O(n)
⚠️ EDGE:   Zeros in product, integer overflow
```

---

## Card 5: Prefix Sum + HashMap (Subarray Sum = K)
```
🔍 TRIGGER: "Number of subarrays with sum K"
💡 IDEA:   If prefixSum - K exists in map → subarray found!
           Same as Two Sum but with running sum
📝 CODE:   map.put(0, 1); // empty subarray
           if (map.containsKey(prefixSum - k)) count += map.get(prefixSum - k)
⏱️ TIME:   O(n)  |  SPACE: O(n)
⚠️ EDGE:   K=0, negative numbers, single element = K
```

---

## Card 6: HashMap Grouping
```
🔍 TRIGGER: "Group elements by property"
💡 IDEA:   Transform element → key, group by that key
📝 CODE:   map.computeIfAbsent(key, k -> new ArrayList<>()).add(val)
⏱️ TIME:   O(n * transform cost)  |  SPACE: O(n)
⚠️ EDGE:   All same group, all different groups
```

---

## Card 7: Bucket Sort (Frequency as Index)
```
🔍 TRIGGER: "Top K frequent" or "sort by frequency in O(n)"
💡 IDEA:   Use frequency as array index → buckets[freq].add(element)
           Walk array from right to left → highest frequency first
📝 CODE:   List<Integer>[] buckets = new List[n + 1];
           buckets[map.get(key)].add(key);
           for (i = n; i >= 0 && ptr < k; i--)
⏱️ TIME:   O(n)  |  SPACE: O(n)
⚠️ EDGE:   Multiple elements same frequency → use List not int
           Inner loop must check ptr >= k to avoid overflow
```

---

## Card 8: 🔴 EARLY EXIT — Size/Length Check (RECURRING MISS)
```
🔍 TRIGGER: ANY problem comparing two inputs (strings, arrays, lists)
💡 RULE:    FIRST LINE of your solution = check if sizes differ
📝 CODE:    if (s.length() != t.length()) return false;
            if (a.length != b.length) return false;
⚠️ WHY:    Missed this 3 times (May 12, Jun 3 recall, Jun 3 code)
            Without it: "abc" vs "ab" returns TRUE (WRONG!)
🧠 MANTRA: "Different size? INSTANT FALSE."
```

---

## Card 9: Two Pointers (Opposite Ends)
```
🔍 TRIGGER: "Sorted array + find pair" or "two numbers that sum to X"
💡 IDEA:   left=0, right=n-1. Sum too small → left++. Sum too big → right--.
📝 CODE:   while (left < right) { sum = a[left]+a[right]; if sum==target return; }
⏱️ TIME:   O(n)  |  SPACE: O(1)
⚠️ EDGE:   1-indexed vs 0-indexed output, duplicates in sorted array
🧠 KEY:    "Sorted input = free information. Don't waste it with HashMap."
```

---

## Card 10: Prefix/Suffix Product
```
🔍 TRIGGER: "Product of all elements except self" or "everything except current"
💡 IDEA:   Build prefix products left→right into answer array,
           then multiply suffix products right→left using a running variable
📝 CODE:   answer[0] = 1; answer[i] = answer[i-1] * nums[i-1]
           product = 1; answer[i] *= product; product *= nums[i]
⏱️ TIME:   O(n)  |  SPACE: O(1) extra (output doesn't count)
⚠️ EDGE:   Zeros (make everything except zero's position = 0)
           Base case is 1 (multiplicative identity), NOT the element
🧠 KEY:    "Two passes, not two arrays. Output array does double duty."
```

---

## Card 11: HashSet + Sequence Start Detection
```
🔍 TRIGGER: "Longest consecutive sequence" in unsorted data, O(n)
💡 IDEA:   Dump into HashSet. Only count from SEQUENCE STARTS (num-1 not in set).
           Count forward: num+1, num+2... until chain breaks.
📝 CODE:   if (!set.contains(n - 1)) { count forward... }
⏱️ TIME:   O(n)  |  SPACE: O(n)
⚠️ EDGE:   Duplicates (iterate set not nums!), empty array
🧠 KEY:    "Inner while loop total across ALL iterations = n.
           Each element is visited at most twice. This is AMORTIZED O(n)."
⚠️ TRAP:   Looks O(n²) because of nested loop — but it's NOT.
           Same amortized pattern as sliding window and two pointers.
```

---

## Card 12: Length-Prefix Encoding
```
🔍 TRIGGER: "Encode/decode list of strings" or "serialize strings with ANY chars"
💡 IDEA:   Prepend each string with its length + delimiter.
           Decode by reading length, then reading exactly that many chars.
📝 CODE:   Encode: sb.append(str.length() + "#" + str)
           Decode: hashPos = s.indexOf('#', i); len = parseInt(s.substring(i, hashPos));
                   str = s.substring(hashPos+1, hashPos+len+1); i = hashPos+len+1;
⏱️ TIME:   O(n)  |  SPACE: O(n)  where n = total characters
⚠️ EDGE:   Empty strings (length=0), strings containing the delimiter #
🧠 KEY:    "Count, don't scan. Length-prefix makes delimiter ambiguity impossible."
           Same principle as HTTP Content-Length, TCP, Protocol Buffers.
```

---

## Card 13: HashSet Validation (Row/Col/Box)
```
🔍 TRIGGER: "Validate a grid" or "check rows/columns/boxes for duplicates"
💡 IDEA:   HashSet per row (9), per col (9), per box (9). One pass.
           Box index from (r,c): boxIndex = (r/3)*3 + (c/3)
📝 CODE:   if (!rows[r].add(val) || !cols[c].add(val) || !boxes[boxIdx].add(val))
               return false;
⏱️ TIME:   O(1)  |  SPACE: O(1)  (fixed 9×9 board)
⚠️ EDGE:   Skip '.' cells, empty board is valid
🧠 KEY:    "Integer division collapses 3 indices into 1. r/3 maps 0,1,2→0 and 3,4,5→1."
           Reuses !set.add() idiom from Contains Duplicate.
```

---

## Card 14: Prefix Sum + HashMap — Max Length Variant (Transform & Sum-to-Zero)
```
🔍 TRIGGER: "Longest subarray with equal X and Y" or "equal number of two things"
💡 IDEA:   Transform one value to -1, other to +1 → "subarray sum = 0"
          Same prefix sum at two indices → subarray between sums to 0
📝 CODE:   map.put(0, -1); // handles subarray from index 0
          sum += (nums[i] == 0 ? -1 : 1);
          if (map.containsKey(sum)) maxLen = max(maxLen, i - map.get(sum));
          else map.put(sum, i); // ONLY first occurrence!
⏱️ TIME:   O(n)  |  SPACE: O(n)
⚠️ KEY:    Two variants of Prefix Sum + HashMap:
          • COUNT subarrays: store sum→count, init {0:1}, always update
          • MAX LENGTH: store sum→first_index, init {0:-1}, NEVER overwrite
```

---

## 🧠 Week 1 Summary Mantra
```
╔════════════════════════════════════════════════╗
║  Need to FIND something?  → HashMap            ║
║  Need UNIQUE check?       → HashSet            ║
║  Need to COUNT things?    → Frequency map       ║
║  Need SUBARRAY sum?       → Prefix sum          ║
║  Need to GROUP things?    → HashMap<key,list>    ║
║  Need TOP K by frequency? → Freq map + Bucket   ║
║  SORTED + find pair?      → Two Pointers        ║
║  Everything EXCEPT self?  → Prefix/Suffix       ║
║  Consecutive sequence?    → HashSet + Start Detect║
║  Encode/Decode strings?   → Length-Prefix        ║
║  Validate grid?           → HashSet per Row/Col/Box║
║  Equal count of 2 things? → Transform + PrefixSum║
║                                                ║
║  🔴 COMPARING TWO INPUTS? → SIZE CHECK FIRST!  ║
╚════════════════════════════════════════════════╝
```

---

_Cards for Week 2+ will be created as we progress._

