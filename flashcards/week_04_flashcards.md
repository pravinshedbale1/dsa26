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

## Card 5: Monotonic Stack + HashMap (Next Greater Element I, LC #496)
```
🔍 TRIGGER: "Next greater element for each query value, in another array" — nums1 is a
           subset of nums2, all distinct. Answer -1 if none to the right.
💡 IDEA:   Decouple from the queries: PRECOMPUTE next-greater for EVERY value in nums2 in
           one decreasing-stack pass, storing value→answer in a HashMap. Then just look
           up each nums1[i]. The stack resolves a waiting value the moment a bigger one
           appears (same pop-and-resolve as Daily Temperatures); leftovers on the stack
           never got a bigger element → default -1 via getOrDefault.
📝 CODE:   for (int n : nums2) {
             while (!stack.isEmpty() && stack.peek() < n)
               nextGreater.put(stack.pop(), n);
             stack.push(n);
           }
           for (i..) result[i] = nextGreater.getOrDefault(nums1[i], -1);
⏱️ TIME:   O(n1 + n2)  |  SPACE: O(n2)
⚠️ KEY:    Map is keyed by VALUE — only valid because nums2 is DISTINCT. If duplicates were
           allowed, one key can't stand for two positions with two answers → key by INDEX
           instead. This is the "what breaks if the guarantee is dropped" gotcha.
⚠️ NOTE:   Prefer ArrayDeque over java.util.Stack in production (Stack is legacy/synchronized,
           extends Vector). Same monotonic-stack skeleton as Daily Temps, but resolve into a
           map (values as keys) instead of an index-keyed result array.
```

---

## Card 6: Monotonic (Increasing) Stack — Boundaries (Largest Rectangle in Histogram, LC #84)
```
🔍 TRIGGER: "Largest rectangle in a histogram" / for each bar find how far it extends left
           and right until a SHORTER bar. Any "max area/width bounded by nearest smaller
           on both sides" problem.
💡 IDEA:   Keep an INCREASING stack of indices. When a bar arrives that's shorter than the
           top, the top bar's rectangle is finalized: pop it. Its RIGHT boundary = current i;
           its LEFT boundary = the new stack top after popping (nearest shorter to the left).
           width = i - stack.peek() - 1  (or = i if stack becomes empty / hits -1 sentinel).
           area = heights[popped] * width. Keep popping while top > current.
📝 CODE:   Deque<Integer> st = new ArrayDeque<>(); st.push(-1);   // bottom sentinel
           for (int i = 0; i <= n; i++) {
             int curr = (i == n) ? -1 : heights[i];              // right sentinel drains stack
             while (st.peek() != -1 && heights[st.peek()] > curr) {
               int h = heights[st.pop()];
               int w = i - st.peek() - 1;
               max = Math.max(max, h * w);
             }
             st.push(i);
           }
⏱️ TIME:   O(n) amortized (each index pushed once, popped once)  |  SPACE: O(n)
⚠️ KEY:    TWO sentinels, and they are DIFFERENT things — don't conflate them.
           (1) LEFT sentinel = the INDEX `-1` parked at the bottom of the stack. It stands in
               for "nearest smaller on the left" when the stack would otherwise empty, so
               width = i - (-1) - 1 = i with no isEmpty() special case. It must be -1 because
               0 is a REAL index — using 0 would chop one bar off every width. Think of it as
               an imaginary height-(-∞) bar at position -1 that never pops.
           (2) RIGHT sentinel = a virtual HEIGHT at i==n that drains the stack. Both `0` and
               `-1` work: pop is strict `>`, so every leftover bar of height > 0 is forced off,
               and a height-0 bar left unresolved is harmless (its area is 0 anyway).
               `1` is what FAILS — [1,1,1] pops nothing and wrongly returns 0.
           (Jul 23 note said the right sentinel "must be -1, not 0" — that was WRONG; 0 is the
            standard LC choice. Corrected Jul 26. Rule: right sentinel <= 0.)
⚠️ WHY EQUAL OK: strict `>` means equal bars don't pop each other; the LEFTMOST of an equal run
           pops last and gets the full width → widest rectangle still counted.
```

---

