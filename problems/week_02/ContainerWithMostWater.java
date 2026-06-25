import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 2 — Problem 1 of 2
 * ============================================
 * PROBLEM: Container With Most Water (LeetCode #11)
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Note: You may not slant the container.
 *
 * CONSTRAINTS:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 *
 * PATTERN: ???
 *
 * COMPLEXITY:
 * - Brute Force: O(n²) time — try all pairs
 * - Optimal: O(n) time, O(1) space — ???
 */
public class ContainerWithMostWater {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int d = right - left;

            maxArea = Math.max(maxArea, d * Math.min(leftHeight, rightHeight));

            if (leftHeight <= rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Standard case
        int r1 = maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        assert r1 == 49 : "Test 1 FAILED: expected 49, got " + r1;

        // Test 2: Two elements only
        int r2 = maxArea(new int[] { 1, 1 });
        assert r2 == 1 : "Test 2 FAILED: expected 1, got " + r2;

        // Test 3: Decreasing heights
        int r3 = maxArea(new int[] { 5, 4, 3, 2, 1 });
        assert r3 == 6 : "Test 3 FAILED: expected 6, got " + r3;

        // Test 4: All same height
        int r4 = maxArea(new int[] { 3, 3, 3, 3, 3 });
        assert r4 == 12 : "Test 4 FAILED: expected 12, got " + r4;

        // Test 5: Peak in the middle
        int r5 = maxArea(new int[] { 1, 2, 4, 3 });
        assert r5 == 4 : "Test 5 FAILED: expected 4, got " + r5;

        System.out.println("✅ All tests passed!");
    }
}
