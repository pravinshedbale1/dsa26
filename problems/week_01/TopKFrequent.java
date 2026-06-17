/*
 * ============================================================
 * TOP K FREQUENT ELEMENTS (LeetCode #347) — Medium
 * ============================================================
 * 
 * PROBLEM:
 *   Given an integer array nums and an integer k, return the
 *   k most frequent elements. You may return the answer in
 *   any order.
 *
 * CONSTRAINTS:
 *   1 <= nums.length <= 10^5
 *   -10^4 <= nums[i] <= 10^4
 *   k is in the range [1, number of unique elements]
 *   It is guaranteed that the answer is unique.
 *
 * EXAMPLES:
 *   Input:  nums = [1,1,1,2,2,3], k = 2
 *   Output: [1,2]
 *
 *   Input:  nums = [1], k = 1
 *   Output: [1]
 * ============================================================
 */

import java.util.*;

public class TopKFrequent {

    // ✅ Fill in this method
    public static int[] topKFrequent(int[] nums, int k) {
        int size = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            if (freqMap.containsKey(n)) {
                freqMap.put(n, freqMap.get(n) + 1);
            } else {
                freqMap.put(n, 1);
            }
        }

        List[] buckets = new List[size + 1];

        for (int n : freqMap.keySet()) {
            int key = freqMap.get(n);
            int value = n;

            if (buckets[key] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                buckets[key] = list;
            } else {
                buckets[key].add(value);
            }
        }

        int[] result = new int[k];
        int ptr = 0;

        for (int i = size; i >= 1 && ptr < k; i--) {
            List<Integer> list = buckets[i];
            if (list != null) {
                for (int n : list) {
                    result[ptr] = n;
                    ptr++;
                }
            }
        }

        return result;
    }

    // ─── Driver Code ──────────────────────────────────────────
    public static void main(String[] args) {

        // Test 1: Standard case
        int[] r1 = topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);
        assert arraysEqualUnordered(r1, new int[] { 1, 2 }) : "Test 1 FAILED — got " + Arrays.toString(r1);
        System.out.println("Test 1 PASSED ✅  result=" + Arrays.toString(r1));

        // Test 2: Single element
        int[] r2 = topKFrequent(new int[] { 1 }, 1);
        assert arraysEqualUnordered(r2, new int[] { 1 }) : "Test 2 FAILED — got " + Arrays.toString(r2);
        System.out.println("Test 2 PASSED ✅  result=" + Arrays.toString(r2));

        // Test 3: All same frequency, k equals unique count
        int[] r3 = topKFrequent(new int[] { 1, 2, 3 }, 3);
        assert arraysEqualUnordered(r3, new int[] { 1, 2, 3 }) : "Test 3 FAILED — got " + Arrays.toString(r3);
        System.out.println("Test 3 PASSED ✅  result=" + Arrays.toString(r3));

        // Test 4: Negative numbers
        int[] r4 = topKFrequent(new int[] { -1, -1, 2, 2, 2, 3 }, 2);
        assert arraysEqualUnordered(r4, new int[] { 2, -1 }) : "Test 4 FAILED — got " + Arrays.toString(r4);
        System.out.println("Test 4 PASSED ✅  result=" + Arrays.toString(r4));

        // Test 5: k = 1, clear winner
        int[] r5 = topKFrequent(new int[] { 4, 4, 4, 1, 1, 2, 2, 2, 2 }, 1);
        assert arraysEqualUnordered(r5, new int[] { 2 }) : "Test 5 FAILED — got " + Arrays.toString(r5);
        System.out.println("Test 5 PASSED ✅  result=" + Arrays.toString(r5));

        System.out.println("\n🎉 All tests passed!");
    }

    // Helper: compare two arrays ignoring order
    private static boolean arraysEqualUnordered(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        int[] aSorted = a.clone();
        Arrays.sort(aSorted);
        int[] bSorted = b.clone();
        Arrays.sort(bSorted);
        return Arrays.equals(aSorted, bSorted);
    }
}
