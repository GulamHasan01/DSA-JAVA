class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
      
            int pre1 = 0;
            int pre2 = 0;
            int max = 0;
            for (int i = 0; i < n - 1; i++) {
                int curr = Math.max(pre1, nums[i] + pre2);
                pre2 = pre1;
                pre1 = curr;
            }
            max = Math.max(max, pre1);
            pre1 = 0;
            pre2 = 0;
            for (int i = 1; i < n; i++) {
                int curr = Math.max(pre1, nums[i] + pre2);
                pre2 = pre1;
                pre1 = curr;
            }
            max = Math.max(max, pre1);
            return max;
        
    }
}