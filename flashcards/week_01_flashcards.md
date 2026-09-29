# 🃏 Week 1 Flashcards — Arrays & Hashing

---

### Card 1 — Two Sum (LC #1)
**Q:** Find indices of two numbers summing to `target`. Pattern + key detail?
**A:** HashMap Complement. Map `value → index`. For each `x`: if `target - x` in map → return; else `put(x, i)`. **Check before put** (handles `[3,3]`, never reuses same index). O(n) / O(n). Sorted + O(1) space → two pointers.

### Card 2 — HashMap internals
**Q:** What happens on `map.get(key)`? Why is it O(1) *average*?
**A:** `hashCode()` → bucket index; `equals()` to find the key inside the bucket. Collisions degrade a bucket to O(n) (pre-Java 8) or O(log n) (Java 8+ treeifies buckets). Resize at load factor 0.75 costs O(n) once but is amortized O(1) per insert. Presize with `new HashMap<>(n)` when size is known.

### Card 3 — HashMap vs HashSet
**Q:** When to use which?
**A:** HashMap for key → value (e.g. value → index). HashSet for uniqueness / "seen it?" checks. HashSet is backed by a HashMap with a dummy value.

### Card 4 — Contains Duplicate (LC #217)
**Q:** Any value appearing twice? Give three approaches plus the trade-off.
**A:** Brute O(n²)/O(1). Sort then compare neighbours O(n log n), with O(log n) stack space, and it mutates the input. HashSet: `if (!set.add(x)) return true`, O(n)/O(n). Small known range (e.g. 0..1000) → `boolean[1001]`, O(n)/O(k).

### Card 5 — Valid Anagram (LC #242)
**Q:** Is t an anagram of s? What's the first check, and why is no final scan needed?
**A:** First check: `s.length() != t.length()` → false. Then `int[26]`: +1 for each char of s, and for each char of t return false if the count is already 0, else −1. Equal lengths plus no negatives means all counts end at 0. O(n) / O(1). Sorting costs O(n log n) and O(n) space in Java (immutable strings). Unicode → HashMap.

### Card 6 — Frequency counting: array vs HashMap
**Q:** When do you use `int[26]` vs a HashMap for counts?
**A:** Use `int[k]` for a small known key range: direct indexing, no hashing or boxing, O(1) space for a fixed k. Use a HashMap for unbounded or unknown keys (Unicode, large ints, strings): O(distinct keys).

### Card 7 — Find All Duplicates in an Array (LC #442)
**Q:** Values in [1, n], each appearing 1–2 times. Find all duplicates in O(n) time and O(1) space.
**A:** Index marking. `v = abs(nums[i])`; if `nums[v-1] < 0` add v, else `nums[v-1] = -nums[v-1]`. Restore with a final abs pass if the caller needs the array. If a value can appear 3× → use a +n counter per slot (or a Set).

### Card 8 — When does index marking apply?
**Q:** What are the three signals for "use the array as a hash table"?
**A:** (1) Values lie in [1, n] / [0, n-1], tied to the array length. (2) "O(1) extra space". (3) The question is about seen/missing/duplicate values. The sign bit must be free, so all values must be positive.
