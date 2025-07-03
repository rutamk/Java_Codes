package Codes.Data_Structures.Graphs.ApnaCollege;
// used to find out articulate points using tarjans algo
import java.util.ArrayList;

public class getAP {

    static class Edge { // making adjacency list which a way of creating a graph which has an array of
                        // arraylists(can also be made using hashmaps) the size of array is the number
                        // of vertexs and the arraylists store the Edge info such as source src
                        // destination dest weight wt (and directions if needed)
        int src; // source
        int dest; // destination

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) { // when the array is created it has null at every index so we have to
                                                 // first instead of null put the arraylists at the indexs.
            graph[i] = new ArrayList<Edge>();
        }
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));
        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));
        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 2)); doesnt fucking work

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par,
            boolean vis[], int dt[], int low[], int time,
            boolean isArticulation[]) {

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int child = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par)
                continue;
            if (vis[e.dest]) {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else {
                dfs(graph, e.dest, curr, vis, dt, low, time, isArticulation);
                low[curr] = Math.min(low[curr], low[e.dest]);

                if (dt[curr] <= low[e.dest] && par != -1) {
                    isArticulation[curr] = true;
                }
                child++;
            }
        }
        if (par == -1 && child > 1) {
            isArticulation[curr] = true;
        }
    }

    public static void getArticulation(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean isArticulation[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, time, isArticulation);
            }
        }
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V]; // creating the graph array of arraylists
        createGraph(graph);
        getArticulation(graph, V);

    }
}
