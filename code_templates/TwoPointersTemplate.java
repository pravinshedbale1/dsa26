
/**
 * ═══════════════════════════════════════════════════════════════
 * TWO POINTERS TEMPLATES
 * ═══════════════════════════════════════════════════════════════
 * 
 * When to use:
 * - Sorted array + pair/triplet finding
 * - In-place array modification (remove, move, partition)
 * - Palindrome checking
 * - Merging two sorted arrays
 * 
 * Types:
 * 1. OPPOSITE ENDS: left=0, right=n-1, converge
 * 2. SAME DIRECTION: slow/fast or read/write pointers
 * 3. MULTI-POINTER: Fix one, two-pointer on rest (3Sum, 4Sum)
 * 
 * Common mistakes:
 * - Forgetting to skip duplicates in 3Sum/4Sum
 * - Wrong comparison direction (< vs <=)
 * - Not handling the case where pointers cross
 */

import java.util.*;

public class TwoPointersTemplate {

    // ─── Template 1: Opposite Ends (Pair Sum in Sorted Array) ──
    // Use when: Sorted array, find pair that sums to target
    public int[] twoSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++; // Need bigger sum → move left pointer right
            } else {
                right--; // Need smaller sum → move right pointer left
            }
        }
        return new int[] { -1, -1 }; // Not found
    }

    // ─── Template 2: Palindrome Check ──────────────────────────
    // Use when: "Is this a palindrome?" or "Valid palindrome"
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric (for "valid palindrome" variant)
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ─── Template 3: Three Sum ─────────────────────────────────
    // Fix one element, use two pointers for the remaining
    // CRITICAL: Skip duplicates to avoid duplicate triplets
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // MUST sort first

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Early termination: if smallest triplet > 0, done
            if (nums[i] > 0)
                break;

            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for BOTH pointers
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // ─── Template 4: Container With Most Water ─────────────────
    // Greedy two pointers: always move the shorter side
    // Why? Moving the taller side can never increase area.
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, width * h);

            // Move the shorter side — greedy choice
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    // ─── Template 5: Write Pointer (In-place modification) ─────
    // Remove duplicates from sorted array
    // Use when: "in-place", "modify array without extra space"
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int writePtr = 1; // Position to write next unique element

        for (int readPtr = 1; readPtr < nums.length; readPtr++) {
            if (nums[readPtr] != nums[readPtr - 1]) {
                nums[writePtr] = nums[readPtr];
                writePtr++;
            }
        }
        return writePtr; // Length of unique portion
    }

    // ─── Template 6: Dutch National Flag (3-way partition) ─────
    // Sort Colors: partition into 3 groups in-place
    // Use when: "Sort into 3 categories", "3-way partition"
    public void sortColors(int[] nums) {
        int lo = 0; // Boundary for 0s (next position for 0)
        int mid = 0; // Current element
        int hi = nums.length - 1; // Boundary for 2s (next position for 2)

        while (mid <= hi) {
            if (nums[mid] == 0) {
                swap(nums, lo, mid);
                lo++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, hi);
                hi--;
                // DON'T advance mid — swapped element needs checking
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
