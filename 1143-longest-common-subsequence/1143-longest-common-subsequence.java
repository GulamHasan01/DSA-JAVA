class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] num : dp) {
            Arrays.fill(num, 0);
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    // private int helper(char[] s, char[] ss, int n, int m, int[][] dp) {
    //     if (n == 0 || m == 0)
    //         return 0;

    //     if (dp[n][m] != -1)
    //         return dp[n][m];
    //     if (s[n - 1] == ss[m - 1]) {
    //         return dp[n][m] = 1 + helper(s, ss, n - 1, m - 1, dp);
    //     } else {
    //         return dp[n][m] = Math.max(helper(s, ss, n - 1, m, dp), helper(s, ss, n, m - 1, dp));
    //     }
    // }
}