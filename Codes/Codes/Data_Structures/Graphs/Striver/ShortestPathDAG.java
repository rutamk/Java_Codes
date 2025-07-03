package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

// Utility class to represent a neighbor and the weight of the edge
class Pairr {
    int v, w;
    public Pairr(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class ShortestPathDAG {

    // Topological Sort using DFS
    public static void topoSort(int node, List<List<Pairr>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (Pairr neighbor : adj.get(node)) {
            int v = neighbor.v;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public static int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Pairr>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pairr(v, w));
        }

        // Step 2: Perform Topological Sort
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) topoSort(i, adj, vis, st);
        }

        // Step 3: Initialize distances
        int INF = (int)1e9;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        // Step 4: Process nodes in topological order
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != INF) {
                for (Pairr p : adj.get(node)) {
                    if (dist[node] + p.w < dist[p.v]) {
                        dist[p.v] = dist[node] + p.w;
                    }
                }
            }
        }

        // Step 5: Replace INF with -1 for unreachable nodes
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF) dist[i] = -1;
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        int[][] edges = {
            {0, 1, 1},
            {0, 2, 4},
            {1, 2, 2},
            {1, 3, 6},
            {2, 3, 3}
        };

        int[] result = shortestPath(V, E, edges);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Node " + i + ": " + result[i]);
        }
    }
}
