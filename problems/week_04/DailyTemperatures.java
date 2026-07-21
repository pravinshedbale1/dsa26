import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Daily Temperatures (LC #739)
 *
 * Given an array of integers `temperatures` representing daily temperatures,
 * return an array `answer` such that `answer[i]` is the number of days you
 * have to wait after day `i` to get a warmer temperature. If there is no
 * future day for which this is possible, `answer[i] == 0`.
 *
 * Pattern: ??? (name it before you code)
 *
 * Constraints:
 * - 1 <= temperatures.length <= 10^5
 * - 30 <= temperatures[i] <= 100
 */

public class DailyTemperatures {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int[] dailyTemperatures(int[] temperatures) {
                Stack<Integer> stack = new Stack<>();
                int[] result = new int[temperatures.length];
                for (int i = 0; i < temperatures.length; i++) {
                        if (stack.isEmpty() || temperatures[stack.peek()] > temperatures[i]) {
                                stack.push(i);
                        } else {
                                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                                        result[stack.peek()] = i - stack.peek();
                                        stack.pop();
                                }
                                stack.push(i);
                        }
                }
                return result;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert java.util.Arrays.equals(
                                dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }),
                                new int[] { 1, 1, 4, 2, 1, 1, 0, 0 })
                                : "Test 1 failed";

                // Test 2: Strictly increasing (always next day is warmer)
                assert java.util.Arrays.equals(
                                dailyTemperatures(new int[] { 30, 40, 50, 60 }),
                                new int[] { 1, 1, 1, 0 })
                                : "Test 2 failed";

                // Test 3: Strictly decreasing (never warmer again)
                assert java.util.Arrays.equals(
                                dailyTemperatures(new int[] { 60, 50, 40, 30 }),
                                new int[] { 0, 0, 0, 0 })
                                : "Test 3 failed";

                // Test 4: All equal temperatures
                assert java.util.Arrays.equals(
                                dailyTemperatures(new int[] { 55, 55, 55 }),
                                new int[] { 0, 0, 0 })
                                : "Test 4 failed";

                // Test 5: Single day
                assert java.util.Arrays.equals(
                                dailyTemperatures(new int[] { 45 }),
                                new int[] { 0 })
                                : "Test 5 failed";

                System.out.println("All tests passed! ✅");
        }
}
