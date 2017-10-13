import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSum {
    public static void main(String[] args){
        int[] arr = {1,2,3,0,0,4,5,6,7,8,9,10};
        int k = 5;
        for(Point p : findContinousSum(arr,k)){
            System.out.println(p.i + "," + p.j);
        }
    }
    public static Set<Point> findContinousSum(int[] arr, int k){
        Set<Point> result = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == k){
                result.add(new Point(0, i));
            }
            map.put(sum, i);
            if(map.containsKey(sum - k)){
                result.add(new Point(map.get(sum - k)+1, i));
            }
        }
        return result;
    }
    static class Point{
        int i, j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}

