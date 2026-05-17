
/**
 * BACKTRACKING TEMPLATE
 * 
 * When to use:
 * - Generate ALL subsets, permutations, combinations
 * - Constraint satisfaction (N-Queens, Sudoku)
 * - "Find all possible..." or "Generate all valid..."
 * 
 * Core pattern: CHOOSE → EXPLORE → UNCHOOSE
 * 
 * Common mistakes:
 * - Forgetting to unchoose (remove last element after recursion)
 * - Not handling duplicates (sort + skip same element at same level)
 * - Wrong base case (especially for combinations vs permutations)
 */
import java.util.*;

public class BacktrackingTemplate {

    // Template 1: Subsets (include/exclude each element)
    // Input: [1,2,3] → Output: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrackSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add every subset (including empty)

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // CHOOSE
            backtrackSubsets(nums, i + 1, current, result); // EXPLORE (i+1 = no reuse)
            current.remove(current.size() - 1); // UNCHOOSE
        }
    }

    // Template 2: Subsets II (with duplicates — skip same at same level)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // MUST sort to group duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsetsDup(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrackSubsetsDup(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue; // Skip duplicates at SAME LEVEL
            current.add(nums[i]);
            backtrackSubsetsDup(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    // Template 3: Permutations (use every element exactly once)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackPermute(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrackPermute(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Base case: used all elements
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true; // CHOOSE
            current.add(nums[i]);
            backtrackPermute(nums, current, used, result); // EXPLORE
            current.remove(current.size() - 1); // UNCHOOSE
            used[i] = false;
        }
    }

    // Template 4: Combination Sum (unlimited use, find target sum)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackCombo(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrackCombo(int[] nums, int remain, int start, List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remain < 0)
            return; // Pruning

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrackCombo(nums, remain - nums[i], i, current, result); // i (not i+1) = reuse allowed
            current.remove(current.size() - 1);
        }
    }

    // Template 5: N-Queens (constraint satisfaction)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');
        backtrackQueens(board, 0, n, result);
        return result;
    }

    private void backtrackQueens(char[][] board, int row, int n, List<List<String>> result) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board)
                solution.add(new String(r));
            result.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q'; // CHOOSE
                backtrackQueens(board, row + 1, n, result); // EXPLORE
                board[row][col] = '.'; // UNCHOOSE
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;
        return true;
    }
}
