# Implement Queue using Stacks (LC #232) — Analysis

**Date solved**: July 26, 2026 (Session #26, Week 4 Day 4)
**Difficulty**: Easy · **Verdict**: 🟢 HIRE · **Hints**: 0 · **Tests**: 5/5 first run

---

## Pattern

**Two-Stack Lazy Transfer (amortized O(1) queue)**

First *design* problem of the plan — the deliverable is a data structure, not an algorithm over an input. The reusable idea is not "two stacks make a queue"; it is **defer expensive work until it's unavoidable, then do it in bulk and never repeat it.**

---

## The Design

| Stack | Role |
|-------|------|
| `in` (stack1) | Every `push` lands here. No exceptions. |
| `out` (stack2) | Every `pop`/`peek` is served from here. |

Pouring `in` into `out` reverses the order, so the oldest element ends up on top — exactly FIFO. The drain happens **only when `out` is empty**.

```java
push(x): in.push(x);
peek():  if (out.isEmpty()) while (!in.isEmpty()) out.push(in.pop());
         return out.peek();
pop():   peek(); return out.pop();
empty(): return in.isEmpty() && out.isEmpty();
```

`out` is best understood as a **cache of already-reversed elements**. You refill it only when it runs dry, and no element is ever reversed twice.

---

## The Load-Bearing Detail

`if (out.isEmpty())` is the entire problem. Transfer at any other moment and newly pushed elements land *on top of* older ones, and FIFO silently breaks.

The test built to catch this:
```
push 1, push 2  →  pop() == 1   (out now holds [2])
push 3, push 4                  (in now holds [3,4] — do NOT transfer)
pop() MUST be 2, not 3
```
A premature transfer returns 3 here, and the failure looks like a logic bug far from its cause.

---

## Complexity

| Operation | Worst case (single call) | Amortized |
|-----------|--------------------------|-----------|
| `push` | O(1) | O(1) |
| `pop` | O(n) — the call that triggers a drain | **O(1)** |
| `peek` | O(n) — same | **O(1)** |
| `empty` | O(1) | O(1) |

Space: **O(n)**.

### The amortized proof, stated rigorously

Each element causes **at most 4 stack operations** across its entire lifetime:
1. pushed onto `in`
2. popped off `in`
3. pushed onto `out`
4. popped off `out`

and it **never moves back**. Over `m` operations there are at most `m` elements, so total work is ≤ `4m` stack operations. Divide by `m` operations → **4 = a constant** → amortized O(1).

**Amortized ≠ average-case.** Amortized is a *worst-case guarantee over any sequence* — no adversarial input can break it. Average-case is a claim about input distributions. Interviewers do probe this distinction.

**Which to lead with:** amortized O(1), then volunteer the O(n) worst case unprompted. Stating both without being asked signals you understand the structure rather than reciting a number.

---

## Nuances & Interview Probes

### 1. Why `pop()` delegates to `peek()`
Both operations need `out` loaded with the reversed order, so delegating keeps the transfer loop in **exactly one place**. The alternative duplicates the `while` loop in both methods, where the two copies can drift apart under later edits. Cost is one extra function call; benefit is a single point of change.

### 2. Empty-queue behavior — the API trap
The constraints guarantee `pop`/`peek` are never called on an empty queue. Drop that guarantee and, **with `ArrayDeque`**:

```
ArrayDeque.peek() -> returns null  →  NullPointerException on int unboxing
ArrayDeque.pop()  -> java.util.NoSuchElementException
java.util.Stack.peek() -> java.util.EmptyStackException
```

So `peek()` throws **NPE** — from a line that never mentions `null` — and `pop()` throws NPE too, inside its delegated `peek()` call, before ever reaching `out.pop()`.

⚠️ **This was the one miss on Jul 26**: answered `EmptyStackException`, which belongs to `java.util.Stack` — the class deliberately *not* used here. The reasoning was applied to the remembered API rather than the one actually on the page.

**Fix**: guard at the top of `peek()` — `if (empty()) throw new NoSuchElementException(...)`. `pop()` inherits the protection for free via delegation. Alternatively return a sentinel, depending on the contract you want to publish.

### 3. Why not transfer on push instead?
You could keep the queue order in `in` by dumping to a helper, inserting at the bottom, and dumping back on every push. That gives O(1) `pop` but **O(n) `push`** — and it re-reverses on every single operation, so there's no amortization to claim. The lazy version wins because work is done once per element rather than once per operation.

---

## What Went Well

- Design, both complexity bounds, and *which bound to lead with* all delivered before writing a line of code.
- `pop()` → `peek()` delegation reached for unprompted — the cleanest form of this solution.
- All 5 test groups passed first run, including the interleaving trap.
- The amortized argument was **rigorous rather than gestural**: counted 4 ops per element, bounded elements by `m`, divided. Most candidates say "it averages out" and stop.

## What to Carry Forward

**Reason about the API you're actually holding.** Naming `EmptyStackException` for an `ArrayDeque` is the same shape as the Car Fleet ordering miss earlier in this session — the concept was right, the specific was assumed rather than checked. When a question turns on library behavior, name the class first, then its contract.

---

## Sibling Problems

- **Monotonic stack** (Daily Temperatures, Largest Rectangle) — same amortized accounting: "each index pushed once, popped once."
- **Dynamic array doubling** — same deferred-bulk-work shape.
- **Implement Stack using Queues (LC #225)** — the mirror problem; worth doing as a contrast, since there the cost cannot be amortized away as cleanly.
