
/**
 * Fruit Into Baskets (LC #904)
 *
 * You are visiting a farm with a single row of fruit trees, given as an
 * array `fruits` where fruits[i] is the type of fruit tree i produces. You
 * have exactly 2 baskets, each holding only a single type of fruit (no
 * capacity limit). Starting from any tree, you must pick exactly one fruit
 * from every tree while moving right, until you reach a tree whose fruit
 * doesn't fit in either basket. Return the maximum number of fruits you can
 * pick.
 *
 * (This reduces to: longest contiguous subarray with at most 2 distinct
 * values.)
 *
 * Pattern: Sliding Window (Variable Size — Longest) + At-Most-K-Distinct (HashMap)
 *
 * Brute Force: Check all subarrays, count distinct values in each → O(n^2)
 * Optimal: Sliding window with HashMap<fruitType, countInWindow>, shrink
 *          when map.size() > 2 → O(n) time, O(1) space (at most 3 keys ever)
 *
 * Constraints:
 * - 1 <= fruits.length <= 10^5
 * - 0 <= fruits[i] < fruits.length
 */

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

        // ========================================
        // TODO: Implement this method
        // ========================================
        public static int totalFruit(int[] fruits) {
                Map<Integer, Integer> basket = new HashMap<>();
                int left = 0;
                int maxFruits = 0;

                for (int right = 0; right < fruits.length; right++) {
                        int fruitAtRight = fruits[right];
                        basket.put(fruitAtRight, basket.getOrDefault(fruitAtRight, 0) + 1);

                        while (basket.size() > 2) {
                                int fruitAtLeft = fruits[left];
                                if (basket.get(fruitAtLeft) == 1) {
                                        basket.remove(fruitAtLeft);
                                } else {
                                        basket.put(fruitAtLeft, basket.get(fruitAtLeft) - 1);
                                }
                                left++;
                        }

                        maxFruits = Math.max(maxFruits, right - left + 1);
                }
                return maxFruits;
        }

        // ========================================
        // Driver Code — DO NOT MODIFY
        // ========================================
        public static void main(String[] args) {
                // Test 1: All fruits fit (only 2 distinct types)
                assert totalFruit(new int[] { 1, 2, 1 }) == 3
                                : "Test 1 failed: expected 3";

                // Test 2: Basic case
                assert totalFruit(new int[] { 0, 1, 2, 2 }) == 3
                                : "Test 2 failed: expected 3";

                // Test 3: Best window is not at the start
                assert totalFruit(new int[] { 1, 2, 3, 2, 2 }) == 4
                                : "Test 3 failed: expected 4";

                // Test 4: Edge case — only 1 distinct type throughout
                assert totalFruit(new int[] { 1, 1, 1, 1 }) == 4
                                : "Test 4 failed: expected 4";

                // Test 5: Edge case — every element distinct
                assert totalFruit(new int[] { 1, 2, 3, 4, 5 }) == 2
                                : "Test 5 failed: expected 2";

                System.out.println("All tests passed! ✅");
        }
}
