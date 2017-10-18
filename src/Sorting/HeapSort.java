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
        while(n >= 0){
            swap(arr, n-1, 0);
            n--;
            heapify(arr, n , 0);
        }
    }
    private static void heapify(int[] arr, int n, int i){
        int childL = i * 2 + 1;
        int childR = i * 2 + 2;
        if(childL < n && childR < n){
            int largest = i;
            if(arr[i] < arr[childL])
                largest = childL;
            if(arr[largest] < arr[childR])
                largest = childR;
            if(largest != i){
                swap(arr, largest, i);
                heapify(arr, n, largest);
            }
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
