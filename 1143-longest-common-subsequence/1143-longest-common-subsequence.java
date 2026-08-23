class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }
        helper(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length(), dp);
        return dp[text1.length()][text2.length()];
    }

    private int helper(char[] s, char[] ss, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];
        if (s[n - 1] == ss[m - 1]) {
            return dp[n][m] = 1 + helper(s, ss, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(helper(s, ss, n - 1, m, dp), helper(s, ss, n, m - 1, dp));
        }
    }
}