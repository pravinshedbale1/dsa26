/*
 * ============================================================
 * PRODUCT OF ARRAY EXCEPT SELF (LeetCode #238) — Medium
 * ============================================================
 * 
 * PROBLEM:
 *   Given an integer array nums, return an array answer such that
 *   answer[i] is equal to the product of all the elements of nums
 *   except nums[i].
 *
 *   You must write an algorithm that runs in O(n) time and
 *   WITHOUT using the division operation.
 *
 * PATTERN: Prefix/Suffix Product
 *
 * COMPLEXITY:
 *   Brute:   O(n²) time, O(n) space — for each i, multiply all others
 *   Optimal: O(n) time, O(1) space* — prefix pass + suffix pass
 *            (*output array not counted as extra space per problem statement)
 *
 * CONSTRAINTS:
 *   2 <= nums.length <= 10^5
 *   -30 <= nums[i] <= 30
 *   The product of any prefix or suffix is guaranteed to fit in a 32-bit int.
 * ============================================================
 */

import java.util.*;

public class ProductExceptSelf {

        // ✅ Fill in this method
        public static int[] productExceptSelf(int[] nums) {
                int size = nums.length;
                int[] result = new int[size];
                result[0] = 1;
                for (int i = 1; i < size; i++) {
                        result[i] = nums[i - 1] * result[i - 1];
                }
                int rightProducts = 1;
                for (int i = size - 1; i >= 0; i--) {
                        result[i] = result[i] * rightProducts;
                        rightProducts = rightProducts * nums[i];
                }

                return result;
        }

        // ============ DRIVER CODE — DO NOT MODIFY ============
        public static void main(String[] args) {
                // Test 1: Basic case
                int[] r1 = productExceptSelf(new int[] { 1, 2, 3, 4 });
                assert Arrays.equals(r1, new int[] { 24, 12, 8, 6 })
                                : "Test 1 FAILED: expected [24,12,8,6], got " + Arrays.toString(r1);

                // Test 2: Contains a zero
                int[] r2 = productExceptSelf(new int[] { -1, 1, 0, -3, 3 });
                assert Arrays.equals(r2, new int[] { 0, 0, 9, 0, 0 })
                                : "Test 2 FAILED: expected [0,0,9,0,0], got " + Arrays.toString(r2);

                // Test 3: Two elements
                int[] r3 = productExceptSelf(new int[] { 3, 5 });
                assert Arrays.equals(r3, new int[] { 5, 3 })
                                : "Test 3 FAILED: expected [5,3], got " + Arrays.toString(r3);

                // Test 4: All ones
                int[] r4 = productExceptSelf(new int[] { 1, 1, 1, 1 });
                assert Arrays.equals(r4, new int[] { 1, 1, 1, 1 })
                                : "Test 4 FAILED: expected [1,1,1,1], got " + Arrays.toString(r4);

                // Test 5: Negative numbers
                int[] r5 = productExceptSelf(new int[] { -1, -2, -3 });
                assert Arrays.equals(r5, new int[] { 6, 3, 2 })
                                : "Test 5 FAILED: expected [6,3,2], got " + Arrays.toString(r5);

                System.out.println("✅ All tests passed!");
        }
}
