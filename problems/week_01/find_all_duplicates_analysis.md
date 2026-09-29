# Find All Duplicates in an Array (LC #442) — Analysis

**Date**: 2026-09-29 · **Difficulty**: Medium · **Verdict**: 🟢 HIRE · **Time**: ~5 / 25 min · **Hints**: 0

## Pattern
**Index Marking**: use the array as its own hash table, with the sign bit as the "seen" flag.

## Approaches
| Approach | Idea | Time | Space |
|---|---|---|---|
| Sort | Sort, check neighbours | O(n log n) | O(log n) |
| HashSet | `if (!set.add(x))` → dup | O(n) | O(n) |
| Index marking (optimal) | `v = abs(nums[i])`; `nums[v-1] < 0` → dup, else negate | O(n) | O(1) |

## Follow-ups discussed
- **Mutation:** a final `nums[i] = abs(nums[i])` pass restores the array and stays O(n)/O(1).
- **A value can appear 3×:** the sign-flip version adds it twice (`[2,2,2,1]` → `[2,2]`). Fix with a Set, which is bounded by the output size, or with a counter: `nums[(nums[i]-1) % n] += n`, count = `(nums[i]-1)/n`.

## Learning note
The technique didn't click from the first abstract explanation. It clicked after the locker analogy, a full step-by-step trace table, and a trace on the user's own array. **Teach new techniques with a worked trace first.**
