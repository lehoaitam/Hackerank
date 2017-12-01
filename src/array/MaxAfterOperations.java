package array;

import java.io.File;
import java.util.*;

public class MaxAfterOperations {
    public static void main(String[] args){
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/temp"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++)
            arr[i]=0;
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            arr[a] += k;
            if(b < n)arr[b+1] -= k;
        }
        in.close();
        long max = Integer.MIN_VALUE, sum = 0;
        for(int i = 1; i <= n; i++){
            sum += arr[i];
            if(sum > max)
                max = sum;
        }
        System.out.println(max);

        List<String> strList = new ArrayList<>();
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Stack<Integer> stack = new Stack<>();

        Vector<Integer> vector = new Vector<>();

    }
}
