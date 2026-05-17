import java.util.*;

/**
 * ══════════════════════════════════════════════════════════════
 * PROBLEM: Group Anagrams (LeetCode #49)
 * ══════════════════════════════════════════════════════════════
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An anagram is a word formed by rearranging the letters of
 * another word, using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters
 *
 * PATTERN: ???
 * BRUTE FORCE: ???
 * OPTIMAL: ???
 * ══════════════════════════════════════════════════════════════
 */
public class GroupAnagrams {

    // ═══════════════════════════════════════════════════════════
    // APPROACH 1: BRUTE FORCE — Sort each string as the key
    // TC: O(n * k log k) where n = number of strings, k = max string length
    // SC: O(n * k)
    // ═══════════════════════════════════════════════════════════
    public List<List<String>> groupAnagramsBrute(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (res.containsKey(key)) {
                res.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                res.put(key, list);
            }
        }
        return new ArrayList<>(res.values());
    }

    // ═══════════════════════════════════════════════════════════
    // APPROACH 2: OPTIMAL — Use frequency count as the key
    // TC: O(n * k) where n = number of strings, k = max string length
    // SC: O(n * k)
    // ═══════════════════════════════════════════════════════════
    public static String getFreqKey(String str) {
        int[] arr = new int[26];
        for (char ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }
        return Arrays.toString(arr);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getFreqKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    // ═══════════════════════════════════════════════════════════
    // DRIVER CODE — DO NOT MODIFY BELOW
    // ═══════════════════════════════════════════════════════════
    static int passed = 0, failed = 0;

    static void verify(String testName, List<List<String>> actual, int expectedGroups, int[] expectedSizes) {
        System.out.print(testName + ": " + actual.size() + " groups");

        if (actual.size() != expectedGroups) {
            System.out.println("  ❌ FAIL (Expected " + expectedGroups + " groups, got " + actual.size() + ")");
            failed++;
            return;
        }

        // Check group sizes match (sort both for comparison)
        int[] actualSizes = actual.stream().mapToInt(List::size).sorted().toArray();
        int[] sortedExpected = Arrays.stream(expectedSizes).sorted().toArray();

        if (Arrays.equals(actualSizes, sortedExpected)) {
            System.out.println("  ✅ PASS");
            passed++;
        } else {
            System.out.println("  ❌ FAIL (Group sizes don't match. Expected: "
                    + Arrays.toString(sortedExpected) + ", Got: " + Arrays.toString(actualSizes) + ")");
            failed++;
        }
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        // Test 1: Classic example
        verify("Test 1 [Classic]",
                solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }),
                3, new int[] { 3, 2, 1 });

        // Test 2: Single empty string
        verify("Test 2 [Empty string]",
                solution.groupAnagrams(new String[] { "" }),
                1, new int[] { 1 });

        // Test 3: Single character
        verify("Test 3 [Single char]",
                solution.groupAnagrams(new String[] { "a" }),
                1, new int[] { 1 });

        // Test 4: All same anagram
        verify("Test 4 [All anagrams]",
                solution.groupAnagrams(new String[] { "abc", "bca", "cab", "bac" }),
                1, new int[] { 4 });

        // Test 5: All different (no anagrams)
        verify("Test 5 [No anagrams]",
                solution.groupAnagrams(new String[] { "abc", "def", "ghi" }),
                3, new int[] { 1, 1, 1 });

        // Test 6: Mixed with duplicates
        verify("Test 6 [Duplicates]",
                solution.groupAnagrams(new String[] { "a", "a", "b" }),
                2, new int[] { 2, 1 });

        System.out.println("\n══════════════════════════════");
        System.out.println("Results: " + passed + " passed, " + failed + " failed out of " + (passed + failed));
        if (failed == 0) {
            System.out.println("🎉 All tests passed!");
        } else {
            System.out.println("🔴 " + failed + " test(s) FAILED — fix your solution!");
        }
    }
}
