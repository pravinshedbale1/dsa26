
/**
 * LeetCode #26 — Remove Duplicates from Sorted Array (Easy)
 *
 * Given a sorted (non-decreasing) integer array nums, remove the duplicates
 * IN-PLACE such that each unique element appears only once.
 * Return k — the number of unique elements.
 * The first k elements of nums must hold the unique values in order.
 *
 * Constraints:
 *   - 1 <= nums.length <= 3 * 10^4
 *   - -100 <= nums[i] <= 100
 *   - nums is sorted in non-decreasing order
 *
 * Pattern: Two Pointers — Same Direction (Write Pointer)
 *
 * Brute Force: Use extra array / HashSet → O(n) / O(n)
 * Optimal:     Write pointer + scan pointer → O(n) / O(1)
 */

import java.util.Arrays;

public class RemoveDuplicates {

    // ✅ Fill in this method
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    // ─── Driver Code ───────────────────────────────────────────
    public static void main(String[] args) {

        // Test 1: Basic duplicates
        int[] t1 = { 1, 1, 2 };
        int k1 = removeDuplicates(t1);
        assert k1 == 2 : "Test 1 failed: expected k=2, got " + k1;
        assert t1[0] == 1 && t1[1] == 2 : "Test 1 failed: expected [1,2,...], got " + Arrays.toString(t1);

        // Test 2: Multiple duplicates
        int[] t2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k2 = removeDuplicates(t2);
        assert k2 == 5 : "Test 2 failed: expected k=5, got " + k2;
        int[] expected2 = { 0, 1, 2, 3, 4 };
        for (int i = 0; i < k2; i++) {
            assert t2[i] == expected2[i]
                    : "Test 2 failed at index " + i + ": expected " + expected2[i] + ", got " + t2[i];
        }

        // Test 3: No duplicates
        int[] t3 = { 1, 2, 3, 4, 5 };
        int k3 = removeDuplicates(t3);
        assert k3 == 5 : "Test 3 failed: expected k=5, got " + k3;

        // Test 4: All same
        int[] t4 = { 7, 7, 7, 7 };
        int k4 = removeDuplicates(t4);
        assert k4 == 1 : "Test 4 failed: expected k=1, got " + k4;
        assert t4[0] == 7 : "Test 4 failed: expected [7,...], got " + Arrays.toString(t4);

        // Test 5: Single element
        int[] t5 = { 42 };
        int k5 = removeDuplicates(t5);
        assert k5 == 1 : "Test 5 failed: expected k=1, got " + k5;
        assert t5[0] == 42 : "Test 5 failed: expected [42], got " + Arrays.toString(t5);

        System.out.println("✅ All tests passed!");
    }
}
