import java.util.*;

/**
 * ══════════════════════════════════════════════════════════════
 * PROBLEM: Top K Frequent Elements (LeetCode #347)
 * ══════════════════════════════════════════════════════════════
 *
 * Given an integer array nums and an integer k, return the k
 * most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, number of unique elements]
 * The answer is guaranteed to be unique
 *
 * FOLLOW-UP: Can you solve it better than O(n log n)?
 *
 * PATTERN: ???
 * BRUTE FORCE: ???
 * BETTER: ???
 * OPTIMAL: ???
 * ══════════════════════════════════════════════════════════════
 */
public class TopKFrequent {

    // ✅ COMPLETE THIS METHOD
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] buckets = new List[n + 1];
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int[] res = new int[k];
        int ptr = 0;
        for (int i = n; i >= 0 && ptr < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    if (ptr >= k)
                        break;
                    res[ptr++] = num;
                }
            }
        }
        return res;
    }

    // ═══════════════════════════════════════════════════════════
    // DRIVER CODE — DO NOT MODIFY BELOW
    // ═══════════════════════════════════════════════════════════
    static int passed = 0, failed = 0;

    static void verify(String testName, int[] actual, int[] expected) {
        Arrays.sort(actual);
        Arrays.sort(expected);
        System.out.print(testName + ": " + Arrays.toString(actual));
        if (Arrays.equals(actual, expected)) {
            System.out.println("  ✅ PASS");
            passed++;
        } else {
            System.out.println("  ❌ FAIL (Expected: " + Arrays.toString(expected) + ")");
            failed++;
        }
    }

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();

        verify("Test 1 [Classic]",
                solution.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2),
                new int[] { 1, 2 });

        verify("Test 2 [Single element]",
                solution.topKFrequent(new int[] { 1 }, 1),
                new int[] { 1 });

        verify("Test 3 [All same frequency]",
                solution.topKFrequent(new int[] { 1, 2, 3 }, 3),
                new int[] { 1, 2, 3 });

        verify("Test 4 [Negatives]",
                solution.topKFrequent(new int[] { -1, -1, 2, 2, 2, 3 }, 1),
                new int[] { 2 });

        verify("Test 5 [K equals unique count]",
                solution.topKFrequent(new int[] { 4, 4, 5, 5, 6, 6 }, 3),
                new int[] { 4, 5, 6 });

        verify("Test 6 [Large frequency gap]",
                solution.topKFrequent(new int[] { 1, 1, 1, 1, 1, 2, 3, 4, 5 }, 2),
                new int[] { 1, 2 });

        System.out.println("\n══════════════════════════════");
        System.out.println("Results: " + passed + " passed, " + failed + " failed out of " + (passed + failed));
        if (failed == 0) {
            System.out.println("🎉 All tests passed!");
        } else {
            System.out.println("🔴 " + failed + " test(s) FAILED — fix your solution!");
        }
    }
}
