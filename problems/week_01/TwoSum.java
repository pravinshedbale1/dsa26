import java.util.*;

/**
 * ════════════════════════════════════════════════════════════
 * TWO SUM (LeetCode #1) — Easy
 * ════════════════════════════════════════════════════════════
 * 
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 * 
 * Examples:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1] (because nums[0] + nums[1] == 9)
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * ════════════════════════════════════════════════════════════
 * 
 * Session: Week 1, Day 1 — June 15, 2026
 * Pattern: _______________
 * Brute: O(___) time, O(___) space
 * Optimal: O(___) time, O(___) space
 */
public class TwoSum {

    // ══════════════════════════════════════════════
    // YOUR CODE HERE — fill in the method body only
    // ══════════════════════════════════════════════
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complementPair = target - nums[i];
            if (map.containsKey(complementPair)) {
                result[0] = i;
                result[1] = map.get(complementPair);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // ══════════════════════════════════════════════
    // DRIVER CODE — DO NOT MODIFY
    // ══════════════════════════════════════════════
    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        // Test 1: Basic case
        int[] r1 = sol.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        assert Arrays.equals(r1, new int[] { 0, 1 }) || Arrays.equals(r1, new int[] { 1, 0 })
                : "Test 1 FAILED: expected [0,1], got " + Arrays.toString(r1);

        // Test 2: Not at the start
        int[] r2 = sol.twoSum(new int[] { 3, 2, 4 }, 6);
        assert Arrays.equals(r2, new int[] { 1, 2 }) || Arrays.equals(r2, new int[] { 2, 1 })
                : "Test 2 FAILED: expected [1,2], got " + Arrays.toString(r2);

        // Test 3: Duplicate values
        int[] r3 = sol.twoSum(new int[] { 3, 3 }, 6);
        assert Arrays.equals(r3, new int[] { 0, 1 }) || Arrays.equals(r3, new int[] { 1, 0 })
                : "Test 3 FAILED: expected [0,1], got " + Arrays.toString(r3);

        // Test 4: Negative numbers
        int[] r4 = sol.twoSum(new int[] { -1, -2, -3, -4, -5 }, -8);
        assert Arrays.equals(r4, new int[] { 2, 4 }) || Arrays.equals(r4, new int[] { 4, 2 })
                : "Test 4 FAILED: expected [2,4], got " + Arrays.toString(r4);

        // Test 5: Large array, pair at the end
        int[] r5 = sol.twoSum(new int[] { 1, 5, 8, 3, 9, 2 }, 7);
        assert Arrays.equals(r5, new int[] { 1, 5 }) || Arrays.equals(r5, new int[] { 5, 1 })
                : "Test 5 FAILED: expected [1,5], got " + Arrays.toString(r5);

        System.out.println("✅ All 5 tests passed!");
    }
}
