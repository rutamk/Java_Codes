package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

public class ShortestPathUnweightedGraphBFS {

    // Function to find the shortest path from the source to all other nodes in an unweighted graph
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        int INF = (int) 1e9;

        // Initialize distances to all nodes as "infinity"
        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        // Distance to source is 0
        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        // Standard BFS loop
        while (!q.isEmpty()) {
            int node = q.remove();

            // Explore all neighbors
            for (int neighbor : adj.get(node)) {
                // If a shorter path to neighbor is found
                if (dist[neighbor] > dist[node] + 1) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        // Replace unreachable nodes (still INF) with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    // Main method to test the shortest path function
    public static void main(String[] args) {
        ShortestPathUnweightedGraphBFS solver = new ShortestPathUnweightedGraphBFS();

        int V = 6; // number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph (undirected for this example)
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        int src = 0;
        int[] distances = solver.shortestPath(adj, src);

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + distances[i]);
        }
    }
}
