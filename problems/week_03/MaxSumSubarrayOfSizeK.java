/**
 * Maximum Sum Subarray of Size K
 * 
 * Given an array of integers and an integer k, find the maximum sum
 * of any contiguous subarray of size k.
 * 
 * Pattern: Sliding Window (Fixed Size)
 * 
 * Brute Force: Check all subarrays of size k → O(n*k)
 * Optimal: Sliding window → O(n) time, O(1) space
 * 
 * Constraints:
 * - 1 <= k <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 */
public class MaxSumSubarrayOfSizeK {

    public static int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0;
        int j = 0;
        int windowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i - j + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[j];
                j++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // Test 1: Basic case
        assert maxSumSubarray(new int[] { 2, 1, 5, 1, 3, 2 }, 3) == 9
                : "Test 1 failed: expected 9";

        // Test 2: Window at the end
        assert maxSumSubarray(new int[] { 2, 3, 4, 1, 5 }, 2) == 7
                : "Test 2 failed: expected 7";

        // Test 3: All same elements
        assert maxSumSubarray(new int[] { 4, 4, 4, 4, 4 }, 3) == 12
                : "Test 3 failed: expected 12";

        // Test 4: k equals array length (entire array)
        assert maxSumSubarray(new int[] { 1, 2, 3 }, 3) == 6
                : "Test 4 failed: expected 6";

        // Test 5: Negative numbers
        assert maxSumSubarray(new int[] { -1, 2, 3, -4, 5, 10 }, 2) == 15
                : "Test 5 failed: expected 15";

        System.out.println("All tests passed! ✅");
    }
}
