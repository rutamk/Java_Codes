package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * 📋 Purpose:
 * Find the shortest path from node 1 to node n in a **weighted undirected graph**
 * using **Dijkstra's Algorithm**.
 *
 * It not only calculates the minimum distance but also reconstructs the path.
 *
 * Common applications:
 * - Shortest route in a map
 * - Network routing
 * - Cost minimization problems
 *
 * ⚡ Time Complexity: O((V + E) * logV)
 *      - Every edge is relaxed at most once
 *      - PriorityQueue operations take logV
 *
 * 📦 Space Complexity: O(V + E)
 *      - Adjacency list + distance array + parent array
 */
public class ShortestPathWeightedUndirected {

    // Pair class to represent (node, weight)
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    /**
     * Finds the shortest path from node 1 to node n
     * @param n number of nodes
     * @param m number of edges
     * @param edges list of edges [u, v, w] where u-v has weight w
     * @return List of integers: [total_weight, path...] or [-1] if no path exists
     */
    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w)); // undirected
            adj.get(v).add(new Pair(u, w));
        }

        int[] dist = new int[n + 1];      // distance from node 1 to each node
        int[] parent = new int[n + 1];   // to reconstruct the path
        Arrays.fill(dist, (int) 1e9);    // initialize with "infinity"

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        dist[1] = 0;        // distance to self is 0
        parent[1] = 1;      // parent of 1 is itself
        pq.add(new Pair(1, 0));

        // Step 2: Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.weight;

            // Relax all neighbors
            for (Pair nei : adj.get(u)) {
                int v = nei.node, w = nei.weight;

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    parent[v] = u;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // If node n is unreachable
        if (dist[n] == (int) 1e9) {
            return Arrays.asList(-1);
        }

        // Step 3: Reconstruct the path from parent[]
        List<Integer> path = new ArrayList<>();
        int node = n;

        while (node != parent[node]) {
            path.add(node);
            node = parent[node];
        }
        path.add(1); // add start node
        Collections.reverse(path);

        // Prepare result: [total weight, path...]
        List<Integer> result = new ArrayList<>();
        result.add(dist[n]); // total weight of path
        result.addAll(path);
        return result;
    }

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {
            {1, 2, 2},
            {2, 5, 5},
            {2, 3, 4},
            {1, 4, 1},
            {4, 3, 3},
            {3, 5, 1}
        };

        List<Integer> result = shortestPath(n, m, edges);

        if (result.size() == 1 && result.get(0) == -1) {
            System.out.println("No path exists from 1 to " + n);
        } else {
            System.out.println("Shortest Path from 1 to " + n + ":");
            System.out.println("Total weight: " + result.get(0));
            System.out.print("Path: ");
            for (int i = 1; i < result.size(); i++) {
                System.out.print(result.get(i) + (i == result.size() - 1 ? "\n" : " → "));
            }
        }
    }
}
