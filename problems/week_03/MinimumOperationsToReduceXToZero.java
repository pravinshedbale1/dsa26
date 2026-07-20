
/**
 * Minimum Operations to Reduce X to Zero (LC #1658)
 *
 * You are given an integer array `nums` and an integer `x`. In one operation
 * you remove either the leftmost or the rightmost element from `nums` and
 * subtract its value from `x`. Return the minimum number of operations to
 * reduce `x` to exactly 0, or -1 if it's not possible.
 *
 * Pattern: ??? (name it before you code — think about what's left over after
 * you remove a prefix and a suffix)
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^4
 * - 0 <= x <= 10^9
 */

public class MinimumOperationsToReduceXToZero {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int minOperations(int[] nums, int x) {
                int result = -1;
                int totalSum = 0;
                for (int n : nums) {
                        totalSum += n;
                }
                int target = totalSum - x;
                int right = 0;
                int left = 0;
                int sum = 0;

                while (right < nums.length) {
                        sum += nums[right];
                        while (sum > target && left <= right) {
                                sum -= nums[left];
                                left++;
                        }
                        if (sum == target) {
                                result = Math.max(result, right - left + 1);
                        }
                        right++;
                }
                return result == -1 ? result : nums.length - result;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert minOperations(new int[] { 1, 1, 4, 2, 3 }, 5) == 2
                                : "Test 1 failed: expected 2";

                // Test 2: Impossible case
                assert minOperations(new int[] { 5, 6, 7, 8, 9 }, 4) == -1
                                : "Test 2 failed: expected -1";

                // Test 3: Requires removing from both ends
                assert minOperations(new int[] { 3, 2, 20, 1, 1, 3 }, 10) == 5
                                : "Test 3 failed: expected 5";

                // Test 4: Edge case — x equals total sum, remove everything
                assert minOperations(new int[] { 1, 2, 3 }, 6) == 3
                                : "Test 4 failed: expected 3";

                // Test 5: Edge case — no combination works
                assert minOperations(new int[] { 2, 3, 4 }, 1) == -1
                                : "Test 5 failed: expected -1";

                System.out.println("All tests passed! ✅");
        }
}
