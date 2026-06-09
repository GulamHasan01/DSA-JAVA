package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxTotalValue {
//    public long maxTotalValue(int[] nums, int k) {
//        Arrays.sort(nums);
//        int l=nums[0];
//        int h=nums[nums.length-1];
//
//        return (long) k *(h-l);
//    }
public long maxTotalValue(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }

    return (long) k * (max - min);
}
}
