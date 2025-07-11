package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * 📋 Purpose:
 * Finds the shortest path from a source node to all other nodes
 * in an **unweighted graph** using **Breadth-First Search (BFS)**.
 *
 * Since all edges have equal weight (implicitly 1), BFS guarantees
 * the shortest path in terms of the number of edges.
 *
 * Applications:
 * - Social network degrees of separation
 * - Minimum number of moves in a board game
 * - Network broadcasting
 *
 * ⚡ Time Complexity: O(V + E)
 *      - Visits each vertex and edge once
 *
 * 📦 Space Complexity: O(V + E)
 *      - Adjacency list + distance array + queue
 */
public class ShortestPathUnweightedGraphBFS {

    /**
     * Finds shortest distance from `src` to all other nodes in an unweighted graph.
     * @param adj adjacency list of graph
     * @param src source node
     * @return int[] where dist[i] = shortest distance from src to i
     *         unreachable nodes have value -1
     */
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        int INF = (int) 1e9;

        int[] dist = new int[V];         // distance array
        Arrays.fill(dist, INF);         // initialize distances as "infinity"

        dist[src] = 0;                  // distance to self is 0

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        // 🔁 BFS traversal
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                // If a shorter path to neighbor is found
                if (dist[neighbor] > dist[node] + 1) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        // Mark unreachable nodes as -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        ShortestPathUnweightedGraphBFS solver = new ShortestPathUnweightedGraphBFS();

        int V = 6; // number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph (undirected in this example)
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        int src = 0;
        int[] distances = solver.shortestPath(adj, src);

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + distances[i]);
        }
    }
}
