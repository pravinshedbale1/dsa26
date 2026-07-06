import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 4 — Problem 2 of 2
 * ============================================
 * PROBLEM: 4Sum (LeetCode #18)
 *
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * - 0 <= a, b, c, d < n
 * - a, b, c, d are distinct
 * - nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * You may return the answer in any order.
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 200
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 *
 * PATTERN: Sort + Fix Two + Two Pointers (extend 3Sum)
 *
 * COMPLEXITY:
 * - Brute Force: O(n⁴) time — four nested loops
 * - Optimal: O(n³) time, O(k) space — sort + fix two + two pointers
 */
public class FourSum {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < size; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = size - 1;

                while (k < l) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k] + nums[l];

                    if (sum == target) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        result.add(quadruplet);
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return result;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Standard case
        List<List<Integer>> r1 = fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
        assert r1.size() == 3 : "Test 1 FAILED: expected 3 quadruplets, got " + r1.size();
        assert r1.contains(Arrays.asList(-2, -1, 1, 2)) : "Test 1 FAILED: missing [-2,-1,1,2]";
        assert r1.contains(Arrays.asList(-2, 0, 0, 2)) : "Test 1 FAILED: missing [-2,0,0,2]";
        assert r1.contains(Arrays.asList(-1, 0, 0, 1)) : "Test 1 FAILED: missing [-1,0,0,1]";

        // Test 2: Target != 0
        List<List<Integer>> r2 = fourSum(new int[] { 2, 2, 2, 2, 2 }, 8);
        assert r2.size() == 1 : "Test 2 FAILED: expected 1 quadruplet, got " + r2.size();
        assert r2.contains(Arrays.asList(2, 2, 2, 2)) : "Test 2 FAILED: missing [2,2,2,2]";

        // Test 3: No valid quadruplet
        List<List<Integer>> r3 = fourSum(new int[] { 1, 2, 3, 4 }, 100);
        assert r3.size() == 0 : "Test 3 FAILED: expected 0 quadruplets, got " + r3.size();

        // Test 4: Negative numbers
        List<List<Integer>> r4 = fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0);
        assert r4.size() == 8 : "Test 4 FAILED: expected 8 quadruplets, got " + r4.size();

        // Test 5: Large values (overflow trap!)
        List<List<Integer>> r5 = fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296);
        assert r5.size() == 0 : "Test 5 FAILED: expected 0 quadruplets, got " + r5.size();

        System.out.println("✅ All tests passed!");
    }
}
