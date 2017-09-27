package Implementation.Medium.GraphTheory;

import sun.reflect.annotation.ExceptionProxy;

import java.io.File;
import java.util.*;

public class RoadAndLibrary {
//    public static void main(String[] args) {
//        //input
//        Scanner in = null;
//        try {
//            in = new Scanner(new File("./resource/RoadAndLibrary/input05.txt"));
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        int q = in.nextInt();
//        HackerLand[] hackerLands = new HackerLand[q];
//        for(int a0 = 0; a0 < q; a0++){
//            hackerLands[a0] = new HackerLand();
//            long n = in.nextInt();
//            int m = in.nextInt();
//            hackerLands[a0].n = n;
//            hackerLands[a0].m = m;
//            hackerLands[a0].edgeMap = new HashMap<>();
//            long x = in.nextLong();
//            long y = in.nextLong();
//            hackerLands[a0].clib = x;
//            hackerLands[a0].croad = y;
//            for(int a1 = 0; a1 < m; a1++){
//                int v1 = in.nextInt();
//                int v2 = in.nextInt();
//                if(!hackerLands[a0].edgeMap.containsKey(v1))
//                    hackerLands[a0].edgeMap.put(v1, new HashSet<>());
//                hackerLands[a0].edgeMap.get(v1).add(new AdjEdge(v2,0));
//            }
//        }
//        //output;
//        long startTime = System.currentTimeMillis();
//        for(long l : findMinimumCost(hackerLands))
//            System.out.println(l);
//        long endTime = System.currentTimeMillis();
//        System.out.println("total time: " + (endTime - startTime));
//    }
//    public static long[] findMinimumCost(HackerLand[] hackerLands){
//        int q = hackerLands.length;
//        long[] result = new long[q];
//        int index = 0;
//        for(HackerLand hackerLand : hackerLands){
//            result[index++] = findMinimumCost(hackerLand);
//        }
//        return result;
//    }
//    public static long findMinimumCost(HackerLand hackerLand){
//        if(hackerLand.clib < hackerLand.croad)
//            return hackerLand.clib * hackerLand.n;
//        List<Set> setList = merge(hackerLand);
//        long result = 0;
//        long numberOfCity = 0;
//        for(Set set : setList){
//            numberOfCity = set.size();
//            result += hackerLand.croad * (numberOfCity - 1) + hackerLand.clib;
//        }
//        return result + (hackerLand.n - numberOfCity) * hackerLand.clib;
//    }
//    public static List<Set> merge(HackerLand hackerLand){
//        List<Set> setList = new ArrayList<>();
////        for(Edge edge : hackerLand.roads){
////            List<Set> findSet = find(setList, Edge);
////            if(findSet == null) {
////                Set<Integer> set = new HashSet<Integer>();
////                set.add(Edge.v1);
////                set.add(Edge.v2);
////                setList.add(set);
////            }else{
////                if(findSet.size() == 1){
////                    findSet.get(0).add(Edge.v1);
////                    findSet.get(0).add(Edge.v2);
////                }else if(findSet.size() == 2){
////                    findSet.get(0).addAll(findSet.get(1));
////                    setList.remove(findSet.get(1));
////                }
////            }
////        }
//        return setList;
//    }
//    public static List<Set> find(List<Set> setList, Edge Edge){
//        if(setList.isEmpty())return null;
//        Set set1 = null;
//        Set set2 = null;
//        for(Set set : setList){
//            if(set.contains(Edge.v1))
//                set1 = set;
//            if(set.contains(Edge.v2))
//                set2 = set;
//        }
//        if(set1 == null && set2 == null) return null;
//        List<Set> result = new ArrayList<Set>();
//        if(set1 != null)
//            result.add(set1);
//        if(set1 != set2 && set2 != null) result.add(set2);
//        return result;
//    }


}

