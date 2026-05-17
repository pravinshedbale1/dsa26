/**
 * DYNAMIC PROGRAMMING TEMPLATES
 * 
 * DP Framework (3 steps):
 * 1. DEFINE STATE: dp[i] = what does this represent?
 * 2. FIND TRANSITION: dp[i] = f(dp[i-1], dp[i-2], ...)
 * 3. SET BASE CASE: dp[0] = ?, dp[1] = ?
 * 
 * When to use: Overlapping subproblems + Optimal substructure
 * Signs: "maximum/minimum", "count ways", "is it possible"
 */
import java.util.*;

public class DPTemplate {

    // Template 1: 1D DP — Fibonacci Style (Climbing Stairs)
    // dp[i] = number of ways to reach step i
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev2 = 1, prev1 = 2;  // Space optimized: O(1)
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // Template 2: 1D DP — Decision Making (House Robber)
    // dp[i] = max money robbing houses 0..i
    // Transition: dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    // "Take it or skip it"
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int prev2 = nums[0], prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // Template 3: 1D DP — Unbounded (Coin Change)
    // dp[amount] = min coins to make this amount
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // Fill with impossible value
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Template 4: 2D DP — Grid (Unique Paths)
    // dp[i][j] = ways to reach cell (i,j)
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];  // Space optimized to 1D
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];  // dp[j] already has value from row above
            }
        }
        return dp[n-1];
    }

    // Template 5: 2D DP — Two Strings (Longest Common Subsequence)
    // dp[i][j] = LCS of text1[0..i-1] and text2[0..j-1]
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;  // Match: extend
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);  // Skip one
                }
            }
        }
        return dp[m][n];
    }

    // Template 6: 0/1 Knapsack
    // dp[i][w] = max value using items 0..i with capacity w
    // Space optimized: iterate w from RIGHT to LEFT
    public int knapsack(int[] weights, int[] values, int capacity) {
        int[] dp = new int[capacity + 1];
        
        for (int i = 0; i < weights.length; i++) {
            for (int w = capacity; w >= weights[i]; w--) {  // RIGHT to LEFT (0/1)
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
        return dp[capacity];
    }

    // Template 7: LIS (Longest Increasing Subsequence) — O(n log n)
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();  // tails[i] = smallest tail of LIS of length i+1
        
        for (int num : nums) {
            int pos = Collections.binarySearch(tails, num);
            if (pos < 0) pos = -(pos + 1);  // Insert position
            
            if (pos == tails.size()) {
                tails.add(num);  // Extend LIS
            } else {
                tails.set(pos, num);  // Replace with smaller value
            }
        }
        return tails.size();
    }
}
