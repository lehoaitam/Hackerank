package dp;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args){
//input
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/CoinChange/sampleinput1"));
        }catch(Exception e){
            e.printStackTrace();
        }
        int n = in.nextInt();
        int m = in.nextInt();
        long[] C = new long[m+1];
        for(int i = 1; i <= m; i++){
            C[i] = in.nextLong();
        }
        System.out.println(dp(n,m,C));
    }

    public static long getWays(long n, int m, long[] C){
        System.out.println("n:" + n + ", m:"+m);
        if(n == 0) return 1;
        if(n<0) return 0;
        if(m<=0 && n>=1) return 0;
        return getWays(n, m-1, C) + getWays(n-C[m], m, C);

    }
    public static long dp(int n, int m, long[] C){
        long[] ans = new long[n+1];
        ans[0] = 1;
        for(int i = 1; i <= m; i++)
            for(long j = C[i]; j <= n; j++ ){
                int index1 = (int)j;
                int index2 = (int)(j-C[i]);
                ans[index1] = ans[index1] + ans[index2];
            }
        return ans[n];
    }
}
