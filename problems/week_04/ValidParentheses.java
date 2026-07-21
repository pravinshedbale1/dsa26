import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid Parentheses (LC #20)
 *
 * Given a string `s` containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 *
 * A string is valid if:
 * - Open brackets are closed by the same type of bracket.
 * - Open brackets are closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 *
 * Pattern: Stack for matching/nesting
 *
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s consists only of parentheses characters '()[]{}'
 */

public class ValidParentheses {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static boolean isValid(String s) {

                Deque<Character> stack = new ArrayDeque<>();
                stack.push('z');
                Map<Character, Character> map = new HashMap<>();
                map.put(')', '(');
                map.put(']', '[');
                map.put('}', '{');
                for (char ch : s.toCharArray()) {
                        if (ch == ')' && stack.peek() == map.get(ch)) {
                                stack.pop();
                        } else if (ch == ']' && stack.peek() == map.get(ch)) {
                                stack.pop();
                        } else if (ch == '}' && stack.peek() == map.get(ch)) {
                                stack.pop();
                        } else {
                                stack.push(ch);
                        }
                }
                return stack.peek() == 'z';
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic valid case
                assert isValid("()") == true : "Test 1 failed: expected true";

                // Test 2: Multiple types, valid
                assert isValid("()[]{}") == true : "Test 2 failed: expected true";

                // Test 3: Mismatched types
                assert isValid("(]") == false : "Test 3 failed: expected false";

                // Test 4: Nested, valid
                assert isValid("{[]}") == true : "Test 4 failed: expected true";

                // Test 5: Interleaved, not properly nested
                assert isValid("([)]") == false : "Test 5 failed: expected false";

                // Test 6: Leftover open bracket at the end
                assert isValid("(()") == false : "Test 6 failed: expected false";

                System.out.println("All tests passed! ✅");
        }
}
