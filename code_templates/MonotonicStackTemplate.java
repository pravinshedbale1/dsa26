
/**
 * MONOTONIC STACK TEMPLATE
 * 
 * When to use:
 * - Next Greater Element / Next Smaller Element
 * - Daily Temperatures
 * - Largest Rectangle in Histogram
 * - Stock Span
 * 
 * Key insight: Stack maintains elements in MONOTONIC order.
 * - Decreasing stack: finds NEXT GREATER element
 * - Increasing stack: finds NEXT SMALLER element
 */
import java.util.*;

public class MonotonicStackTemplate {

    // Template 1: Next Greater Element (Decreasing Stack)
    // For each element, find the next element that is GREATER
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Default: no greater element

        Deque<Integer> stack = new ArrayDeque<>(); // Stores INDICES

        for (int i = 0; i < n; i++) {
            // Pop all elements that are SMALLER than current
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i]; // Current is the next greater for popped
            }
            stack.push(i);
        }
        return result;
    }

    // Template 2: Daily Temperatures (same as next greater, return distance)
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                int prevIdx = stack.pop();
                result[prevIdx] = i - prevIdx; // Distance instead of value
            }
            stack.push(i);
        }
        return result;
    }

    // Template 3: Largest Rectangle in Histogram (Increasing Stack)
    // Key: stack maintains indices of increasing heights
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // Sentinel: force pop all at end

            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
