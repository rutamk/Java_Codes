package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * 📋 Purpose:
 * Kosaraju’s Algorithm to find the **number of Strongly Connected Components (SCCs)**
 * in a **directed graph**.  
 * SCC: A maximal subset of vertices such that every vertex is reachable from every other vertex in the subset.
 *
 * 🧪 Approach:
 * 1️⃣ Do a DFS to fill stack with nodes in order of finishing time.
 * 2️⃣ Reverse all edges to get the transposed graph.
 * 3️⃣ Do DFS in the order of the stack on the transposed graph.  
 * Each DFS tree corresponds to one SCC.
 *
 * ⚡ Time Complexity: O(V + E)
 * 📦 Space Complexity: O(V + E)
 */
public class KosarajuAlgorithm {

    /**
     * 🚀 Step 1: Standard DFS to fill stack by finish time (Topological sort order)
     */
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;

        for (Integer neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, vis, adj, st);
            }
        }

        st.push(node); // push node after visiting all descendants
    }

    /**
     * 🚀 Step 3: DFS on the transposed graph to visit one SCC
     */
    private void dfsOnTranspose(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;

        for (Integer neighbor : adjT.get(node)) {
            if (vis[neighbor] == 0) {
                dfsOnTranspose(neighbor, vis, adjT);
            }
        }
    }

    /**
     * 🌟 Main Kosaraju's Algorithm function
     * @param adj adjacency list of original graph
     * @return number of SCCs
     */
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        // Step 1️⃣: Do DFS & push nodes to stack in finishing time order
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // Step 2️⃣: Transpose the graph (reverse all edges)
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) adjT.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            vis[i] = 0; // reset visited for next phase
            for (Integer neighbor : adj.get(i)) {
                adjT.get(neighbor).add(i); // reverse edge i → neighbor becomes neighbor → i
            }
        }

        int sccCount = 0; // count of SCCs

        // Step 3️⃣: Process all nodes in stack order on the transposed graph
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 0) {
                sccCount++;
                dfsOnTranspose(node, vis, adjT);
            }
        }

        return sccCount;
    }

    /**
     * 🧪 Main method to test Kosaraju's Algorithm
     */
    public static void main(String[] args) {
        int V = 5; // number of vertices

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example graph:
        // 0 → 2, 0 → 3
        // 1 → 0
        // 2 → 1
        // 3 → 4
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(4);

        KosarajuAlgorithm solver = new KosarajuAlgorithm();

        int result = solver.kosaraju(adj);

        System.out.println("Number of Strongly Connected Components: " + result);
    }
}
