# Contains Duplicate (LC #217) — Analysis

**Date**: 2026-09-29 · **Difficulty**: Easy · **Verdict**: 🟢 HIRE · **Time**: ~6.5 / 15 min · **Hints**: 0

## Pattern
**HashSet Membership**: "have I seen this before?"

## Approaches
| Approach | Idea | Time | Space |
|---|---|---|---|
| Brute force | Compare every pair | O(n²) | O(1) |
| Sort | Sort, then check adjacent elements | O(n log n) | O(log n) stack (dual-pivot quicksort); mutates input |
| HashSet (optimal) | `if (!set.add(x)) return true` | O(n) | O(n) |
| Bounded range | `boolean[range]` seen array | O(n) | O(k) → O(1) for a fixed range |

## Key details
- `set.add()` returns `false` if the element is already present, so one call both checks and inserts.
- Sorting mutates the caller's array, and sorting a clone costs O(n). For objects, TimSort uses up to O(n) extra space.
- If the values fit in a small range, an array beats a HashSet: no hashing and no `Integer` boxing.

## Interview feedback
- ✅ Excellent on the space cost and side effects of sorting.
- ⚠️ Still dropping parts of multi-part questions (sort side effects at first, the cost of the bounded array).
