import java.util.*;

/*
 * ============================================================
 * IMPLEMENT QUEUE USING STACKS (LC #232) — Easy
 * ============================================================
 *
 * Implement a first-in-first-out (FIFO) queue using only two stacks.
 * The implemented queue must support all the normal queue operations:
 *
 *   void push(int x)  — push element x to the BACK of the queue
 *   int  pop()        — remove and return the element from the FRONT
 *   int  peek()       — return the element at the FRONT without removing it
 *   boolean empty()   — return true if the queue is empty
 *
 * ------------------------------------------------------------
 * RULES:
 *   - You may only use the standard operations of a stack: push to top,
 *     peek/pop from top, size, and is-empty.
 *   - Depending on your language, a stack may not be natively supported.
 *     You may simulate one using a list or deque, as long as you ONLY use
 *     the standard stack operations. (In Java: ArrayDeque used as a stack.)
 *   - You may NOT use a Deque as a queue (no pollLast/addFirst tricks) —
 *     that defeats the exercise.
 *
 * ------------------------------------------------------------
 * Example:
 *   MyQueue q = new MyQueue();
 *   q.push(1);          // queue: [1]
 *   q.push(2);          // queue: [1, 2]
 *   q.peek();           // returns 1
 *   q.pop();            // returns 1, queue: [2]
 *   q.empty();          // returns false
 *
 * ------------------------------------------------------------
 * Constraints:
 *   1 <= x <= 9
 *   At most 100 calls total to push, pop, peek, and empty.
 *   All calls to pop and peek are valid (never called on an empty queue).
 *
 * ------------------------------------------------------------
 * FOLLOW-UP (the real question):
 *   Can you implement the queue such that each operation is AMORTIZED
 *   O(1) time complexity? In other words, performing n operations takes
 *   overall O(n) time even if one individual operation may take longer.
 *
 * ------------------------------------------------------------
 * PATTERN: Two-Stack Lazy Transfer (amortized O(1) queue)
 *
 * KEY INSIGHT: Pouring one stack into another REVERSES it. Give the two stacks
 * fixed roles — `in` receives every push, `out` serves every pop/peek — and
 * drain `in` into `out` ONLY when `out` is empty. That condition is the whole
 * problem: transfer at any other moment and newly pushed elements land on top
 * of older ones, breaking FIFO (see Test 3).
 *
 * Naive:        on every push, dump to a helper, insert at the bottom, dump back
 *               → O(n) per push. Correct but re-reverses on every operation.
 * Optimal:      lazy transfer → push O(1), pop/peek amortized O(1)
 *               (worst case O(n) on the call that triggers a drain), space O(n)
 *
 * AMORTIZED PROOF: each element causes at most 4 stack operations in its whole
 * lifetime — pushed to `in`, popped from `in`, pushed to `out`, popped from
 * `out` — and it NEVER moves back. Over m operations there are at most m
 * elements, so total work <= 4m stack ops. 4m / m = 4 = constant → O(1)
 * amortized. Amortized is a worst-case guarantee over ANY sequence, not an
 * average over a distribution — no adversarial input breaks it.
 *
 * NUANCES:
 *   - `pop()` delegates to `peek()` so the transfer loop lives in exactly one
 *     place (DRY — the two copies can't drift apart).
 *   - Empty-queue behavior with ArrayDeque (NOT java.util.Stack):
 *       ArrayDeque.peek() returns NULL, so `return stack2.peek();` on an int
 *       method throws NullPointerException via auto-unboxing — not
 *       EmptyStackException (that's java.util.Stack) and not
 *       NoSuchElementException (that's ArrayDeque.pop()/element()).
 *     Fix: guard at the top of peek(); pop() inherits it via delegation.
 * ============================================================
 */
public class ImplementQueueUsingStacks {

    static class MyQueue {

        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            peek();
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    // ---------------- Driver / Tests ----------------
    public static void main(String[] args) {

        // Test 1: LC example — basic push/peek/pop/empty
        MyQueue q1 = new MyQueue();
        q1.push(1);
        q1.push(2);
        assert q1.peek() == 1 : "Test 1a failed: peek should be 1";
        assert q1.pop() == 1 : "Test 1b failed: pop should be 1";
        assert !q1.empty() : "Test 1c failed: queue should not be empty";
        assert q1.pop() == 2 : "Test 1d failed: pop should be 2";
        assert q1.empty() : "Test 1e failed: queue should be empty";

        // Test 2: FIFO order preserved across a straight run
        MyQueue q2 = new MyQueue();
        for (int i = 1; i <= 5; i++)
            q2.push(i);
        for (int i = 1; i <= 5; i++)
            assert q2.pop() == i : "Test 2 failed at element " + i;
        assert q2.empty() : "Test 2 failed: should be empty at end";

        // Test 3: INTERLEAVED push/pop — this is the one that breaks a
        // premature transfer (draining `in` into `out` while `out` is non-empty)
        MyQueue q3 = new MyQueue();
        q3.push(1);
        q3.push(2);
        assert q3.pop() == 1 : "Test 3a failed";
        q3.push(3); // pushed while `out` still holds 2
        q3.push(4);
        assert q3.pop() == 2 : "Test 3b failed: expected 2 (old element wins)";
        assert q3.pop() == 3 : "Test 3c failed: expected 3";
        assert q3.pop() == 4 : "Test 3d failed: expected 4";
        assert q3.empty() : "Test 3e failed: should be empty";

        // Test 4: peek() must not consume, and must trigger a transfer if needed
        MyQueue q4 = new MyQueue();
        q4.push(7);
        q4.push(8);
        assert q4.peek() == 7 : "Test 4a failed";
        assert q4.peek() == 7 : "Test 4b failed: peek must not consume";
        assert q4.pop() == 7 : "Test 4c failed";
        assert q4.peek() == 8 : "Test 4d failed";
        assert !q4.empty() : "Test 4e failed";

        // Test 5: drain fully, then reuse the same queue (both stacks empty mid-life)
        MyQueue q5 = new MyQueue();
        assert q5.empty() : "Test 5a failed: fresh queue must be empty";
        q5.push(9);
        assert q5.pop() == 9 : "Test 5b failed";
        assert q5.empty() : "Test 5c failed: empty after draining";
        q5.push(1);
        q5.push(2);
        assert q5.pop() == 1 : "Test 5d failed after reuse";
        q5.push(3);
        assert q5.pop() == 2 : "Test 5e failed after reuse";
        assert q5.pop() == 3 : "Test 5f failed after reuse";
        assert q5.empty() : "Test 5g failed";

        System.out.println("All tests passed!");
    }
}
