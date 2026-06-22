import java.util.*;

/**
 * ============================================
 * 🔥 WEEKLY CHALLENGE — Problem 2 of 2
 * ============================================
 * PROBLEM: Sort Characters By Frequency (LeetCode #451)
 * 
 * Given a string s, sort it in decreasing order based on the
 * frequency of the characters. Return any valid answer.
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 5 * 10^5
 * - s consists of uppercase/lowercase English letters and digits
 *
 * PATTERN: [YOU IDENTIFIED IT]
 * 
 * COMPLEXITY:
 * - Brute Force: O(n log n) — frequency map + sort by frequency
 * - Optimal: O(n) — frequency map + bucket sort
 */
public class SortCharsByFrequency {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static String frequencySort(String s) {
        int size = s.length();
        StringBuilder sb = new StringBuilder("");
        List<Character>[] arr = new List[size + 1];
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : map.keySet()) {
            int index = map.get(ch);
            if (arr[index] == null) {
                List<Character> list = new ArrayList<>();
                list.add(ch);
                arr[index] = list;
            } else {
                arr[index].add(ch);
            }
        }

        for (int i = size; i >= 1; i--) {
            if (arr[i] != null) {
                for (Character ch : arr[i]) {
                    for (int j = 0; j < i; j++)
                        sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        int passed = 0;
        int total = 5;

        // Test 1: Basic case
        String r1 = frequencySort("tree");
        if (r1.equals("eert") || r1.equals("eetr")) {
            passed++;
            System.out.println("✅ Test 1 passed: " + r1);
        } else {
            System.out.println("❌ Test 1 FAILED — expected 'eert' or 'eetr', got '" + r1 + "'");
        }

        // Test 2: Same frequency characters
        String r2 = frequencySort("cccaaa");
        if (r2.equals("cccaaa") || r2.equals("aaaccc")) {
            passed++;
            System.out.println("✅ Test 2 passed: " + r2);
        } else {
            System.out.println("❌ Test 2 FAILED — expected 'cccaaa' or 'aaaccc', got '" + r2 + "'");
        }

        // Test 3: Case sensitive
        String r3 = frequencySort("Aabb");
        if ((r3.equals("bbAa") || r3.equals("bbaA"))) {
            passed++;
            System.out.println("✅ Test 3 passed: " + r3);
        } else {
            System.out.println("❌ Test 3 FAILED — expected 'bbAa' or 'bbaA', got '" + r3 + "'");
        }

        // Test 4: Single character
        String r4 = frequencySort("z");
        if (r4.equals("z")) {
            passed++;
            System.out.println("✅ Test 4 passed: " + r4);
        } else {
            System.out.println("❌ Test 4 FAILED — expected 'z', got '" + r4 + "'");
        }

        // Test 5: All same characters
        String r5 = frequencySort("aaaa");
        if (r5.equals("aaaa")) {
            passed++;
            System.out.println("✅ Test 5 passed: " + r5);
        } else {
            System.out.println("❌ Test 5 FAILED — expected 'aaaa', got '" + r5 + "'");
        }

        System.out.println("\n" + passed + "/" + total + " tests passed.");
    }
}
