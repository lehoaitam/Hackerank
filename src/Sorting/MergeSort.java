package Sorting;

public class MergeSort {
    public static void main(String[] args){
        int[] arr = {4,5,1,3,9,7,0,3};
        mergesort(arr, 0, arr.length-1);
        print(arr);
    }
    private static void merge(int[] arr, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int i, j = left;
        for(i = 0; i < n1; i++){
            arr1[i] = arr[j++];
        }
        j = middle + 1;
        for(i = 0; i < n2; i++){
            arr2[i] = arr[j++];
        }

        int i1 = 0, i2 = 0;
        j = left;
        while(i1 < n1 && i2 < n2)
            arr[j++] = arr1[i1] < arr2[i2] ? arr1[i1++] : arr2[i2++];
        while(i1 < n1)
            arr[j++] = arr1[i1++];
        while(i2 < n2)
            arr[j++] = arr2[i2++];
    }
    private static void mergesort(int[] arr, int left, int right){
        if(left < right){
            int middle = (left + right)/2;
            mergesort(arr, left, middle);
            mergesort(arr, middle+1, right);
            merge(arr, left, middle, right);
        }
    }
    private static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
