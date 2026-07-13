
/**
 * Minimum Window Substring (LC #76)
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring,
 * return the empty string "".
 *
 * Pattern: Sliding Window (Variable Size — Shortest) + HashMap Freq Match
 *
 * Brute Force: Check all substrings, verify containment → O(n^2 * m) or worse
 * Optimal: Sliding window with need/window maps + formed/required counters
 *          → O(n + m) time, O(m) space (m = distinct chars in t)
 *
 * Constraints:
 * - m == s.length, n == t.length
 * - 1 <= m, n <= 10^5
 * - s and t consist of uppercase and lowercase English letters
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static String minWindow(String s, String t) {
                Map<Character, Integer> need = new HashMap<>();
                Map<Character, Integer> window = new HashMap<>();
                int required = 0;
                int formed = 0;
                int left = 0;
                int right = 0;
                String result = "";
                int minLength = Integer.MAX_VALUE;
                for (char ch : t.toCharArray()) {
                        need.put(ch, need.getOrDefault(ch, 0) + 1);
                }
                required = need.size();
                while (right < s.length()) {
                        char rightChar = s.charAt(right);
                        window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                        if (need.containsKey(rightChar)
                                        && window.get(rightChar).intValue() == need.get(rightChar).intValue()) {
                                formed++;
                        }
                        while (formed == required) {
                                char leftChar = s.charAt(left);
                                if (minLength > right - left + 1) {
                                        minLength = right - left + 1;
                                        result = s.substring(left, right + 1);
                                }
                                window.put(leftChar, window.get(leftChar) - 1);
                                if (need.containsKey(leftChar)
                                                && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                                        formed--;
                                }
                                left++;
                        }
                        right++;
                }
                return result;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert minWindow("ADOBECODEBANC", "ABC").equals("BANC")
                                : "Test 1 failed: expected BANC";

                // Test 2: Single char match
                assert minWindow("a", "a").equals("a")
                                : "Test 2 failed: expected a";

                // Test 3: Not enough of a char in s
                assert minWindow("a", "aa").equals("")
                                : "Test 3 failed: expected empty string";

                // Test 4: Entire string is the answer
                assert minWindow("aa", "aa").equals("aa")
                                : "Test 4 failed: expected aa";

                // Test 5: Character in t not present in s at all
                assert minWindow("abc", "d").equals("")
                                : "Test 5 failed: expected empty string";

                System.out.println("All tests passed! ✅");
        }
}
