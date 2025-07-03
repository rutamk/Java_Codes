package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

public class BipartiteGraph {

    // BFS-based check for bipartite graph
    public static boolean checkBFS(int start, int V, List<List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        color[start] = 0; // Start coloring with 0
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : adj.get(node)) {
                if (color[it] == -1) {
                    // Assign opposite color to neighbor
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    // Same color neighbor found → not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    // Driver for BFS-based bipartite check
    public static boolean isBipartiteBFS(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1); // -1 means uncolored

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkBFS(i, V, adj, color)) return false;
            }
        }
        return true;
    }

    // DFS-based check for bipartite graph
    public static boolean checkDFS(int node, int col, int[] color, List<List<Integer>> adj) {
        color[node] = col; // Color the current node
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!checkDFS(it, 1 - col, color, adj)) return false;
            } else if (color[it] == col) {
                // Same color neighbor found → not bipartite
                return false;
            }
        }
        return true;
    }

    // Driver for DFS-based bipartite check
    public static boolean isBipartiteDFS(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkDFS(i, 0, color, adj)) return false;
            }
        }
        return true;
    }

    // Main method to test the above functions
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example: Bipartite graph
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);

        System.out.println("BFS check: " + (isBipartiteBFS(V, adj) ? "Bipartite" : "Not Bipartite"));
        System.out.println("DFS check: " + (isBipartiteDFS(V, adj) ? "Bipartite" : "Not Bipartite"));
    }
}
