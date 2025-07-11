package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * Tarjan's Algorithm to find all bridges (critical connections) in an undirected graph.
 *
 * Time Complexity:  O(V + E)
 *     - DFS visits each vertex & edge exactly once
 *
 * Space Complexity: O(V + E)
 *     - Adjacency list: O(V + E)
 *     - Visited, tin, low arrays: O(V)
 *     - Recursion stack: O(V) in worst case
 */
public class TarjanBridges {

    private int timer = 1; // global timer for discovery times

    /**
     * DFS helper for Tarjan's Algorithm
     * @param node - current node
     * @param parent - parent of current node
     * @param vis - visited array
     * @param adj - adjacency list
     * @param tin - discovery time of each node
     * @param low - lowest discovery time reachable from this node
     * @param bridges - list of bridges (critical connections)
     */
    private void dfs(int node, int parent, int[] vis, List<List<Integer>> adj,
                     int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer++; // initialize discovery & low time

        for (Integer it : adj.get(node)) {
            if (it == parent) continue; // skip the edge to parent

            if (vis[it] == 0) {
                // Visit the child
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);

                // Check if edge (node, it) is a bridge
                if (low[it] > tin[node]) {
                    bridges.add(List.of(node, it));
                }
            } else {
                // Back edge found
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    /**
     * Main function to find all critical connections (bridges)
     * @param n - number of nodes
     * @param connections - list of edges
     * @return list of bridges
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Build adjacency list
        for (List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        // Start DFS from node 0
        dfs(0, -1, vis, adj, tin, low, bridges);

        return bridges;
    }

    /**
     * Driver method to test the algorithm
     */
    public static void main(String[] args) {
        TarjanBridges solver = new TarjanBridges();

        int n = 5;
        List<List<Integer>> connections = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2),
            Arrays.asList(2, 0),
            Arrays.asList(1, 3),
            Arrays.asList(3, 4)
        );

        List<List<Integer>> bridges = solver.criticalConnections(n, connections);

        System.out.println("Critical Connections (Bridges):");
        for (List<Integer> bridge : bridges) {
            System.out.println(bridge);
        }
    }
}

