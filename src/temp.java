public class temp {
    public static void main(String[] args){
        int[] a = {2,6,8,10,35,47};
        //System.out.println(bs(a,7));
        for(int i = 0; i < 50; i++)
            System.out.println(i + " : " + bs(a,i));
    }

    public static int bs(int[] a, int v){
        int l = 0, r = a.length - 1;
        int mid = 0;
        while(l <= r){
            mid = (l +r )/2;
            if(v < a[mid])
                r = mid - 1;
            else if(v > a[mid])
                l = mid + 1;
            else
                return mid;
        }
        return l;
    }
}
