
/**
 * Longest Substring Without Repeating Characters (LC #3)
 * 
 * Given a string s, find the length of the longest substring
 * without repeating characters.
 * 
 * Pattern: Sliding Window (Variable Size) + HashSet
 * 
 * Brute Force: Check all substrings → O(n³) or O(n²)
 * Optimal: Sliding window + HashSet → O(n) time, O(min(n, charset)) space
 * 
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces
 */

import java.util.*;

public class LongestSubstringWithoutRepeating {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int lengthOfLongestSubstring(String s) {
                int maxWindow = 0;
                Set<Character> set = new HashSet<>();
                int left = 0;
                int right = 0;
                int size = s.length();

                while (right < size) {
                        char rightChar = s.charAt(right);
                        if (set.contains(rightChar)) {
                                set.remove(s.charAt(left));
                                left++;
                                continue;
                        }
                        maxWindow = Math.max(maxWindow, right - left + 1);
                        set.add(rightChar);
                        right++;
                }
                return maxWindow;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert lengthOfLongestSubstring("abcabcbb") == 3
                                : "Test 1 failed: expected 3 (\"abc\")";

                // Test 2: All same characters
                assert lengthOfLongestSubstring("bbbbb") == 1
                                : "Test 2 failed: expected 1 (\"b\")";

                // Test 3: No repeats at all
                assert lengthOfLongestSubstring("abcdef") == 6
                                : "Test 3 failed: expected 6 (entire string)";

                // Test 4: Empty string
                assert lengthOfLongestSubstring("") == 0
                                : "Test 4 failed: expected 0";

                // Test 5: Repeats with spaces and symbols
                assert lengthOfLongestSubstring("pwwkew") == 3
                                : "Test 5 failed: expected 3 (\"wke\")";

                System.out.println("All tests passed! ✅");
        }
}
