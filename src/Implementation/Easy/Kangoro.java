package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 12/31/16.
 */
public class Kangoro {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        //figure out two kangaroo have same pos or not
        String result = "";
        if(v1 == v2) {
            if (x1 == x2) result = "YES";
            else result = "NO";
        }
        else{
            if( (x2-x1)%(v1-v2) == 0 && (x2-x1)*(v1-v2) > 0) result = "YES";
            else result = "NO";
        }
        System.out.println(result);
    }
}
