class Solution {
    public int minimumCost(int[] nums, int k) {
        long ops=0;
        long resources=k;
        long mod=1_000_000_007L;

        for(int i:nums){
            if(i>resources){
                long need=i-resources;
                long add=(need+k-1)/k;
                ops+=add%mod;
                resources+=add*k;
            }
            resources-=i;
        }
        return (int)((ops%mod*(ops%mod+1)/2)%mod);
    }
}