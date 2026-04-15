package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class findMissingAndRepeatedValue {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));
    }
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalElements = n * n;
        int[] ans= new int[2];
        Map<Integer,Integer> map =new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        for (int num:map.keySet()){
            if (map.get(num)>1){
                ans[0]=num;
            }
        }

        for (int i=1;i<=totalElements;i++){
            if (!map.containsKey(i)) {
                ans[1]=i;

            }else if (map.get(i)==2){
                ans[0]=i;
            }
        }


        return ans;
    }

}
