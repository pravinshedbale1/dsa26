# 📖 Stack & Queue — Concept Knowledge

> This file is populated through our conversations. Each section captures what you understood, not textbook definitions.

---

## Core Concept

### What is a Stack?

A **stack** is LIFO — Last In, First Out. Think of a stack of plates: you can only add or remove from the **top**. You can never grab one from the middle without removing everything above it first.

```
push(3)  →  [3]
push(7)  →  [3, 7]
push(2)  →  [3, 7, 2]
pop()    →  returns 2, stack is now [3, 7]
peek()   →  returns 7, stack unchanged
```

In Java: `Deque<Character> stack = new ArrayDeque<>();` — `push()`, `pop()`, `peek()`, all O(1).

**Why stacks fit matching/nesting problems**: nesting means "the most recently opened thing must be the first thing closed" — exactly LIFO behavior. That's why Valid Parentheses (and any bracket/tag-matching problem) reaches for a stack.

---

## Min Stack — Auxiliary Stack Trick

Need O(1) `push`, `pop`, `top`, AND `getMin()`. Problem: after a `pop()`, if the popped value was the current min, what's the new min? You can't just remember "the min" as a single value — you'd lose history.

**Fix**: run a second stack in parallel, tracking "what was the min at that point."

```
push(5):  main=[5]        minStack=[5]
push(3):  main=[5,3]      minStack=[5,3]      (3 < 5, new min)
push(7):  main=[5,3,7]    minStack=[5,3,3]    (7 > 3, min unchanged → repeat 3)
pop():    main=[5,3]      minStack=[5,3]      (popped together, min correctly back to 3)
```

