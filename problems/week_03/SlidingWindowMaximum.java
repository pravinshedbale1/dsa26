import java.util.*;

/**
 * ============================================================
 * Sliding Window Maximum (LC #239) — HARD
 * ============================================================
 *
 * PROBLEM:
 * You are given an array of integers nums and an integer k.
 * A sliding window of size k moves from the very left of the
 * array to the very right, one position at a time. You can only
 * see the k numbers currently inside the window.
 *
 * Return an array of the maximum of each window.
 *
 * Example:
 *   nums = [1,3,-1,-3,5,3,6,7], k = 3
 *   Windows:  [1  3  -1] -3  5  3  6  7   → max 3
 *              1 [3  -1  -3] 5  3  6  7   → max 3
 *              1  3 [-1  -3  5] 3  6  7   → max 5
 *              1  3  -1 [-3  5  3] 6  7   → max 5
 *              1  3  -1  -3 [5  3  6] 7   → max 6
 *              1  3  -1  -3  5 [3  6  7]  → max 7
 *   Output: [3,3,5,5,6,7]
 *
 * CONSTRAINTS:
 *   1 <= nums.length <= 10^5
 *   -10^4 <= nums[i] <= 10^4
 *   1 <= k <= nums.length
 *
 * PATTERN: Fixed Sliding Window + Monotonic Deque
 *
 * COMPLEXITY:
 *   Brute force: O(n·k) time — rescan every window for its max
 *   Optimal:     O(n) time, O(k) space — monotonic decreasing
 *                deque of indices; front is always the window max
 * ============================================================
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // TODO: implement (re-solve — Day 6 review, timer 40 min)
        int[] result = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int right = 0;
        while(right < nums.length) {
                if(!dq.isEmpty() && dq.peekFirst()<=right-k) {
                        dq.pollFirst();
                }
                while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) {
                        dq.pollLast();
                }
                dq.offerLast(right);
                if(right>=k-1) {
                        result[right-k+1] = nums[dq.peekFirst()];
                }
                right++;
        }
        return result;
    }
}

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Standard case
        int[] r1 = sol.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        assert Arrays.equals(r1, new int[]{3, 3, 5, 5, 6, 7})
                : "Test 1 failed: " + Arrays.toString(r1);

        // Test 2: k = 1 (every element is its own window)
        int[] r2 = sol.maxSlidingWindow(new int[]{4, -2, 7}, 1);
        assert Arrays.equals(r2, new int[]{4, -2, 7})
                : "Test 2 failed: " + Arrays.toString(r2);

        // Test 3: k = nums.length (single window)
        int[] r3 = sol.maxSlidingWindow(new int[]{9, 1, 8, 2}, 4);
        assert Arrays.equals(r3, new int[]{9})
                : "Test 3 failed: " + Arrays.toString(r3);

        // Test 4: Strictly decreasing array (front constantly expires)
        int[] r4 = sol.maxSlidingWindow(new int[]{5, 4, 3, 2, 1}, 2);
        assert Arrays.equals(r4, new int[]{5, 4, 3, 2})
                : "Test 4 failed: " + Arrays.toString(r4);

        // Test 5: Duplicates and negatives
        int[] r5 = sol.maxSlidingWindow(new int[]{-1, -3, -1, -3, -1}, 3);
        assert Arrays.equals(r5, new int[]{-1, -1, -1})
                : "Test 5 failed: " + Arrays.toString(r5);

        System.out.println("All tests passed!");
    }
}
