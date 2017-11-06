package searching;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreaseSubsequence {
    public static void main(String[] args){
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/LIS/input2"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        int[] arr1 = {1,2,3,5,7,9};
        System.out.println("----ceil----");
//        System.out.println("ceil:" + bs_ceil(arr1, 0));
//        System.out.println("ceil:" + bs_ceil(arr1, 1));
//        System.out.println("ceil:" + bs_ceil(arr1, 2));
//        System.out.println("ceil:" + bs_ceil(arr1, 3));
        System.out.println("ceil:" + bs_ceil(arr1, 4));
//        System.out.println("ceil:" + bs_ceil(arr1, 5));
        System.out.println("ceil:" + bs_ceil(arr1, 6));
//        System.out.println("ceil:" + bs_ceil(arr1, 7));
        System.out.println("ceil:" + bs_ceil(arr1, 8));
//        System.out.println("ceil:" + bs_ceil(arr1, 9));
        System.out.println("ceil:" + bs_ceil(arr1, 10));
        System.out.println("----floor----");
//        System.out.println("floor:" + bs_floor(arr1, 0));
//        System.out.println("floor:" + bs_floor(arr1, 1));
//        System.out.println("floor:" + bs_floor(arr1, 2));
//        System.out.println("floor:" + bs_floor(arr1, 3));
        System.out.println("floor:" + bs_floor(arr1, 4));
//        System.out.println("floor:" + bs_floor(arr1, 5));
        System.out.println("floor:" + bs_floor(arr1, 6));
//        System.out.println("floor:" + bs_floor(arr1, 7));
        System.out.println("floor:" + bs_floor(arr1, 8));
//        System.out.println("floor:" + bs_floor(arr1, 9));
        System.out.println("floor:" + bs_floor(arr1, 10));

        System.out.println("----bs----");
//        System.out.println("floor:" + bs_floor(arr1, 0));
//        System.out.println("floor:" + bs_floor(arr1, 1));
//        System.out.println("floor:" + bs_floor(arr1, 2));
//        System.out.println("floor:" + bs_floor(arr1, 3));
        System.out.println("bs:" + bs(arr1, 4));
//        System.out.println("floor:" + bs_floor(arr1, 5));
        System.out.println("bs:" + bs(arr1, 6));
//        System.out.println("floor:" + bs_floor(arr1, 7));
        System.out.println("bs:" + bs(arr1, 8));
//        System.out.println("floor:" + bs_floor(arr1, 9));
        System.out.println("bs:" + bs(arr1, 10));


//        System.out.println(LIS(arr));
//        System.out.println(lengthOfLIS(arr));

    }

    public static int bs(int[] arr, int key){
        int l = 0, r = arr.length - 1, m = 0;
        while(l < r){
            m = (l + r)/2;
            if(arr[m] == key) return m;
            if(arr[m] < key)
                l = m + 1;
            else
                r = m - 1;
        }
        if(l == r) System.out.println("EQUAL");
        else System.out.println("NOT EQUAL");
        return l;
    }
    public static int bs_ceil(List<Integer> list, int key){
        print(list);
        int l = 0, r = list.size() - 1;
        int mid = 0;
        while(l < r){
            mid = (l + r)/2;
            if(list.get(mid) < key)
                l = mid + 1;
            else
                r = mid;
        }
//        System.out.println("ceil" + r);
        return r;
    }



    public static int bs_ceil(int[] arr, int key){
        int l = 0, r = arr.length - 1;
        int mid = 0;
        while(l < r){
            mid = (l + r)/2;
            if(arr[mid] < key)
                l = mid + 1;
            else
                r = mid;
        }
//        System.out.println("ceil:" + r);
        return r;
    }

    public static int bs_floor(int[] arr, int key){
        int l = 0, r = arr.length - 1;
        int mid = 0;
        while(l < r){
            mid = (l + r)/2;
            if(key < arr[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
//        System.out.println("ceil:" + r);
        return l;
    }

    public static void print(List<Integer> list){
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " " );
        System.out.println();
    }

    public static int LIS(int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(list.get(list.size() - 1) < arr[i])
                list.add(arr[i]);
            else{
                int pos = bs_ceil(list, arr[i]);
                list.set(pos,arr[i]);
            }
        }
        return list.size();
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int num: nums){
            if(list.size()==0 || num>list.get(list.size()-1)){
                list.add(num);
            }else{
                int i=0;
                int j=list.size()-1;

                while(i<j){
                    int mid = (i+j)/2;
                    if(list.get(mid) < num){
                        i=mid+1;
                    }else{
                        j=mid;
                    }
                }

                list.set(j, num);
            }
        }

        return list.size();
    }
}
