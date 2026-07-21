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

## Common Mistakes (Your Struggle Log)

| Date | Mistake | Fix |
|------|---------|-----|
| Jul 21 | Min Stack concept check: said `minStack` would look like `[5,3,3]` after pushing a 4th element (correct value, wrong length) | `minStack` must grow by exactly one entry per push to `main`, even when the min doesn't change — otherwise `pop()` desyncs the two stacks |
| Jul 21 | Valid Parentheses: on mismatch, code fell through to an `else` branch and pushed the closing bracket rather than failing fast | Still correct (a wrongly-pushed closer can never be matched later, since the map only maps closers→openers), but not fail-fast. Cleaner: return `false` immediately the moment `stack.peek() != map.get(ch)` on a closing bracket. |

---

## Key Insights (Aha! Moments)

1. **LIFO = nesting** — the defining property of a stack (only touch the top) is exactly what "properly nested" means: the innermost/most-recent thing must resolve first.
2. **Sentinel value avoids `isEmpty()` checks** (Valid Parentheses, Jul 21) — pushing a placeholder (e.g. `'z'`) at the bottom means `stack.peek()` is always safe to call, and the final validity check becomes `stack.peek() == sentinel` instead of `stack.isEmpty()`. **Only safe if the sentinel value can never appear in valid input** — here, constraints guarantee the string is bracket-characters-only, so `'z'` can't collide.
3. **Mismatched closers get "stuck," never falsely matched** — a closing bracket pushed onto the stack (because it didn't match the top) can never later be popped by another closing bracket, because the open→close map only ever maps a closer to an *opening* bracket character, never to another closer. This is why the non-fail-fast version of Valid Parentheses still produces a correct final answer, just without early-exit.
4. **Auxiliary stack = "track a derived running property that pop() must also roll back"** — the same shape as maintaining a running max/min elsewhere, but here `pop()` needs to undo the derived state (the min) exactly as cleanly as it undoes the main state, which is why the second stack mirrors the first stack's length 1:1.

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

---

## Week 4 Problem Map

| Day | Problem | Type | Notes |
|-----|---------|------|-------|
| D1 | Valid Parentheses (LC #20) | Stack Matching | ✅ Sentinel-stack trick, correct without fail-fast |
| D1 | Min Stack (LC #155) | Auxiliary Stack | ✅ Two-stack, push repeat on tie (`>=`), correct first try |
