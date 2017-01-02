package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class BonAppetit {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int bCharged = in.nextInt();
        //calculate the actual cost
        int bActual = 0;
        for(int i = 0; i < n; i++){
            if(i != k)bActual += c[i];
        }
        bActual /= 2;
        //figure out refund amount
        if(bCharged == bActual)
            System.out.println("Bon Appetit");
        else
            System.out.println(bCharged - bActual);
    }
}
