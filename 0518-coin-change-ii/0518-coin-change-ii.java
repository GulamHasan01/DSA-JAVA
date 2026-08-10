class Solution {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length ][amount + 1];
        for(int[]num:dp){
            Arrays.fill(num,-1);
        }
        int ans= helper(coins, amount, dp, 0);
        return ans;
    }

    private int helper(int[] arr, int target, int[][] dp, int i) {

        if (i == arr.length) {
            return 0;
        }
        if(target==0){
            return 1;
        }
        if(target<0) return 0;

         if(dp[i][target]!=-1){
            return dp[i][target];
         }
        int skip = helper(arr, target, dp, i+1);
    
        int take = helper(arr, target - arr[i], dp, i);

        return dp[i][target]=take+skip;
    }
}