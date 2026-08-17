class Solution {
public int climbStairs(int n) {
    if (n < 4) return n;
int[]dp=new int[n+1];
Arrays.fill(dp,-1);
    return  helper(n,dp);
}

    int helper(int n, int[] dp) {
        if (n < 4)
            return n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = helper(n - 1,dp) + helper(n-2,dp);
    }
}