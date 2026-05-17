
/**
 * TOPOLOGICAL SORT TEMPLATE
 * 
 * When to use:
 * - Dependencies / prerequisites ordering
 * - "Can all tasks be completed?" (cycle detection in directed graph)
 * - Build order, course schedule
 */
import java.util.*;

public class TopologicalSortTemplate {

    // Template 1: Kahn's Algorithm (BFS-based) — PREFERRED in interviews
    // Returns topological order, or empty list if cycle exists
    public List<Integer> topoSortBFS(int numNodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numNodes];

        for (int i = 0; i < numNodes; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]); // edge[0] → edge[1]
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numNodes; i++) {
            if (indegree[i] == 0)
                queue.offer(i); // Start with nodes having no prereqs
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        return order.size() == numNodes ? order : new ArrayList<>(); // Empty = cycle!
    }

    // Template 2: DFS-based Topological Sort
    // Uses: 0 = unvisited, 1 = in-progress (cycle detection), 2 = done
    public List<Integer> topoSortDFS(int numNodes, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);

        int[] state = new int[numNodes]; // 0=unvisited, 1=in-progress, 2=done
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            if (state[i] == 0 && !dfs(graph, i, state, order)) {
                return new ArrayList<>(); // Cycle detected
            }
        }
        Collections.reverse(order);
        return order;
    }

    private boolean dfs(List<List<Integer>> graph, int node, int[] state, List<Integer> order) {
        if (state[node] == 1)
            return false; // Cycle! Back edge to in-progress node
        if (state[node] == 2)
            return true; // Already processed

        state[node] = 1; // Mark in-progress
        for (int neighbor : graph.get(node)) {
            if (!dfs(graph, neighbor, state, order))
                return false;
        }
        state[node] = 2; // Mark done
        order.add(node); // Add to order AFTER all neighbors processed (post-order)
        return true;
    }
}
