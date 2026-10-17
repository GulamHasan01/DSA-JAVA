class Solution {
     int mArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
       
      
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               if (grid[i][j] == 1 && !visited[i][j]) {
                    q.offer(new int[] { i, j });
                      int area=0;
                    visited[i][j] = true;
                    bfs(grid, q, visited,area);
                }
            }
        }
        return mArea;
    }
   private void bfs(int[][] grid, Queue<int[]> q, boolean[][] visited,int area) {
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = grid.length;
        int cols = grid[0].length;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            area++;
            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny] == 0 || visited[nx][ny]) {
                    continue; 
                }

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true; 
            }
        }
         mArea=Math.max(mArea,area);
    }
}