import java.util.*;

/**
 * ══════════════════════════════════════════════════════════════
 * PROBLEM: Two Sum (LeetCode #1)
 * ══════════════════════════════════════════════════════════════
 * 
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * 
 * - Each input has EXACTLY one solution
 * - You may NOT use the same element twice
 * - Return answer in any order
 * 
 * Example:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * 
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * PATTERN: HashMap Complement Lookup
 * BRUTE FORCE: O(n²) time, O(1) space — nested loops checking every pair
 * OPTIMAL: O(n) time, O(n) space — HashMap to store seen elements
 * ══════════════════════════════════════════════════════════════
 */
public class TwoSum {

        // ✅ COMPLETE THIS METHOD — implement the optimal O(n) HashMap approach
        public int[] twoSum(int[] nums, int target) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < nums.length; i++) {
                        int compPair = target - nums[i];
                        if (map.containsKey(compPair)) {
                                return new int[] { i, map.get(compPair) };
                        }
                        map.put(nums[i], i);
                }
                return new int[] {};
        }

        // ═══════════════════════════════════════════════════════════
        // DRIVER CODE — DO NOT MODIFY BELOW
        // ═══════════════════════════════════════════════════════════
        static int passed = 0, failed = 0;

        static void verify(String testName, int[] actual, int[] expected1, int[] expected2) {
                System.out.print(testName + ": " + Arrays.toString(actual));
                if (Arrays.equals(actual, expected1) || Arrays.equals(actual, expected2)) {
                        System.out.println("  ✅ PASS");
                        passed++;
                } else {
                        System.out.println("  ❌ FAIL (Expected: " + Arrays.toString(expected1) + ")");
                        failed++;
                }
        }

        public static void main(String[] args) {
                TwoSum solution = new TwoSum();

                verify("Test 1 [Basic]",
                                solution.twoSum(new int[] { 2, 7, 11, 15 }, 9),
                                new int[] { 0, 1 }, new int[] { 1, 0 });

                verify("Test 2 [Target at end]",
                                solution.twoSum(new int[] { 3, 2, 4 }, 6),
                                new int[] { 1, 2 }, new int[] { 2, 1 });

                verify("Test 3 [Duplicate values]",
                                solution.twoSum(new int[] { 3, 3 }, 6),
                                new int[] { 0, 1 }, new int[] { 1, 0 });

                verify("Test 4 [Negatives]",
                                solution.twoSum(new int[] { -1, -2, -3, -4, -5 }, -8),
                                new int[] { 2, 4 }, new int[] { 4, 2 });

                verify("Test 5 [Two elements]",
                                solution.twoSum(new int[] { 1, 5 }, 6),
                                new int[] { 0, 1 }, new int[] { 1, 0 });

                System.out.println("\n══════════════════════════════");
                System.out.println("Results: " + passed + " passed, " + failed + " failed out of " + (passed + failed));
                if (failed == 0) {
                        System.out.println("🎉 All tests passed!");
                } else {
                        System.out.println("🔴 " + failed + " test(s) FAILED — fix your solution!");
                }
        }
}
