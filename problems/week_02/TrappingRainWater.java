import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 2 — Problem 2 of 2
 * ============================================
 * PROBLEM: Trapping Rain Water (LeetCode #42)
 *
 * Given n non-negative integers representing an elevation map
 * where the width of each bar is 1, compute how much water
 * it can trap after raining.
 *
 * CONSTRAINTS:
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 *
 * PATTERN: ???
 *
 * COMPLEXITY:
 * - Brute Force: O(n²) time — for each bar, scan left and right for max
 * - Better: O(n) time, O(n) space — ???
 * - Optimal: O(n) time, O(1) space — ???
 */
public class TrappingRainWater {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int trappedWater = 0;

        // Step 4: Move pointers inward until they meet in the middle
        while (left < right) {

            // Step 3: Check which highest wall is shorter (the bottleneck)
            if (height[left] < height[right]) {

                // Step 1 & 2: Update highest left wall, or calculate trapped water
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    trappedWater += maxLeft - height[left];
                }
                left++;

            } else {

                // Step 1 & 2: Update highest right wall, or calculate trapped water
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    trappedWater += maxRight - height[right];
                }
                right--;

            }
        }

        return trappedWater;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Classic example
        int r1 = trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        assert r1 == 6 : "Test 1 FAILED: expected 6, got " + r1;

        // Test 2: No water trapped (ascending)
        int r2 = trap(new int[] { 1, 2, 3, 4, 5 });
        assert r2 == 0 : "Test 2 FAILED: expected 0, got " + r2;

        // Test 3: No water trapped (descending)
        int r3 = trap(new int[] { 5, 4, 3, 2, 1 });
        assert r3 == 0 : "Test 3 FAILED: expected 0, got " + r3;

        // Test 4: Single valley
        int r4 = trap(new int[] { 3, 0, 3 });
        assert r4 == 3 : "Test 4 FAILED: expected 3, got " + r4;

        // Test 5: Multiple valleys
        int r5 = trap(new int[] { 4, 2, 0, 3, 2, 5 });
        assert r5 == 9 : "Test 5 FAILED: expected 9, got " + r5;

        System.out.println("✅ All tests passed!");
    }
}
