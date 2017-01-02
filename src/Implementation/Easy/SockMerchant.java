package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class SockMerchant {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        int[] count = new int[101];
        int result = 0;
        //figure out same color socks
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
            if(count[c[c_i]] != 0 ){
                count[c[c_i]] = 0;
                result++;
            }
            else count[c[c_i]] = 1;
        }
        System.out.println(result);
    }
}
