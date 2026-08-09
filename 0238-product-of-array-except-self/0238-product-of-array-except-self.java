class Solution {
   
    public int[] productExceptSelf(int[] nums) {
        int[] pre= new int[nums.length];
         int[] suf= new int[nums.length];
         int p=1;
        for (int i = 0; i < nums.length; i++) {
            pre[i]=p;
           p*=nums[i];
           
        }
        p=1;
         for (int i = nums.length-1; i >=0 ; i--) {
            suf[i]=p;
           p*=nums[i];
           
        }

         for (int i = 0; i < nums.length; i++) {
           nums[i]=pre[i]*suf[i];
           
        }
        
        return nums;
    }

}