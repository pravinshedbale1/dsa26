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
 * CONSTRAINTS:
 *   1 <= s.length, t.length <= 5 * 10^4
 *   s and t consist of lowercase English letters.
 * ============================================================
 */

import java.util.*;

public class ValidAnagram {

    // ✅ Fill in this method
    public static boolean isAnagram(String s, String t) {
        int[] freqArr = new int[26];
        if (s.length() != t.length()) {
            return false;
        }

        // create a freq array
        for (char ch : s.toCharArray()) {
            freqArr[ch - 'a']++;
        }

        // for second string decrement each count
        for (char ch : t.toCharArray()) {
            if (freqArr[ch - 'a'] == 0) {
                return false;
            }
            freqArr[ch - 'a']--;
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
