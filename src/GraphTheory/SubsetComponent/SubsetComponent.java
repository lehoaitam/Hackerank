package GraphTheory.SubsetComponent;

import java.io.File;
import java.math.BigInteger;
import java.util.*;

public class SubsetComponent {
    public static void main(String[] args){
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/SubsetComponent/input8"));
        }catch(Exception e){
            e.printStackTrace();
        }
        //Scanner in = new Scanner(System.in);
        int i,j,k, result = 0;
        int n = in.nextInt();
        BigInteger[] d = new BigInteger[n];
        for(i = 0; i < n; i++)
            d[i] = new BigInteger(in.next());
        //sample{0,1,2,3....63} is for minimize subset
        int[] sample = new int[64];
        for(i = 0; i < 64; i++)
            sample[i] = i;
        //every number is represented by mask
        //ex: 36 -> 0000000000000000000000000000000000000000000000000000000000100100
        //       -> {0,1,2,3,4,2,6,7,8,9,.....63}
        int[][] ds = new int[n][];
        for(i = 0; i < n; i++){
            ds[i] = new int[64];
            int temp = -1;
            for(k = 0; k < 64; k++) {
                if (d[i].testBit(k)) {
                    if (temp == -1)
                        temp = k;
                    ds[i][k] = temp;
                } else
                    ds[i][k] = k;
            }
        }
        //list out 2^n sub set
        for(i = 0; i < (1<<n); i++){
            int[] min = sample.clone();
            for(j = 0; j < n; j++)
                if((i & (1<<j)) > 0)
                    //connect vertex together by minimize
                    for(k = 0; k < 64; k++)
                        min[k] = min[k] > ds[j][k] ? ds[j][k] : min[k];
            //calculate connected subset in graph
            for(j = 0; j < 64; j++)
                if(min[j] == j)
                    result++;
        }
        System.out.println(result);
    }
}