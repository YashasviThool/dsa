package struckture;

import java.util.ArrayList;

public class BellmanFord {
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, -1));

        graph[1].add(new Edge(1, 0, 4));
        graph[1].add(new Edge(1, 3, 2)); 

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 1, 2));
        graph[3].add(new Edge(3, 4, 5));
        graph[3].add(new Edge(3, 5, 8));

        graph[4].add(new Edge(4, 2, 3));
        graph[4].add(new Edge(4, 3, 5));
        graph[4].add(new Edge(4, 5, 2));

        graph[5].add(new Edge(5, 3, 8));
        graph[5].add(new Edge(5, 4, 2));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));

    }

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V) {
        // boolean vis[]=new boolean[V];
        // ye nai hota

        int dis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (src != i) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        dis[src]=0;

        for (int k = 0; k < V - 1; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.des;
                    if (dis[u] != Integer.MAX_VALUE && dis[u] + e.wt < dis[v]) {
                        dis[v] = dis[u] + e.wt;
                    }
                }
            }
        }
        //for negative cycle detect
        for (int i = 0; i < V; i++) { //O(V)
            for (int j = 0; j < graph[i].size(); j++) {  //O(E)
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.des;
                if (dis[u] != Integer.MAX_VALUE && dis[u] + e.wt < dis[v]) {
                    System.out.println("negative ecycle detect");
                }
            }
        }
        for (int i : dis) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bellmanFord(graph, 0, V);

    }

}
