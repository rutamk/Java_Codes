package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

class Dijkstra {

    /**
     * Helper class to represent (distance, node) in PriorityQueue.
     */
    static class Pair {
        int dist, node;

        public Pair(int d, int n) {
            dist = d;
            node = n;
        }
    }

    /**
     * Dijkstra's Algorithm: Computes shortest distances from `src` to all nodes.
     * Works for graphs with non-negative edge weights.
     *
     * @param V Number of vertices
     * @param edges Edge list: [u, v, w] for undirected weighted edges
     * @param src Source vertex
     * @return Array of shortest distances from `src`
     */
    public static int[] dijkstraPQ(int V, int[][] edges, int src) {
        // Adjacency list: adj.get(u) = list of [v, w] pairs
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected weighted graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(List.of(v, w)); // u → v
            adj.get(v).add(List.of(u, w)); // v → u
        }

        // PriorityQueue (min-heap) to pick node with smallest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);

        int[] dist = new int[V];
        int INF = (int) 1e9;
        Arrays.fill(dist, INF);  // Initialize all distances as ∞

        dist[src] = 0;
        pq.add(new Pair(0, src));

        // Main loop
        while (!pq.isEmpty()) {
            int dis = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            // Traverse all neighbors
            for (List<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);

                // Relaxation step
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }

    /**
     * Main method to test Dijkstra’s Algorithm.
     */
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1, 2},
            {0, 2, 4},
            {1, 2, 1},
            {1, 3, 7},
            {2, 4, 3},
            {3, 4, 1}
        };
        int src = 0;

        int[] distances = dijkstraPQ(V, edges, src);

        System.out.println("📍 Shortest distances from source " + src + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + " → " + distances[i]);
        }
    }
}
