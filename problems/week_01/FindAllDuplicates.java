import java.util.*;

/**
 * LC #442 — Find All Duplicates in an Array (Medium)
 *
 * Given an integer array nums of length n where all integers are in the range
 * [1, n] and each integer appears once or twice, return an array of all the
 * integers that appear twice. The result may be in any order.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant
 * auxiliary space (the output list does not count).
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * Each element appears once or twice.
 *
 * Pattern: (you tell me in the debrief)
 * Complexity: (you tell me — brute vs better vs optimal)
 */
public class FindAllDuplicates {
    static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> duplicates = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int e = Math.abs(nums[i]);
                int index = e - 1;
                if (nums[index] >= 0) {
                    nums[index] = -nums[index];
                } else {
                    duplicates.add(e);
                }
            }
            return duplicates;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        check(sol, new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }, List.of(2, 3)); // basic
        check(sol, new int[] { 1, 1, 2 }, List.of(1)); // duplicate at start
        check(sol, new int[] { 1 }, List.of()); // single element
        check(sol, new int[] { 1, 2, 3, 4 }, List.of()); // no duplicates
        check(sol, new int[] { 2, 2, 1, 1 }, List.of(1, 2)); // every value duplicated
        check(sol, new int[] { 5, 4, 6, 7, 9, 3, 10, 9, 5, 6 }, List.of(5, 6, 9)); // larger mix

        System.out.println("All tests passed ✅");
    }

    private static void check(Solution sol, int[] nums, List<Integer> expected) {
        List<Integer> res = sol.findDuplicates(nums.clone());
        if (res == null)
            fail("Got null for " + Arrays.toString(nums));
        List<Integer> got = new ArrayList<>(res);
        List<Integer> want = new ArrayList<>(expected);
        Collections.sort(got);
        Collections.sort(want);
        if (!got.equals(want))
            fail("Expected " + want + " but got " + got + " for " + Arrays.toString(nums));
        System.out.println("PASS " + Arrays.toString(nums) + " -> " + got);
    }

    private static void fail(String msg) {
        System.out.println("FAIL " + msg);
        System.exit(1);
    }
}
