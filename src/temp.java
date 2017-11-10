import java.io.File;
import java.util.Scanner;

public class temp {
    public static void main(String[] args){
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/CoinChange/sampleinput1"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        //solution
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= n; i++){
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        System.out.println(dp[n]);

    }

    public static int bs(int[] a, int v){
        int l = 0, r = a.length - 1;
        int mid = 0;
        while(l <= r){
            mid = (l +r )/2;
            if(v < a[mid])
                r = mid - 1;
            else if(v > a[mid])
                l = mid + 1;
            else
                return mid;
        }
        return l;
    }
}
