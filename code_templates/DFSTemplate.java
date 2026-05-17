
/**
 * DFS TEMPLATE (Depth-First Search)
 * 
 * When to use:
 * - Tree traversal (preorder, inorder, postorder)
 * - Graph: connected components, cycle detection, path finding
 * - Grid: flood fill, island counting
 * - Problems needing exhaustive search
 */
import java.util.*;

public class DFSTemplate {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    // Template 1: Tree DFS (Preorder/Inorder/Postorder)
    // Max depth example — most tree problems follow this shape
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0; // BASE CASE — always handle null first!
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    // Template 2: Tree DFS with Path (tracking state top-down)
    // Path Sum: root-to-leaf sum equals target
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        // Leaf check
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        // Subtract current and recurse
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    // Template 3: Tree DFS with Global Variable
    // Diameter of Binary Tree — track global max while computing heights
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;
        int left = height(node.left);
        int right = height(node.right);
        diameter = Math.max(diameter, left + right); // Update global
        return 1 + Math.max(left, right);
    }

    // Template 4: Graph DFS (Adjacency List)
    public void dfsGraph(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (visited.contains(node))
            return;
        visited.add(node);
        // Process node here
        for (int neighbor : graph.getOrDefault(node, List.of())) {
            dfsGraph(graph, neighbor, visited);
        }
    }

    // Template 5: Grid DFS (Island counting)
    public void dfsGrid(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            return;
        if (grid[r][c] != '1')
            return; // Not land or already visited
        grid[r][c] = '0'; // Mark visited
        for (int[] dir : DIRS) {
            dfsGrid(grid, r + dir[0], c + dir[1]);
        }
    }

    // Template 6: DFS with Memoization (top-down DP)
    // Longest Increasing Path in Matrix
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int max = 0;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                max = Math.max(max, dfsMemo(matrix, r, c, memo));
        return max;
    }

    private int dfsMemo(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0)
            return memo[r][c]; // Already computed
        int maxLen = 1;
        for (int[] dir : DIRS) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length
                    && matrix[nr][nc] > matrix[r][c]) {
                maxLen = Math.max(maxLen, 1 + dfsMemo(matrix, nr, nc, memo));
            }
        }
        return memo[r][c] = maxLen;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
