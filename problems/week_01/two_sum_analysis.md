# Two Sum (LC #1) — Analysis

**Date**: 2026-09-29 · **Difficulty**: Easy · **Verdict**: 🟢 HIRE · **Time**: ~8 / 15 min · **Hints**: 0

## Pattern
**HashMap Complement** — rewrite "find `a + b = target`" as "have I already seen `target - b`?"

## Approaches
| Approach | Idea | Time | Space |
|---|---|---|---|
| Brute force | Nested loops over all pairs (i < j) | O(n²) | O(1) |
| Optimal | One pass; for each `x`, check map for `target - x`, else `put(x, i)` | O(n) | O(n) |
| Variant: sorted input | Two pointers from both ends (→ LC #167) | O(n) | O(1) |

## Key details
- **Check before insert.** Guarantees you never pair an element with itself, and handles duplicates like `[3,3]`: at i=0 the map is empty → put 3→0; at i=1 find 3 → return [1,0].
- **Overflow:** worst case `target - nums[i] = -10^9 - 10^9 = -2×10^9`, which is > `Integer.MIN_VALUE` (≈ -2.147×10^9), so `int` is safe. With wider bounds, use `long`.
- Map value = index (not a boolean), because we return indices.

## Interview feedback
- ✅ Jumped brute → optimal immediately; correct first try.
- ⚠️ Communication: skipped the space question, the `[3,3]` trace, and the overflow justification until pushed. **Answer every sub-question and state the "why" unprompted.**
- Nit: name `compPair` → `complement`.
