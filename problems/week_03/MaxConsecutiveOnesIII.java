
/**
 * Max Consecutive Ones III (LC #1004)
 *
 * Given a binary array `nums` and an integer `k`, return the maximum number
 * of consecutive 1's in the array if you can flip at most `k` 0's.
 *
 * Pattern: Sliding Window (Variable Size — Longest) + Zero Count
 *
 * Brute Force: Check all subarrays, count zeros in each → O(n^2)
 * Optimal: Sliding window, track count of zeros in window, shrink when
 * zeroCount > k → O(n) time, O(1) space
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - nums[i] is either 0 or 1
 * - 0 <= k <= nums.length
 */

public class MaxConsecutiveOnesIII {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int longestOnes(int[] nums, int k) {
                int zeroCount = 0;
                int result = 0;
                int left = 0;
                for (int right = 0; right < nums.length; right++) {
                        if (nums[right] == 0) {
                                zeroCount++;
                        }
                        if (zeroCount > k) {
                                if (nums[left] == 0) {
                                        zeroCount--;
                                }
                                left++;
                        }
                        result = Math.max(result, right - left + 1);
                }
                return result;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2) == 6
                                : "Test 1 failed: expected 6";

                // Test 2: Flip enough to cover most of the array
                assert longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3) == 10
                                : "Test 2 failed: expected 10";

                // Test 3: Edge case — k = 0 (no flips allowed)
                assert longestOnes(new int[] { 1, 0, 1, 1, 0, 1 }, 0) == 2
                                : "Test 3 failed: expected 2";

                // Test 4: Edge case — all ones
                assert longestOnes(new int[] { 1, 1, 1, 1 }, 2) == 4
                                : "Test 4 failed: expected 4";

                // Test 5: Edge case — k covers entire array
                assert longestOnes(new int[] { 0, 0, 0, 0 }, 4) == 4
                                : "Test 5 failed: expected 4";

                System.out.println("All tests passed! ✅");
        }
}
