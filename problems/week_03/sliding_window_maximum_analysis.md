# Sliding Window Maximum (LC #239) — Analysis

**Date solved**: July 18, 2026 · **Difficulty**: Hard · **Verdict**: 🟢 HIRE · **Hints**: 0

## Pattern
**Fixed Sliding Window + Monotonic (Decreasing) Deque**

## Problem
Given `nums` and window size `k`, return the max of every contiguous window of size `k`.

## Approaches

### 1. Brute Force — O(n·k) / O(1)
For each of the `n-k+1` windows, scan all `k` elements for the max. Too slow for n = 10^5 with large k.

### 2. Optimal — Monotonic Deque — O(n) / O(k)
Keep a deque of **indices** whose values are in **decreasing order front→back**:

1. **Expire front**: if `dq.peekFirst() <= right - k`, `pollFirst()` — index slid out of the window. An `if` suffices (not `while`) because the window advances one step per iteration, so at most one index can expire.
2. **Evict back**: while `nums[dq.peekLast()] < nums[right]`, `pollLast()` — those elements are smaller AND older than the newcomer, so they can never be a window max again.
3. **Push**: `offerLast(right)`.
4. **Record**: once `right >= k-1`, answer for this window is `nums[dq.peekFirst()]`.

## Key Insights
- **Eviction logic ("younger and taller")**: an element is permanently useless the moment a newer element with value ≥ it arrives — the newcomer survives longer in the window AND is at least as large. Both conditions are required: smaller-but-newer elements stay (they outlive the current front).
- **Amortized O(n)**: each index is pushed exactly once and popped at most once → ≤ 2n deque operations total, despite the nested while loop. Same amortized argument as Longest Consecutive Sequence and variable-window shrink loops.
- **Strict `<` vs `<=` on back-eviction**: both are correct. `<=` also evicts equal values (safe — the newer equal copy dominates); `<` keeps redundant duplicates in the deque (slightly more space, still correct since front value is the same).
- **Space is O(k)**, not O(n): the deque only ever holds indices within one window's span.

## Java Notes
- `ArrayDeque` over `LinkedList` — same `Deque` API, faster.
- `offerLast` / `pollLast` / `peekLast` (back), `pollFirst` / `peekFirst` (front). `poll*`/`peek*` return `null` when empty.

## Session Notes (nuance tracking)
- Concept teach needed two passes: dense trace-table first (didn't land), then slow narrative walkthrough on `[4,2,5,1]` with the line-of-candidates analogy (landed immediately). Confirms the "concrete example before abstraction" teaching preference.
- First code draft was structurally broken (`dq.poll()` on empty deque, `while(dq.isEmpty())` inverted) and asked interviewer to validate mid-writing — deflected; self-recovered and produced clean correct code with zero further help.
- Follow-up reasoning was sharp: if-vs-while front expiry justified correctly, duplicate-handling for `<`/`<=` explained with the dominance argument.
