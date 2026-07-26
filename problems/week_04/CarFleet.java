import java.util.*;

/*
 * ============================================================
 * CAR FLEET (LC #853) — Medium
 * ============================================================
 *
 * There are n cars at given miles away from a target destination, all
 * driving in the same direction toward the target.
 *
 * You are given:
 *   - target      : the destination (miles away, at position `target`)
 *   - position[i] : the starting mile position of the i-th car (all distinct)
 *   - speed[i]    : the speed (miles/hour) of the i-th car
 *
 * A car can NEVER pass the car ahead of it. If a faster car catches up to a
 * slower one, it slows down and they travel together as a single "fleet",
 * bumper to bumper, at the slower car's speed. A fleet is a set of >= 1 cars
 * driving together at the same position and speed. A single car is also a
 * fleet.
 *
 * If a car catches up to a fleet EXACTLY at the destination, it is still
 * considered part of that fleet.
 *
 * Return the number of car fleets that will arrive at the destination.
 *
 * ------------------------------------------------------------
 * Example 1:
 *   target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 *   Output: 3
 *   - Cars at 10 (t=1) and 8 (t=1) form a fleet, meeting at 12.
 *   - Car at 0 (t=12) is its own fleet.
 *   - Cars at 5 (t=7) and 3 (t=3): the car at 5 arrives at t=7; the car at 3
 *     catches it and they form a fleet arriving at t=7.
 *
 * Example 2:
 *   target = 10, position = [3], speed = [3]
 *   Output: 1
 *
 * ------------------------------------------------------------
 * Constraints:
 *   n == position.length == speed.length
 *   1 <= n <= 10^5
 *   0 < target <= 10^6
 *   0 <= position[i] < target   (all positions are UNIQUE)
 *   0 < speed[i] <= 10^6
 *
 * ------------------------------------------------------------
 * PATTERN: Sort + Monotonic Stack (rear-to-front collapse / "absorb" flavor)
 *
 * KEY INSIGHT: Convert each car to its ETA = (target - position) / speed.
 * Sort cars by position DESCENDING (closest to target first) and sweep backward.
 * A car merges into the fleet ahead iff its ETA <= that fleet's ETA (it would
 * catch up at or before the target). A merged car is ABSORBED — the fleet keeps
 * the SLOWER (larger) ETA. Otherwise it starts a new fleet. Answer = fleet count.
 *
 * The stack top is a running maximum ETA, so the stack degenerates to a single
 * variable — see the O(1) note below.
 *
 * Brute force:  simulate positions over time / pairwise catch-up checks — O(n^2)
 * Optimal:      sort by position desc + single sweep — O(n log n) time, O(n) space
 *               (O(n) is the cars[n][2] array + TimSort aux; the "stack" itself
 *               collapses to one `double maxEta` variable + a counter)
 *
 * NUANCES:
 *   - `>=` not `>`: equal ETA means they meet EXACTLY at the destination, which
 *     the problem counts as one fleet. Counterexample for strict `>`:
 *     target=10, position=[0,5], speed=[2,1] → both ETA 5 → answer 1, `>` gives 2.
 *   - Floating point is SAFE here: two distinct ETAs differ by >= 1/(s1*s2) >= 1e-12,
 *     while double error at this magnitude is ~1e-16. Formally safe while
 *     num1*den2 + num2*den1 < 2^53 (~9e15); here it is <= 2e12.
 *   - Integer-only alternative: never divide — compare fractions by cross-multiplying
 *     in `long` (max product 10^6 * 10^6 = 10^12, no overflow risk).
 * ============================================================
 */
public class CarFleet {

        static class Solution {
                public int carFleet(int target, int[] position, int[] speed) {
                        int n = position.length;

                        int[][] cars = new int[n][2];
                        for (int i = 0; i < n; i++) {
                                cars[i][0] = position[i];
                                cars[i][1] = speed[i];
                        }

                        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
                        Deque<Double> stack = new ArrayDeque<>();
                        for (int i = 0; i < n; i++) {
                                double tat = (double) (target - cars[i][0]) / cars[i][1];
                                if (!stack.isEmpty() && stack.peek() >= tat) {
                                        continue;
                                }
                                stack.push(tat);
                        }
                        return stack.size();
                }
        }

        // ---------------- Driver / Tests ----------------
        public static void main(String[] args) {
                Solution sol = new Solution();

                // Test 1: LC example — 3 fleets
                assert sol.carFleet(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }) == 3
                                : "Test 1 failed";

                // Test 2: single car — 1 fleet
                assert sol.carFleet(10, new int[] { 3 }, new int[] { 3 }) == 1
                                : "Test 2 failed";

                // Test 3: back cars all catch the front one — 1 fleet
                assert sol.carFleet(100, new int[] { 0, 2, 4 }, new int[] { 4, 2, 1 }) == 1
                                : "Test 3 failed";

                // Test 4: front car faster/arrives first, back car never catches — 2 fleets
                assert sol.carFleet(10, new int[] { 6, 8 }, new int[] { 3, 3 }) == 2
                                : "Test 4 failed";

                // Test 5: all same speed, spread out — nobody catches anybody — 5 fleets
                assert sol.carFleet(5, new int[] { 0, 1, 2, 3, 4 }, new int[] { 1, 1, 1, 1, 1 }) == 5
                                : "Test 5 failed";

                System.out.println("All tests passed!");
        }
}
