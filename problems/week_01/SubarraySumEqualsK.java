/*
 * ============================================================
 * SUBARRAY SUM EQUALS K (LeetCode #560)
 * ============================================================
 *
 * Given an array of integers nums and an integer k, return the
 * total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements
 * within an array.
 *
 * ============================================================
 * CONSTRAINTS:
 * - 1 <= nums.length <= 2 * 10^4
 * - -1000 <= nums[i] <= 1000
 * - -10^7 <= k <= 10^7
 *
 * ============================================================
 * EXAMPLES:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Explanation: [1,1] at index 0-1 and [1,1] at index 1-2
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * Explanation: [1,2] and [3]
 *
 * ============================================================
 * PATTERN: Prefix Sum + HashMap
 * BRUTE FORCE: O(n^2) — check all subarray sums
 * OPTIMAL: O(n) — running prefix sum + HashMap lookup
 * ============================================================
 */

import java.util.*;

public class SubarraySumEqualsK {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        int passed = 0;
        int total = 5;

        // Test 1: Basic case — two subarrays sum to 2
        int[] nums1 = { 1, 1, 1 };
        if (subarraySum(nums1, 2) == 2) {
            System.out.println("✅ Test 1 PASSED: [1,1,1] k=2 → 2");
            passed++;
        } else {
            System.out.println("❌ Test 1 FAILED: Expected 2, got " + subarraySum(nums1, 2));
        }

        // Test 2: Subarray starting at index 0
        int[] nums2 = { 1, 2, 3 };
        if (subarraySum(nums2, 3) == 2) {
            System.out.println("✅ Test 2 PASSED: [1,2,3] k=3 → 2");
            passed++;
        } else {
            System.out.println("❌ Test 2 FAILED: Expected 2, got " + subarraySum(nums2, 3));
        }

        // Test 3: Negative numbers — cancellation creates subarrays
        int[] nums3 = { 1, -1, 1, -1, 1 };
        if (subarraySum(nums3, 0) == 6) {
            System.out.println("✅ Test 3 PASSED: [1,-1,1,-1,1] k=0 → 6");
            passed++;
        } else {
            System.out.println("❌ Test 3 FAILED: Expected 6, got " + subarraySum(nums3, 0));
        }

        // Test 4: Single element equals k
        int[] nums4 = { 5 };
        if (subarraySum(nums4, 5) == 1) {
            System.out.println("✅ Test 4 PASSED: [5] k=5 → 1");
            passed++;
        } else {
            System.out.println("❌ Test 4 FAILED: Expected 1, got " + subarraySum(nums4, 5));
        }

        // Test 5: No subarray sums to k
        int[] nums5 = { 1, 2, 3 };
        if (subarraySum(nums5, 10) == 0) {
            System.out.println("✅ Test 5 PASSED: [1,2,3] k=10 → 0");
            passed++;
        } else {
            System.out.println("❌ Test 5 FAILED: Expected 0, got " + subarraySum(nums5, 10));
        }

        System.out.println("\n" + passed + "/" + total + " tests passed.");
    }
}
