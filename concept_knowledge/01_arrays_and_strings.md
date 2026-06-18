# 📖 Arrays & Strings — Concept Knowledge

> This file is populated through our conversations. Each section captures what you understood, not textbook definitions.

---

## Core Concept

_To be filled during Session #1_

<!-- 
Template:
- What is an array? How does it work in memory?
- Why O(1) access? (contiguous memory + index calculation)
- Why O(n) insertion/deletion? (shifting elements)
- When to use array vs ArrayList vs LinkedList?
-->

---

## Key Insights (Aha! Moments)

- "HashSet is enough when I don't need key→value — just existence checking"
- "int[26] beats HashMap when charset is fixed — O(1) space, no boxing overhead"
- "HashMap Grouping is about: what property makes elements 'the same'? Use that as the key"
- "Frequency as array index (Bucket Sort) eliminates sorting entirely — O(n) instead of O(n log n)"
- "When a bucket can hold multiple values, MUST use List[] not int[] — otherwise overwrites happen"
- "Custom comparator `(a, b) -> map.get(b) - map.get(a)` sorts keys by their map values descending"
- "When array is SORTED, that's a gift — don't waste it with HashMap. Use Two Pointers for O(1) space"
- "Two Pointers on sorted: too small → move left right, too big → move right left"
- "Prefix/Suffix base case is 1 (multiplicative identity) — NOT the element itself"
- "Two passes, not two arrays — use output array for prefix, running variable for suffix → O(1) extra space"
- "Nested loop ≠ always O(n²). If inner loop total across ALL outer iterations = n, it's AMORTIZED O(n)"
- "Iterate over HashSet instead of input array to naturally handle duplicates without extra logic"
- "Sequence start detection: num-1 NOT in set means this is the beginning of a chain — only count from here"

---

## When to Use

| Data Structure | Use When... | Don't Use When... |
|---------------|------------|-------------------|
| Array | Fixed size, frequent access by index | Need dynamic resizing, frequent inserts |
| ArrayList | Dynamic size, mostly reads | Frequent inserts in middle |
| HashMap | O(1) lookups by key | Order matters |
| HashSet | O(1) membership check | Need duplicates |
| int[26] | Only lowercase letters | Unicode or mixed chars |
| List[] (Bucket) | Group items by numeric index (e.g. frequency) | Index range is huge or unknown |

---

## Common Mistakes (Your Struggle Log)

- `char[].toString()` returns memory address → use `new String(arr)` or `String.valueOf(arr)`
- Forgot `Arrays.sort(arr)` before using sorted char array as key
- `(List) map.values()` fails → use `new ArrayList<>(map.values())`
- `int[] buckets` overwrites when multiple values share same index → use `List[]`
- Missing inner loop bound check (`ptr >= k`) when iterating bucket contents → ArrayIndexOutOfBounds
- 🔴 **RECURRING**: Missing length/size early-exit check when comparing two inputs (3 times!)

---

## Complexity Rules for Arrays & Hashing

| Operation | Array | ArrayList | HashMap | HashSet |
|-----------|-------|-----------|---------|---------|
| Access by index | O(1) | O(1) | — | — |
| Search | O(n) | O(n) | O(1) avg | O(1) avg |
| Insert at end | — | O(1) amortized | O(1) avg | O(1) avg |
| Insert at middle | O(n) | O(n) | — | — |
| Delete | O(n) | O(n) | O(1) avg | O(1) avg |

---

## Interview Tips

1. Always ask: "Is the array sorted?" (changes approach completely)
2. Ask about duplicates — they affect HashSet/HashMap strategies
3. Ask about constraints (size, value range) — affects whether int[26] works vs HashMap
4. For in-place problems, think two-pointer first
5. For subarray problems, think prefix sum or sliding window

---

## Related Patterns
- HashMap Complement → Two Sum
- Frequency Count → Valid Anagram, Top K Frequent
- Prefix Sum → Subarray Sum Equals K, Product of Array Except Self
- Prefix/Suffix Product → Product of Array Except Self (O(1) space trick)
- HashMap Grouping → Group Anagrams
- Two Pointers (Opposite Ends) → Two Sum II (sorted input, O(1) space)
- HashSet + Sequence Start → Longest Consecutive Sequence (amortized O(n))
