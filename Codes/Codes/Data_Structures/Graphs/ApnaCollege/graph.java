package Codes.Data_Structures.Graphs.ApnaCollege;
import java.util.*;
public class graph {
    static class Edge{ // making adjacency list which is a way of creating a graph which has an array of arraylists(can also be made using hashmaps) the size of array is the number of vertexs and the arraylists store the Edge info such as source src destination dest weight wt (and directions if needed)
        int src; // source
        int dest; // destination
        int wt; //weight
        
        Edge(int s , int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) { // when the array is created it has null at every index so we have to first instead of null put the arraylists at the indexs.
            graph[i] = new ArrayList<Edge>();
        }

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));


        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));
        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));
        // graph[2].add(new Edge(2, 4));

        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));
        
        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));

        //for cycle in directed graph

        // graph[0].add(new Edge(0,2));
        // graph[1].add(new Edge(1,0));
        // graph[2].add(new Edge(2,3));
        //graph[3].add(new Edge(3,0)); //if u cmt this then there will be no cycle
    
        //for topological sort

        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 1));
        // graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));
        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));

        //for cycle in undirected graph
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[0].add(new Edge(0, 3));
        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));
        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));
        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 4));
        // graph[4].add(new Edge(4, 3));

        //for dijkstras algo

        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));
        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[2].add(new Edge(2, 4, 3));
        // graph[3].add(new Edge(3, 5, 1));
        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));

        //for bellman fords algorithms

        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));
        // graph[1].add(new Edge(1, 2, -4));
        // graph[2].add(new Edge(2, 3, 2));
        // graph[3].add(new Edge(3, 4, 4));
        // graph[4].add(new Edge(4, 1, -10)); // change weight to -10 to get negative weight cycle and change to -1 for positive weight cycle
    
        //for prims algo

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static ArrayList<Integer> findNeighbours(ArrayList<Edge> graph[], int src){// s/m this function returns an arraylist of the neighbours of a vertex by accessing the graphs index which is the vertex and then storing the dest value in the arraylist
        ArrayList<Integer> nbrs = new ArrayList<>();
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            nbrs.add(e.dest);
        }
        return nbrs;
    }

                                       //BFS implementation://
    // We use a queue for printing and an array of visited nodes.graphs can be collection of segments which have no Edges in between them.
    // 1. We create a queue and define and add a start node in it. 
    // 2. Create a curr pointer to keep track of the front of the queue and assign it to the front and also remove the front value which is the node we are operating on.
    // 3. If the node hasnt been visited yet then : 1. Print it. 2. Mark it as visited. 3.Add its neibouring nodes to the queue.
    // 4. we iterate over the values of the arraylist we get from the findNeighbours function and add them to the queue.

    public static void bfs(ArrayList<Edge>graph[], int V, boolean vis[], int start){ 
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr +" ");
                vis[curr] = true;
                
                // for(String key : keys){
                //     System.out.println(key + " " + map.get(key));
                // }

                for(int nbr : findNeighbours(graph, curr)){
                    q.add(nbr);
                }
            }
        }
    }

    /////////////////////////////////////DFS////////////////////////////////
    // We use curr pointer to keep track of the currently processing node and vis array to keep track of visited status of the nodes.
    // 1. print the curr node and mark it visited.
    // 2. Recursively call on non visited neighbours.

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System. out.print(curr+" ");
        vis[curr] = true;

        //method 1
        // for(int i=0; i<graph[curr].size(); i++) {
        //     Edge e = graph[curr].get(i);
        //     if(vis[e.dest] == false)
        //         dfs(graph, e.dest, vis);
        // }

        //method 2
        for(int nbr : findNeighbours(graph, curr)){
            if(vis[nbr] == false)
                dfs(graph, nbr, vis);
        }
    }

    //////////////////////////// Questions on bfs dfs //////////////////////////

    //print all paths
    //O(V^V) very bad so not good for big graphs.usually given small graphs to do this
    public static void printAllPaths(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int tar){
        if(curr == tar) {
            System.out.println(path); 
            return;
        }

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                printAllPaths(graph, vis, e.dest, path+e.dest, tar);
                vis[curr] = false;
            }
        }
    }

    //cycle in directed graph

    public static boolean isCycleDirected(ArrayList<Edge>graph[],boolean vis[], int curr, boolean rec[]){
        vis[curr]= true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){ // cycle
                return true;
            } 
            else if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    ///////topological sort : it is used to determine dependencies of nodes on each other/////////

    public static void topoSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[],Stack<Integer> s) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topoSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
        }

        //O(V+E)
        public static void topoSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
            topoSortUtil(graph, i, vis, s);
            }
        }
        while(!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    // Topo sort using Kahns algo
    public static ArrayList<Integer> topoSortKahn(int V, int[][] edges) {
        int[] inDegree = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v); // directed graph
        }
        
        for(int i = 0 ; i < V ; i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);
            
            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        

        return topo;
    }

    ///////for cycle in undirected graph/////

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //case1
            if(vis[e.dest] && e.dest != par) {
                boolean isCycle = isCyclicUtil(graph, vis, e.dest, curr);
            if(isCycle)
                return true;
            } 
            else {
                //case 2
                return true;
            }
        }
        return false;
    }
