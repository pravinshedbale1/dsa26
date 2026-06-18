/*
 * ============================================================
 * Product of Array Except Self (LeetCode #238) — Medium
 * ============================================================
 * 
 * Problem:
 *   Given an integer array nums, return an array answer such that
 *   answer[i] is equal to the product of all elements of nums 
 *   except nums[i]. Must not use division. O(n) time required.
 *
 * Pattern: Prefix/Suffix Product
 *
 * Brute Force: For each i, multiply all other elements → O(n²)
 * Optimal:     Prefix pass (left→right) + Suffix running variable (right→left) → O(n) time, O(1) extra space
 *
 * Constraints:
 *   - 2 <= nums.length <= 10^5
 *   - -30 <= nums[i] <= 30
 *   - Product of any prefix/suffix fits in 32-bit integer
 * ============================================================
 */

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] answer = new int[size];

        answer[0] = 1;

        for (int i = 1; i < size; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int product = 1;

        for (int i = size - 1; i >= 0; i--) {
            answer[i] = product * answer[i];
            product = product * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // Test 1: Standard case
        int[] t1 = productExceptSelf(new int[] { 1, 2, 3, 4 });
        assert Arrays.equals(t1, new int[] { 24, 12, 8, 6 })
                : "Test 1 FAILED: expected [24,12,8,6], got " + Arrays.toString(t1);
        System.out.println("Test 1 PASSED: " + Arrays.toString(t1));

        // Test 2: Contains zero
        int[] t2 = productExceptSelf(new int[] { -1, 1, 0, -3, 3 });
        assert Arrays.equals(t2, new int[] { 0, 0, 9, 0, 0 })
                : "Test 2 FAILED: expected [0,0,9,0,0], got " + Arrays.toString(t2);
        System.out.println("Test 2 PASSED: " + Arrays.toString(t2));

        // Test 3: Two elements
        int[] t3 = productExceptSelf(new int[] { 3, 5 });
        assert Arrays.equals(t3, new int[] { 5, 3 }) : "Test 3 FAILED: expected [5,3], got " + Arrays.toString(t3);
        System.out.println("Test 3 PASSED: " + Arrays.toString(t3));

        // Test 4: All ones
        int[] t4 = productExceptSelf(new int[] { 1, 1, 1, 1 });
        assert Arrays.equals(t4, new int[] { 1, 1, 1, 1 })
                : "Test 4 FAILED: expected [1,1,1,1], got " + Arrays.toString(t4);
        System.out.println("Test 4 PASSED: " + Arrays.toString(t4));

        // Test 5: Negative numbers
        int[] t5 = productExceptSelf(new int[] { -1, -2, -3 });
        assert Arrays.equals(t5, new int[] { 6, 3, 2 }) : "Test 5 FAILED: expected [6,3,2], got " + Arrays.toString(t5);
        System.out.println("Test 5 PASSED: " + Arrays.toString(t5));

        System.out.println("\n🎉 All tests passed!");
    }
}
