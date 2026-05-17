
/**
 * ══════════════════════════════════════════════════════════════
 * PROBLEM: Valid Anagram (LeetCode #242)
 * ══════════════════════════════════════════════════════════════
 *
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise.
 *
 * An anagram is a word formed by rearranging the letters of another
 * word, using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters only
 *
 * PATTERN: ???
 * BRUTE FORCE: ???
 * OPTIMAL: ???
 * ══════════════════════════════════════════════════════════════
 */
public class ValidAnagram {

        // ✅ COMPLETE THIS METHOD — implement the optimal O(n) int[26] approach
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

        // ═══════════════════════════════════════════════════════════
        // DRIVER CODE — DO NOT MODIFY BELOW
        // ═══════════════════════════════════════════════════════════
        static int passed = 0, failed = 0;

        static void verify(String testName, boolean actual, boolean expected) {
                System.out.print(testName + ": " + actual);
                if (actual == expected) {
                        System.out.println("  ✅ PASS");
                        passed++;
                } else {
                        System.out.println("  ❌ FAIL (Expected: " + expected + ")");
                        failed++;
                }
        }

        public static void main(String[] args) {
                ValidAnagram solution = new ValidAnagram();

                verify("Test 1 [Basic anagram]",
                                solution.isAnagram("anagram", "nagaram"),
                                true);

                verify("Test 2 [Not anagram]",
                                solution.isAnagram("rat", "car"),
                                false);

                verify("Test 3 [Different lengths]",
                                solution.isAnagram("hello", "hi"),
                                false);

                verify("Test 4 [Single char same]",
                                solution.isAnagram("a", "a"),
                                true);

                verify("Test 5 [Single char different]",
                                solution.isAnagram("a", "b"),
                                false);

                verify("Test 6 [Same chars different frequency]",
                                solution.isAnagram("aacc", "ccac"),
                                false);

                verify("Test 7 [Empty-like: all same chars]",
                                solution.isAnagram("aaa", "aaa"),
                                true);

                System.out.println("\n══════════════════════════════");
                System.out.println("Results: " + passed + " passed, " + failed + " failed out of " + (passed + failed));
                if (failed == 0) {
                        System.out.println("🎉 All tests passed!");
                } else {
                        System.out.println("🔴 " + failed + " test(s) FAILED — fix your solution!");
                }
        }
}
