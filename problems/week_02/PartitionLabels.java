import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 7 — Weekly Challenge (Problem 2 of 2)
 * ============================================
 * PROBLEM: Partition Labels (LeetCode #763) — UNSEEN
 *
 * You are given a string s. We want to partition the string into as
 * many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the
 * parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 * Example:
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9, 7, 8]
 * Explanation:
 * "ababcbaca" | "defegde" | "hijhklij"
 * Each letter appears in at most one part.
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 500
 * - s consists of lowercase English letters
 *
 * ⏱️ TIME LIMIT: 25 minutes
 */
public class PartitionLabels {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Standard case from example
        List<Integer> r1 = partitionLabels("ababcbacadefegdehijhklij");
        assert r1.equals(Arrays.asList(9, 7, 8)) : "Test 1 FAILED: expected [9, 7, 8], got " + r1;

        // Test 2: Each char unique — max partitions
        List<Integer> r2 = partitionLabels("abcdef");
        assert r2.equals(Arrays.asList(1, 1, 1, 1, 1, 1)) : "Test 2 FAILED: expected [1,1,1,1,1,1], got " + r2;

        // Test 3: All same char — one partition
        List<Integer> r3 = partitionLabels("aaaa");
        assert r3.equals(Arrays.asList(4)) : "Test 3 FAILED: expected [4], got " + r3;

        // Test 4: Two partitions
        List<Integer> r4 = partitionLabels("abab");
        assert r4.equals(Arrays.asList(4)) : "Test 4 FAILED: expected [4], got " + r4;

        // Test 5: Single character
        List<Integer> r5 = partitionLabels("a");
        assert r5.equals(Arrays.asList(1)) : "Test 5 FAILED: expected [1], got " + r5;

        System.out.println("✅ All tests passed!");
    }
}
