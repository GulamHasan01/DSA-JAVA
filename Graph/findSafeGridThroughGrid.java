package Graph;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

class Pairs{
     int first;
     int second;
     int remainingHealth;
     Pairs(int first,int second,int remainingHealth){
         this.first=first;
         this.second=second;
         this.remainingHealth=remainingHealth;
     }

 }
public class findSafeGridThroughGrid {
    public static void main(String[] args) {

    }
    public int[][]coordinate={{-1,0},{+1,0},{0,-1},{0,+1}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
      int row=grid.size();
        int col = grid.get(0).size();
        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

      int [][] visitedbest=new int[row][col];
        for (int i = 0; i < row; i++)
            Arrays.fill(visitedbest[i], -1);
        Queue<Pairs>q=new LinkedList<>();
        q.offer(new Pairs(0,0,startHealth));
        visitedbest[0][0] = startHealth;


        while (!q.isEmpty()){
            Pairs curr=q.poll();
            int cx= curr.first;
            int cy= curr.second;
            if (cx==row-1 && cy==col-1) return true;



            for (int []co:coordinate){
             int nr=co[0]+cx;
             int nc=co[1]+cy;
                if (nr < 0 || nc < 0 || nr >= row || nc >= col)
                    continue;
                int newHealth = curr.remainingHealth - grid.get(nr).get(nc);
                if (newHealth <= 0)
                    continue;
                if (newHealth > visitedbest[nr][nc]) {

                    visitedbest[nr][nc] = newHealth;
                     q.offer(new Pairs(nr, nc,newHealth));


                 }
             }
            }

        return false;
    }
}
