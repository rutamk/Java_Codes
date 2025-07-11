package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

public class BellmanFord {

    /**
     * Bellman-Ford Algorithm
     * -----------------------
     * ✅ Finds shortest paths from a single source to all vertices
     * ✅ Works with negative weights
     * ✅ Detects negative weight cycles
     *
     * 📈 Time Complexity: O(V * E)
     * 📦 Space Complexity: O(V)
     *
     * @param V     Number of vertices
     * @param edges Edge list: [u, v, w]
     * @param src   Source vertex
     * @return Array of distances from src to all vertices,
     *         or [-1] if a negative weight cycle is detected
     */
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e8)); // Initialize all distances as "infinity"
        dist[src] = 0;

        // Relax all edges (V-1) times
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                if (dist[u] != 1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative weight cycle by relaxing once more
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            if (dist[u] != 1e8 && dist[u] + w < dist[v]) {
                // Negative cycle detected
                return new int[]{-1};
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0, 1, -1},
                {0, 2, 4},
                {1, 2, 3},
                {1, 3, 2},
                {1, 4, 2},
                {3, 2, 5},
                {3, 1, 1},
                {4, 3, -3} // for normal
                // {4, 3, -10} // uncomment for negative weight cycle
        };
        int src = 0;

        int[] result = bellmanFord(V, edges, src);

        if (result.length == 1 && result[0] == -1) {
            System.out.println("Negative weight cycle detected!");
        } else {
            System.out.println("Shortest distances from source " + src + ":");
            for (int i = 0; i < result.length; i++) {
                System.out.println("To vertex " + i + " = " + result[i]);
            }
        }
    }
}
