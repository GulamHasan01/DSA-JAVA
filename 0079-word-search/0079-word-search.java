class Solution {
    public int[][] coordinate = { { -1, 0 }, { +1, 0 }, { 0, -1 }, { 0, +1 } };

    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, visited,word, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid,int s,int e,boolean[][] visited,String ss,int idx){
        visited[s][e]=true;
        if(idx==ss.length()-1) return true;

        for(int[]dir:coordinate){
            int i=s+dir[0];
            int j=e+dir[1];
             
            if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && !visited[i][j] && grid[i][j]==ss.charAt(idx+1)){
                if(dfs(grid,i,j,visited,ss,idx+1)) return true;
            }
        }
        visited[s][e]=false;

        return false;
    }
}