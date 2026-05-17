
/**
 * ═══════════════════════════════════════════════════════════════
 * SLIDING WINDOW TEMPLATES
 * ═══════════════════════════════════════════════════════════════
 * 
 * When to use:
 * - "Contiguous subarray" or "substring"
 * - "Longest/shortest" with some condition
 * - "At most K distinct" or "contains all characters"
 * 
 * Two types:
 * 1. FIXED window: window size is given (K)
 * 2. VARIABLE window: find max/min window satisfying condition
 * 
 * Common mistakes:
 * - Forgetting to shrink the window (infinite growth)
 * - Off-by-one when calculating window size: size = right - left + 1
 * - Not updating the result at the right time (after shrink, not before)
 */

import java.util.*;

public class SlidingWindowTemplate {

    // ─── Template 1: Fixed Size Window ─────────────────────────
    // Find max sum of subarray of size K
    // Use when: "subarray of size K", "window of size K"
    public int fixedWindow(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i]; // Add right element

            if (i >= k) {
                windowSum -= nums[i - k]; // Remove left element (window full)
            }

            if (i >= k - 1) { // Window has K elements
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        return maxSum;
    }

    // ─── Template 2: Variable Window — Find Longest ────────────
    // Find longest substring without repeating characters
    // Use when: "longest subarray/substring" with condition
    //
    // Pattern: Expand right always, shrink left when INVALID
    public int longestVariableWindow(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // SHRINK: while window is invalid, remove from left
            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }

            // EXPAND: add current character
            window.add(c);

            // UPDATE: result after window is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // ─── Template 3: Variable Window — Find Shortest ───────────
    // Find minimum size subarray with sum >= target
    // Use when: "shortest/minimum subarray" with condition
    //
    // Pattern: Expand right always, shrink left when VALID (to find minimum)
    public int shortestVariableWindow(int[] nums, int target) {
        int left = 0;
        int windowSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right]; // EXPAND

            // SHRINK: while window is valid, try to make it smaller
            while (windowSum >= target) {
                minLen = Math.min(minLen, right - left + 1); // UPDATE while valid
                windowSum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // ─── Template 4: Window with Frequency Map ─────────────────
    // Minimum Window Substring — find smallest window containing all chars of t
    // Use when: "contains all characters", "at most K distinct"
    //
    // Key trick: Use 'have' and 'need' counters
    public String minWindowSubstring(String s, String t) {
        if (s.length() < t.length())
            return "";

        // Count required characters
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> window = new HashMap<>();
        int have = 0, needCount = need.size(); // Unique chars satisfied
        int left = 0;
        int[] result = { -1, -1 }; // start, end of best window
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            // Check if this character's requirement is now satisfied
            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                have++;
            }

            // SHRINK: while all requirements are met
            while (have == needCount) {
                // UPDATE result
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                window.merge(leftChar, -1, Integer::sum);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }

    // ─── Template 5: At Most K Distinct ────────────────────────
    // Longest substring with at most K distinct characters
    // Trick for "exactly K": atMost(K) - atMost(K-1)
    public int atMostKDistinct(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            // SHRINK: when distinct count exceeds K
            while (window.size() > k) {
                char leftChar = s.charAt(left);
                window.merge(leftChar, -1, Integer::sum);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
