package Arrays;

import java.util.HashMap;
import java.util.Map;
//finding maximum sum from the given array with negative number
public class MaximumSumSubArray {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{-1,1,2,-1,3,4,-2}));
    }
    public static int maxSum(int[] arr){
       int maxSum=0;
       int currentSum=0;
        for (int num : arr) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
