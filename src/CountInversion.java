import java.util.HashMap;
import java.util.Map;

public class CountInversion {
    public static void main(String[] args){
        int[] a = {1, 20, 6, 4, 5};
        long count = mergeSort(a, 0, a.length-1);
        System.out.println("count:" + count );
        for(int num : a){
            System.out.print(num + " ");
        }

    }
    static long mergeSort(int[] a, int left, int right){
        long count = 0;
        if(left < right){
            int middle = (left + right)/2;
            count += mergeSort(a, left, middle);
            count += mergeSort(a, middle+1, right);
            count += merge(a, left, middle, right);
        }
        return count;
    }
    static long merge(int[] a, int left, int middle, int right){
        //copy to another buffer
        int[] b = new int[right -left +1];
        int l = left;
        for(int k = 0; k < b.length; k++)
            b[k] = a[l++];
        int i = 0, j = middle +1 - left;
        int index = left;
        long count = 0;
        //merge two array into original
        int I = middle - left;
        int J = right - left;
        while(i <= I && j <= J){
            if(b[i] <= b[j])
                a[index++] = b[i++];
            else {
                a[index++] = b[j++];
                count += (I - i) + 1;
            }
        }
        //copy remain
        while(i <= I)
            a[index++] = b[i++];
        while(j <= J)
            a[index++] = b[j++];

        return count;
    }
}
