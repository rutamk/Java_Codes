package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

// Utility class to hold a node and its parent for BFS
class Pair {
    int node, parent;
    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class DetectCycleUnDirectedGraph {

    public static boolean checkForCycleBFS(int src, int V, List<List<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1)); // push source with parent -1

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();

            // explore all neighbors
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(new Pair(it, node));
                }
                // visited and not parent → cycle
                else if (parent != it) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleBFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        // check all components
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (checkForCycleBFS(i, V, adj, vis)) return true;
            }
        }
        return false;
    }

    public static boolean checkForCycleDFS(int node, int parent, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;

        // explore all neighbors
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (checkForCycleDFS(it, node, vis, adj)) return true;
            }
            // visited and not parent → cycle
            else if (it != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        // check all components
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (checkForCycleDFS(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // create graph
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(1); // back edge to form a cycle
        adj.get(1).add(4);

        System.out.println("Cycle Detected (BFS): " + (isCycleBFS(V, adj) ? "Yes" : "No"));
        System.out.println("Cycle Detected (DFS): " + (isCycleDFS(V, adj) ? "Yes" : "No"));
    }
}
