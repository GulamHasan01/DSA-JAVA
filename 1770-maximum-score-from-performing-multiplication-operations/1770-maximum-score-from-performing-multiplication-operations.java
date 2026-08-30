class Solution {
    int[][] dp;
    int[] nums, multipliers;
    int n, m;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        n = nums.length;
        m = multipliers.length;

        dp = new int[m][m];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);

        return solve(0, 0);
    }

    int solve(int i, int left) {
        if (i == m)
            return 0;

        if (dp[i][left] != Integer.MIN_VALUE)
            return dp[i][left];

        int right = i - left;
        int rightIndex = n - 1 - right;

        int takeFront =
            nums[left] * multipliers[i]
            + solve(i + 1, left + 1);

        int takeBack =
            nums[rightIndex] * multipliers[i]
            + solve(i + 1, left);

        return dp[i][left] = Math.max(takeFront, takeBack);
    }
}