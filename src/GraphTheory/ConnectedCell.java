package GraphTheory;

import java.io.File;
import java.util.Scanner;

public class ConnectedCell {
    public static void main(String[] args){
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/connectedcell"));
        }catch(Exception e){
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];

        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        Island island = new Island(grid, n, m);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(island.grid[i][j] == 1 && island.isVisited[i][j] == false) {
                    island.maxCount = 0;
                    dfs(island, i, j);
                    if (island.maxCount > max)
                        max = island.maxCount;
                }
            }
        }
        System.out.println(max);
    }

    public static void dfs(Island island, int i, int j){
        if(island.isValid(i,j) && island.grid[i][j] == 1 && island.isVisited[i][j] == false ){
            island.maxCount++;
            island.isVisited[i][j] = true;
            dfs(island, i-1,j-1);
            dfs(island, i-1,j);
            dfs(island, i-1,j+1);
            dfs(island, i,j-1);
            dfs(island, i,j+1);
            dfs(island, i+1,j-1);
            dfs(island, i+1,j);
            dfs(island, i+1,j+1);

        }


    }

}

class Island{
    public int[][] grid;
    public boolean[][] isVisited;
    public int n, m;
    public int maxCount;
    public Island(int[][] grid, int n, int m){
        this.grid = grid;
        this.n = n;
        this.m = m;
        this.maxCount = 0;
        isVisited = new boolean[n][m];
    }
    public boolean isValid(int i, int j){
        if (0 <= i && i < n && 0 <= j && j < m)
            return true;
        return false;
    }
}
