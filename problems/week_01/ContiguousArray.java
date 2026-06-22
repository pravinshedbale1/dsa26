import java.util.*;

/**
 * ============================================
 * 🔥 WEEKLY CHALLENGE — Problem 1 of 2
 * ============================================
 * PROBLEM: Contiguous Array (LeetCode #525)
 * 
 * Given a binary array nums, find the maximum length of a contiguous
 * subarray with an equal number of 0s and 1s.
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^5
 * - nums[i] is either 0 or 1
 *
 * PATTERN: [YOU IDENTIFIED IT]
 * 
 * COMPLEXITY:
 * - Brute Force: O(n³) — check every subarray, count 0s and 1s
 * - Optimal: O(n) time, O(n) space
 */
public class ContiguousArray {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum = (nums[i] == 0 ? -1 : 1) + sum;
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        int passed = 0;
        int total = 5;

        // Test 1: Simple case
        int r1 = findMaxLength(new int[] { 0, 1 });
        if (r1 == 2) {
            passed++;
            System.out.println("✅ Test 1 passed");
        } else {
            System.out.println("❌ Test 1 FAILED — expected 2, got " + r1);
        }

        // Test 2: Odd length, partial match
        int r2 = findMaxLength(new int[] { 0, 1, 0 });
        if (r2 == 2) {
            passed++;
            System.out.println("✅ Test 2 passed");
        } else {
            System.out.println("❌ Test 2 FAILED — expected 2, got " + r2);
        }

        // Test 3: No equal subarray exists
        int r3 = findMaxLength(new int[] { 1, 1, 1, 1 });
        if (r3 == 0) {
            passed++;
            System.out.println("✅ Test 3 passed");
        } else {
            System.out.println("❌ Test 3 FAILED — expected 0, got " + r3);
        }

        // Test 4: Entire array is the answer
        int r4 = findMaxLength(new int[] { 0, 1, 1, 0, 1, 1, 1, 0, 0, 0 });
        if (r4 == 10) {
            passed++;
            System.out.println("✅ Test 4 passed");
        } else {
            System.out.println("❌ Test 4 FAILED — expected 10, got " + r4);
        }

        // Test 5: Longest subarray in the middle
        int r5 = findMaxLength(new int[] { 0, 0, 0, 1, 1, 1, 0 });
        if (r5 == 6) {
            passed++;
            System.out.println("✅ Test 5 passed");
        } else {
            System.out.println("❌ Test 5 FAILED — expected 6, got " + r5);
        }

        System.out.println("\n" + passed + "/" + total + " tests passed.");
    }
}
