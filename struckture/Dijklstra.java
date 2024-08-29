package struckture;

import java.util.ArrayList;
import java.util.PriorityQueue;

//this is use for find min distance but the wight is non negative
public class Dijklstra {

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 1));

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

    static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        diklstra(graph,0,V);
    }
//O(E + E log V) time complexity 
    public static void diklstra(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dis = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[0]=0;
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr=pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;

                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.des;
                    if( dis[u]+e.wt < dis[v]){
                        dis[v]=dis[u] + e.wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
                
            }
        }

        for(int i=0;i<V;i++){
            System.out.print(dis[i]+" ");
        }
    }

}
