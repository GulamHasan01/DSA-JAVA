package Graph;

import java.util.LinkedList;
import java.util.Queue;

class pair{
int first;
int sec;
pair(int first,int sec){
    this.first=first;
    this.sec=sec;
}
}
public class MOvesByKnight {
   public int [][] coordinate={{-2,-1},{-2,+1},{+2,+1},{+2,-1},{-1,-2},{+1,-2},{-1,+2},{+1,+2}};
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        int sx=n-knightPos[1];
        int sy=knightPos[0]-1;
        int tx=n-targetPos[1],ty=targetPos[0]-1;

        return helperBFS(sx,sy,tx,ty,n);
    }

    private int helperBFS(int sx, int sy, int tx, int ty, int n) {
        boolean[][]visited=new boolean[n][n];
        Queue<pair> q=new LinkedList<>();
        int count=0;
        q.offer(new pair(sx,sy));
        visited[sx][sy]=true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                pair curr = q.poll();
                int cx = curr.first;
                int cy = curr.sec;
                if (cx == tx && cy == ty) return count;
                for (int[] co : coordinate) {
                    int nx = cx + co[0];
                    int ny = cy + co[1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]){
                       visited[nx][ny]=true;
                       q.offer(new pair(nx,ny));
                   }
                }
                size--;
            }
            count++;
        }
        return -1;
    }
}