package dp;

public class SubSetSum {
    static int countnaive = 0;
    static int countdp = 0;
    public static void main(String[] agrs){
        int[] arr = {1, 2, 3, 4, 5, 6};
        int sum = 7;
//        System.out.println(sol(arr,arr.length-1, sum));
//        System.out.println("countnaive" + countnaive);
        System.out.println(dp_sol(arr, sum));
//        System.out.println("countnaive" + countdp);
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
