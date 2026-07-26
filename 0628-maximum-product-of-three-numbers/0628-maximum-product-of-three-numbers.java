class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        
        if (nums[0] >= 0 || nums[nums.length - 1] <= 0 || nums.length == 3) {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        } else if (nums[1] <= 0 && nums[nums.length - 1] >= 0) {
            int neg = nums[0] * nums[1];
            int pos = nums[nums.length - 1] * nums[nums.length - 2];
            if (neg * nums[nums.length - 1] > pos * nums[nums.length - 3])
                return neg * nums[nums.length - 1];
            else
                return pos * nums[nums.length - 3];
            // if (pos > neg) {
            //     if (nums[nums.length - 3] > 0)
            //         return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
            //         else  return neg * nums[nums.length - 1];
            // } else {
            //     return neg * nums[nums.length - 1];
            // }
        }
        return -1;
    }
}