class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int totalPoints = n + k - 1;
        int choose = 2 * k;
        
        if (choose > totalPoints) return 0;
        
        // DP array to compute Pascal's Triangle row by row
        int[] dp = new int[choose + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= totalPoints; i++) {
            for (int j = Math.min(i, choose); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        
        return dp[choose];
    }
}
