package Implementation.Medium;

import java.util.Scanner;

/**
 * Created by lehoaitam on 1/1/17.
 */
public class AlmostSorted {
    public static void main(String[] args) {
        //read from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < arr.length; i++)
            arr[i] = in.nextInt();
        System.out.println(isOperable(arr));
    }
    public static String isOperable(int[] arr){
        //detect first disorder
        String result = "";
        int i;
        for(i = 0; i < arr.length - 1; i++)
            if(arr[i] > arr[i+1])break;
        //inputed array is ascending sorted
        if(i == arr.length - 1) return "yes";
        //detect last disorder
        int j;
        for(j = arr.length - 1; j > 0; j--)
            if(arr[j] < arr[j-1])break;
        //check if it swapable
        int[] arrTemp = arr.clone();
        int temp = arrTemp[i];
        arrTemp[i] = arrTemp[j];
        arrTemp[j] = temp;
        if(isSortedAscending(arrTemp)) return "yes\nswap " + (i+1) + " " + (j+1);
        //check if it reversable
        //detect last disorder
        RevertSubArray(arr,i,j);
        if(isSortedAscending(arr))
            return "yes\nreverse " + (i+1) + " " + (j+1);
        return "no";
    }
    //check array is ascending or not
    public static boolean isSortedAscending(int[] arr){
        for(int i = 0; i < arr.length - 1; i++)
            if(arr[i] > arr[i+1])return false;
        return true;
    }
    //translate to new array by revert a sub set of item
    public static void RevertSubArray(int[] arr, int l, int r){
        int[] arrTemp = arr.clone();
        int index = r;
        for(int k = l; k <= r; k++)
            arr[k] = arrTemp[index--];
    }
}
