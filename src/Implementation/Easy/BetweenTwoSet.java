package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 12/31/16.
 */
public class BetweenTwoSet {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        //find min and max of set A and set B
        int maxA = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            if(maxA < a[a_i]) maxA = a[a_i];
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
            if(minB > b[b_i]) minB = b[b_i];
        }
        //count number that satisfy condition
        int result = 0;
        if(maxA <= minB) {
            int gcdOfB = gcd(b);
            if(gcdOfB >= maxA){
                int lcmOfA = lcm(a);
                if (gcdOfB % lcmOfA == 0) {
                    for (int i = lcmOfA; i <= gcdOfB; i++)
                        if (i % lcmOfA == 0 && gcdOfB % i == 0) result++;
                }
            }
        }
        System.out.println(result);

    }
    //great common descent of two number
    public static int gcd(int a, int b){
        if(a == b) return a;
        if(a < b) return gcd(a, b - a);
        else return gcd(a-b, b);
    }
    //great common descent of set of number
    public static int gcd(int[] arr){
        if(arr.length == 1) return arr[0];
        int d = gcd(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            if(d == 1) return 1;
            d = gcd(d, arr[i]);
        }
        return d;
    }
    //least common multiple of two number
    public static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
    //least common multiple of set of number
    public static int lcm(int[] arr){
        if(arr.length == 1) return arr[0];
        int d = lcm(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            d = lcm(d, arr[i]);
        }
        return d;
    }

}
