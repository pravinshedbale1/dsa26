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
