package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * 📋 Purpose:
 * Computes the shortest path from source node `0` to all other nodes
 * in a **Directed Acyclic Graph (DAG)** with weighted edges.
 *  
 * Since DAGs have no cycles, we can use **topological sort** + **relaxation**
 * instead of Dijkstra to compute shortest paths efficiently.
 *
 * ⚡ Time Complexity: O(V + E)
 *   - Topological sort: O(V + E)
 *   - Relaxation: O(E)
 *
 * 📦 Space Complexity: O(V + E)
 *   - Adjacency list + distance array + stack
 */
public class ShortestPathDAG {

    /**
     * Utility class to represent a neighbor and the weight of the edge.
     */
    static class Pair {
        int v, w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    /**
     * Performs Topological Sort of the graph using DFS
     */
    public static void topoSort(int node, List<List<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (Pair neighbor : adj.get(node)) {
            int v = neighbor.v;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        // Push the node after visiting all its descendants
        st.push(node);
    }

    /**
     * Computes shortest path from node 0 to all nodes in DAG
     * @param V number of vertices
     * @param E number of edges
     * @param edges edge list [u, v, w]
     * @return int[] of shortest distances from node 0
     */
    public static int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
        }

        // Step 2: Perform Topological Sort
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                topoSort(i, adj, vis, st);
        }

        // Step 3: Initialize distances from source
        int INF = (int) 1e9;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[0] = 0; // distance to self is 0

        // Step 4: Process nodes in topological order and relax edges
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != INF) {
                for (Pair p : adj.get(node)) {
                    if (dist[node] + p.w < dist[p.v]) {
                        dist[p.v] = dist[node] + p.w;
                    }
                }
            }
        }

        // Step 5: Mark unreachable nodes as -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF)
                dist[i] = -1;
        }

        return dist;
    }

    /**
     * Test the algorithm
     */
    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        int[][] edges = {
                { 0, 1, 1 },
                { 0, 2, 4 },
                { 1, 2, 2 },
                { 1, 3, 6 },
                { 2, 3, 3 }
        };

        int[] result = shortestPath(V, E, edges);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Node " + i + ": " + result[i]);
        }
    }
}
