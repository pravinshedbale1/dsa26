
/**
 * Longest Repeating Character Replacement (LC #424)
 *
 * You are given a string s and an integer k. You can choose up to k
 * characters of the string and replace them with any uppercase English
 * letter. Return the length of the longest substring containing the same
 * letter you can get after performing the above operations.
 *
 * Pattern: Sliding Window (Variable Size — Longest) + Max Frequency Tracking
 *
 * Brute Force: Check all substrings, count max freq char, verify
 * (length - maxFreq) <= k → O(n^2) or worse
 * Optimal: Sliding window with running int[26] freq array + running maxFreq
 * → O(n) time, O(1) space (26 fixed uppercase letters)
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of only uppercase English letters
 * - 0 <= k <= s.length
 */

public class LongestRepeatingCharacterReplacement {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int characterReplacement(String s, int k) {
                int mostFrequentChar = 0;
                int left = 0, right = 0;
                int[] freq = new int[26];
                int result = 0;

                while (right < s.length()) {
                        mostFrequentChar = Math.max(mostFrequentChar, ++freq[s.charAt(right) - 'A']);
                        if (right - left + 1 - mostFrequentChar > k) {
                                freq[s.charAt(left) - 'A']--;
                                left++;
                        }
                        result = Math.max(result, right - left + 1);
                        right++;
                }
                return result;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic case
                assert characterReplacement("ABAB", 2) == 4
                                : "Test 1 failed: expected 4";

                // Test 2: Classic case, replacements needed mid-string
                assert characterReplacement("AABABBA", 1) == 4
                                : "Test 2 failed: expected 4";

                // Test 3: No useful repeats — k only allows one swap
                assert characterReplacement("ABCDE", 1) == 2
                                : "Test 3 failed: expected 2";

                // Test 4: Already all same character
                assert characterReplacement("AAAA", 2) == 4
                                : "Test 4 failed: expected 4";

                // Test 5: Edge case — single character, k = 0
                assert characterReplacement("A", 0) == 1
                                : "Test 5 failed: expected 1";

                System.out.println("All tests passed! ✅");
        }
}
