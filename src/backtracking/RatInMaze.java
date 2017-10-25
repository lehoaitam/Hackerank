package backtracking;

public class RatInMaze {
    public static int N = 4;
    public static int[][] next = {{1,0},{0,1}};
    public static void main(String[] args){
        int[][] maze = {
                {0,-1,-1,-1},
                {0,0,-1,0},
                {0,0,-1,-1},
                {-1,0,0,0}
        };
        int[][] sol = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        sol[0][0] = 1;
        if(backtracking(maze,0,0, 1, sol))
            print(sol);
        System.out.println("there is no configuration for solution");
    }

    public static boolean backtracking(int[][] maze, int x, int y, int step, int[][] sol){
        if(x == N-1 && y == N-1)
            return true;
        //try all
        for(int i = 0; i < next.length; i++){
            int xNext = x + next[i][0];
            int yNext = y + next[i][1];
            //check whether try is valid or not
            if(isValid(maze, xNext, yNext, sol)){
                //record next step into solution
                sol[xNext][yNext] = step + 1;
                //back track
                if(backtracking(maze, xNext, yNext, step + 1, sol)) {
                    return true;
                }
                //remove next out of solution
                sol[xNext][yNext] = 0;
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

    public static boolean isValid(int[][] maze, int x, int y, int[][] sol){
        if(0 <= x && x < N && 0 <= y && y < N && maze[x][y] == 0)
            return true;
        return false;
    }
}
