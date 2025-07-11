package Codes.Data_Structures.Graphs.Striver;

import java.util.*;

// Disjoint Set (Union-Find) with Path Compression and Union by Rank / Size
public class DisjointSet {
    List<Integer> rank = new ArrayList<>();   // Rank of each node (for union by rank)
    List<Integer> parent = new ArrayList<>(); // Parent of each node
    List<Integer> size = new ArrayList<>();   // Size of each set (for union by size)

    /**
     * Initializes N nodes where each is its own parent.
     */
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    /**
     * Finds the ultimate parent (representative) of a node.
     * Applies path compression to flatten the tree.
     */
    public int findUPar(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp); // Path compression
        return ulp;
    }

    /**
     * Union two sets by rank.
     * Smaller rank tree gets attached under higher rank tree.
     */
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    /**
     * Union two sets by size.
     * Smaller set gets attached under the larger set.
     */
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

// Driver code to demonstrate Disjoint Set
class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        System.out.println("🪄 Union by Rank example:");

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // Check if nodes 3 and 7 belong to the same component
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("✅ 3 and 7 are in the same set.");
        } else {
            System.out.println("❌ 3 and 7 are NOT in the same set.");
        }

        ds.unionByRank(3, 7);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("✅ 3 and 7 are now in the same set.");
        } else {
            System.out.println("❌ 3 and 7 are still NOT in the same set.");
        }

        ///////////////////////////////////////////////////////
        // Uncomment to test Union by Size
        /*
        System.out.println("\n🪄 Union by Size example:");

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("✅ 3 and 7 are in the same set.");
        } else {
            System.out.println("❌ 3 and 7 are NOT in the same set.");
        }

        ds.unionBySize(3, 7);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("✅ 3 and 7 are now in the same set.");
        } else {
            System.out.println("❌ 3 and 7 are still NOT in the same set.");
        }
        */
    }
}
