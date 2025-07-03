package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

public class DetectCycleDirectedGraph {

    // Detect cycle in a Directed Graph using Kahn's Algorithm (Topological Sort)
    public static boolean isCyclicTopo(int V, int[][] edges) {
        int[] inDegree = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }

        // Compute in-degree of each node
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Push nodes with in-degree 0 into queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            cnt++;

            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // If cnt != V → cycle exists
        return cnt != V;
    }

    // DFS helper to detect cycle
    public static boolean checkDFS(int node, int[] vis, int[] pathVis, List<List<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (checkDFS(it, vis, pathVis, adj)) return true;
            } else if (pathVis[it] == 1) {
                return true; // back edge detected
            }
        }

        pathVis[node] = 0; // backtrack
        return false;
    }

    // DFS-based cycle detection
    public static boolean isCyclicDFS(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (checkDFS(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }

    // Main method to test both approaches
    public static void main(String[] args) {

        // Sample graph with a cycle
        int V1 = 4;
        int[][] edges1 = {
            {0, 1},
            {1, 2},
            {2, 0},
            {2, 3}
        };

        // Sample graph without a cycle
        int V2 = 4;
        int[][] edges2 = {
            {0, 1},
            {1, 2},
            {2, 3}
        };

        System.out.println("--- Using Kahn's Algorithm ---");
        System.out.println("Graph 1: " + (isCyclicTopo(V1, edges1) ? "Cycle detected" : "No cycle"));
        System.out.println("Graph 2: " + (isCyclicTopo(V2, edges2) ? "Cycle detected" : "No cycle"));

        System.out.println("\n--- Using DFS ---");

        // Build adjacency list for DFS
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < V1; i++) adj1.add(new ArrayList<>());
        for (int[] edge : edges1) {
            adj1.get(edge[0]).add(edge[1]);
        }

        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) adj2.add(new ArrayList<>());
        for (int[] edge : edges2) {
            adj2.get(edge[0]).add(edge[1]);
        }

        System.out.println("Graph 1: " + (isCyclicDFS(V1, adj1) ? "Cycle detected" : "No cycle"));
        System.out.println("Graph 2: " + (isCyclicDFS(V2, adj2) ? "Cycle detected" : "No cycle"));
    }
}
