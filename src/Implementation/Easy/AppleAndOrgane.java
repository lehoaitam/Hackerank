package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 12/31/16.
 */
public class AppleAndOrgane {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        //calculate number of apple and organge
        int countApple = 0, countOrange = 0;
        for(int x : apple){
            if(x > 0 && x + a >= s && x + a <= t) countApple++;
        }
        for(int y : orange){
            if(y < 0 && y + b >= s && y + b <= t) countOrange++;
        }
        System.out.println(countApple);
        System.out.println(countOrange);
    }
}
