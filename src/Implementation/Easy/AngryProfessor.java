package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] n = new int[T];
        int[] k = new int[T];
        int[][] a = new int[T][];
        for(int i=0; i < T; i++){
            //read n and k
            n[i] = in.nextInt();
            k[i] = in.nextInt();
            //read attendance list
            a[i] = new int[n[i]];
            int count = 0;
            for(int j = 0; j < n[i]; j++){
                a[i][j] = in.nextInt();
                if(a[i][j] <= 0)count++;
            }
            //figure out result base on number of attendace
            if(count >= k[i])System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
