
class Solution {
    private int[] suffixSum;
    private int[][] memo;
    private int n;

    public int stoneGameII(int[] piles) {
        this.n = piles.length;
        this.suffixSum = new int[n + 1];
        this.memo = new int[n][n + 1];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return dfs(0, 1);
    }

    private int dfs(int i, int M) {
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        if (memo[i][M] != -1) {
            return memo[i][M];
        }

        int maxStones = 0;

        for (int X = 1; X <= 2 * M; X++) {
            int opponentScore = dfs(i + X, Math.max(M, X));
            int currentScore = suffixSum[i] - opponentScore;
            maxStones = Math.max(maxStones, currentScore);
        }

        return memo[i][M] = maxStones;
    }
}
