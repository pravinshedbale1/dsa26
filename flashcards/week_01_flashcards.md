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

## 🧠 Week 1 Summary Mantra
```
╔════════════════════════════════════════════════╗
║  Need to FIND something?  → HashMap            ║
║  Need UNIQUE check?       → HashSet            ║
║  Need to COUNT things?    → Frequency map       ║
║  Need SUBARRAY sum?       → Prefix sum          ║
║  Need to GROUP things?    → HashMap<key,list>    ║
║  Need TOP K by frequency? → Freq map + Bucket   ║
╚════════════════════════════════════════════════╝
```

---

_Cards for Week 2+ will be created as we progress._

