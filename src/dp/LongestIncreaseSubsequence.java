package dp;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncreaseSubsequence {
    public static void main(String[] args){
//        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] arr = {10, 22, 9, 33, 1, 2, 3, 40, 80,21,22,1,2,3};
        int[] f = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            f[i] = -1;
        System.out.println(LIS(arr, arr.length-1, f));
        for(int i = 0; i < f.length; i++)
            f[i] = LIS(arr, i, f);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < f.length; i++){
            if(f[i] > max)
                max = f[i];
        }
        System.out.println(max);
    }
    public static int LIS(int[] arr, int i, int[] f){
        //base case
        if(i == 0) return 1;
        //find max longest increase sub array from ( 0 -> n-1 )
        int maxValue = 1, maxIndex = 0;
        for(int j = 0; j < i ; j++){
            int temp = f[j] != -1 ? f[j] : LIS(arr, j, f);
            if(arr[j] < arr[i] && temp + 1 > maxValue){
                maxValue = temp + 1;
            }
        }
        System.out.println("i am go here");
        f[i] = maxValue;
        return maxValue;
    }
}
