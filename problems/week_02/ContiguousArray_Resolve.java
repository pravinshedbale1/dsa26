import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 6 — Review Re-solve
 * ============================================
 * PROBLEM: Contiguous Array (LeetCode #525) — RE-SOLVE FROM MEMORY
 *
 * Given a binary array nums, return the maximum length of a contiguous
 * subarray with an equal number of 0 and 1.
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^5
 * - nums[i] is either 0 or 1
 *
 * ⏱️ TIME LIMIT: 15 minutes (re-solve, should be faster)
 */
public class ContiguousArray_Resolve {

    // ========================================
    // RE-SOLVE: Implement from memory
    // ========================================
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
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
        // Test 1: Basic case
        int r1 = findMaxLength(new int[] { 0, 1 });
        assert r1 == 2 : "Test 1 FAILED: expected 2, got " + r1;

        // Test 2: Longer subarray
        int r2 = findMaxLength(new int[] { 0, 1, 0 });
        assert r2 == 2 : "Test 2 FAILED: expected 2, got " + r2;

        // Test 3: Entire array
        int r3 = findMaxLength(new int[] { 0, 0, 1, 0, 0, 0, 1, 1 });
        assert r3 == 6 : "Test 3 FAILED: expected 6, got " + r3;

        // Test 4: No valid subarray
        int r4 = findMaxLength(new int[] { 0, 0, 0 });
        assert r4 == 0 : "Test 4 FAILED: expected 0, got " + r4;

        // Test 5: All equal
        int r5 = findMaxLength(new int[] { 0, 1, 1, 0, 1, 1, 1, 0, 0, 0 });
        assert r5 == 10 : "Test 5 FAILED: expected 10, got " + r5;

        System.out.println("✅ All tests passed!");
    }
}
