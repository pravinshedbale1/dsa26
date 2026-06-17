/*
 * ============================================================
 * GROUP ANAGRAMS (LeetCode #49) — Medium
 * ============================================================
 * 
 * PROBLEM:
 *   Given an array of strings strs, group the anagrams together.
 *   You can return the answer in any order.
 *   An anagram is a word formed by rearranging the letters of
 *   another word, using all the original letters exactly once.
 *
 * CONSTRAINTS:
 *   1 <= strs.length <= 10^4
 *   0 <= strs[i].length <= 100
 *   strs[i] consists of lowercase English letters.
 *
 * EXAMPLES:
 *   Input:  ["eat","tea","tan","ate","nat","bat"]
 *   Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 *   Input:  [""]
 *   Output: [[""]]
 *
 *   Input:  ["a"]
 *   Output: [["a"]]
 * ============================================================
 */

import java.util.*;

public class GroupAnagrams {

    // ✅ Fill in this method
    public static String getFrequencyKey(String str) {
        String key = "";
        int[] freqArr = new int[26];
        for (char ch : str.toCharArray()) {
            freqArr[ch - 'a']++;
        }
        key = Arrays.toString(freqArr);
        return key;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> classifiedStrings = new HashMap<>();
        for (String str : strs) {
            String key = getFrequencyKey(str);
            if (classifiedStrings.containsKey(key)) {
                classifiedStrings.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                classifiedStrings.put(key, list);
            }
        }
        return new ArrayList<>(classifiedStrings.values());
    }

    // ─── Driver Code ──────────────────────────────────────────
    public static void main(String[] args) {

        // Test 1: Standard mixed anagrams
        String[] t1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> r1 = groupAnagrams(t1);
        assert r1.size() == 3 : "Test 1 FAILED — expected 3 groups, got " + r1.size();
        System.out.println("Test 1 PASSED ✅  groups=" + r1);

        // Test 2: Single empty string
        String[] t2 = { "" };
        List<List<String>> r2 = groupAnagrams(t2);
        assert r2.size() == 1 && r2.get(0).contains("") : "Test 2 FAILED";
        System.out.println("Test 2 PASSED ✅  groups=" + r2);

        // Test 3: Single character
        String[] t3 = { "a" };
        List<List<String>> r3 = groupAnagrams(t3);
        assert r3.size() == 1 && r3.get(0).contains("a") : "Test 3 FAILED";
        System.out.println("Test 3 PASSED ✅  groups=" + r3);

        // Test 4: All same anagrams
        String[] t4 = { "abc", "bca", "cab", "bac" };
        List<List<String>> r4 = groupAnagrams(t4);
        assert r4.size() == 1 && r4.get(0).size() == 4 : "Test 4 FAILED — expected 1 group of 4";
        System.out.println("Test 4 PASSED ✅  groups=" + r4);

        // Test 5: No anagrams (all unique)
        String[] t5 = { "abc", "def", "ghi" };
        List<List<String>> r5 = groupAnagrams(t5);
        assert r5.size() == 3 : "Test 5 FAILED — expected 3 groups, got " + r5.size();
        System.out.println("Test 5 PASSED ✅  groups=" + r5);

        System.out.println("\n🎉 All tests passed!");
    }
}
