class Solution {
    public int minimumDeletions(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int maxI=0;
        int minI=0;
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        for(int k=0;k<n;k++){
            if(min>nums[k]){
                min=nums[k];
                  minI=k;
            }
            if(max<nums[k]){
                max=nums[k];
                maxI=k;
            }
        }
        if(minI>maxI){
        ans=Math.min(ans,(n-minI)+(maxI+1));
        ans=Math.min(ans,Math.min(n-maxI,minI+1));
        }else{
        ans=Math.min(ans,(n-maxI)+(minI+1));
        ans=Math.min(ans,Math.min(n-minI,maxI+1));
        }
        return ans;
    }
}