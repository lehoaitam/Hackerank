package Implementation.Medium.GraphTheory;

import java.io.File;
import java.util.*;

public class JourneyToTheMoon {
    public static void main(String[] args){
    //input
    Scanner in = null;
        try {
        in = new Scanner(new File("./resource/JourneyToTheMoon/sampleinput1"));
    }catch(Exception e){
        e.printStackTrace();
    }
        //        Scanner in = new Scanner(System.in);
    Graph graph  = new Graph();
    graph = new Graph();
    int n = in.nextInt();
    int m = in.nextInt();
    graph.n = n;
    graph.m = m;
    graph.visit = new boolean[n + 1];
    graph.adj =  new List[n + 1];
    for(int a1 = 0; a1 < m; a1++){
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        if(graph.adj[v1] == null)
            graph.adj[v1] = new ArrayList<>();
        graph.adj[v1].add(v2);

        if(graph.adj[v2] == null)
            graph.adj[v2] = new ArrayList<>();
        graph.adj[v2].add(v1);
        
    }
    //output;
     System.out.println(findMinimumCost(graph));
}
    public static long findMinimumCost(Graph graph){
        List<Integer> setList = numberOfConnected(graph);
        long result = 0;
        long sum = 0;
        for(int i = 0; i < setList.size(); i++) {
            sum += setList.get(i);
        }
        for(int j = 0; j < setList.size() - 1; j++){
            sum -= setList.get(j);
            result += setList.get(j) * (sum);
        }

        return result;
    }

    public static List<Integer> numberOfConnected(Graph graph){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < graph.n; i++){
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
                }
                result.add(set.size());
            }
        }
        return result;
    }

}

class Graph {
    public int n;
    public int m;
    public List<Integer>[] adj;
    public boolean[] visit;
}
