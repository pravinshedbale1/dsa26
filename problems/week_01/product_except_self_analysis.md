# 📊 Product of Array Except Self — Analysis

## Problem Info
| Field | Value |
|-------|-------|
| **LeetCode** | #238 |
| **Difficulty** | Medium |
| **Pattern** | Prefix/Suffix Product |
| **Date** | June 18, 2026 (re-solve) |
| **Result** | 🟢 HIRE |
| **Time Taken** | ~11 min |
| **Hints Used** | 0 |
| **Bugs** | 0 |

---

## Approaches

### Brute Force — O(n²) time, O(1) space
For each element, multiply all other elements. Two nested loops.

### Two-Array — O(n) time, O(n) space
- `prefix[i]` = product of all elements before index i
- `suffix[i]` = product of all elements after index i
- `answer[i] = prefix[i] * suffix[i]`

### Optimal — O(n) time, O(1) extra space ✅
- Use the answer array itself for prefix products (left → right pass)
- Use a single running variable `product` for suffix products (right → left pass)
- Multiply `product` into answer array as you go

---

## Complexity Nuances 🔍

| Point | Detail |
|-------|--------|
| **Why O(1) space?** | The output array doesn't count as extra space (per problem definition). The only extra variable is `product` — a single int. |
| **Base case** | `answer[0] = 1` and `product = 1` — multiplicative identity. NOT the element itself. This is a common confusion point. |
| **Two passes, not two arrays** | First pass builds prefix into answer. Second pass multiplies suffix in-place using running variable. |

---

## Key Code

```java
// Pass 1: Prefix products into answer array
answer[0] = 1;
for (int i = 1; i < size; i++) {
    answer[i] = answer[i - 1] * nums[i - 1];
}

// Pass 2: Suffix products via running variable
int product = 1;
for (int i = size - 1; i >= 0; i--) {
    answer[i] = product * answer[i];
    product = product * nums[i];
}
```

---

## Session Notes

- **No mistakes** — zero bugs, zero hints on re-solve
- **Improvement**: June 10 needed 2 debug iterations on the optimization → today flawless
- **Pattern confidence**: 5/5 — Prefix/Suffix fully locked in
- **Approach articulation**: Explained both approaches + why O(1) space optimization works before coding

---

## Pattern: Prefix/Suffix

**When to use**: "Everything except current element" — product, sum, or any aggregate that excludes the current index.

**Key insight**: Build from both directions. Use output array for one direction + running variable for the other to achieve O(1) extra space.
