package struckture;

import java.util.ArrayList;

public class Tarjans {

    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getBridge(graph, V);
    }

    public static void getBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, dt, low, time, -1);
            }
        }
    }

    private static void dfs(ArrayList<Edge>[] graph,int curr, boolean[] vis, int[] dt, int[] low, int time,int par) {
        vis[curr]=true;
        dt[curr]=low[curr]=++time;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            //if this is parent 
            if(e.des==par)continue;

            //if not visited
            else if(!vis[e.des]){
                dfs(graph, e.des, vis, dt, low, time, curr);
                low[curr]=Math.min(low[e.des],low[curr]);
                if(dt[curr]<low[e.des]){
                    System.out.println(curr+"->"+e.des);
                }
            }
            
            //if visted update the low[curr]
            else{
                low[curr]=Math.min(low[curr],dt[e.des]);

            }
            
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

    }

    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

}
