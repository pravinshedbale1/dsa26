import java.util.Arrays;

/**
 * Permutation in String (LC #567)
 * 
 * Given two strings s1 and s2, return true if s2 contains a
 * permutation of s1, or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is
 * a substring of s2.
 * 
 * Pattern: Sliding Window (Fixed Size) + Frequency Match
 * 
 * Brute Force: Check all permutations of s1 → O(n! * m)
 * Better: Check all substrings of s2 with length s1 → O(m * 26) with freq
 * comparison
 * Optimal: Sliding window + match count → O(m) time, O(1) space
 * 
 * Constraints:
 * - 1 <= s1.length, s2.length <= 10^4
 * - s1 and s2 consist of lowercase English letters
 */

public class PermutationInString {

        // ========================================
        // TODO: Implement this method
        // ========================================

        public static boolean checkInclusion(String s1, String s2) {
                int[] need = new int[26];
                int[] window = new int[26];
                int k = s1.length();
                int left = 0;
                int right = 0;
                for (char ch : s1.toCharArray()) {
                        need[ch - 'a']++;
                }

                while (right < s2.length()) {
                        window[s2.charAt(right) - 'a']++;
                        if (right - left + 1 == k) {
                                if (Arrays.equals(need, window)) {
                                        return true;
                                }
                                window[s2.charAt(left) - 'a']--;
                                left++;
                        }
                        right++;
                }

                return false;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: Basic true case
                assert checkInclusion("ab", "eidbaooo") == true
                                : "Test 1 failed: expected true ('ba' is permutation of 'ab')";

                // Test 2: Basic false case
                assert checkInclusion("ab", "eidboaoo") == false
                                : "Test 2 failed: expected false";

                // Test 3: s1 longer than s2
                assert checkInclusion("abcdef", "abc") == false
                                : "Test 3 failed: expected false (s1 longer than s2)";

                // Test 4: Exact match
                assert checkInclusion("abc", "cba") == true
                                : "Test 4 failed: expected true (entire s2 is permutation)";

                // Test 5: Single character
                assert checkInclusion("a", "a") == true
                                : "Test 5 failed: expected true";

                System.out.println("All tests passed! ✅");
        }
}
