package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntergal {

    public static void main(String []args){
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6},{8,10}})));
    }

    public static int[][] merge(int[][] intervals) {
        int n= intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        ArrayList<int[]>list=new ArrayList<>();
        int[] current=intervals[0];
         for (int i=1;i<n;i++){

             if (current[1]>=intervals[i][0]){
                current[1]=Math.max(current[1], intervals[i][1]);
             }else{
                 list.add(current);
                 current=intervals[i];
             }
         }
         list.add(current);

        return list.toArray(new int[list.size()][]);
    }
}
