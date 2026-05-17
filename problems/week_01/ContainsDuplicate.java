import java.util.*;

/**
 * ══════════════════════════════════════════════════════════════
 * PROBLEM: Contains Duplicate (LeetCode #217)
 * ══════════════════════════════════════════════════════════════
 * 
 * Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element
 * is distinct.
 * 
 * Example 1:
 * Input: nums = [1, 2, 3, 1]
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: false
 * 
 * Example 3:
 * Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
 * Output: true
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * PATTERN: ??? (You tell me!)
 * BRUTE FORCE: ???
 * OPTIMAL: ???
 * ══════════════════════════════════════════════════════════════
 */
public class ContainsDuplicate {

    // ✅ COMPLETE THIS METHOD — implement the optimal O(n) HashSet approach
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    // ═══════════════════════════════════════════════════════════
    // DRIVER CODE — DO NOT MODIFY BELOW
    // ═══════════════════════════════════════════════════════════
    static int passed = 0, failed = 0;

    static void verify(String testName, boolean actual, boolean expected) {
        System.out.print(testName + ": " + actual);
        if (actual == expected) {
            System.out.println("  ✅ PASS");
            passed++;
        } else {
            System.out.println("  ❌ FAIL (Expected: " + expected + ")");
            failed++;
        }
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        verify("Test 1 [Has duplicate]",
                solution.containsDuplicate(new int[] { 1, 2, 3, 1 }),
                true);

        verify("Test 2 [All unique]",
                solution.containsDuplicate(new int[] { 1, 2, 3, 4 }),
                false);

        verify("Test 3 [Multiple duplicates]",
                solution.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }),
                true);

        verify("Test 4 [Single element]",
                solution.containsDuplicate(new int[] { 1 }),
                false);

        verify("Test 5 [Two same elements]",
                solution.containsDuplicate(new int[] { 5, 5 }),
                true);

        verify("Test 6 [Negatives with duplicate]",
                solution.containsDuplicate(new int[] { -1, -2, -3, -1 }),
                true);

        System.out.println("\n══════════════════════════════");
        System.out.println("Results: " + passed + " passed, " + failed + " failed out of " + (passed + failed));
        if (failed == 0) {
            System.out.println("🎉 All tests passed!");
        } else {
            System.out.println("🔴 " + failed + " test(s) FAILED — fix your solution!");
        }
    }
}
