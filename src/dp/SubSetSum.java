package dp;

public class SubSetSum {
    static int countnaive = 0;
    static int countdp = 0;
    public static void main(String[] agrs){
        int[] arr = {8, 9, 6, 7, 1, 2,3};
        int sum = 7;

//        System.out.println(dp_sol(arr, sum));
        Double a = 1.0, b = 2.0;
        func(a,b);
        System.out.println(a + "," + b);
    }

    public static void func(Double a, Double b){
        a = 5.0;
        b = 10.0;
        System.out.println(a + "," + b);
    }

    private static boolean sol(int[] arr, int i, int sum){
        countnaive++;
        if(i < 0 && sum > 0) return false;
        if(sum == 0) return true;
        if(arr[i] > sum) return sol(arr, i - 1, sum);
        return sol(arr, i-1, sum) || sol(arr, i-1, sum - arr[i]);
    }

    private static boolean dp_sol(int[] arr, int sum){
        boolean[][] result = new boolean[arr.length+1][sum+1];
        int i, j;
        for(i = 0; i <=arr.length; i++)
            result[i][0] = true;
        for(i = 1; i <= sum; i++)
            result[0][i] = false;
        for(i = 1; i <= arr.length; i++){
            for(j = 1; j<= sum; j++){
//                countdp++;
                if(arr[i-1] > j)
                    result[i][j] = result[i-1][j];
                else
                    result[i][j] = result[i-1][j] || result[i-1][j-arr[i-1]];
            }
        }
        return result[arr.length][sum];
    }
}
