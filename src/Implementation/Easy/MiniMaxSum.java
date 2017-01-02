package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 12/31/16.
 */
public class MiniMaxSum {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        long[] arr = {a,b,c,d,e};
        long min = a, max = a, sum = 0;
        //find min and max sum
        for(long item: arr){
            if(min > item) min = item;
            if(max < item) max = item;
            sum += item;
        }
        System.out.println((sum - max) + " " + (sum - min));
    }
}
