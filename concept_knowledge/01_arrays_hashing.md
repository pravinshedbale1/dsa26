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
- **Overflow habit:** always check `a - b` / `a + b` against the constraints. The worst case for Two Sum is -2×10^9, which fits in `int`.
