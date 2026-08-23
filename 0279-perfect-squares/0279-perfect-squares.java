class Solution {
    private boolean isPerf(int n) {
        int sq = (int) (Math.sqrt(n));
        return sq * sq == n;
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            if (isPerf(j))
               dp[j] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int i = 1; i * i <= j; i++) {
                    int count = dp[i * i] +dp[j-i * i];
                    min = Math.min(min, count);
                }
               dp[j] = min;
            }
        }
        return dp[n];

    }

    // private int minSqrt(int n, int[] dp) {
    //     if (isPerf(n))
    //         return 1;
    //     if (dp[n] != -1)
    //         return dp[n];
    //     int min = Integer.MAX_VALUE;
    //     for (int i = 1; i * i <= n; i++) {
    //         int count = minSqrt(i * i, dp) + minSqrt(n - i * i, dp);
    //         min = Math.min(min, count);
    //     }
    //     return dp[n] = min;
    // }
}