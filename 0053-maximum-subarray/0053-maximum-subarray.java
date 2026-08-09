class Solution {
    public int maxSubArray(int[] nums) {
       int max=Integer.MIN_VALUE;
      int pre=0;
       for(int num:nums){
        pre+=num;
         max=Math.max(pre,max);
        if(num>pre){
            pre=num;
             max=Math.max(pre,max);
        }
       } 
       return max;
    }
}