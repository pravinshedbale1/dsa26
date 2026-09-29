import java.util.*;

/**
 * LC #1 — Two Sum (Easy)
 *
 * Given an array of integers nums and an integer target, return the indices
 * of the two numbers such that they add up to target.
 * You may assume each input has exactly one solution, and you may not use
 * the same element twice. Return the answer in any order.
 *
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Exactly one valid answer exists.
 *
 * Pattern: (you tell me in the debrief)
 * Complexity: (you tell me — brute vs optimal)
 */
public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int compPair = target - nums[i];
                if (map.containsKey(compPair)) {
                    return new int[] { i, map.get(compPair) };
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        check(s, new int[] { 2, 7, 11, 15 }, 9); // basic
        check(s, new int[] { 3, 2, 4 }, 6); // answer not at index 0
        check(s, new int[] { 3, 3 }, 6); // duplicate values
        check(s, new int[] { -3, 4, 3, 90 }, 0); // negatives
        check(s, new int[] { 1000000000, 5, -1000000000, 7 }, 0); // extremes, sum = 0

        System.out.println("All tests passed ✅");
    }

    private static void check(Solution s, int[] nums, int target) {
        int[] res = s.twoSum(nums.clone(), target);
        if (res == null || res.length != 2)
            fail("Expected 2 indices, got " + Arrays.toString(res));
        if (res[0] == res[1])
            fail("Same index used twice: " + Arrays.toString(res));
        if (nums[res[0]] + nums[res[1]] != target)
            fail("Wrong pair " + Arrays.toString(res) + " for " + Arrays.toString(nums) + ", target " + target);
        System.out.println("PASS " + Arrays.toString(nums) + " target=" + target + " -> " + Arrays.toString(res));
    }

    private static void fail(String msg) {
        System.out.println("FAIL " + msg);
        System.exit(1);
    }
}
