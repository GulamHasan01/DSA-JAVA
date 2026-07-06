package Arrays;

public class MergeCoveredINterval {
    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1,100},
                {2,99},
                {2,98},
                {3,97},
                {4,96},
                {5,95},
                {6,94},
                {50,60},
                {60,70},
                {70,80},
                {80,90},
                {90,100},
                {100,100},
                {101,102},
                {101,101},
                {102,102}}));
    }
    public static int removeCoveredIntervals(int[][] intervals) {
   boolean covered;
   int count=0;

        for (int i = 0; i < intervals.length; i++) {
            int [] arr=intervals[i];
            covered=false;
            for(int[] num:intervals){
                if (arr[0]==num[0] && arr[1]==num[1]) continue;

                if (arr[0]>=num[0] && arr[1]<=num[1]){
                    covered=true;
                    break;
                }
            }
            if (covered){
                count++;

            }
        }
        return intervals.length-count;
    }
}
