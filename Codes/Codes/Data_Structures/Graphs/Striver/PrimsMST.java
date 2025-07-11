package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * 📋 Purpose:
 * Computes the weight of the **Minimum Spanning Tree (MST)**
 * of an **undirected weighted connected graph** using **Prim's Algorithm**.
 *  
 * Prim's Algorithm uses a min-heap (PriorityQueue) to greedily pick the smallest edge
 * that connects a visited node to an unvisited node.
 *
 * ⚡ Time Complexity: O(E log E)
 *      - Each edge can be pushed & popped from the priority queue at most once.
 *
 * 📦 Space Complexity: O(V + E)
 *      - Adjacency list, priority queue, visited array
 */
public class PrimsMST {

    /**
     * Helper class for PriorityQueue
     * Represents a node and its edge weight
     */
    static class Pair {
        int distance; // weight of the edge
        int node;     // adjacent node

        public Pair(int d, int n) {
            distance = d;
            node = n;
        }
    }

    /**
     * Computes the sum of weights of the MST
     * @param V number of vertices
     * @param E number of edges
     * @param adj adjacency list (u -> list of [v, weight])
     * @return total weight of MST
     */
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Min-heap based on edge weight
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V]; // visited array to mark included nodes
        pq.add(new Pair(0, 0)); // Start with node 0, weight 0
        int sum = 0;

        // Loop until all nodes are included
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int wt = current.distance;
            int node = current.node;

            // If already included in MST, skip
            if (vis[node] == 1) continue;

            // Mark node as visited and add weight to MST
            vis[node] = 1;
            sum += wt;

            // Traverse all adjacent nodes
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edgeWeight, adjNode));
                }
            }
        }

        return sum;
    }

    /**
     * Driver method to test Prim's Algorithm
     */
    public static void main(String[] args) {
        int V = 3;
        int E = 3;

        // Initialize adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Hardcoded graph:
        //   0 --(5)-- 1
        //   1 --(3)-- 2
        //   0 --(1)-- 2
        //
        // MST = edges (0-2) + (2-1) → weight = 1 + 3 = 4

        adj.get(0).add(new int[]{1, 5});
        adj.get(1).add(new int[]{0, 5});

        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});

        adj.get(0).add(new int[]{2, 1});
        adj.get(2).add(new int[]{0, 1});

        int result = spanningTree(V, E, adj);
        System.out.println("Minimum Spanning Tree weight: " + result);
    }
}
