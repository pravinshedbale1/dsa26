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

## Card 3: Stack for Expression Evaluation (Evaluate RPN, LC #150)
```
🔍 TRIGGER: Postfix/prefix expression evaluation, or any "process left-to-right, combine
           the two most recent pending operands when an operator shows up" problem.
💡 IDEA:   Push numbers. On an operator, pop TWICE — second pop is the left operand,
           first pop is the right operand (order matters for - and /). Apply the op,
           push the result back. At the end, the stack holds exactly one value: the answer.
📝 CODE:   for (String t : tokens) {
             if (isOperator(t)) { int b = stack.pop(); int a = stack.pop();
               stack.push(apply(a, t, b)); }
             else stack.push(Integer.parseInt(t));
           }
           return stack.pop();
⏱️ TIME:   O(n)  |  SPACE: O(n) worst case, but tight bound is ~(n+1)/2 (still O(n) in Big-O —
           constants drop out). n = 2k+1 for k operators; each op is net -1 on stack depth.
⚠️ KEY:    Prefer checking token against the literal operator strings/chars over relying on
           parseInt throwing — a broad catch can silently swallow unrelated bugs in production.
           Operand order for pop: first pop = right-hand operand, second pop = left-hand.
⚠️ EDGE:   Negative number tokens (don't misparse "-11" as the '-' operator), division
           truncates toward zero (not floor — matters for negative results).
```

---

## Card 4: Monotonic Stack (Daily Temperatures, LC #739)
```
🔍 TRIGGER: "Next greater/warmer/larger element" — for each index, find the next index
           to the right with a bigger value.
💡 IDEA:   Keep a stack of indices whose temps are DECREASING bottom→top. When a new
           value beats the top, that top index just found its answer — pop it, record
           `i - poppedIndex`, and keep popping while the new value beats the new top.
           Once nothing left to pop (or nothing beats the new value), push i.
📝 CODE:   for (i = 0; i < n; i++) {
             while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
               int idx = stack.pop(); result[idx] = i - idx;
             }
             stack.push(i);
           }
⏱️ TIME:   O(n) amortized — each index pushed once, popped at most once |  SPACE: O(n)
⚠️ KEY:    No separate "push" branch needed — the while loop's own condition already
           no-ops when the top is bigger, so just always fall through to push after the
           while. Same "evict what can never win again" idea as Monotonic Deque, minus
           the front-expiry/window-size complication.
⚠️ EDGE:   Strictly increasing input (every element resolves the very next day), strictly
           decreasing (nothing ever resolves, all zeros), all-equal values (strict `<`
           means equal values never pop each other — correctly stay 0 until a real rise).
```

---