**Key rule**: `minStack` gets a push on **every single push** to `main` — either the new value (if it's a new min) or a repeat of the current min. This keeps both stacks the same length, so `pop()` on both together never desyncs, and `minStack.peek()` always reflects the min of everything currently in `main`.

---

## Evaluate RPN — Stack for Expression Evaluation

Postfix notation removes the need for parentheses/precedence because operators always apply to the two most recently seen operands. A stack tracks exactly that "two most recent pending values."

```
tokens: 2 1 + 3 *
push 2      → [2]
push 1      → [2, 1]
'+' → pop 1, pop 2, push 2+1=3   → [3]
push 3      → [3, 3]
'*' → pop 3, pop 3, push 3*3=9   → [9]
result: 9
```

**Operand order matters for non-commutative ops**: the *first* pop is the right-hand operand, the *second* pop is the left-hand operand — `a - b` means pop `b` first, then `a`.

---

## Monotonic Stack — Daily Temperatures

Keep a stack of indices where the corresponding temperatures are **decreasing** from bottom to top. When a new, warmer temperature shows up, every colder index still sitting in the stack just found its "next warmer day" — pop them all, record `today - poppedIndex`, then push today.

```
temps: 73  71  68  76
push 73                → [73]
push 71 (71<73, waits)  → [73,71]
push 68 (68<71, waits)  → [73,71,68]
76 arrives: 68<76 → pop 68, answer[68's day]=3
            71<76 → pop 71, answer[71's day]=2
            73<76 → pop 73, answer[73's day]=3
push 76                → [76]
```

**Why this is O(n) despite the inner while loop**: every index is pushed exactly once and popped at most once across the whole run — the total work across all pops, summed over the whole array, is bounded by n. This is the same amortized argument as Week 3's Monotonic Deque (Sliding Window Maximum).

---

## Common Mistakes (Your Struggle Log)

| Date | Mistake | Fix |
|------|---------|-----|
| Jul 21 | Min Stack concept check: said `minStack` would look like `[5,3,3]` after pushing a 4th element (correct value, wrong length) | `minStack` must grow by exactly one entry per push to `main`, even when the min doesn't change — otherwise `pop()` desyncs the two stacks |
| Jul 21 | Valid Parentheses: on mismatch, code fell through to an `else` branch and pushed the closing bracket rather than failing fast | Still correct (a wrongly-pushed closer can never be matched later, since the map only maps closers→openers), but not fail-fast. Cleaner: return `false` immediately the moment `stack.peek() != map.get(ch)` on a closing bracket. |
| Jul 22 | Evaluate RPN: used a broad `try/catch (Exception e)` around `Integer.parseInt` to detect "this token is an operator" | Works, but swallows unrelated exceptions in production. Self-corrected to a direct check: `str.equals("+")||...` before falling back to `parseInt`. |
| Jul 22 | Daily Temperatures: wrote a redundant `if (top>current) push` branch before the `while` loop, duplicating logic the `while`'s own condition already handles when it doesn't fire | Harmless (not a bug), but unnecessary — just always fall through to `push` after the `while` loop unconditionally. Self-identified immediately when asked. |

---

## Key Insights (Aha! Moments)

1. **LIFO = nesting** — the defining property of a stack (only touch the top) is exactly what "properly nested" means: the innermost/most-recent thing must resolve first.
2. **Sentinel value avoids `isEmpty()` checks** (Valid Parentheses, Jul 21) — pushing a placeholder (e.g. `'z'`) at the bottom means `stack.peek()` is always safe to call, and the final validity check becomes `stack.peek() == sentinel` instead of `stack.isEmpty()`. **Only safe if the sentinel value can never appear in valid input** — here, constraints guarantee the string is bracket-characters-only, so `'z'` can't collide.
3. **Mismatched closers get "stuck," never falsely matched** — a closing bracket pushed onto the stack (because it didn't match the top) can never later be popped by another closing bracket, because the open→close map only ever maps a closer to an *opening* bracket character, never to another closer. This is why the non-fail-fast version of Valid Parentheses still produces a correct final answer, just without early-exit.
4. **Auxiliary stack = "track a derived running property that pop() must also roll back"** — the same shape as maintaining a running max/min elsewhere, but here `pop()` needs to undo the derived state (the min) exactly as cleanly as it undoes the main state, which is why the second stack mirrors the first stack's length 1:1.
5. **Postfix notation = "a stack is the parentheses"** (Evaluate RPN, Jul 22) — because operators always combine the two most recently seen operands, there's never any ambiguity about precedence or grouping; the stack's LIFO order does the work parentheses would otherwise do.
6. **Tight bound vs Big-O bound** (Evaluate RPN, Jul 22) — worst-case stack depth is `(n+1)/2` (n=2k+1 for k operators, each op is net -1 on depth), but Big-O still reports O(n) since constants are dropped. Knowing the tight constant is good practice, but doesn't change the asymptotic class.
7. **Monotonic Stack = "evict what can never win again"** (Daily Temperatures, Jul 22) — identical idea to Week 3's Monotonic Deque, just simpler: no front-expiry/window-size complication, only back-eviction. Once a bigger element shows up, everything smaller underneath is resolved immediately and never needs reconsidering.

---

## Interview Tips

1. "Matching/nesting" (brackets, tags, matching pairs in order) → Stack.
2. If you need O(1) access to a running aggregate (min/max) that must correctly "roll back" on pop → auxiliary stack tracking that aggregate at each depth.
3. Watch for fail-fast opportunities — a stack-based validity check doesn't have to scan the whole input if you can detect invalidity the moment it occurs.
4. Sentinel values are a valid simplification IF you can prove the sentinel can never collide with real input (check constraints).

---

## Related Patterns

- Stack Matching → Valid Parentheses
- Auxiliary Stack → Min Stack
- Stack for Expression Evaluation → Evaluate RPN
- Monotonic Stack → Daily Temperatures
- Monotonic Stack + HashMap → Next Greater Element I (precompute answers into a value→answer map)
- Monotonic (Increasing) Stack for boundaries → Largest Rectangle in Histogram

---

## Monotonic Stack — Three Flavors (Jul 23 insight, extended Jul 26)

The first two flavors share ONE core move: **when a new element arrives, evict everything on the stack that can never win again, and resolve each evicted element's answer at the moment it's popped.** What differs is *what gets recorded on pop*. The third flavor inverts the direction of information flow entirely.

1. **Next-greater / next-warmer (decreasing stack)** — Daily Temperatures, Next Greater Element I.
   - Stack holds elements *waiting* for a bigger value. The newcomer that beats them IS their answer.
   - Next Greater Element I twist: decouple queries from the scan — precompute the answer for *every* value of nums2 into a `value→answer` HashMap in one pass, then O(1) lookups. **The value-as-key only works because values are distinct** — with duplicates, key by index. (Classic "what breaks if the guarantee is dropped" interview probe.)

2. **Nearest-smaller-on-both-sides / max area (increasing stack)** — Largest Rectangle in Histogram.
   - When a *shorter* bar arrives, every taller pending bar is finalized: its **right boundary** is the newcomer, its **left boundary** is the new stack top after popping. `width = i - stack.peek() - 1`.
   - **Dual sentinels** make the edges uniform, and they are two *different* devices:
     - **Left sentinel = an INDEX** (`-1`) parked at the bottom of the stack. It stands in for "nearest smaller on the left" when the stack would otherwise empty, so `width = i - (-1) - 1 = i` falls out of the same formula with no `isEmpty()` branch. It must be `-1` because `0` is a **real index** — using `0` would silently chop one bar off every width. Mental model: an imaginary bar of height −∞ sitting at position −1, so nothing is ever smaller and it never pops.
     - **Right sentinel = a virtual HEIGHT** at `i == n` that drains the stack. Both `0` and `-1` work here, because the pop test is strict `>`: every leftover bar taller than 0 is forced off, and a height-0 bar left unresolved is harmless since its area is 0. `1` is the value that **fails** — `[1,1,1]` pops nothing and returns 0. Rule: right sentinel ≤ 0.
     - *(Correction, Jul 26: the Jul 23 note claimed the right sentinel "must be -1, not 0". That was wrong — `0` is the standard LC choice. The `-1`-must-not-be-`0` argument belongs to the **left/index** sentinel, not the height one. The two got conflated.)*
     - *(Recall status: the full left-sentinel justification was reproduced unprompted on Jul 26 — the Jul 23 code-ahead-of-why gap is now closed.)*
   - **Strict `>` pop** lets equal bars sit unresolved; the leftmost of an equal run pops last and captures the full width, so no wide rectangle is missed.

3. **Sort + collapse / "absorb" (Jul 26)** — Car Fleet.
   - The first two flavors *resolve*: the newcomer supplies the answer for whatever it pops. This one *absorbs*: the newcomer merges into what's already on the stack and disappears. Information flows the opposite way.
   - Preconditions differ too. Daily Temps and Largest Rectangle sweep the array **as given** — index order *is* the dependency order. Here the input order is meaningless, so **you must sort first**: by position descending, because a car only ever interacts with what is ahead of it. The sort is not preprocessing, it is the algorithm. (This is exactly the step that was missing from the first verbal pass on Jul 26 — the ETA transform came instantly, the ordering had to be probed for.)
   - Because you only ever compare against the top and never pop, the stack top is just a **running maximum**. The stack is therefore optional — one `double maxEta` plus a counter does the same job. Recognizing that a monotonic structure has degenerated to a single variable is a real interview signal.
   - **Boundary semantics matter**: `>=` not `>`, because equal ETAs mean the cars meet *exactly at* the destination, which the problem counts as one fleet.

**Generalized trigger for flavor 3**: elements travel along a line and can *block* or *merge into* the one ahead — cars that can't pass, jobs queued behind a slower one, anything asking "how many groups form". Sort into dependency order, then let a local rule collapse the chain. Same skeleton as **Boats to Save People** (Week 2) — sort first, then a greedy local rule collapses the sequence.

---

## Floating Point in Comparison Problems (Jul 26)

Car Fleet computes `ETA = (target - position) / speed` as a `double`. When is that safe, and how do you *prove* it rather than hope?

- **The gap argument**: two distinct ETAs are fractions `a/s1` and `b/s2`. If they differ at all, they differ by at least `1/(s1·s2)`. With speeds ≤ 10⁶ that floor is 10⁻¹². Double precision at these magnitudes carries error ~10⁻¹⁶ — four orders of magnitude smaller than the smallest real gap, so a comparison can never flip.
- **The formal bound**: comparing `a/s1` vs `b/s2` by cross-multiplication is exact while `a·s2 + b·s1 < 2^53` (≈9×10¹⁵). Here it's ≤ 2×10¹². Comfortable.
- **The escape hatch**: don't divide at all. Compare fractions by cross-multiplying in `long` — `(target-p1)*s2` vs `(target-p2)*s1`. Max product 10⁶ × 10⁶ = 10¹², nowhere near `long` overflow. Zero float risk.

Transferable rule: whenever a problem makes you divide to compare, either (a) bound the smallest possible gap against the precision floor, or (b) cross-multiply into integers and sidestep the question. Saying "doubles are probably fine" is not an answer.

---

## Week 4 Problem Map

| Day | Problem | Type | Notes |
|-----|---------|------|-------|
| D1 | Valid Parentheses (LC #20) | Stack Matching | ✅ Sentinel-stack trick, correct without fail-fast |
| D1 | Min Stack (LC #155) | Auxiliary Stack | ✅ Two-stack, push repeat on tie (`>=`), correct first try |
| D2 | Evaluate Reverse Polish Notation (LC #150) | Stack for Expression Evaluation | ✅ try/catch for operand/operator split, tight (n+1)/2 depth derived |
| D2 | Daily Temperatures (LC #739) | Monotonic Stack | ✅ First Monotonic Stack problem, clean transfer from Monotonic Deque concept |
| D3 | Next Greater Element I (LC #496) | Monotonic Stack + HashMap | ✅ Precompute all next-greaters into value→answer map; value-key valid only because distinct |
| D3 | Largest Rectangle in Histogram (LC #84) | Monotonic (Increasing) Stack | ✅ Hard, same-session concept. Dual sentinels, width = i - peek - 1. 6/6 first try |
| D4 | Car Fleet (LC #853) | Sort + Monotonic Stack (Absorb) | ✅ ETA transform + sort by position DESC. 5/5 first try, 0 hints. Stack collapses to one variable. Float-safety proven via 2^53 bound |
| D4 | Implement Queue using Stacks (LC #232) | Two-Stack Lazy Transfer | ✅ First DESIGN problem. 5/5 first try, 0 hints. `pop()` delegates to `peek()`. Rigorous amortized proof (≤4 ops/element → 4m/m). Missed the ArrayDeque-vs-Stack exception semantics |

---

## Amortized Analysis as a Design Tool (Jul 26)

Week 4 has now hit amortized O(1) from two different directions, and it's worth naming the shared shape.

**The pattern**: an individual operation is occasionally expensive, but the expensive work is *paid for* by cheap operations that preceded it, and no unit of work is ever repeated. Count total work across the whole sequence, divide by the number of operations, and the per-operation cost is constant.

| Where it showed up | The accounting |
|---|---|
| Monotonic stack (Daily Temps, Largest Rectangle, NGE I) | Each index is pushed once and popped once → ≤ 2n stack ops over n iterations |
| Two-stack queue (Implement Queue using Stacks) | Each element moves ≤ 4 times (into `in`, out of `in`, into `out`, out of `out`) and never back → ≤ 4m ops over m calls |
| Dynamic array doubling (background) | Copies are geometric; total copy work is ≤ 2n over n appends |

**How to state it in an interview** (the version that landed on Jul 26):
> "Each element causes at most 4 stack operations in its entire lifetime, and it never moves back. With at most m elements over m operations, total work is ≤ 4m, so 4m/m = 4 — constant. Amortized O(1)."

Count it. Don't say "it averages out."

**The distinction interviewers probe**: *amortized* is a **worst-case guarantee over any sequence** — no adversarial input can break it. *Average-case* is a claim about input distributions and says nothing about the worst input. They are not synonyms.

**How to present it**: lead with the amortized bound, then volunteer the worst-case single-operation cost unprompted. Giving both without being asked signals that you understand the structure rather than having memorized a number.

---

## Java API Precision — Empty-Collection Semantics (Jul 26)

A miss worth keeping visible: on the LC #232 follow-up, the empty-queue behavior was answered as `EmptyStackException` for code that uses `ArrayDeque`. Verified behavior:

| Call on empty | Result |
|---|---|
| `ArrayDeque.peek()` | returns **`null`** — no exception. In an `int`-returning method this becomes **`NullPointerException`** via auto-unboxing, from a line that never mentions null |
| `ArrayDeque.pop()` | `java.util.NoSuchElementException` |
| `ArrayDeque.element()` | `java.util.NoSuchElementException` |
| `java.util.Stack.peek()` | `java.util.EmptyStackException` |

Two lessons:
1. **`peek()` returning null instead of throwing** is the genuinely surprising one — the failure surfaces as an NPE at an unboxing site, which reads like an unrelated bug.
2. **Name the class before reasoning about its contract.** Having correctly switched from `Stack` to `ArrayDeque` for good reasons, the reasoning still ran against `Stack`'s API out of habit. Same shape as the Car Fleet ordering miss the same session: the concept was right, the specific was assumed rather than checked.
