import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 3 — Problem 2 of 2
 * ============================================
 * PROBLEM: Sort Colors (LeetCode #75)
 *
 * Given an array nums with n objects colored red, white, or blue,
 * sort them IN-PLACE so that objects of the same color are adjacent,
 * with the colors in the order red (0), white (1), and blue (2).
 *
 * You must solve this WITHOUT using the library's sort function.
 *
 * CONSTRAINTS:
 * - n == nums.length
 * - 1 <= n <= 300
 * - nums[i] is either 0, 1, or 2
 *
 * PATTERN: ???
 *
 * COMPLEXITY:
 * - Brute Force: O(n log n) — just sort it
 * - Better: O(n) time, O(1) space — ???
 * - Optimal: O(n) time, O(1) space, single pass — ???
 */
public class SortColors {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid++, low++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Standard case
        int[] t1 = { 2, 0, 2, 1, 1, 0 };
        sortColors(t1);
        assert Arrays.equals(t1, new int[] { 0, 0, 1, 1, 2, 2 }) : "Test 1 FAILED: got " + Arrays.toString(t1);

        // Test 2: Already sorted
        int[] t2 = { 0, 1, 2 };
        sortColors(t2);
        assert Arrays.equals(t2, new int[] { 0, 1, 2 }) : "Test 2 FAILED: got " + Arrays.toString(t2);

        // Test 3: Reverse sorted
        int[] t3 = { 2, 1, 0 };
        sortColors(t3);
        assert Arrays.equals(t3, new int[] { 0, 1, 2 }) : "Test 3 FAILED: got " + Arrays.toString(t3);

        // Test 4: All same color
        int[] t4 = { 1, 1, 1 };
        sortColors(t4);
        assert Arrays.equals(t4, new int[] { 1, 1, 1 }) : "Test 4 FAILED: got " + Arrays.toString(t4);

        // Test 5: Two colors only
        int[] t5 = { 2, 0, 0, 2 };
        sortColors(t5);
        assert Arrays.equals(t5, new int[] { 0, 0, 2, 2 }) : "Test 5 FAILED: got " + Arrays.toString(t5);

        System.out.println("✅ All tests passed!");
    }
}
