/*
 * ============================================================
 * TOP K FREQUENT ELEMENTS (LeetCode #347) — Medium
 * ============================================================
 * 
 * PROBLEM:
 *   Given an integer array nums and an integer k, return
 *   the k most frequent elements. Answer in any order.
 *
 * PATTERN: Frequency Count + Bucket Sort
 *
 * COMPLEXITY:
 *   Brute:   O(n log n) time, O(n) space — freq map + sort
 *   Optimal: O(n) time, O(n) space — freq map + bucket sort
 *
 * CONSTRAINTS:
 *   1 <= nums.length <= 10^5
 *   -10^4 <= nums[i] <= 10^4
 *   k is in range [1, number of unique elements]
 *   Answer is guaranteed to be unique.
 * ============================================================
 */

import java.util.*;

public class TopKFrequent {

    // ✅ Fill in this method
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int size = nums.length;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[size + 1];

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                buckets[freq] = list;
            } else {
                buckets[freq].add(key);
            }
        }

        int ptr = 0;
        for (int i = size; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    if (ptr < k)
                        result[ptr++] = num;
                }
            }
        }

        return result;
    }

    // ============ DRIVER CODE — DO NOT MODIFY ============
    public static void main(String[] args) {
        // Test 1: Basic case
        int[] r1 = topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        Arrays.sort(r1);
        assert Arrays.equals(r1, new int[] { 1, 2 }) : "Test 1 FAILED: expected [1,2], got " + Arrays.toString(r1);

        // Test 2: Single element
        int[] r2 = topKFrequent(new int[] { 1 }, 1);
        assert Arrays.equals(r2, new int[] { 1 }) : "Test 2 FAILED: expected [1], got " + Arrays.toString(r2);

        // Test 3: All same frequency, k = total unique
        int[] r3 = topKFrequent(new int[] { 1, 2, 3 }, 3);
        Arrays.sort(r3);
        assert Arrays.equals(r3, new int[] { 1, 2, 3 }) : "Test 3 FAILED: expected [1,2,3], got " + Arrays.toString(r3);

        // Test 4: Negative numbers
        int[] r4 = topKFrequent(new int[] { -1, -1, -1, 2, 2, 3, 3, 3, 3 }, 2);
        Arrays.sort(r4);
        assert Arrays.equals(r4, new int[] { -1, 3 }) : "Test 4 FAILED: expected [-1,3], got " + Arrays.toString(r4);

        // Test 5: k = 1, find the single most frequent
        int[] r5 = topKFrequent(new int[] { 4, 4, 4, 1, 1, 2 }, 1);
        assert Arrays.equals(r5, new int[] { 4 }) : "Test 5 FAILED: expected [4], got " + Arrays.toString(r5);

        System.out.println("✅ All tests passed!");
    }
}
