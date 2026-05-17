
/**
 * DIJKSTRA'S ALGORITHM TEMPLATE
 * 
 * When to use:
 * - Shortest path in WEIGHTED graph (non-negative weights)
 * - "Minimum cost to reach from A to B"
 * - Network delay time
 * 
 * NOT for: Negative weights (use Bellman-Ford)
 */
import java.util.*;

public class DijkstraTemplate {

    // Dijkstra using Priority Queue (Min-Heap)
    // Time: O((V + E) log V), Space: O(V + E)
    public int[] dijkstra(int n, int[][] edges, int source) {
        // Build adjacency list: node → list of [neighbor, weight]
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
            // If undirected: graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Min-heap: [distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, source });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0], node = curr[1];

            if (currDist > dist[node])
                continue; // Skip stale entries

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                int newDist = dist[node] + weight;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    pq.offer(new int[] { newDist, next });
                }
            }
        }
        return dist; // dist[i] = shortest distance from source to i
    }
}
