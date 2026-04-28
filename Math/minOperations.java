package Math;
import java.util.Arrays;
public class minOperations {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;

        int[] result=new int[m*n];

        int targetRem=grid[0][0]%x;
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] % x != targetRem){
                    return -1;
                }
                result[k++]=grid[i][j];
            }
        }
        Arrays.sort(result);
        int medain=result[(m*n)/2];

        int totalOp=0;
        for(int val:result){
            totalOp+=Math.abs(val-medain)/x;
        }
        return totalOp;
    }
}
}
