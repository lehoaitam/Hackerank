package dp;

public class fibonaci {
    public static void main(String[] args){
        int n = 101;
        int[] f = new int[n];
        for(int i = 0; i < n; i++)
            f[i] = -1;
//        System.out.println(fibonaci_dp_topdown(45,f));
        System.out.println(fibonaci_dp_botomup(45));
//        System.out.println(fibonaci_recursive(45));

    }
    public static int fibonaci_dp_topdown(int n, int[] f){
        if(f[n] != -1)
            return f[n];
        if(n <= 1){
            f[n] = 1;
            return 1;
        }
        f[n] = fibonaci_dp_topdown(n-1, f) + fibonaci_dp_topdown(n-2, f );
        return f[n];
    }
    public static int fibonaci_recursive(int n){
        return n <= 1 ? 1 : fibonaci_recursive(n-1) + fibonaci_recursive(n-2);
    }

    public static int fibonaci_dp_botomup(int n){
        int[] f = new int[n+1];
        f[0] = f[1] = 1;
        for(int i = 2; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
