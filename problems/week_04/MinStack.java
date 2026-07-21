
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Min Stack (LC #155)
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in O(1) time for all operations.
 *
 * Pattern: Auxiliary Stack (track running min alongside the main stack)
 *
 * Constraints:
 * - -2^31 <= val <= 2^31 - 1
 * - pop, top, getMin operations will always be called on a non-empty stack
 * - At most 3 * 10^4 calls total
 */

public class MinStack {

    // ========================================
    // TODO: Declare your fields
    // ========================================

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int value) {
        if (minStack.isEmpty() || minStack.peek() >= value) {
            minStack.push(value);
        }
        stack.push(value);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Basic push/getMin
        MinStack s1 = new MinStack();
        s1.push(-2);
        s1.push(0);
        s1.push(-3);
        assert s1.getMin() == -3 : "Test 1a failed: expected -3";
        s1.pop();
        assert s1.top() == 0 : "Test 1b failed: expected 0";
        assert s1.getMin() == -2 : "Test 1c failed: expected -2";

        // Test 2: Min unchanged across a pop that isn't the min
        MinStack s2 = new MinStack();
        s2.push(5);
        s2.push(3);
        s2.push(7);
        assert s2.getMin() == 3 : "Test 2a failed: expected 3";
        s2.pop(); // pops 7
        assert s2.getMin() == 3 : "Test 2b failed: expected 3";
        assert s2.top() == 3 : "Test 2c failed: expected 3";

        // Test 3: Repeated equal minimums
        MinStack s3 = new MinStack();
        s3.push(1);
        s3.push(1);
        s3.push(1);
        assert s3.getMin() == 1 : "Test 3a failed: expected 1";
        s3.pop();
        assert s3.getMin() == 1 : "Test 3b failed: expected 1";
        s3.pop();
        assert s3.getMin() == 1 : "Test 3c failed: expected 1";

        // Test 4: Min decreasing then popped back up
        MinStack s4 = new MinStack();
        s4.push(10);
        s4.push(8);
        s4.push(6);
        s4.push(4);
        assert s4.getMin() == 4 : "Test 4a failed: expected 4";
        s4.pop();
        s4.pop();
        assert s4.getMin() == 8 : "Test 4b failed: expected 8";

        // Test 5: Single element
        MinStack s5 = new MinStack();
        s5.push(42);
        assert s5.top() == 42 : "Test 5a failed: expected 42";
        assert s5.getMin() == 42 : "Test 5b failed: expected 42";

        System.out.println("All tests passed! ✅");
    }
}
