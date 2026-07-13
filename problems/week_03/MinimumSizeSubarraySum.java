
/**
 * Minimum Size Subarray Sum (LC #209)
 * 
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or
 * equal to target. If there is no such subarray, return 0.
 * 
 * Pattern: Sliding Window (Variable Size — Shortest)
 * 
 * Brute Force: Check all subarrays → O(n²)
 * Optimal: Sliding window → O(n) time, O(1) space
 * 
 * Constraints:
 * - 1 <= target <= 10^9
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^4
 */

public class MinimumSizeSubarraySum {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int minSubArrayLen(int target, int[] nums) {
                int minLength = Integer.MAX_VALUE;
                int left = 0;
                int right = 0;
                int sum = 0;

                while (right < nums.length) {
                        sum += nums[right];
                        while (sum >= target) {
                                minLength = Math.min(minLength, right - left + 1);
                                sum -= nums[left];
                                left++;
                        }
                        right++;
                }
                return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }) == 2
                                : "Test 1 failed: expected 2 ([4,3])";

                // Test 2: Entire array needed
                assert minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }) == 0
                                : "Test 2 failed: expected 0 (sum=8 < 11)";

                // Test 3: Single element meets target
                assert minSubArrayLen(4, new int[] { 1, 4, 4 }) == 1
                                : "Test 3 failed: expected 1 (single 4)";

                // Test 4: Whole array is the answer
                assert minSubArrayLen(15, new int[] { 1, 2, 3, 4, 5 }) == 5
                                : "Test 4 failed: expected 5 (entire array)";

                // Test 5: Multiple valid windows
                assert minSubArrayLen(7, new int[] { 1, 1, 1, 1, 7, 1, 1 }) == 1
                                : "Test 5 failed: expected 1 ([7])";

                System.out.println("All tests passed! ✅");
        }
}
