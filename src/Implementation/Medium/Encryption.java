package Implementation.Medium;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class Encryption {
    public static void main(String[] args) {
        //Read input from STDIN
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int L = str.length();
        double sqrtL = Math.sqrt(L * 1.0);
        int min = (int)Math.floor(sqrtL);
        int max = (int)Math.ceil(sqrtL);
        //choose min(col * row) so that col * row <= L
        int col = 0, row = 0;
        for(row = min; row <= max; row++){
            for(col = row; col <= max; col++){
                if(row * col >= L) break;
            }
        }
        //calculate output
        String result = "";
        char[] arrChrs = str.toCharArray();
        for(int i = 0;  i < col; i++){
            for(int j = 0; j < row; j++){
                int index = i + j * col;
                if(index < L)
                    result += arrChrs[index];
            }
            result += " ";
        }
        System.out.println(result);
    }
}
