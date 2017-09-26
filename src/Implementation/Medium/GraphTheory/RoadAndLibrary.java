package Implementation.Medium.GraphTheory;

import sun.reflect.annotation.ExceptionProxy;

import java.io.File;
import java.util.*;

public class RoadAndLibrary {
    public static void main(String[] args) {
        //input
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/RoadAndLibrary/input05.txt"));
        }catch(Exception e){
            e.printStackTrace();
        }
        int q = in.nextInt();
        HackerLand[] hackerLands = new HackerLand[q];
        for(int a0 = 0; a0 < q; a0++){
            hackerLands[a0] = new HackerLand();
            long n = in.nextInt();
            int m = in.nextInt();
            hackerLands[a0].n = n;
            hackerLands[a0].m = m;
            hackerLands[a0].roads = new Road[m];
            long x = in.nextLong();
            long y = in.nextLong();
            hackerLands[a0].clib = x;
            hackerLands[a0].croad = y;
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                Road r = new Road(city_1, city_2);
                hackerLands[a0].roads[a1] = r;
            }
        }
        //output;
        long startTime = System.currentTimeMillis();
        for(long l : findMinimumCost(hackerLands))
            System.out.println(l);
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
    }
    public static class HackerLand{
        public long n;
        public long m;
        public long clib;
        public long croad;
        public Road[] roads;
    }
    public static class Road{
        public long city_1;
        public long city_2;
        public Road(long city_1, long city_2){
            this.city_1 = city_1;
            this.city_2 = city_2;
        }
    }
    public static long[] findMinimumCost(HackerLand[] hackerLands){
        int q = hackerLands.length;
        long[] result = new long[q];
        int index = 0;
        for(HackerLand hackerLand : hackerLands){
            result[index++] = findMinimumCost(hackerLand);
        }
        return result;
    }
    public static long findMinimumCost(HackerLand hackerLand){
        if(hackerLand.clib < hackerLand.croad)
            return hackerLand.clib * hackerLand.n;
        List<Set> setList = merge(hackerLand);
        long result = 0;
        long numberOfCity = 0;
        for(Set set : setList){
            numberOfCity = set.size();
            result += hackerLand.croad * (numberOfCity - 1) + hackerLand.clib;
        }
        return result + (hackerLand.n - numberOfCity) * hackerLand.clib;
    }
    public static List<Set> merge(HackerLand hackerLand){
        List<Set> setList = new ArrayList<>();
        for(Road road : hackerLand.roads){
            List<Set> findSet = find(setList, road);
            if(findSet == null) {
                Set<Long> set = new HashSet<Long>();
                set.add(road.city_1);
                set.add(road.city_2);
                setList.add(set);
            }else{
                if(findSet.size() == 1){
                    findSet.get(0).add(road.city_1);
                    findSet.get(0).add(road.city_2);
                }else if(findSet.size() == 2){
                    findSet.get(0).addAll(findSet.get(1));
                    setList.remove(findSet.get(1));
                }
            }
        }
        return setList;
    }
    public static List<Set> find(List<Set> setList, Road road){
        if(setList.isEmpty())return null;
        Set set1 = null;
        Set set2 = null;
        for(Set set : setList){
            if(set.contains(road.city_1))
                set1 = set;
            if(set.contains(road.city_2))
                set2 = set;
        }
        if(set1 == null && set2 == null) return null;
        List<Set> result = new ArrayList<Set>();
        if(set1 != null)
            result.add(set1);
        if(set1 != set2 && set2 != null) result.add(set2);
        return result;
    }

}
