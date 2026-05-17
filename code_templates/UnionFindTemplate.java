/**
 * UNION-FIND (Disjoint Set Union) TEMPLATE
 * 
 * When to use:
 * - "Are X and Y connected?"
 * - "How many groups/components?"
 * - Dynamic connectivity (edges added over time)
 * - Kruskal's MST
 */

public class UnionFindTemplate {

    int[] parent;
    int[] rank;
    int components;

    public UnionFindTemplate(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++)
            parent[i] = i; // Each node is its own parent
    }

    // Find with PATH COMPRESSION — amortized O(α(n)) ≈ O(1)
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression: point directly to root
        }
        return parent[x];
    }

    // Union by RANK — keeps tree shallow
    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY)
            return false; // Already connected

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        components--;
        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public int getComponents() {
        return components;
    }
}
