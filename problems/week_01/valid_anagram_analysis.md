# Valid Anagram (LC #242) — Analysis

**Date**: 2026-09-29 · **Difficulty**: Easy · **Verdict**: 🟡 LEAN HIRE · **Time**: ~11 / 15 min · **Hints**: 0

## Pattern
**Frequency Count** with +1/−1 balancing.

## Approaches
| Approach | Idea | Time | Space |
|---|---|---|---|
| Sort | Sort both char arrays and compare | O(n log n + m log m) | O(n + m): Java strings are immutable, so `toCharArray()` copies |
| Count (optimal) | Length check; `int[26]` +1 for s, −1 for t; fail when a count would go below 0 | O(n + m) | O(1) with `charAt` |
| Unicode follow-up | `HashMap<Character/Integer, Integer>` | O(n) | O(distinct chars) |

## Why no final scan is needed
With equal lengths, the counts start summing to n. Each char of t subtracts 1 without going negative, and there are exactly n of them, so the total reaches 0 with every count ≥ 0. That means every count is 0.

## Bug hit
Missed `if (s.length() != t.length()) return false;`, so `s="ab", t="a"` returned true. Caught by the tests and fixed quickly.

## Interview feedback
- ✅ Clean counting approach with an early return.
- ⚠️ Missed the unequal-length edge case. First complexity claims were imprecise (O(n) → O(m+n); sort space "~O(1)" → O(m+n)).
