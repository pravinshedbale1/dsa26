import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 6 — Review Re-solve
 * ============================================
 * PROBLEM: 3Sum (LeetCode #15) — RE-SOLVE FROM MEMORY
 *
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * The solution set must not contain duplicate triplets.
 *
 * CONSTRAINTS:
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 *
 * ⏱️ TIME LIMIT: 15 minutes (re-solve, should be faster)
 */
public class ThreeSum_Resolve {

    // ========================================
    // RE-SOLVE: Implement from memory
    // ========================================
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                long sum = (long) nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(triplet);
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
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
        List<List<Integer>> r1 = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        assert r1.size() == 2 : "Test 1 FAILED: expected 2 triplets, got " + r1.size();

        // Test 2: No valid triplets
        List<List<Integer>> r2 = threeSum(new int[] { 0, 1, 1 });
        assert r2.size() == 0 : "Test 2 FAILED: expected 0 triplets, got " + r2.size();

        // Test 3: All zeros
        List<List<Integer>> r3 = threeSum(new int[] { 0, 0, 0 });
        assert r3.size() == 1 : "Test 3 FAILED: expected 1 triplet, got " + r3.size();

        // Test 4: Multiple duplicates
        List<List<Integer>> r4 = threeSum(new int[] { -2, 0, 1, 1, 2 });
        assert r4.size() == 2 : "Test 4 FAILED: expected 2 triplets, got " + r4.size();

        // Test 5: Larger input with many triplets
        List<List<Integer>> r5 = threeSum(new int[] { -4, -2, -1, 0, 1, 2, 3, 4 });
        assert r5.size() == 5 : "Test 5 FAILED: expected 5 triplets, got " + r5.size();

        System.out.println("✅ All tests passed!");
    }
}
