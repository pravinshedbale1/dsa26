import java.util.*;

/**
 * ============================================
 * WEEK 2, DAY 5 — Problem 1 of 1
 * ============================================
 * PROBLEM: Boats to Save People (LeetCode #881)
 *
 * You are given an array people where people[i] is the weight of the
 * ith person, and an infinite number of boats where each boat can carry
 * a maximum weight of limit. Each boat carries at most two people at
 * the same time, provided the sum of the weight of those people is at
 * most limit.
 *
 * Return the minimum number of boats to carry every given person.
 *
 * CONSTRAINTS:
 * - 1 <= people.length <= 5 * 10^4
 * - 1 <= people[i] <= limit <= 3 * 10^4
 *
 * PATTERN: Sort + Greedy Two Pointers
 *
 * COMPLEXITY:
 * - Brute Force: O(n²) time — try all pairs
 * - Optimal: O(n log n) time, O(1) space — sort + greedy two pointers
 */
public class BoatsToSavePeople {

    // ========================================
    // TODO: Implement this method
    // ========================================
    public static int numRescueBoats(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        int boatCount = 0;
        Arrays.sort(people);
        while (left <= right) {
            int weighSum = people[left] + people[right];
            if (weighSum <= limit) {
                left++;
            }
            right--;
            boatCount++;
        }
        return boatCount;
    }

    // ========================================
    // Driver Code — DO NOT MODIFY
    // ========================================
    public static void main(String[] args) {
        // Test 1: Basic pairing
        int r1 = numRescueBoats(new int[] { 1, 2 }, 3);
        assert r1 == 1 : "Test 1 FAILED: expected 1, got " + r1;

        // Test 2: No one can pair
        int r2 = numRescueBoats(new int[] { 3, 2, 2, 1 }, 3);
        assert r2 == 3 : "Test 2 FAILED: expected 3, got " + r2;

        // Test 3: Optimal greedy pairing
        int r3 = numRescueBoats(new int[] { 3, 5, 3, 4 }, 5);
        assert r3 == 4 : "Test 3 FAILED: expected 4, got " + r3;

        // Test 4: Everyone pairs up
        int r4 = numRescueBoats(new int[] { 1, 2, 3, 4 }, 5);
        assert r4 == 2 : "Test 4 FAILED: expected 2, got " + r4;

        // Test 5: Single person
        int r5 = numRescueBoats(new int[] { 5 }, 5);
        assert r5 == 1 : "Test 5 FAILED: expected 1, got " + r5;

        System.out.println("✅ All tests passed!");
    }
}
