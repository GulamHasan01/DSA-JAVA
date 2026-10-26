import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]>0 && !visited[i][j]){
                    long sum=0;
                    sum=bfs(grid,i,j,visited,sum);
                    if(sum%k==0) count++;
                }
            }
        }
        return count;
    }
    private long bfs(int[][]grid,int i,int j,boolean[][]visited,long sum){
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j]=true;
        int[][]coordinate={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int cx=curr[0];
            int cy=curr[1];
            sum=sum+grid[cx][cy];

            for(int[] dir:coordinate){
                int nx=cx+dir[0];
                int ny=cy+dir[1];
                if(nx<grid.length && nx>=0 && ny<grid[0].length && ny>=0 && !visited[nx][ny] && grid[nx][ny]>0 ){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }
            }
        }
        return sum;
    }
}
