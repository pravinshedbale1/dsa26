/*
 * ============================================================
 * VALID ANAGRAM (LeetCode #242) — Easy
 * ============================================================
 * 
 * PROBLEM:
 *   Given two strings s and t, return true if t is an
 *   anagram of s, and false otherwise.
 *   An anagram uses all original letters exactly once.
 *
 * PATTERN: Frequency Counting (int[26])
 *
 * COMPLEXITY:
 *   Sort:    O(n log n) time, O(n) space
 *   Optimal: O(n) time, O(1) space
 *
 * CONSTRAINTS:
 *   1 <= s.length, t.length <= 5 * 10^4
 *   s and t consist of lowercase English letters.
 * ============================================================
 */

import java.util.*;

public class ValidAnagram {

    // ✅ Fill in this method
    public static boolean isAnagram(String s, String t) {
        // YOUR CODE HERE
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (freq[ch - 'a'] == 0) {
                return false;
            }
            freq[ch - 'a']--;
        }
        return true;
    }

    // ============ DRIVER CODE — DO NOT MODIFY ============
    public static void main(String[] args) {
        // Test 1: Valid anagram
        assert isAnagram("anagram", "nagaram") == true : "Test 1 FAILED";

        // Test 2: Not an anagram
        assert isAnagram("rat", "car") == false : "Test 2 FAILED";

        // Test 3: Different lengths
        assert isAnagram("ab", "abc") == false : "Test 3 FAILED";

        // Test 4: Single character — same
        assert isAnagram("a", "a") == true : "Test 4 FAILED";

        // Test 5: Same letters, different frequency
        assert isAnagram("aacc", "ccac") == false : "Test 5 FAILED";

        System.out.println("✅ All tests passed!");
    }
}
