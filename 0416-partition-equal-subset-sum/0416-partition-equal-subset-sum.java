class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        boolean[][] dp = new boolean[nums.length + 1][(sum / 2) + 1];
        return (sum % 2 == 0) ? helper(nums, sum / 2, dp, nums.length) : false;
    }

    private boolean helper(int[] arr, int w, boolean[][] dp, int n) {
      
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= w; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }
}