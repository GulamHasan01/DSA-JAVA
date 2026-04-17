package Arrays;

import java.util.Arrays;
import java.util.HashMap;
// Used Sliding Window technique to find the longest subarray with sum = k (works for positive numbers)
public class LongestSubArraySum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestSumSunArray(new int[]{1, 2, 3, 1, 2}, 3)));
        System.out.println(longestSumSunArray1(new int[]{1, 2, 3, 1, 2}, 3));
    }
    public static int[] longestSumSunArray(int[] arr,int k){
        int sum=0,start=-1;
        int ans=0;
        int[] result ;
        int j=0;
        int i=0;
        while(j<arr.length){
            sum=sum+arr[j];


            while (sum>k){
                sum=sum-arr[i];
                i++;
            }
            if (sum==k){
                if (j-i+1>ans) {
                    ans = j - i + 1;
                    start=i;
                }

            }
            j++;
        }
        if (start == -1) return new int[0];

        result=Arrays.copyOfRange(arr,start,start+ans);
        return result;
    }


    public static int longestSumSunArray1(int[] arr,int k){
        int sum=0;
        int ans=0;
        int j=0;
        int i=0;
        while(j<arr.length){
            sum=sum+arr[j];


            while (sum>k){
                    sum=sum-arr[i];
                    i++;
                }
            if (sum==k){
                ans=Math.max(ans,j-i+1);
            }
                j++;
            }

        return ans;
    }
}
