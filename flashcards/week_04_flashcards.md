# 📝 Week 4 Flashcards — Stack & Queue

> Write these on your whiteboard. Glance every morning.

---

## Card 1: Stack for Matching/Nesting (Valid Parentheses, LC #20)
```
🔍 TRIGGER: "Valid nesting/matching" — brackets, tags, any "most-recent-must-close-first" problem
💡 IDEA:   Push opening brackets. On a closing bracket, check it matches the top (map close→open).
           If it matches, pop; if not, invalid. At the end, stack must be empty (or back to sentinel).
📝 CODE:   Map<Character,Character> map = {')':'(', ']':'[', '}':'{'};
           for (char c : s) { if (map.containsValue(c)) push(c);
             else if (stack.isEmpty() || stack.pop() != map.get(c)) return false; }
           return stack.isEmpty();
⏱️ TIME:   O(n)  |  SPACE: O(n) worst case (all opening brackets)
⚠️ KEY:    A sentinel value at the stack's bottom avoids repeated `!isEmpty()` checks — only safe
           if the sentinel can never appear in valid input (check constraints first).
⚠️ EDGE:   Empty string (vacuously valid depending on constraints), single unmatched bracket,
           interleaved-not-nested ("([)]"), leftover opens at the end ("(()").
```

---

## Card 2: Auxiliary Stack — Running Min (Min Stack, LC #155)
```
🔍 TRIGGER: "Design a stack with O(1) getMin/getMax" — need a derived aggregate that
           correctly "rolls back" when you pop.
💡 IDEA:   Run a second stack in parallel. On every push, also push onto minStack —
           either the new value (if it's a new min) or a REPEAT of the current min
           (use >= so ties also get repeated, not just >). Both stacks stay the same
           length, so pop() on both together never desyncs.
📝 CODE:   push(v): if (minStack.isEmpty() || minStack.peek() >= v) minStack.push(v);
                     stack.push(v);
           pop():  if (stack.peek().equals(minStack.peek())) minStack.pop();
                     stack.pop();
           getMin(): return minStack.peek();
⏱️ TIME:   O(1) per operation  |  SPACE: O(n) (2n worst case, e.g. strictly descending input)
⚠️ KEY:    A single `minSoFar` variable doesn't work — it has no memory of the min's
           history, so once the element that set the current min is popped, the
           previous min is unrecoverable without rescanning.
⚠️ EDGE:   Repeated equal minimums (push 1,1,1 → pop → pop → min still 1), min set then
           immediately popped back out.
```

---
