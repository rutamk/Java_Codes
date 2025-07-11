package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

/**
 * Topological Sort of a Directed Acyclic Graph (DAG)
 *
 * 📋 Purpose:
 * Find a linear ordering of vertices such that for every directed edge u → v,
 * vertex u comes before v in the ordering.
 *
 * Common applications:
 *   - Task scheduling
 *   - Course prerequisite ordering
 *   - Compilation order of files
 *
 * ✅ Works only on Directed Acyclic Graphs (DAGs).
 *
 * Time Complexity: O(V + E)  
 *   - Each vertex and edge is processed exactly once.
 *
 * Space Complexity: O(V + E)  
 *   - For adjacency list + auxiliary arrays/stack/queue.
 */
public class TopologicalSort {

    /**
     * Computes topological sort of a DAG using Kahn's Algorithm (BFS-based)
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

        // Step 2: Compute in-degree of each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Step 3: Add vertices with in-degree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        // Step 4: Process nodes
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            // Decrease in-degree of neighbors
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
     * Helper DFS function for topological sort
     */
    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }

        // Push current node to stack after visiting all neighbors
        stack.push(node);
    }

    /**
     * Computes topological sort of a DAG using DFS
     * @param V - number of vertices
     * @param edges - list of directed edges
     * @return list of nodes in topological order
     */
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

        // Step 2: Run DFS for unvisited nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Step 3: Collect nodes from stack
        ArrayList<Integer> topo = new ArrayList<>();
        while (!stack.isEmpty()) {
            topo.add(stack.pop());
        }

        return topo;
    }

    /**
     * Main method to test the algorithms
     */
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

        System.out.println("Topological Sort (Kahn's Algorithm - BFS): " + topoSortBFS(V, edges));
        System.out.println("Topological Sort (DFS): " + topoSortDFS(V, edges));
    }
}
