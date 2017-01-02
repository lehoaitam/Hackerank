package Implementation.Easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class DivisibleSumPairs {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        //calculate number of pair which have sume of k value
        int count = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if((a[i] + a[j]) % k == 0) count++;
            }
        }
        System.out.println(count);
    }
}
