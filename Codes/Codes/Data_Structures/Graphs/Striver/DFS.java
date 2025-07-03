package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

public class DFS {
    // Recursive function to perform DFS starting from a given node
    public static void dfs(int node, boolean[] vis, List<Integer> dfs, List<List<Integer>> adj) {
        vis[node] = true;      // mark current node as visited
        dfs.add(node);         // add it to the result

        // explore all unvisited neighbors
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, dfs, adj);
            }
        }
    }

    // Function to initiate DFS and return the traversal
    public static List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];       // visited array
        List<Integer> dfs = new ArrayList<>(); // list to store DFS order
        dfs(0, vis, dfs, adj);                // start DFS from node 0
        return dfs;
    }

    // Main method to run the DFS example
    public static void main(String[] args) {
        int V = 5;  // number of vertices

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example undirected graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        List<Integer> result = dfsOfGraph(V, adj);

        System.out.println("DFS Traversal: " + result);
    }
}
