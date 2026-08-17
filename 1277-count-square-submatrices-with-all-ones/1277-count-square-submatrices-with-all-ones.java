class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int count = 0;
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 1; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                else {
                    dp[i][j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }
}