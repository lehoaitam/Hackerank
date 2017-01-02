package Implementation.Medium;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class ExtraLongFactorials {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //init a biginteger with value of 1
        BigInteger fac = new BigInteger("1");
        for(int i = 2; i <= n; i++)
            fac = fac.multiply(new BigInteger(i + ""));
        System.out.println(fac.toString());
    }
}
