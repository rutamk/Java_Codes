package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

// Topological sort using Kahn's algorithm (BFS-based)
public class TopologicalSort {

    /**
     * Computes topological sort of a directed acyclic graph using Kahn's Algorithm.
     * @param V - number of vertices
     * @param edges - list of directed edges
     * @return list of nodes in topological order
     */
    public static ArrayList<Integer> topoSortBFS(int V, int[][] edges) {
        int[] inDegree = new int[V]; // in-degree of each vertex
        List<List<Integer>> adj = new ArrayList<>();
        
        // Step 1: Build adjacency list
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }

        // Step 2: Calculate in-degree of each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Step 3: Initialize queue with all vertices having in-degree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        // Step 4: Process queue
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            // Reduce in-degree of all its neighbors
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return topo;
    }

    /**
     * Computes topological sort of a DAG using DFS
     */
    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // After visiting all neighbors, push this node to stack
        stack.push(node);
    }

    public static ArrayList<Integer> topoSortDFS(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();
        
        // Step 1: Build adjacency list
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }

        // Step 2: Call DFS for each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Step 3: Extract nodes from stack
        ArrayList<Integer> topo = new ArrayList<>();
        while (!stack.isEmpty()) {
            topo.add(stack.pop());
        }

        return topo;
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
            {5, 0},
            {5, 2},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        System.out.println("Topological Sort (Kahn's Algorithm): " + topoSortBFS(V, edges));
        System.out.println("Topological Sort (DFS): " + topoSortDFS(V, edges));
    }
}
