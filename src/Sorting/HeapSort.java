package Sorting;

public class HeapSort {
    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        heapsort(arr);
        print(arr);
    }
    private static void heapsort(int[] arr){
        //build heap
        int n = arr.length;
        for(int i = n/2 -1; i >= 0; i--)
            heapify(arr, n, i);
        //extract heap
        int i = n-1;
        while(i >= 0){
            swap(arr, i, 0);
            i--;
            heapify(arr, i , 0);
        }
    }
    private static void heapify(int[] arr, int n, int i){
        int childL = i * 2 + 1;
        int childR = i * 2 + 2;
        int largest = i;
        if(childL < n && arr[i] < arr[childL])
            largest = childL;
        if(childR < n && arr[largest] < arr[childR])
            largest = childR;
        if(largest != i){
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
