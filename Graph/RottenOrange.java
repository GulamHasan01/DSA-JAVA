package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
   public int[][]coordinate={{-1,0},{+1,0},{0,-1},{0,+1}};
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        int freshorange=0;
        Queue<int []>q=new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = rows; j <cols ; j++) {
                if (grid[i][j]==2){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j]==1) freshorange++;
            }
        }
        if (freshorange==0) return 0;
        while (!q.isEmpty() && freshorange>0) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                for (int[] co:coordinate) {
                    int nx=x+co[0];
                    int ny=y+co[1];
                    if (nx<rows && ny<cols && ny>=0 && nx>=0 && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        q.offer(new int[]{nx,ny});
                        freshorange--;
                    }
                }
            }
        }
        return freshorange==0?count:-1;
    }
}
