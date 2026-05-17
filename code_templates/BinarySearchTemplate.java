/**
 * ═══════════════════════════════════════════════════════════════
 * BINARY SEARCH TEMPLATES
 * ═══════════════════════════════════════════════════════════════
 * 
 * When to use:
 * - Sorted array → find exact / find boundary
 * - Monotonic predicate → binary search on answer space
 * - "Minimum X that satisfies Y" or "Maximum X that satisfies Y"
 * 
 * Key insight: Binary search is NOT just for sorted arrays.
 * It works anywhere you have a MONOTONIC condition.
 * 
 * Common mistakes:
 * - Using (lo + hi) / 2 instead of lo + (hi - lo) / 2 → overflow!
 * - Wrong loop condition: <= for exact, < for boundary
 * - Infinite loop when lo = mid (use lo = mid + 1 or hi = mid - 1)
 */

public class BinarySearchTemplate {

    // ─── Template 1: Exact Match ───────────────────────────────
    // Find index of target. Returns -1 if not found.
    // Use when: "Find X in sorted array"
    public int exactMatch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) { // NOTE: <= because we want to check when lo == hi
            int mid = lo + (hi - lo) / 2; // Avoid integer overflow

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                lo = mid + 1; // Target is in right half
            } else {
                hi = mid - 1; // Target is in left half
            }
        }
        return -1;
    }

    // ─── Template 2: Lower Bound (First position >= target) ───
    // Find the first index where arr[index] >= target
    // Use when: "Search Insert Position", "First occurrence"
    public int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length; // NOTE: hi = length (not length - 1)

        while (lo < hi) { // NOTE: < not <=
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid; // NOTE: hi = mid (not mid - 1) — mid could be the answer
            }
        }
        return lo; // lo == hi == first position >= target
    }

    // ─── Template 3: Upper Bound (First position > target) ────
    // Find the first index where arr[index] > target
    public int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] <= target) { // Only difference from lower bound: <=
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // ─── Template 4: Binary Search on Answer Space ─────────────
    // Use when: "Minimum speed to finish", "Maximum value such that..."
    // Key: Define a predicate function canAchieve(mid)
    //
    // Example: Koko Eating Bananas
    // "What is the minimum eating speed K such that Koko can eat all
    // bananas within H hours?"
    public int binarySearchOnAnswer(int[] piles, int h) {
        int lo = 1; // Minimum possible answer
        int hi = getMax(piles); // Maximum possible answer

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (canFinish(piles, mid, h)) {
                hi = mid; // mid works, try smaller (find minimum)
            } else {
                lo = mid + 1; // mid doesn't work, need bigger
            }
        }
        return lo;
    }

    // The predicate function — this is what changes per problem
    private boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // Ceiling division trick
        }
        return hours <= h;
    }

    private int getMax(int[] arr) {
        int max = 0;
        for (int x : arr)
            max = Math.max(max, x);
        return max;
    }

    // ─── Template 5: Rotated Sorted Array ──────────────────────
    // Use when: Array was sorted but rotated at some pivot
    // Key insight: One half is ALWAYS sorted
    public int searchRotated(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return mid;

            // Determine which half is sorted
            if (nums[lo] <= nums[mid]) {
                // Left half is sorted
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1; // Target in sorted left half
                } else {
                    lo = mid + 1; // Target in right half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1; // Target in sorted right half
                } else {
                    hi = mid - 1; // Target in left half
                }
            }
        }
        return -1;
    }
}
