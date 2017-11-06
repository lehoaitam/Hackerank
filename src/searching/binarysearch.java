package searching;

public class binarysearch {
    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        System.out.println(minimumSortedCutArray(arr));
//        System.out.println(bs(arr, 0, arr.length - 1, 1));
//        System.out.println(bs(arr, 0, arr.length - 1, 2));
//        System.out.println(bs(arr, 0, arr.length - 1, 3));
//        System.out.println(bs(arr, 0, arr.length - 1, 4));
//        System.out.println(bs(arr, 0, arr.length - 1, 5));
//        System.out.println(bs(arr, 0, arr.length - 1, 6));
//        System.out.println(bs(arr, 0, arr.length - 1, 7));
//        System.out.println(bs(arr, 0, arr.length - 1, 8 ));
//        System.out.println(bs(arr, 0, arr.length - 1, 9 ));
//        System.out.println(bs(arr, 0, arr.length - 1, 10 ));
//        System.out.println(bs(arr, 0, arr.length - 1, 11 ));
//        System.out.println(bs(arr, 0, arr.length - 1, 14 ));

        System.out.println("count" + countOcurrence(arr, 0, arr.length - 1, 9));

    }

    //return index of found item in array
    //if not found return -1
    public static int bs(int[] arr, int l, int r, int key){
        int mid = 0;
        while(l <= r){
            mid = (l+r)/2;
            if(arr[mid] == key) {
                return mid;
            }
            else if(key < arr[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    //return index of found item in array
    //if not found return -1
    //TODO: not complete yet
//    public static int bs_customization(int[] arr, int l, int r, int key){
//        int mid = 0;
//        while(l < r){
//            mid = (l+r)/2;
//            if(arr[mid] <= key)
//                l = mid;
//            else
//                r = mid - 1;
//        }
//        return arr[l] == key ? l : -1;
//    }

    //return index of found item in array
    //if not return index of ceil value
    public static int bs_ceil(int[] arr, int l, int r, int key){
        int mid = 0;
        while(l <= r){
            mid = (l+r)/2;
            if(arr[mid] == key)
                return mid;
            else if(key < arr[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return key < arr[mid] ? mid : mid + 1;
    }

    //return index of found item in array
    //if not return index of ceil value
    public static int bs_floor(int[] arr, int l, int r, int key){
        int mid = 0;
        while(l <= r){
            mid = (l+r)/2;
            if(arr[mid] == key)
                return mid;
            else if(key < arr[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return arr[mid] < key ? mid : mid - 1;
    }

    public static int bs_lesscomparision(int A[], int l, int r, int key)
    {
        int m;

        while( r - l > 1 )
        {
            m = (l +r ) / 2;

            if( A[m] <= key )
                l = m;
            else
                r = m;
        }

        if( A[l] == key )
            return l;
        else
            return -1;
    }

    public static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    //return index of found item in array
    //if not found return -1
    public static int bs_left(int[] arr, int l, int r, int key){
        int mid = 0;
        while(l <= r){
            mid = (l+r)/2;
            if(arr[mid] == key) {
                while(mid >= 0 && arr[mid] == key)
                    mid--;
                return mid + 1;
            }
            else if(key < arr[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    //return index of found item in array
    //if not found return -1
    public static int bs_right(int[] arr, int l, int r, int key){
        int mid = 0;
        while(l <= r){
            mid = (l+r)/2;
            if(arr[mid] == key) {
                while(mid < arr.length && arr[mid] == key)
                    mid++;
                return mid -1;
            }
            else if(key < arr[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public static int countOcurrence(int[] arr, int l, int r, int key){
        int mostL = bs_left(arr, l, r, key);
        int mostR = bs_right(arr, l, r, key);
        if(mostL == -1 || mostR == -1) return 0;
        return mostR - mostL + 1;
    }

    public static int minimumSortedCutArray(int[] arr){
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while(l < r){
            mid = (l +r)/2;
            if(arr[mid] > arr[r])
                l = mid + 1;
            else
                r = mid;
        }
        return arr[l];
    }
}

