package GraphTheory.Bfsshortreach;

import java.io.File;
import java.util.*;

public class Bfsshortreach {
    public static void main(String[] args){
        //input
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/Bfsshortreach/input5"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        Graph[] graphs = new Graph[q];
        for(int a0 = 0; a0 < q; a0++){
            graphs[a0] = new Graph();
            int n = in.nextInt();
            int m = in.nextInt();
            graphs[a0].n = n;
            graphs[a0].m = m;
            graphs[a0].dis = new long[n+1];
            for(int i = 1; i <= n ; i ++){
                graphs[a0].dis[i] = -1;
            }
            graphs[a0].visit = new boolean[n + 1];
            graphs[a0].edgeMap = new HashMap<>();
            graphs[a0].adj = new List[n+1];
            for(int a1 = 0; a1 < m; a1++){
                int v1 = in.nextInt();
                int v2 = in.nextInt();

                if(graphs[a0].adj[v1] == null)
                    graphs[a0].adj[v1] = new ArrayList<>();
                if(!graphs[a0].adj[v1].contains(v2))
                    graphs[a0].adj[v1].add(v2);

                if(graphs[a0].adj[v2] == null)
                    graphs[a0].adj[v2] = new ArrayList<>();
                if(!graphs[a0].adj[v2].contains(v1))
                    graphs[a0].adj[v2].add(v1);
            }
            graphs[a0].startVertex = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            shortreach(graphs[a0]);
            for(int i = 1; i < graphs[a0].dis.length; i++ ){
                if(i != graphs[a0].startVertex)
                    System.out.print(graphs[a0].dis[i] + " ");
            }
            if(a0 < q -1)
                System.out.println();
        }
    }
    public static void shortreach(Graph graph){
        Queue<Integer> queue = new LinkedList<>();
        graph.dis[graph.startVertex] = 0;
        queue.add(graph.startVertex);
        while(!queue.isEmpty()){
            Integer u = queue.poll();
            graph.visit[u] = true;
            if(graph.adj[u] != null) {
                for (int v : graph.adj[u]) {
                    if (!graph.visit[v]) {
                        if (graph.dis[v] == -1 || graph.dis[v] > graph.dis[u] + 6)
                            graph.dis[v] = graph.dis[u] + 6;
                        queue.add(v);
                    }
                }
            }
        }
    }

}
class Graph {
    public int n;
    public int m;
    public Map<Integer, Set<AdjEdge>> edgeMap;
    public List<Integer>[] adj;
    public boolean[] visit;
    public int startVertex;
    public long[] dis;
}

class AdjEdge{
    public int v;
    public long dis;
    public AdjEdge(int v, long dis){
        this.v = v;
        this.dis = dis;
    }
//    @Override
//    public int hashCode(){
//        return this.v;
//    }
//
//    @Override
//    public boolean equals(Object obj){
//        return this.v == ((AdjEdge)obj).v ? true : false;
//    }
}





