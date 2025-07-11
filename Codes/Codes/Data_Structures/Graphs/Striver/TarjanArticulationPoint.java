package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * Tarjan's Algorithm to find all **articulation points (cut vertices)** in an undirected graph.
 *
 * An articulation point is a vertex, which when removed, increases the number of connected components.
 * e.g., it disconnects some part of the graph.
 *
 * Time Complexity:  O(V + E) 
 *     - Each vertex & edge is visited once during DFS
 *
 * Space Complexity: O(V + E)
 *     - Adjacency list: O(V + E)
 *     - Arrays & recursion stack: O(V)
 */
public class TarjanArticulationPoint {

    private int timer = 1;

    /**
     * DFS helper for Tarjan's Algorithm
     * @param node - current node
     * @param parent - parent of current node
     * @param vis - visited array
     * @param tin - discovery time of each node
     * @param low - lowest discovery time reachable from this node
     * @param mark - mark[node] = 1 if it is an articulation point
     * @param adj - adjacency list
     */
    private void dfs(int node, int parent, int[] vis, int[] tin, int[] low, int[] mark,
                     ArrayList<ArrayList<Integer>> adj) {

        vis[node] = 1;
        tin[node] = low[node] = timer++; // initialize discovery & low time
        int child = 0; // count of children (for root node special case)

        for (Integer it : adj.get(node)) {
            if (it == parent) continue; // skip edge to parent

            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);

                // If the earliest reachable vertex from child is >= discovery time of node
                // and node is not root → it's an articulation point
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }

                child++;
            } else {
                // Back edge found
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        // Special case for root: if it has >1 child, it's an articulation point
        if (parent == -1 && child > 1) {
            mark[node] = 1;
        }
    }

    /**
     * Main function to find articulation points
     * @param V - number of vertices
     * @param adj - adjacency list
     * @return list of articulation points
     */
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V]; // mark[i]=1 if i is an articulation point

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }

        if (ans.size() == 0) {
            ans.add(-1); // if no articulation point
        }

        return ans;
    }

    /**
     * Main method to test the algorithm
     */
    public static void main(String[] args) {
        TarjanArticulationPoint solver = new TarjanArticulationPoint();

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example graph
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        ArrayList<Integer> result = solver.articulationPoints(V, adj);

        System.out.println("Articulation Points:");
        System.out.println(result);
    }
}

