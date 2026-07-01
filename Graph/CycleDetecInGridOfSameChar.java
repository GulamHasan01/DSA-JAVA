package Graph;

public class CycleDetecInGridOfSameChar {
    int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    public boolean containsCycle(char[][] grid) {

        int n= grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]){
                    boolean ans=dfs(grid,visited,i,j,-1,-1);
                    if (ans) return true;
        int a=5;

                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int parentRow, int parentCol) {
        visited[i][j]=true;

        for (int[] dir:direction){
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            if (nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length){
                continue;
            }
            if (grid[i][j]!=grid[nr][nc]) continue;

            if (!visited[nr][nc]){
                boolean ans=dfs(grid, visited, nr, nc, i,j);
                if (ans) return true;
            }else{
                if (nr!=parentRow || nc!=parentCol) return true;
            }
        }
        return false;
    }
}
