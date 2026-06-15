import java.util.*;

/**
 * ════════════════════════════════════════════════════════════
 * CONTAINS DUPLICATE (LeetCode #217) — Easy
 * ════════════════════════════════════════════════════════════
 * 
 * Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element
 * is distinct.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 * 
 * Examples:
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * ════════════════════════════════════════════════════════════
 * 
 * Session: Week 1, Day 1 — June 15, 2026
 * Pattern: _______________
 * Brute: O(___) time, O(___) space
 * Optimal: O(___) time, O(___) space
 */
public class ContainsDuplicate {

    // ══════════════════════════════════════════════
    // YOUR CODE HERE — fill in the method body only
    // ══════════════════════════════════════════════
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    // ══════════════════════════════════════════════
    // DRIVER CODE — DO NOT MODIFY
    // ══════════════════════════════════════════════
    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();

        // Test 1: Has duplicate
        assert sol.containsDuplicate(new int[] { 1, 2, 3, 1 }) == true
                : "Test 1 FAILED: expected true";

        // Test 2: All unique
        assert sol.containsDuplicate(new int[] { 1, 2, 3, 4 }) == false
                : "Test 2 FAILED: expected false";

        // Test 3: Multiple duplicates
        assert sol.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }) == true
                : "Test 3 FAILED: expected true";

        // Test 4: Single element
        assert sol.containsDuplicate(new int[] { 42 }) == false
                : "Test 4 FAILED: expected false";

        // Test 5: Two same elements
        assert sol.containsDuplicate(new int[] { 7, 7 }) == true
                : "Test 5 FAILED: expected true";

        System.out.println("✅ All 5 tests passed!");
    }
}
