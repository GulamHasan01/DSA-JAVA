class Solution {
    public int longestPalindromeSubseq(String s) {

        String ss =  new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][ss.length() + 1];
       System.out.print(ss);
        for (int i = 0; i <s.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <ss.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= ss.length(); j++) {
                if (s.charAt(i - 1) == ss.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[s.length()][ss.length()];
    }
}