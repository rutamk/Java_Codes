package Codes.Data_Structures.Graphs.Striver;

public class FloydWarshall {

    /**
     * Floyd-Warshall Algorithm
     * ------------------------
     * Purpose:
     *   Find the shortest distances between all pairs of vertices in a weighted graph.
     *   Also detects the presence of any negative weight cycles.
     *
     * Time Complexity: O(V^3)
     * Space Complexity: O(V^2)
     *
     * @param dist Adjacency matrix representing edge weights
     *             (Use INF = 1e8 for no edge between i and j)
     * @return true if a negative weight cycle exists, else false
     */
    public static boolean floydWarshall(int[][] dist) {
        int n = dist.length;
        int INF = (int) 1e8;

        // Step 1: Distance to self is 0
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Step 2: Try every node as an intermediate node
        for (int k = 0; k < n; k++) {           // For every intermediate
            for (int i = 0; i < n; i++) {       // For every source
                for (int j = 0; j < n; j++) {   // For every destination
                    // If path i -> k and k -> j exists, try to update i -> j
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 3: Check for negative weight cycle
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) return true; // Negative cycle found
        }

        return false; // No negative cycle
    }

    /**
     * Main method to test Floyd-Warshall
     */
    public static void main(String[] args) {
        int INF = (int) 1e8;

        // Input graph as adjacency matrix
        int[][] dist = {
            {0, 8, 7, -3},
            {1, 0, -1, 6},
            {9, 5, 0, 5},
            {INF, INF, INF, 0}
        };

        System.out.println("🔷 Original Distance Matrix:");
        printMatrix(dist);

        boolean hasNegativeCycle = floydWarshall(dist);

        System.out.println("\n✅ Shortest Path Matrix (after Floyd-Warshall):");
        printMatrix(dist);

        if (hasNegativeCycle) {
            System.out.println("\n⚠️ Negative weight cycle detected in the graph!");
        } else {
            System.out.println("\n🎉 No negative weight cycle detected.");
        }
    }

    // Utility function to print matrix
    private static void printMatrix(int[][] matrix) {
        int INF = (int) 1e8;

        System.out.print("      ");
        for (int j = 0; j < matrix.length; j++) {
            System.out.printf(" %6s", "V" + j);
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("From V%-2d", i);
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == INF) {
                    System.out.printf(" %6s", "INF");
                } else {
                    System.out.printf(" %6d", matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
