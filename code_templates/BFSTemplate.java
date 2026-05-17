
/**
 * BFS TEMPLATE (Breadth-First Search)
 * 
 * When to use:
 * - Shortest path in unweighted graph
 * - Level-order traversal (trees)
 * - Multi-source BFS (rotting oranges)
 * - "Minimum steps/moves to reach..."
 */
import java.util.*;

public class BFSTemplate {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    // Template 1: BFS on Graph (Shortest Path)
    public int bfsShortestPath(Map<Integer, List<Integer>> graph, int source, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(source);
        visited.add(source); // Mark visited WHEN ADDING, not when popping!
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (node == target)
                    return level;
                for (int neighbor : graph.getOrDefault(node, List.of())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    // Template 2: BFS on Grid (Number of Islands style)
    public void bfsGrid(char[][] grid, int startR, int startC, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startR, startC });
        grid[startR][startC] = '0';

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : DIRS) {
                int nr = cell[0] + dir[0], nc = cell[1] + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0'; // Mark BEFORE adding
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
    }

    // Template 3: Multi-Source BFS (Rotting Oranges)
    // Add ALL sources to queue FIRST, then BFS simultaneously
    public int rottingOranges(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2)
                    queue.offer(new int[] { r, c });
                else if (grid[r][c] == 1)
                    fresh++;
            }
        if (fresh == 0)
            return 0;
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : DIRS) {
                    int nr = cell[0] + dir[0], nc = cell[1] + dir[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        rotted = true;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            if (rotted)
                minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }

    // Template 4: Tree Level Order Traversal (no visited needed)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
