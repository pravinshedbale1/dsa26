import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 3 — Problem 1 of 2
 * ============================================
 * PROBLEM: Move Zeroes (LeetCode #283)
 *
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * You must do this IN-PLACE without making a copy of the array.
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 *
 * PATTERN: ???
 *
 * COMPLEXITY:
 * - Brute Force: O(n²) time — ???
 * - Optimal: O(n) time, O(1) space — ???
 */
public class MoveZeroes {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Standard case
        int[] t1 = { 0, 1, 0, 3, 12 };
        moveZeroes(t1);
        assert Arrays.equals(t1, new int[] { 1, 3, 12, 0, 0 }) : "Test 1 FAILED: got " + Arrays.toString(t1);

        // Test 2: Single zero
        int[] t2 = { 0 };
        moveZeroes(t2);
        assert Arrays.equals(t2, new int[] { 0 }) : "Test 2 FAILED: got " + Arrays.toString(t2);

        // Test 3: No zeroes
        int[] t3 = { 1, 2, 3 };
        moveZeroes(t3);
        assert Arrays.equals(t3, new int[] { 1, 2, 3 }) : "Test 3 FAILED: got " + Arrays.toString(t3);

        // Test 4: All zeroes
        int[] t4 = { 0, 0, 0 };
        moveZeroes(t4);
        assert Arrays.equals(t4, new int[] { 0, 0, 0 }) : "Test 4 FAILED: got " + Arrays.toString(t4);

        // Test 5: Zeroes at the end already
        int[] t5 = { 4, 2, 1, 0, 0 };
        moveZeroes(t5);
        assert Arrays.equals(t5, new int[] { 4, 2, 1, 0, 0 }) : "Test 5 FAILED: got " + Arrays.toString(t5);

        System.out.println("✅ All tests passed!");
    }
}
