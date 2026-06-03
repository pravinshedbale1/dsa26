/*
 * ============================================================
 * TWO SUM (LeetCode #1) — Easy
 * ============================================================
 * 
 * PROBLEM:
 *   Given an array of integers nums and an integer target,
 *   return indices of the two numbers that add up to target.
 *   - Exactly one solution exists
 *   - Cannot use the same element twice
 *
 * PATTERN: HashMap Complement Lookup
 *
 * COMPLEXITY:
 *   Brute:   O(n²) time, O(1) space
 *   Optimal: O(n) time, O(n) space
 *
 * CONSTRAINTS:
 *   2 <= nums.length <= 10^4
 *   -10^9 <= nums[i] <= 10^9
 *   Exactly one valid answer exists.
 * ============================================================
 */

import java.util.*;

public class TwoSum {

    // ✅ Fill in this method
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int compPair = target - nums[i];
            if (map.containsKey(compPair)) {
                res[0] = i;
                res[1] = map.get(compPair);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    // ============ DRIVER CODE — DO NOT MODIFY ============
    public static void main(String[] args) {
        // Test 1: Basic case
        int[] r1 = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        Arrays.sort(r1);
        assert Arrays.equals(r1, new int[] { 0, 1 }) : "Test 1 FAILED: expected [0,1], got " + Arrays.toString(r1);

        // Test 2: Non-adjacent pair
        int[] r2 = twoSum(new int[] { 3, 2, 4 }, 6);
        Arrays.sort(r2);
        assert Arrays.equals(r2, new int[] { 1, 2 }) : "Test 2 FAILED: expected [1,2], got " + Arrays.toString(r2);

        // Test 3: Negative numbers
        int[] r3 = twoSum(new int[] { -1, -2, -3, -4, -5 }, -8);
        Arrays.sort(r3);
        assert Arrays.equals(r3, new int[] { 2, 4 }) : "Test 3 FAILED: expected [2,4], got " + Arrays.toString(r3);

        // Test 4: First and last element
        int[] r4 = twoSum(new int[] { 1, 5, 2, 7 }, 8);
        Arrays.sort(r4);
        assert Arrays.equals(r4, new int[] { 0, 3 }) : "Test 4 FAILED: expected [0,3], got " + Arrays.toString(r4);

        // Test 5: Minimum size array
        int[] r5 = twoSum(new int[] { 3, 3 }, 6);
        Arrays.sort(r5);
        assert Arrays.equals(r5, new int[] { 0, 1 }) : "Test 5 FAILED: expected [0,1], got " + Arrays.toString(r5);

        System.out.println("✅ All tests passed!");
    }
}
