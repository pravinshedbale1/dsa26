import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 1 — Problem 2 of 2
 * ============================================
 * PROBLEM: 3Sum (LeetCode #15)
 *
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * The solution set must NOT contain duplicate triplets.
 *
 * CONSTRAINTS:
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 *
 * PATTERN: Sort + Fix One + Two Pointers
 *
 * COMPLEXITY:
 * - Brute Force: O(n³) time — three nested loops
 * - Optimal: O(n²) time, O(k) space — sort + two pointers
 */
public class ThreeSum {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tripleList = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < size - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    tripleList.add(triplet);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return tripleList;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Standard case with duplicates in input
        List<List<Integer>> r1 = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        assert r1.size() == 2 : "Test 1 FAILED: expected 2 triplets, got " + r1.size();
        assert r1.contains(Arrays.asList(-1, -1, 2)) : "Test 1 FAILED: missing [-1,-1,2]";
        assert r1.contains(Arrays.asList(-1, 0, 1)) : "Test 1 FAILED: missing [-1,0,1]";

        // Test 2: No valid triplet
        List<List<Integer>> r2 = threeSum(new int[] { 0, 1, 1 });
        assert r2.size() == 0 : "Test 2 FAILED: expected 0 triplets, got " + r2.size();

        // Test 3: All zeros
        List<List<Integer>> r3 = threeSum(new int[] { 0, 0, 0 });
        assert r3.size() == 1 : "Test 3 FAILED: expected 1 triplet, got " + r3.size();
        assert r3.contains(Arrays.asList(0, 0, 0)) : "Test 3 FAILED: missing [0,0,0]";

        // Test 4: Multiple valid triplets
        List<List<Integer>> r4 = threeSum(new int[] { -2, 0, 1, 1, 2 });
        assert r4.size() == 2 : "Test 4 FAILED: expected 2 triplets, got " + r4.size();
        assert r4.contains(Arrays.asList(-2, 0, 2)) : "Test 4 FAILED: missing [-2,0,2]";
        assert r4.contains(Arrays.asList(-2, 1, 1)) : "Test 4 FAILED: missing [-2,1,1]";

        // Test 5: Large negatives and positives
        List<List<Integer>> r5 = threeSum(new int[] { -4, -2, -1, 0, 1, 2, 3, 4 });
        assert r5.size() == 5 : "Test 5 FAILED: expected 5 triplets, got " + r5.size();

        System.out.println("✅ All tests passed!");
    }
}
