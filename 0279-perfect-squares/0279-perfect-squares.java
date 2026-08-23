class Solution {
    private boolean isPerf(int n){
        int sq=(int)(Math.sqrt(n));
        return sq*sq==n;
    }
    public int numSquares(int n) {
        int[]dp=new int[n+1];
       Arrays.fill(dp,-1);
        return minSqrt(n,dp);

    }
    private int minSqrt(int n,int[]dp){
        if(isPerf(n)) return 1;
          if(dp[n]!=-1) return dp[n];
          int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int count=minSqrt(i*i,dp)+minSqrt(n-i*i,dp);
            min=Math.min(min,count);
        }
          return dp[n]=min;
    }
}