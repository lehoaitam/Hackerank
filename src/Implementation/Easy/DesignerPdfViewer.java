package Implementation.Easy;

import java.util.Scanner;

/**
 * Created by lehoaitam on 12/31/16.
 */
public class DesignerPdfViewer {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        //calculate max area
        int length = word.length();
        char[] arrChar = word.toCharArray();
        int max = 0;
        for(char ch : arrChar){
            int index = ch - 'a';
            if(max < h[index]) max = h[index];
        }
        System.out.println(length * max);
    }
}
