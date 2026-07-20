
/**
 * Subarray Product Less Than K (LC #713)
 *
 * Given an array of positive integers `nums` and an integer `k`, return the
 * number of contiguous subarrays where the product of all elements is
 * strictly less than `k`.
 *
 * Pattern: ??? (name it before you code)
 *
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - 1 <= nums[i] <= 1000
 * - 0 <= k <= 10^6
 */

public class SubarrayProductLessThanK {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int numSubarrayProductLessThanK(int[] nums, int k) {
               int result = -1;
        int totalSum = 0;
        for(int n: nums) {
            totalSum+=n;
        }
        int target  = totalSum-x;
        int right = 0;
        int left = 0;
        int sum = 0;
        
        while(right < nums.length) {
            sum+=nums[right];
            while(sum>target && left<=right) {
                sum-=nums[left];
                left++;
            }
             if(sum==target) {
                result = Math.max(result, right-left+1);
            }
            right++;
        }
        return result==-1 ? result : nums.length-result;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100) == 8
                                : "Test 1 failed: expected 8";

                // Test 2: k = 0, positive elements can never have product < 0
                assert numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0) == 0
                                : "Test 2 failed: expected 0";

                // Test 3: all 1's, every subarray qualifies
                assert numSubarrayProductLessThanK(new int[] { 1, 1, 1 }, 2) == 6
                                : "Test 3 failed: expected 6";

                // Test 4: k = 1, product always >= 1, nothing qualifies
                assert numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 1) == 0
                                : "Test 4 failed: expected 0";

                // Test 5: single element edge case
                assert numSubarrayProductLessThanK(new int[] { 5 }, 10) == 1
                                : "Test 5 failed: expected 1";

                System.out.println("All tests passed! ✅");
        }
}
