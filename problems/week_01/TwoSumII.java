/*
 * ============================================================
 * TWO SUM II — INPUT ARRAY IS SORTED (LeetCode #167) — Medium
 * ============================================================
 * 
 * PROBLEM:
 *   Given a 1-indexed array sorted in non-decreasing order,
 *   find two numbers that add up to target.
 *   Return [index1, index2] where 1 <= index1 < index2.
 *   Must use O(1) extra space.
 *
 * CONSTRAINTS:
 *   2 <= numbers.length <= 3 * 10^4
 *   -1000 <= numbers[i] <= 1000
 *   numbers is sorted in non-decreasing order.
 *   Exactly one solution exists.
 * ============================================================
 */

import java.util.*;

public class TwoSumII {

    // ✅ Fill in this method
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    // ============ DRIVER CODE — DO NOT MODIFY ============
    public static void main(String[] args) {
        // Test 1: Basic case
        int[] r1 = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        assert Arrays.equals(r1, new int[] { 1, 2 }) : "Test 1 FAILED: expected [1,2], got " + Arrays.toString(r1);

        // Test 2: Non-adjacent pair
        int[] r2 = twoSum(new int[] { 2, 3, 4 }, 6);
        assert Arrays.equals(r2, new int[] { 1, 3 }) : "Test 2 FAILED: expected [1,3], got " + Arrays.toString(r2);

        // Test 3: Negative numbers
        int[] r3 = twoSum(new int[] { -5, -3, 0, 3, 7 }, 4);
        assert Arrays.equals(r3, new int[] { 2, 5 }) : "Test 3 FAILED: expected [2,5], got " + Arrays.toString(r3);

        // Test 4: Minimum size array
        int[] r4 = twoSum(new int[] { 1, 2 }, 3);
        assert Arrays.equals(r4, new int[] { 1, 2 }) : "Test 4 FAILED: expected [1,2], got " + Arrays.toString(r4);

        // Test 5: Large values, pair at edges
        int[] r5 = twoSum(new int[] { -1000, -500, 0, 500, 1000 }, 0);
        assert Arrays.equals(r5, new int[] { 1, 5 }) : "Test 5 FAILED: expected [1,5], got " + Arrays.toString(r5);

        System.out.println("✅ All tests passed!");
    }
}
