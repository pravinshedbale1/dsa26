import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 7 — Weekly Challenge (Problem 1 of 2)
 * ============================================
 * PROBLEM: 3Sum Closest (LeetCode #16) — UNSEEN
 *
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 * CONSTRAINTS:
 * - 3 <= nums.length <= 500
 * - -1000 <= nums[i] <= 1000
 * - -10^4 <= target <= 10^4
 *
 * ⏱️ TIME LIMIT: 25 minutes
 */
public class ThreeSumClosest {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static int threeSumClosest(int[] nums, int target) {
        // YOUR CODE HERE
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return sum;
                }
            }
        }
        return closestSum;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Basic case
        int r1 = threeSumClosest(new int[] { -1, 2, 1, -4 }, 1);
        assert r1 == 2 : "Test 1 FAILED: expected 2, got " + r1;

        // Test 2: Exact match exists
        int r2 = threeSumClosest(new int[] { 0, 1, 2 }, 3);
        assert r2 == 3 : "Test 2 FAILED: expected 3, got " + r2;

        // Test 3: All negatives
        int r3 = threeSumClosest(new int[] { -3, -2, -5, 3, -4 }, -1);
        assert r3 == -2 : "Test 3 FAILED: expected -2, got " + r3;

        // Test 4: Large values
        int r4 = threeSumClosest(new int[] { 1, 1, 1, 0 }, 100);
        assert r4 == 3 : "Test 4 FAILED: expected 3, got " + r4;

        // Test 5: Negative target
        int r5 = threeSumClosest(new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5 }, -2);
        assert r5 == -2 : "Test 5 FAILED: expected -2, got " + r5;

        System.out.println("✅ All tests passed!");
    }
}
