/**
 * ============================================
 * WEEK 2, DAY 1 — Problem 1 of 2
 * ============================================
 * PROBLEM: Valid Palindrome (LeetCode #125)
 *
 * Given a string s, return true if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 2 * 10^5
 * - s consists only of printable ASCII characters
 *
 * PATTERN: Two Pointers (Opposite Ends)
 *
 * COMPLEXITY:
 * - Brute Force: O(n) time, O(n) space — filter + reverse + compare
 * - Optimal: O(n) time, O(1) space — two pointers in-place
 *
 * USEFUL JAVA METHODS:
 * - Character.isLetterOrDigit(ch)
 * - Character.toLowerCase(ch)
 */
public class ValidPalindrome {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Classic palindrome with spaces and punctuation
        assert isPalindrome("A man, a plan, a canal: Panama") == true : "Test 1 FAILED";

        // Test 2: Not a palindrome
        assert isPalindrome("race a car") == false : "Test 2 FAILED";

        // Test 3: Empty/whitespace string → trivially palindrome
        assert isPalindrome(" ") == true : "Test 3 FAILED";

        // Test 4: Single character
        assert isPalindrome("a") == true : "Test 4 FAILED";

        // Test 5: Numbers mixed in
        assert isPalindrome("0P") == false : "Test 5 FAILED";

        System.out.println("✅ All tests passed!");
    }
}
