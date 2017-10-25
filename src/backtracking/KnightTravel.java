package backtracking;

public class KnightTravel {
    public static int N = 8;
    public static int[][] next = {{-1, 2},{-1,-2},{1,2},{1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
    public static void main(String[] args){
        int[][] sol = null;
        for(int i = 0; i < N; i++)
            sol = new int[N][];
        for(int i = 0; i < N; i++)
            sol[i] = new int[N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                sol[i][j] = -1;
        sol[5][5] = 0;
        if(backtracking(sol, 0 , 0,1))
            print(sol);
        else
            System.out.println("no have configuration of solution");
    }

    public static boolean backtracking(int[][] sol, int x, int y, int step){
        //if configuration reach solution then print out
        if(step == N * N) {
            return true;
        }
        //try all case
        for(int i = 0; i < next.length; i++ ){
            int xNext = x + next[i][0];
            int yNext = y + next[i][1];
            //if next move is valid
            if(isValid(sol, xNext, yNext)){
                System.out.println("step:"+ step + " | try:" + xNext + "," + yNext);
                //record next step to solution
                sol[xNext][yNext] = step;
                //try next step
                if(backtracking(sol, xNext, yNext, step + 1))
                    return true;
                //back track
                sol[xNext][yNext] = -1;
            }
        }
        return false;
    }
    public static void print(int[][] sol){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }

    public static boolean isValid(int[][] sol, int x, int y){
        if(0 <= x && x < N && 0 <= y && y < N && sol[x][y] == -1)
            return true;
        return false;
    }

}
