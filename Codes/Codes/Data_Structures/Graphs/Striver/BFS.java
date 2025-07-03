package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

public class BFS {
    // Function to perform BFS traversal starting from node 0
    public List<Integer> bfs(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();   // stores BFS traversal order
        boolean[] vis = new boolean[V];         // visited array
        Queue<Integer> q = new LinkedList<>();  // queue for BFS

        q.add(0);         // start from node 0
        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.remove();    // dequeue current node
            bfs.add(node);            // add to result

            // Visit all unvisited adjacent nodes
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }

    // Main method to run the BFS example
    public static void main(String[] args) {
        int V = 5; // number of vertices

        // Create adjacency list for the graph
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

        BFS obj = new BFS();
        List<Integer> result = obj.bfs(V, adj);

        System.out.println("BFS Traversal: " + result);
    }
}
