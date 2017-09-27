package Implementation.Medium.GraphTheory.RoadAndLibrary;
import java.io.File;
import java.util.*;

public class RoadAndLibrary {
    public static void main(String[] args) {
        //input
        long t1 = System.currentTimeMillis();
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/RoadAndLibrary/input1"));
        }catch(Exception e){
            e.printStackTrace();
        }
        int q = in.nextInt();
        Graph graphs[]  = new Graph[q];
        for(int a0 = 0; a0 < q; a0++){
            graphs[a0] = new Graph();
            int n = in.nextInt();
            int m = in.nextInt();
            graphs[a0].n = n;
            graphs[a0].m = m;
            int x = in.nextInt();
            int y = in.nextInt();
            graphs[a0].clib = x;
            graphs[a0].croad = y;
            graphs[a0].visit = new boolean[n + 1];
            graphs[a0].map = new HashSet<>();
            graphs[a0].adj =  new List[n + 1];
            for(int a1 = 0; a1 < m; a1++){
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                if(graphs[a0].adj[v1] == null)
                    graphs[a0].adj[v1] = new ArrayList<>();
                graphs[a0].adj[v1].add(v2);

                if(graphs[a0].adj[v2] == null)
                    graphs[a0].adj[v2] = new ArrayList<>();
                graphs[a0].adj[v2].add(v1);

//                graphs[a0].map.add(new AdjEdge(v1,v2));
//                graphs[a0].map.add(new AdjEdge(v2,v1));
            }
        }
        //output;
        long t2 = System.currentTimeMillis();
        System.out.println("input time: " + (t2 - t1));
        for(long l : findMinimumCost(graphs))
            System.out.println(l);
        long t3 = System.currentTimeMillis();
        System.out.println("total process time: " + (t3 - t2));
    }
    public static long[] findMinimumCost(Graph[] graphs){
        int q = graphs.length;
        long[] result = new long[q];
        int index = 0;
        for(Graph graph : graphs){
            result[index++] = findMinimumCost(graph);
        }
        return result;
    }
    public static long findMinimumCost(Graph graph){
        if(graph.clib < graph.croad)
            return graph.clib * graph.n;
        List<Set> setList = numberOfConnected(graph);
        long result = 0;
        long numberOfCity = 0;
        for(Set set : setList){
            numberOfCity = set.size();
            result += graph.croad * (numberOfCity - 1) + graph.clib;
        }
        return result;
    }

    public static List<Set> numberOfConnected(Graph graph){
        List<Set> result = new ArrayList<>();
        for(int i = 1; i <= graph.n; i++){
            if(!graph.visit[i]){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                Set<Integer> set = new HashSet<>();
                while(!queue.isEmpty()){
                    Integer u = queue.poll();
                    graph.visit[u] = true;
                    set.add(u);
                    if(graph.adj[u] != null) {
                        for (int v : graph.adj[u]) {
                            if (!graph.visit[v])
                                queue.add(v);
                        }
                    }
//                    for(int v = 1; v <= graph.n; v++){
//                        if(!graph.visit[v] && (graph.map.contains(new AdjEdge(u,v)) || graph.map.contains(new AdjEdge(v,u))))
//                            queue.add(v);
//                    }
                }
                result.add(set);
            }
        }
        return result;
    }

}

class Graph {
    public int n;
    public int m;
    public long clib;
    public long croad;

    public int cEdge;
    public int[][] matrix;
    public Map<Integer, Set<AdjEdge>> edgeMap;
    public List<Integer>[] adj;
    public Set<AdjEdge> map;
    public boolean[] visit;
    public int startVertex;
}

class AdjEdge{
    public int v1;
    public int v2;
    public AdjEdge(int v1, int v2){
        this.v1 = v1;
        this.v2 = v2;
    }
//    @Override
//    public int hashCode(){
//        return this.v1 * 31 + this.v2 ;
//    }
//
//    @Override
//    public boolean equals(Object obj){
//        return (this.v1 == ((AdjEdge)obj).v1) && (this.v2 == ((AdjEdge)obj).v2) ? true : false;
//    }
}

