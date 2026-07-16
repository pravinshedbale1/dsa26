
/**
 * Subarrays with K Different Integers (LC #992)
 *
 * Given an integer array `nums` and an integer `k`, return the number of
 * contiguous subarrays that contain exactly `k` different integers.
 *
 * Example: nums = [1,2,1,2,3], k = 2 → 7
 * (The 7 subarrays: [1,2], [2,1], [1,2] again at a different position,
 * [1,2,1], [2,1,2], [1,2,1,2], [2,3])
 *
 * Pattern: Sliding Window — Exactly-K via atMost(K) - atMost(K-1) composition
 *
 * Brute Force: Check all O(n^2) subarrays, count distinct in each → O(n^2) or O(n^3) naive
 * Optimal: exactly(K) = atMost(K) - atMost(K-1), where atMost(K) is computed
 *          with one sliding window pass (HashMap<value, count>, shrink while
 *          distinct > K, add (right - left + 1) valid subarrays ending at
 *          right on every step) → O(n) time, O(k) space
 *
 * Constraints:
 * - 1 <= nums.length <= 2 * 10^4
 * - 1 <= nums[i], k <= nums.length
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinctIntegers {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    // ========================================
    // TODO: Implement this method
    // Count the number of subarrays with AT MOST k distinct integers.
    // ========================================
    private static int atMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;

        int count = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                if (map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left])-1);
                }
                left++;
            }
            count+=right-left+1;
            right++;
        }

        return count;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Basic case from problem walkthrough
        assert subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2) == 7
                : "Test 1 failed: expected 7";

        // Test 2: Official LC example 2
        assert subarraysWithKDistinct(new int[] { 1, 2, 1, 3, 4 }, 3) == 3
                : "Test 2 failed: expected 3";

        // Test 3: Edge case — all elements identical, k = 1 (every subarray qualifies)
        assert subarraysWithKDistinct(new int[] { 1, 1, 1, 1 }, 1) == 10
                : "Test 3 failed: expected 10";

        // Test 4: Edge case — k larger than possible distinct count in array
        assert subarraysWithKDistinct(new int[] { 1, 2, 3 }, 4) == 0
                : "Test 4 failed: expected 0";

        // Test 5: Edge case — single element array
        assert subarraysWithKDistinct(new int[] { 1 }, 1) == 1
                : "Test 5 failed: expected 1";

        System.out.println("All tests passed! ✅");
    }
}
