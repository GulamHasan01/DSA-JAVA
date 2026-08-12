class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int m = 0;
        for (int i : nums) {
            m += i;
        }
        int[][] dp = new int[n + 1][2 * m + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return helper(nums, target, 0, 0, dp, m);
    }

    private int helper(int[] arr, int target, int i, int currSum, int[][] dp, int m) {
        if (i == arr.length) {
            if (currSum == target)
                return 1;
            else
                return 0;
        }
        if (dp[i][m + currSum] != -1) {
            return dp[i][m + currSum];
        }
        int take = helper(arr, target, i + 1, currSum + arr[i], dp, m);
        int skip = helper(arr, target, i + 1, currSum - arr[i], dp, m);

        return dp[i][m + currSum] = take + skip;
    }
}