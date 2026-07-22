import java.util.*;

/*
 * ============================================================
 * LARGEST RECTANGLE IN HISTOGRAM (LC #84) — Hard
 * ============================================================
 *
 * Given an array of integers `heights` representing the histogram's bar heights
 * where the width of each bar is 1, return the area of the largest rectangle in
 * the histogram.
 *
 * ------------------------------------------------------------
 * Example 1:
 *   heights = [2,1,5,6,2,3]
 *   Output: 10
 *   (The rectangle of height 5 spanning the bars [5,6] has area 5*2 = 10.)
 *
 * Example 2:
 *   heights = [2,4]
 *   Output: 4
 *
 * ------------------------------------------------------------
 * Constraints:
 *   1 <= heights.length <= 10^5
 *   0 <= heights[i] <= 10^4
 *
 * ------------------------------------------------------------
 * PATTERN: Monotonic (increasing) Stack of indices
 * Brute force:  O(n²) — for each bar, expand left and right to nearest shorter.
 * Optimal:      O(n) time, O(n) space.
 *
 * Key formula when popping index `top` because a shorter bar arrived at `i`:
 *   height = heights[top]
 *   width  = stack.isEmpty() ? i : i - stack.peek() - 1
 *   area   = height * width
 * Use a right sentinel (treat height at i==n as 0) so the stack fully drains.
 * ============================================================
 */
public class LargestRectangleInHistogram {

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            int n = heights.length;
            for (int i = 0; i <= n; i++) {
                int curr = i == n ? -1 : heights[i];
                while (stack.peek() != -1 && heights[stack.peek()] > curr) {
                    int height = heights[stack.pop()];
                    int width = i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }
            return maxArea;
        }
    }

    // ---------------- Driver / Tests ----------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: classic
        assert sol.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }) == 10 : "Test 1 failed";

        // Test 2: two bars
        assert sol.largestRectangleArea(new int[] { 2, 4 }) == 4 : "Test 2 failed";

        // Test 3: single bar
        assert sol.largestRectangleArea(new int[] { 5 }) == 5 : "Test 3 failed";

        // Test 4: strictly increasing — best is the last bar spanning nothing extra,
        // actually [1,2,3,4,5]: height 3 x width 3 = 9, height 4 x 2 = 8, height 5
        // x1=5,
        // height 2 x 4 = 8, height 1 x 5 = 5 -> max = 9
        assert sol.largestRectangleArea(new int[] { 1, 2, 3, 4, 5 }) == 9 : "Test 4 failed";

        // Test 5: all equal — one big rectangle
        assert sol.largestRectangleArea(new int[] { 3, 3, 3, 3 }) == 12 : "Test 5 failed";

        // Test 6: valley shape
        assert sol.largestRectangleArea(new int[] { 6, 2, 5, 4, 5, 1, 6 }) == 12 : "Test 6 failed";

        System.out.println("All tests passed!");
    }
}
