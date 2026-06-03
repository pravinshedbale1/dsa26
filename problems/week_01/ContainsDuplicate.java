/*
 * ============================================================
 * CONTAINS DUPLICATE (LeetCode #217) — Easy
 * ============================================================
 * 
 * PROBLEM:
 *   Given an integer array nums, return true if any value
 *   appears at least twice, return false if every element
 *   is distinct.
 *
 * PATTERN: HashSet Membership Check
 *
 * COMPLEXITY:
 *   Brute:   O(n²) time, O(1) space
 *   Sort:    O(n log n) time, O(1) space
 *   Optimal: O(n) time, O(n) space
 *
 * CONSTRAINTS:
 *   1 <= nums.length <= 10^5
 *   -10^9 <= nums[i] <= 10^9
 * ============================================================
 */

import java.util.*;

public class ContainsDuplicate {

    // ✅ Fill in this method
    public static boolean containsDuplicate(int[] nums) {
        // YOUR CODE HERE
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    // ============ DRIVER CODE — DO NOT MODIFY ============
    public static void main(String[] args) {
        // Test 1: Has duplicate
        assert containsDuplicate(new int[] { 1, 2, 3, 1 }) == true : "Test 1 FAILED";

        // Test 2: All distinct
        assert containsDuplicate(new int[] { 1, 2, 3, 4 }) == false : "Test 2 FAILED";

        // Test 3: Single element
        assert containsDuplicate(new int[] { 1 }) == false : "Test 3 FAILED";

        // Test 4: All same elements
        assert containsDuplicate(new int[] { 5, 5, 5, 5 }) == true : "Test 4 FAILED";

        // Test 5: Duplicate at the end
        assert containsDuplicate(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 }) == true : "Test 5 FAILED";

        System.out.println("✅ All tests passed!");
    }
}
