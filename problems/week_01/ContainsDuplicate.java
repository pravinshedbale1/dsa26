import java.util.*;

/**
 * LC #217 — Contains Duplicate (Easy)
 *
 * Given an integer array nums, return true if any value appears at least
 * twice in the array, and return false if every element is distinct.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 *
 * Pattern: (you tell me in the debrief)
 * Complexity: (you tell me — brute vs better vs optimal)
 */
public class ContainsDuplicate {
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                if (!set.add(n)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        check(s, new int[] { 1, 2, 3, 1 }, true); // basic duplicate
        check(s, new int[] { 1, 2, 3, 4 }, false); // all distinct
        check(s, new int[] { 7 }, false); // single element
        check(s, new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, true); // many duplicates
        check(s, new int[] { -1000000000, 1000000000, 0, -1000000000 }, true); // extremes, dup at ends

        System.out.println("All tests passed ✅");
    }

    private static void check(Solution s, int[] nums, boolean expected) {
        boolean res = s.containsDuplicate(nums.clone());
        if (res != expected)
            fail("Expected " + expected + " but got " + res + " for " + Arrays.toString(nums));
        System.out.println("PASS " + Arrays.toString(nums) + " -> " + res);
    }

    private static void fail(String msg) {
        System.out.println("FAIL " + msg);
        System.exit(1);
    }
}
