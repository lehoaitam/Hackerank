package Sorting;

/**
 * Created by lehoaitam on 12/31/16.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1,1,2,3,4,5};
        quicksort(arr, 0, arr.length - 1);
        print(arr);
    }

    private static int partition(int[] arr, int left, int right){
        int i = left - 1;
        int pivot = arr[right];
        for(int j = left; j < right; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void quicksort(int[] arr, int left, int right){
        if(left < right){
            int pivotIndex = partition(arr, left, right);
            quicksort(arr, left, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, right);
        }
    }

    private static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