## Card 7: Sort + Monotonic Stack — "Absorb" Flavor (Car Fleet, LC #853)
```
🔍 TRIGGER: Elements move along a line and can BLOCK / merge into the one ahead of them —
           cars that can't pass, tasks that queue behind a slower one, anything where a
           faster follower is capped by a slower leader. Also: "count the groups that form."
💡 IDEA:   1. Convert each element to the quantity that decides merging — here
              ETA = (target - position) / speed  ("when do I finish, unobstructed").
           2. SORT into dependency order — by position DESCENDING (closest to target first).
              The sort IS the algorithm, not preprocessing: a car only ever interacts with
              what is AHEAD of it, so you must sweep in that order.
           3. Sweep back-to-front keeping a stack of fleet ETAs. If curr ETA <= stack top,
              this car catches the fleet ahead → ABSORBED, skip it (the fleet keeps the
              SLOWER/larger ETA, which is already on top). Else push — a new fleet.
           4. Answer = stack.size().
📝 CODE:   int[][] cars = new int[n][2];                    // (position, speed) pairs
           for (int i = 0; i < n; i++) { cars[i][0]=position[i]; cars[i][1]=speed[i]; }
           Arrays.sort(cars, (a, b) -> b[0] - a[0]);        // position DESC
           Deque<Double> stack = new ArrayDeque<>();
           for (int i = 0; i < n; i++) {
             double eta = (double)(target - cars[i][0]) / cars[i][1];
             if (!stack.isEmpty() && stack.peek() >= eta) continue;   // absorbed
             stack.push(eta);                                        // new fleet
           }
           return stack.size();
⏱️ TIME:   O(n log n) — dominated by the sort  |  SPACE: O(n) — pairs array + TimSort aux
⚠️ NO STACK NEEDED: you only ever read peek() and never pop, and you only push when the new
           ETA is LARGER → the top is just "max ETA so far". Replace with one `double maxEta`
           + a counter. That drops the stack to O(1); total stays O(n) because of cars[][].
⚠️ WHY `>=` NOT `>`: equal ETA = they meet EXACTLY at the destination, which the problem
           counts as ONE fleet. Counterexample for strict `>`:
           target=10, position=[0,5], speed=[2,1] → both ETA 5 → answer 1, strict `>` gives 2.
⚠️ FLOAT SAFETY: doubles ARE safe here. Two distinct ETAs differ by >= 1/(s1*s2) >= 1e-12,
           while double error at this magnitude is ~1e-16. Formal bound: safe while
           num1*den2 + num2*den1 < 2^53 (~9e15); here <= 2e12.
           Integer-only version: never divide — cross-multiply the fractions in `long`
           (max product 10^6 * 10^6 = 10^12, nowhere near overflow).
⚠️ CONTRAST: Daily Temps / NGE = POP-AND-RESOLVE (the newcomer answers the popped element).
           Car Fleet = ABSORB (the newcomer vanishes into what's already there). Same
           monotonic skeleton, opposite direction of information flow.
🔗 SIBLING: Boats to Save People — same skeleton (sort first, then a greedy local rule
           collapses the sequence). In both, the sort is the insight, not the setup.
```

---

## Card 8: Two-Stack Lazy Transfer (Implement Queue using Stacks, LC #232)
```
🔍 TRIGGER: "Build a FIFO queue out of LIFO stacks" / any design problem where the
           natural operation order is the REVERSE of what you need. More generally:
           "make an expensive reordering amortized cheap."
💡 IDEA:   Pouring stack A into stack B reverses it. Give the two stacks FIXED roles:
           `in`  — every push goes here, no exceptions.
           `out` — every pop/peek is served from here.
           Drain `in` into `out` ONLY when `out` is empty. Never at any other time.
           `out` is effectively a cache of already-reversed elements; you refill it
           only when it runs dry, and no element is ever reversed twice.
📝 CODE:   push(x): in.push(x);
           peek():  if (out.isEmpty()) while (!in.isEmpty()) out.push(in.pop());
                    return out.peek();
           pop():   peek(); return out.pop();       // delegate → transfer logic in ONE place
           empty(): return in.isEmpty() && out.isEmpty();   // BOTH must be empty
⏱️ TIME:   push O(1) | pop/peek AMORTIZED O(1), worst case O(n) on the draining call
           empty O(1)  |  SPACE: O(n)
⚠️ THE CONDITION IS THE PROBLEM: `if (out.isEmpty())`. Transfer while `out` is
           non-empty and newly pushed elements land ON TOP of older ones → FIFO breaks.
           Killer test: push 1,2 → pop (=1) → push 3,4 → pop MUST be 2, not 3.
⚠️ AMORTIZED PROOF (say it like this): each element causes <= 4 stack ops in its whole
           lifetime — push to `in`, pop from `in`, push to `out`, pop from `out` — and it
           never moves back. <= m elements over m ops → <= 4m total → 4m/m = 4 = O(1).
⚠️ AMORTIZED != AVERAGE-CASE: amortized is a WORST-CASE guarantee over ANY sequence
           (no adversarial input breaks it); average-case is a claim about input
           distributions. Interviewers ask. Lead with amortized O(1), then volunteer
           the O(n) worst case unprompted.
⚠️ JAVA API TRAP (cost a point on Jul 26): with ArrayDeque, `peek()` on empty returns
           NULL — an int-returning method then throws NullPointerException via unboxing.
           EmptyStackException belongs to java.util.Stack; NoSuchElementException is what
           ArrayDeque.pop()/element() throw. Know which class you're actually holding.
🔗 SIBLING: same accounting as a monotonic stack ("each index pushed once, popped once")
           and dynamic-array doubling. Defer expensive work, then do it in bulk.
```

---
