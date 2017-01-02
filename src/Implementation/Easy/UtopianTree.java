package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class UtopianTree {
    public static void main(String[] args) {
        //read from STDIN and output height
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
            System.out.println(Height(c[c_i]));
        }
    }
    //height of utopian tree
    public static int Height(int n){
        int pow = (int)Math.ceil((double)(n+2)/2);
        if(n % 2 == 0) return (1 << pow)  - 1;
        else return (1 << pow) - 2;
    }
}
