class Solution { 
    public int firstStableIndex(int[] nums, int k) { 
        int diff = -1; 

        for(int i = 0; i < nums.length; i++) { 
            diff = maxF(nums, 0, i) - minF(nums, i, nums.length); 

            if(diff <= k) { 
                return i; 
            } 
        } 
        return -1; 
    } 

    private int minF(int[] nums, int s, int e) { 
        int min = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            min = Math.min(min, nums[i]);
        }
        return min; 
    } 

    private int maxF(int[] nums, int s, int e) { 
        int max = Integer.MIN_VALUE;
        for (int i = s; i <= e; i++) {
            max = Math.max(max, nums[i]);
        }
        return max; 
    } 
}
