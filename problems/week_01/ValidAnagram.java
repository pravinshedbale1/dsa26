import java.util.*;

/**
 * LC #242 — Valid Anagram (Easy)
 *
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise. An anagram uses exactly the same characters, the same number of
 * times, in any order.
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 *
 * Pattern: (you tell me in the debrief)
 * Complexity: (you tell me — brute vs optimal)
 */
public class ValidAnagram {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            int[] chars = new int[26];
            for (char ch : s.toCharArray()) {
                chars[ch - 'a']++;
            }
            for (char ch : t.toCharArray()) {
                if (chars[ch - 'a'] == 0) {
                    return false;
                }
                chars[ch - 'a']--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        check(sol, "anagram", "nagaram", true); // basic anagram
        check(sol, "rat", "car", false); // same length, different chars
        check(sol, "a", "ab", false); // different lengths
        check(sol, "aacc", "ccac", false); // same char set, different counts
        check(sol, "z", "z", true); // single char
        check(sol, "ab", "a", false); // t shorter than s

        System.out.println("All tests passed ✅");
    }

    private static void check(Solution sol, String s, String t, boolean expected) {
        boolean res = sol.isAnagram(s, t);
        if (res != expected)
            fail("Expected " + expected + " but got " + res + " for s=\"" + s + "\", t=\"" + t + "\"");
        System.out.println("PASS s=\"" + s + "\" t=\"" + t + "\" -> " + res);
    }

    private static void fail(String msg) {
        System.out.println("FAIL " + msg);
        System.exit(1);
    }
}
