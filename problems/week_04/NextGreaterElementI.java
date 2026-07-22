import java.util.*;

/*
 * ============================================================
 * NEXT GREATER ELEMENT I (LC #496) — Easy
 * ============================================================
 *
 * The next greater element of some element x in an array is the FIRST greater
 * element that is to the RIGHT of x in the same array.
 *
 * You are given two DISTINCT-valued arrays nums1 and nums2, where nums1 is a
 * SUBSET of nums2.
 *
 * For each element nums1[i], find the next greater element of that number in
 * nums2. If there is no next greater element, the answer for that query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next
 * greater element as described above.
 *
 * ------------------------------------------------------------
 * Example 1:
 *   nums1 = [4,1,2], nums2 = [1,3,4,2]
 *   Output: [-1,3,-1]
 *   - 4 -> in nums2, nothing to the right is greater -> -1
 *   - 1 -> next greater to the right is 3
 *   - 2 -> nothing greater to the right -> -1
 *
 * Example 2:
 *   nums1 = [2,4], nums2 = [1,2,3,4]
 *   Output: [3,-1]
 *
 * ------------------------------------------------------------
 * Constraints:
 *   1 <= nums1.length <= nums2.length <= 1000
 *   0 <= nums1[i], nums2[i] <= 10^4
 *   All integers in nums1 and nums2 are UNIQUE.
 *   All integers of nums1 also appear in nums2.
 *
 * Follow-up: Can you do it in O(nums1.length + nums2.length) time?
 *
 * ------------------------------------------------------------
 * PATTERN: Monotonic (decreasing) Stack + HashMap
 * Brute force:  O(n1 * n2) — for each nums1 value, scan nums2 to its right.
 * Optimal:      O(n1 + n2) time, O(n2) space.
 * ============================================================
 */
public class NextGreaterElementI {

    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> nextGreater = new HashMap<>();
            int[] result = new int[nums1.length];
            for (int n : nums2) {
                while (!stack.isEmpty() && stack.peek() < n) {
                    int el = stack.pop();
                    nextGreater.put(el, n);
                }
                stack.push(n);
            }
            for (int i = 0; i < nums1.length; i++) {
                result[i] = nextGreater.getOrDefault(nums1[i], -1);
            }
            return result;
        }
    }

    // ---------------- Driver / Tests ----------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: mixed
        assert Arrays.equals(
                sol.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }),
                new int[] { -1, 3, -1 }) : "Test 1 failed";

        // Test 2
        assert Arrays.equals(
                sol.nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 }),
                new int[] { 3, -1 }) : "Test 2 failed";

        // Test 3: single element, no greater
        assert Arrays.equals(
                sol.nextGreaterElement(new int[] { 1 }, new int[] { 1 }),
                new int[] { -1 }) : "Test 3 failed";

        // Test 4: strictly decreasing nums2 -> all -1
        assert Arrays.equals(
                sol.nextGreaterElement(new int[] { 5, 3, 1 }, new int[] { 5, 4, 3, 2, 1 }),
                new int[] { -1, -1, -1 }) : "Test 4 failed";

        // Test 5: strictly increasing nums2
        assert Arrays.equals(
                sol.nextGreaterElement(new int[] { 1, 3, 5, 7 }, new int[] { 1, 3, 5, 7, 9 }),
                new int[] { 3, 5, 7, 9 }) : "Test 5 failed";

        System.out.println("All tests passed!");
    }
}
