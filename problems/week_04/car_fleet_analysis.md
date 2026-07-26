# Car Fleet (LC #853) — Analysis

**Date solved**: July 26, 2026 (Session #26, Week 4 Day 4)
**Difficulty**: Medium · **Verdict**: 🟢 HIRE · **Hints**: 0 (one approach-level probe) · **Tests**: 5/5 first run

---

## Pattern

**Sort + Monotonic Stack — "absorb" flavor (rear-to-front collapse)**

Third distinct flavor of monotonic stack in Week 4:

| Flavor | Problem | On contact, the newcomer... |
|--------|---------|------------------------------|
| Pop-and-resolve (decreasing) | Daily Temperatures, Next Greater Element I | **answers** the popped element |
| Boundaries (increasing) | Largest Rectangle in Histogram | **finalizes** the popped element's rectangle |
| **Absorb** | **Car Fleet** | **vanishes into** what's already on the stack |

The first two push information *out* of the stack. This one pushes information *in* — the arriving car disappears and the fleet ahead is unchanged.

---

## The Insight Chain

1. **Transform to the deciding quantity.** A car's raw position and speed don't compose. Its **ETA** does: `eta = (target - position) / speed` — "when would I finish if nothing were in my way."
2. **Merging is a comparison of ETAs.** Car B (behind) merges into fleet A (ahead) iff `etaB <= etaA` — B would arrive at or before A, which is impossible without passing, so B is forced to slow to A's pace. The merged fleet keeps the **larger** (slower) ETA.
3. **Order is the algorithm.** A car only ever interacts with what is *ahead* of it. The input array is in arbitrary order, so you must **sort by position descending** and sweep from the car nearest the target backward. Without the sort, nothing works.
4. **Sweep and count.** Stack holds fleet ETAs. `stack.peek() >= eta` → absorbed, skip. Else push — a new fleet is born. Answer is `stack.size()`.

---

## Complexity

| | Time | Space |
|---|---|---|
| Brute force (pairwise / simulate) | O(n²) | O(1) |
| **Optimal** | **O(n log n)** — dominated by the sort | **O(n)** — `cars[n][2]` + TimSort aux |

The stack itself is **not** what makes it O(n) space — see below.

---

## Nuances & Interview Probes

### 1. The stack is unnecessary
You only ever call `peek()`, never `pop()`, and you only push when the new ETA is **larger** than the top. So the top is nothing more than "max ETA seen so far." Replace the whole `Deque<Double>` with a single `double maxEta` and a counter.

That drops the stack's contribution to **O(1)** — but total space stays **O(n)** because of the `cars[n][2]` pairs array and the comparator sort's auxiliary space (Java's `Arrays.sort(T[], Comparator)` is TimSort, which needs O(n)).

*Recognizing that a monotonic structure has degenerated into a single variable is a real interview signal — it shows you understand why the structure was there, not just that the template calls for one.*

### 2. Why `>=` and not `>`
The `=` corresponds to a specific sentence in the problem: *"if a car catches up to a fleet exactly at the destination, it is still considered part of that fleet."* Equal ETA = they meet precisely at `target` = one fleet.

Counterexample for strict `>`:
```
target = 10, position = [0, 5], speed = [2, 1]
both ETAs = 5   →  correct answer 1,  strict `>` returns 2
```

### 3. Is floating point safe here?
**Yes — and it's provable, not a hope.**

- Two distinct ETAs are fractions `a/s1` and `b/s2`. If they differ at all, they differ by at least `1/(s1·s2)`. With `speed ≤ 10⁶`, that floor is **10⁻¹²**.
- Double precision at these magnitudes carries error around **10⁻¹⁶** — four orders of magnitude below the smallest real gap. A comparison can never flip.
- Formal bound: cross-multiplied comparison is exact while `a·s2 + b·s1 < 2^53` (≈ 9×10¹⁵). Here it is ≤ 2×10¹².

**Integer-only alternative** (removes the question entirely): never divide. Compare `(target - p1) * s2` against `(target - p2) * s1` in `long`. Max product is 10⁶ × 10⁶ = 10¹² — nowhere near `long` overflow.

### 4. What if positions weren't distinct?
The problem guarantees distinct positions. Two cars at the same position would be physically overlapping — the sort comparator would need a tiebreak and the merge rule would need to define which one is "ahead."

---

## What Went Well

- ETA transform surfaced immediately, unprompted — the actual crux of the problem.
- `ArrayDeque` over `java.util.Stack`, carried forward from the Jul 23 feedback without a reminder.
- All 5 tests passed on the first run, zero debugging cycles.
- Follow-ups answered with unusual precision, especially the float-safety proof — reached for a formal bound (`2^53`) rather than hand-waving, then volunteered the cross-multiply escape hatch.

## What to Carry Forward

**The ordering step was described only after being probed for.** The ETA idea came first and fast; "I need to sort by position" arrived only when asked what order the sweep runs in. On any monotonic-stack problem the processing order *is* the algorithm — it belongs in the first sentence of the approach, not as an implementation detail discovered later.

---

## Sibling Problems

- **Boats to Save People (LC #881)** — same skeleton: sort first, then a greedy local rule collapses the sequence. In both, the sort is the insight, not the setup.
- **Daily Temperatures (LC #739) / Next Greater Element I (LC #496)** — same monotonic machinery, opposite direction of information flow (resolve vs. absorb).
