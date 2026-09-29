# 🧠 Concept Knowledge — Arrays & Hashing

## HashMap internals (confirmed 2026-09-29)
- Array of buckets. `hashCode()` picks the bucket, `equals()` finds the key within it.
- O(1) average; collisions degrade a bucket: O(n) pre-Java 8, O(log n) Java 8+ (treeified buckets).
- **Resize** at load factor 0.75 → O(n) rehash, amortized O(1) per insert. Presize with `new HashMap<>(n)`.
- HashSet = HashMap with a dummy value.

## Aha moments
- **Two Sum:** a pair question becomes a lookup question. "Have I already seen `target - x`?" turns O(n²) into O(n).
- **Order of check vs insert matters.** Check first, then insert, so an element never pairs with itself.
## Sorting cost in Java (confirmed 2026-09-29)
- `Arrays.sort(int[])`: dual-pivot quicksort, O(n log n), **O(log n) stack**, so it's not truly O(1) space.
- `Arrays.sort(Object[])` / `Collections.sort`: TimSort, stable, up to **O(n)** extra space.
- Sorting in place **mutates the caller's array**. Sorting a clone avoids that but costs O(n).

## Aha moments (cont.)
- **Contains Duplicate:** `set.add()` returns false when the element already exists, so one call both checks and inserts.
- **Bounded value range → array instead of HashSet**: O(k) space, no hashing, no boxing.
## Frequency counting (2026-09-29)
- Order doesn't matter, only counts do → count, then compare.
- `int[k]` for a small fixed alphabet (`c - 'a'` → 0..25) is O(1) space because it doesn't grow with n. Unicode or unbounded keys → HashMap.
- Java `String` is immutable: sorting needs `toCharArray()`, which is an O(n) copy. Index with `charAt(i)` to avoid copies.

## Aha moments (cont.)
- **Valid Anagram:** with equal lengths, decrementing n times without ever going negative means every count ends at 0, so no final scan is needed. Without the length check, `s="ab", t="a"` wrongly returns true.
## Index marking: array as its own hash table (2026-09-29)
- Requires values in `[1, n]` (each value has a home slot `v-1`) and all values positive (the sign bit is free).
- Negative sign = "seen". Always read with `Math.abs(nums[i])` because the slot may already be flipped.
- Mutates the input: restore with a final `abs` pass (still O(n)/O(1)).
- One sign bit holds only seen/unseen. To count occurrences, add `n` per visit and read `(nums[i]-1)/n`; recover the original with `(nums[i]-1) % n + 1`.
- Mental model: lockers 1..n, the minus sign is a sticky note on the door.

## Aha moments (cont.)
- **Find All Duplicates:** arriving at a locker that already has a sticky note means this value was seen before, so it's a duplicate.
- **Overflow habit:** always check `a - b` / `a + b` against the constraints. The worst case for Two Sum is -2×10^9, which fits in `int`.
