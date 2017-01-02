package Implementation.Medium;

import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class TheGridSearch {
    public static void main(String[] args) {
        //read from STDIN and output height
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        char Data[][][] = new char[T][][];
        char Pattern[][][] = new char[T][][];
        for(int i=0; i < T; i++){
            int R = in.nextInt();
            int C = in.nextInt();
            Data[i] = new char[R][C];
            char[] chArr;
            for(int k = 0; k < R; k++ ) {
                chArr = in.next().toCharArray();
                for (int l = 0; l < chArr.length; l++)
                    Data[i][k][l] = chArr[l];
            }
            int r = in.nextInt();
            int c = in.nextInt();
            Pattern[i] = new char[r][c];
            for(int k = 0; k < r; k++ ) {
                chArr = in.next().toCharArray();
                for (int l = 0; l < chArr.length; l++)
                    Pattern[i][k][l] = chArr[l];
            }
            System.out.println(PatternRecognize(Data[i],R,C,Pattern[i],r,c));
        }
    }
    //recognize pattern from data
    public static String PatternRecognize(char[][] Data,int R, int C, char[][] Pattern,int r, int c){
        //calculate search area
        int maxR = R - r;
        int maxC = C - c;
        for(int i = 0; i <= maxR; i++){
            for(int j = 0; j <= maxC; j++){
                //detect first matching
                if(Data[i][j] == Pattern[0][0]){
                    int Pi = 0, Pj;
                    boolean bFound = true;
                    //continue check last data
                    for(int k = i; k < i + r && bFound == true; k++) {
                        Pj = 0;
                        for (int l = j; l < j + c && bFound == true; l++) {
                            if (Data[k][l] != Pattern[Pi][Pj++]) bFound = false;
                        }
                        Pi++;
                    }
                    if(bFound) return "YES";
                }
            }
        }
        return "NO";
    }
}
