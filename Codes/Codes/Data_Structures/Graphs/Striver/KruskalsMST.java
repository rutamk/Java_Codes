package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * 📋 Purpose:
 * Finds the **Minimum Spanning Tree (MST)** of a weighted undirected graph
 * using **Kruskal's Algorithm** (Greedy) + Disjoint Set Union (Union-Find).
 * 
 * Works by sorting all edges by weight and adding them one by one 
 * if they don’t form a cycle.
 * 
 * ⚡ Time Complexity:
 *   - Sorting edges: O(E log E)
 *   - DSU operations (find/union): ~O(E α(V)) where α is inverse Ackermann
 *   - Total: **O(E log E)**
 * 
 * 📦 Space Complexity: O(V + E)
 */
public class KruskalsMST {

    /**
     * Edge class represents an edge between two nodes with a weight.
     * Implements Comparable to sort by weight.
     */
    static class Edge implements Comparable<Edge> {
        int src, dest, wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return this.wt - compareEdge.wt;
        }
    }

    /**
     * Computes weight of MST using Kruskal's Algorithm
     * @param V number of vertices
     * @param edges 2D array of edges {u, v, weight}
     * @return total weight of the MST
     */
    static int kruskalsMST(int V, int[][] edges) {
        List<Edge> edgs = new ArrayList<>();

        // Convert edges array into Edge objects
        for (int[] e : edges) {
            edgs.add(new Edge(e[0], e[1], e[2]));
        }

        // Sort all edges by weight
        Collections.sort(edgs);

        // Initialize DSU for cycle detection
        DisjointSet ds = new DisjointSet(V);

        int mstWt = 0;

        // Process edges in increasing weight
        for (Edge edge : edgs) {
            int u = edge.src;
            int v = edge.dest;
            int wt = edge.wt;

            // If u and v belong to different components → safe to include
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
    }

    /**
     * Driver code
     */
    public static void main(String[] args) {
        int V = 3;

        // Example graph: 3 vertices, 3 edges
        int[][] edges = {
            {0, 1, 5},
            {1, 2, 3},
            {0, 2, 1}
        };

        int mstWeight = kruskalsMST(V, edges);
        System.out.println("Weight of Minimum Spanning Tree: " + mstWeight);
    }
}

// /** chatgpt implemantation of DSU
//  * 📋 Disjoint Set (Union-Find) with Union by Size & Path Compression
//  * Operations: 
//  *   - findUPar(u): O(α(V)) amortized
//  *   - unionBySize(u, v): O(α(V)) amortized
//  */
// class DisjointSet {
//     int[] parent, size;

//     public DisjointSet(int n) {
//         parent = new int[n];
//         size = new int[n];
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//             size[i] = 1;
//         }
//     }

//     public int findUPar(int node) {
//         if (node == parent[node]) return node;
//         return parent[node] = findUPar(parent[node]); // Path compression
//     }

//     public void unionBySize(int u, int v) {
//         int pu = findUPar(u);
//         int pv = findUPar(v);

//         if (pu == pv) return;

//         if (size[pu] < size[pv]) {
//             parent[pu] = pv;
//             size[pv] += size[pu];
//         } else {
//             parent[pv] = pu;
//             size[pu] += size[pv];
//         }
//     }
// }
