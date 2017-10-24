package temp;

public class Sorting {
    public static void main(String[] args){
        int[] arr = {1,2,3,9,8,7,6,5,4,0};
        heapSort(arr);
        print(arr);
    }

    private static void heapSort(int[] arr){
        //build heap
        for(int i = arr.length / 2 - 1; i >=0 ; i--)
            heapify(arr, i, arr.length-1);
        //extract max item
        for(int i = arr.length - 1; i >=0; i--){
            swap(arr, i, 0);
            heapify(arr, 0, i-1);
        }
    }
    private static void heapify(int[] arr, int pos, int length){
        int maxIndex = pos;
        int leftChildIndex = pos * 2 + 1;
        int rightChildIndex = pos * 2 + 2;
        if(leftChildIndex <= length && arr[maxIndex] < arr[leftChildIndex])
            maxIndex = leftChildIndex;
        if(rightChildIndex <= length && arr[maxIndex] < arr[rightChildIndex])
            maxIndex = rightChildIndex;
        if(maxIndex != pos){
            swap(arr, pos, maxIndex);
            heapify(arr, maxIndex, length);
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
