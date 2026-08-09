class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0;
        int left=0;
        int ref=k;
        int zc=0;
        for(int i=0;i<nums.length;i++){
            
           if(nums[i]==0){
            ref--;
            zc++;
           }
           if(ref==0){
            ans=Math.max(ans,i-left+1);
           }
           while(ref<0){
            if(nums[left]==0){
                left++;
                ref++;
            }else{
                left++;
            }
           }
        }
        return (k-zc)>=0?nums.length:ans;
    }
}