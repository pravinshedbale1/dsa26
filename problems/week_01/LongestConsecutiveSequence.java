/*
 * ============================================================
 * Longest Consecutive Sequence (LeetCode #128) — Medium
 * ============================================================
 * 
 * Problem:
 *   Given an unsorted array of integers nums, return the length
 *   of the longest consecutive elements sequence.
 *   Must run in O(n) time.
 *
 * Pattern: HashSet + Sequence Start Detection
 *
 * Brute Force: Sort → scan for consecutive runs → O(n log n)
 * Optimal:     HashSet + only count from sequence starts → O(n)
 *
 * Constraints:
 *   - 0 <= nums.length <= 10^5
 *   - -10^9 <= nums[i] <= 10^9
 * ============================================================
 */

import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int longestSequenceCount = 0;

        for (int n : set) {
            int count = 0;
            if (!set.contains(n - 1)) {
                count = 1;
                while (set.contains(n + 1)) {
                    n = n + 1;
                    count++;
                }
                longestSequenceCount = Math.max(count, longestSequenceCount);
            }
        }

        return longestSequenceCount;
    }

    public static void main(String[] args) {
        // Test 1: Standard case
        int r1 = longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 });
        assert r1 == 4 : "Test 1 FAILED: expected 4, got " + r1;
        System.out.println("Test 1 PASSED: " + r1);

        // Test 2: Longer sequence with duplicates
        int r2 = longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 });
        assert r2 == 9 : "Test 2 FAILED: expected 9, got " + r2;
        System.out.println("Test 2 PASSED: " + r2);

        // Test 3: Empty array
        int r3 = longestConsecutive(new int[] {});
        assert r3 == 0 : "Test 3 FAILED: expected 0, got " + r3;
        System.out.println("Test 3 PASSED: " + r3);

        // Test 4: Single element
        int r4 = longestConsecutive(new int[] { 42 });
        assert r4 == 1 : "Test 4 FAILED: expected 1, got " + r4;
        System.out.println("Test 4 PASSED: " + r4);

        // Test 5: All duplicates
        int r5 = longestConsecutive(new int[] { 5, 5, 5, 5 });
        assert r5 == 1 : "Test 5 FAILED: expected 1, got " + r5;
        System.out.println("Test 5 PASSED: " + r5);

        System.out.println("\n🎉 All tests passed!");
    }
}
