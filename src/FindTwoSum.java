import java.util.*;

public class FindTwoSum {
    public static void main(String[] args){
        int[] arr = {1,1,3,4,1,6,7,8,9,10,0,5,5};
        int k = 10;
        for(Point p : findTwoSum(arr, k)){
            System.out.println(p.i + ", " + p.j);
        }
    }
    public static Set<Point> findTwoSum(int[] arr, int k){
        Set<Point> result = new HashSet<>();
        Map<Integer, List> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(k - arr[i])){
                result.add(new Point(arr[i], k - arr[i]));
            }
            if(!map.containsKey(arr[i]))
                map.put(arr[i], new LinkedList());
            map.get(arr[i]).add(arr[i]);

        }
        Set<Point> result2 = new HashSet<>();
        for(Point p : result){
            for(int i = 0; i < map.get(p.j).size(); i++){
                result2.add(new Point(p.i, (Integer)map.get(p.j).get(i)));
            }
        }
        return result2;
    }
    static class Point{
        int i, j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}