//O(V+E)
public static boolean isCyclic(ArrayList<Edge>[] graph, boolean vis[]) {
    for(int i=0; i<graph.length; i++) {
        if(isCyclicUtil(graph, vis, i, -1)) {
             return true;
        }
    }
    return false;
}

///////////Detect cycle in direcetd graph using topo sort////////////
/// //Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]
    public boolean isCyclic(int V, int[][] edges) {
        int[] inDegree = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v); // directed graph
        }
        
        for(int i = 0 ; i < V ; i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            int node = q.remove();
            cnt++;
            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        

        return cnt == V ? false : true;
    }

    ///////////////////////////////////////////Dijkstras Algorithms///////////////////////////////////

    // It is a shortest path finding algo which uses a priority queue to maintain pairs which is a class made of node and its dist bundled in a pair.
    // Sorting int the priority is decided to be done on the dist in the pair by implementing comparable. 
    // Fails if negative weights exists where we have to use bellman fords ago but time complexity of DA is less than BFA so it is prefferable in positive weight graphs

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist; //ascending
        }
    }

    public static void Dijkstras(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];

        for (int i = 0; i < V; i++) { // initialising the dist of all nodes to infinity except the source node or the first node
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;   
            }
        }

        boolean vis[] = new boolean[V];

        pq.add(new Pair(0,0)); // adding source node to the pq and setting dist as 0

        while(!pq.isEmpty()){ // operatin will run till pq is not empty
            Pair curr = pq.remove(); //remove the curr being processed pair 
            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i = 0; i < graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    
                    //relaxation (basically see if there is a shorter path through the node we are on currently to a neighbouring node compared to the dist it is assigned in the dist array)
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for(int i = 0; i < V; i++) { //print the path
           System.out.print(dist[i] + " "); 
        }
        System.out.println();
    }

    ////////////////////////////////////Bellman Fords Algorithm////////////////////////////////
    // Used when weights are negative
    // Fails if negative weight cycles exist

    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V){
        int dist[] = new int[V];

        for (int i = 0; i < V; i++) { // initialising the dist of all nodes to infinity except the source node or the first node
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;   
            }
        }
        
        for(int k = 0 ; k < V-1 ; k++){
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < graph[i].size(); j++) {
                        Edge e = graph[i].get(j);
                        int u = e.src;
                        int v = e.dest;
                        int wt = e.wt;
                        if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        //Detecting Negative Weight Cycle
        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                        System.out.println("negative weight cycle exists");
                        break;
                    } // change -1 to -10 in graph creating last step to get negative cycle
                }
            }
        
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    /////////////////////////////Minimum spanning tree PRIMS ALGO////////////////////////
    //should give answer as 55 but gives ans as 65 if start pair is given as 3,0

    public static void primsAlgo(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[V];
        pq.add(new Pair(3, 0)); //gives 65 if pair is (3,0) but should give 55

        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstCost += curr.dist;
                
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Minimum cost is "+ mstCost);
    }

    public static void main(String[] args) {
        int V = 4;                                  // defining no of vertexs
        ArrayList<Edge> graph[] = new ArrayList[V]; //creating the graph array of arraylists
        createGraph(graph);                         // adding the vertexs in the graph
        
        // int v = 3;                                  // vertex whose neighbours u wanna print
        // System.out.println("The neighbours of " + v + " are " + findNeighbours(graph, v));     //printing the nbrs
        
        //BFS//
        // boolean vis[] = new boolean[V]; 
        // for (int i = 0; i < V; i++) { //if there are segments in the graph then even if there is no Edge between the segments, the start will simply change to the other segments node.
        //     if(vis[i] == false){
        //         bfs(graph, V, vis, i);
        //     }
        // }
        // System.out.println();

        //DFS
        // boolean vis[] = new boolean[V]; 
        // for (int i = 0; i < V; i++) { //if there are segments in the graph then even if there is no Edge between the segments, the start will simply change to the other segments node.
        //     if(vis[i] == false){
        //         dfs(graph, i, vis);
        //     }
        // }
        // System.out.println();

        //Questions
        // int src = 0;
        // int tar = 4;
        // printAllPaths(graph, new boolean[V], src,"0", tar);

        //cycle in directed graph
        // boolean vis[] = new boolean[V];
        // boolean rec[] = new boolean[V];
        // for(int i=0; i<V; i++) {
        //     if(!vis[i]) {
        //         boolean isCycle = isCycleDirected(graph, vis, 0, rec);
        //         if(isCycle){
        //             System.out.println(isCycle);
        //             break;
        //         }
        
        //     }
        // }

        //topological sort//
        //topoSort(graph);

        //cycle in undirected graph
        //System.out.println(isCyclic(graph, new boolean[V]));

        //Dijkstras(graph, 0, V);

        //bellmanFord(graph, 0, V);

        primsAlgo(graph, V);
    }


}
