import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation (LC #150)
 *
 * You are given an array of strings `tokens` that represents an arithmetic
 * expression in Reverse Polish Notation. Evaluate the expression and return
 * an integer that represents its value.
 *
 * Valid operators are '+', '-', '*', and '/'. Division truncates toward
 * zero. There will not be any division by zero. The expression is always
 * valid.
 *
 * Pattern: ??? (name it before you code)
 *
 * Constraints:
 * - 1 <= tokens.length <= 10^4
 * - tokens[i] is either an operator ("+", "-", "*", "/") or an integer in
 * the range [-200, 200]
 */

public class EvaluateRPN {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int evalRPN(String[] tokens) {
                Stack<Integer> stack = new Stack<>();
                for (String str : tokens) {
                        try {
                                int val = Integer.parseInt(str);
                                stack.push(val);
                        } catch (Exception e) {
                                char ch = str.charAt(0);
                                int operand2 = stack.pop();
                                int operand1 = stack.pop();
                                int result = 0;
                                if (ch == '+') {
                                        result = operand1 + operand2;
                                } else if (ch == '-') {
                                        result = operand1 - operand2;
                                } else if (ch == '*') {
                                        result = operand1 * operand2;
                                } else {
                                        result = operand1 / operand2;
                                }
                                stack.push(result);
                        }
                }
                return stack.peek();
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert evalRPN(new String[] { "2", "1", "+", "3", "*" }) == 9
                                : "Test 1 failed: expected 9";

                // Test 2: Mixed operators
                assert evalRPN(new String[] { "4", "13", "5", "/", "+" }) == 6
                                : "Test 2 failed: expected 6";

                // Test 3: Negative numbers
                assert evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5",
                                "+" }) == 22
                                : "Test 3 failed: expected 22";

                // Test 4: Single token, no operator
                assert evalRPN(new String[] { "18" }) == 18
                                : "Test 4 failed: expected 18";

                // Test 5: Division truncation toward zero (negative result)
                assert evalRPN(new String[] { "6", "-132", "/" }) == 0
                                : "Test 5 failed: expected 0";

                System.out.println("All tests passed! ✅");
        }
}
