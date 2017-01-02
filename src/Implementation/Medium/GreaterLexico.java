package Implementation.Medium;

import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class GreaterLexico {
    public static void main(String[] args) {
        //Read input from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arrStr = new String[n];
        for(int i = 0; i < n; i++){
            arrStr[i] = in.next();
            System.out.println(NextGreaterLexico(arrStr[i]));
        }
    }
    public static String NextGreaterLexico(String strInput){
        char[] arrChrs = strInput.toCharArray();
        //find largest i such that arrChrs[i] < arrChrs[i+1]
        int i, j;
        for(i = arrChrs.length - 1; i > 0; i--)
            if(arrChrs[i] > arrChrs[i-1]) break;
        if(i == 0) return "no answer";
        i--;
        //find largest j such that j > i and arrChrs[j] > arrChrs[i]
        for(j = arrChrs.length - 1; j > i; j--)
            if(arrChrs[j] > arrChrs[i])break;
        //swap arrChrs[i] and arrChrs[j]
        char temp = arrChrs[i];
        arrChrs[i] =  arrChrs[j];
        arrChrs[j] = temp;
        //convert all characters after i;
        char[] subStr = String.copyValueOf(arrChrs).substring(i+1,arrChrs.length).toCharArray();
        if(subStr != null) {
            int index = subStr.length - 1;
            for (int k = i + 1; k < arrChrs.length; k++) {
                arrChrs[k] = subStr[index--];
            }
        }
        return String.copyValueOf(arrChrs);
    }
}
