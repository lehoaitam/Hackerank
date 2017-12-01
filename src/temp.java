import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class temp {
    public static void main(String[] args){
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/temp"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int N, Q;
        N = in.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            String str = in.next();
            int count = 0;
            if(map.containsKey(str))
                count = map.get(str);
            map.put(str, count+1);
        }
        Q = in.nextInt();
        for(int i=0; i<Q; i++){
            String str = in.next();
            if(map.containsKey(str))
                System.out.println(map.get(str));
            else
                System.out.println(0);
        }

    }

    public static int bs(int[] a, int v){
        int l = 0, r = a.length - 1;
        int mid = 0;
        while(l <= r){
            mid = (l +r )/2;
            if(v < a[mid])
                r = mid - 1;
            else if(v > a[mid])
                l = mid + 1;
            else
                return mid;
        }
        return l;
    }
}
